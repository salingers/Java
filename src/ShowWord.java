import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ShowWord extends Applet
{ // �~��Applet���O
	String s; // �ŧi�@�Ӧr��A�Ψ���ܪ��T��

	public void init()
	{ // Applet����l�Ƥ�k
		s = getParameter("ShowString"); // �q.HTML�����o�W��ShowString���Ѽ�
		s = "Java & NKNU"; // �p�G�ѼƤ��s�b�A�N�������r�ꤺ�e�C
	}

	public void paint(Graphics g)
	{ // �bApplet�W�e�e�Ϊ���k
		// Graphics���e�����O�Apaint��k�ݭn�ǤJ��������
		int swidth, sheight; // �w�q����ܼơA�ΨӦs�r�ꪺ���M�e

		Font f = new Font("Dialog", Font.BOLD + Font.ITALIC, 24);
		// �Q��Font���O�w�q�@�Ӧr�Ϊ���A�õ����e
		FontMetrics fm = g.getFontMetrics(f);
		// FontMetrics ���O�����U�ΡA�Ψ����������r�Ϊ��ӳ����e
		swidth = fm.stringWidth(s); // ���o�e
		sheight = fm.getHeight(); // ���o��

		int maxx = getSize().width; // �w�q�ܼơA���o�ثe�����e��
		int maxy = getSize().height; // �w�q�ܼơA���o�ثe��������

		g.setColor(Color.blue); // �]�w�����C��
		g.fillRect(0, 0, maxx, maxy); // �N��ӵe���Ϻ�
		// fileRect��k���e�x�Υ�
		g.setFont(f); // �]�w�r�ΡA�N���e�w�q���r������ǤJ
		g.setColor(Color.orange); // �t�]�����C��
		g.drawString(s, (maxx - swidth) / 2, (maxy + sheight) / 2);
		// �N�r���b��������
		g.drawOval(0, 0, maxx, maxy); // �e�Ӿ��
		g.drawOval(1, 1, maxx - 2, maxy - 2); // �A�e�Ӿ��A�W�[�p��
		g.drawOval(2, 2, maxx - 4, maxy - 4); // �S�e�Ӿ��A�W�[�p��
	}
}
