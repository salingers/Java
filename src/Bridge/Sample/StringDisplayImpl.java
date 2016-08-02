package Bridge.Sample;

public class StringDisplayImpl extends DisplayImpl
{
	private String string; // ���C�L���r��C
	private int width; // �Hbyte�����Ҳy�X���r��u�e�T�v�C

	public StringDisplayImpl(String string)
	{ // �غc�l�ǻ��L�Ӫ��r��string�A
		this.string = string; // ���x�s�b���C
		this.width = string.getBytes().length; // ���ۧ�byte��쪺�e�T�]�x�s�����A����᭱�A�Q�ΡC
	}

	public void rawOpen()
	{
		printLine();
	}

	public void rawPrint()
	{
		System.out.println("|" + string + "|"); // �C�L�ɫe��[�W"|"�C
	}

	public void rawClose()
	{
		printLine();
	}

	private void printLine()
	{
		System.out.print("+"); // ��X�ب���"+"�O���C
		for (int i = 0; i < width; i++)
		{ // ��Xwidth��"-"�A
			System.out.print("-"); // �����ؽu�C
		}
		System.out.println("+"); // ��X�ب���"+"�O���C
	}
}
