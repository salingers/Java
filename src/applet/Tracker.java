package applet;

import java.awt.*;
import java.applet.*;

public class Tracker extends Applet implements Runnable
{
	Image[] image; // �v���}�C
	int cur; // �ثe�v��
	MediaTracker mt; // �C��[
	int delay = 100; // ����ɶ�(�@��)
	Thread thread = null; // �����

	public void init() // ��l���p
	{
		mt = new MediaTracker(this); // �إߴC��[����
		image = new Image[10]; // �إ߼v���}�C
		for (int i = 0; i <= 9; i++) // �v���v�@�B�z
		{
			image[i] = getImage(getDocumentBase(), "pic" + i + ".jpg");
			mt.addImage(image[i], i); // �\�W�C��[i
		}
	}

	public void start() // �Ұ�
	{
		thread = new Thread(this); // �إ߰����
		thread.start(); // �Ұʦ������
	}

	public void stop() // ����
	{
		thread = null; // ������ť�
	}

	public void run() // ����
	{
		for (int i = 0; i <= 9; i++) // �C�Ӽv���v�@�B�z
		{
			showStatus("���J�Ϥ�" + i); // ��ܸ��J��i�v����
			try
			{
				mt.waitForID(i);
			} // ���ݸ��J����
			catch (InterruptedException e)
			{
			}
			; // �ҥ~��
			if (mt.isErrorID(i)) // ���J�ɵo�{���~
			{
				showStatus("Loading image " + i + " error!"); // ���~
				return; // ����
			}
		}

		showStatus("���J���\"); // ���J���\
		while (true) // �L�a�j��
		{ // �ثe�v���W�L��
			if (++cur >= image.length)
				cur = 0; // �q�Y�ӹL
			getGraphics().drawImage(image[cur], 0, 0, this);
			try
			{
				Thread.sleep(delay);
			} // ��delay�@��
			catch (InterruptedException e)
			{
			}
			; // �ҥ~��
		}
	}

}
