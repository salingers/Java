package TemplateMethod.Sample;

public class StringDisplay extends AbstractDisplay
{ // StringDisplay�]�OAbstractDisplay���l���O�C
	private String string; // ����X���r��C
	private int width; // �Hbyte�����ҨD�X���r��u�e�סv�C

	public StringDisplay(String string)
	{ // ��H�غc�l�ǻ��L�Ӫ��r��string
		this.string = string; // �x�s�b��줺�C
		this.width = string.getBytes().length; // ���ۧ�Hbyte����쪺�r���e�T�]���x�s�b���A�᭱�ٷ|�ϥΨ�C
	}

	public void open()
	{ // ���мg��A�w�q��open��k�C
		printLine(); // �H�����O����kprintLine�e�X�u�q�C
	}

	public void print()
	{ // print��k�h�b
		System.out.println("|" + string + "|"); // �����x�s���r��e��[�W"|"�A�M���X��e���W�C
	}

	public void close()
	{ // close��k�h�P
		printLine(); // open�A�Q��printLine��k�e�X�{�q�C
	}

	private void printLine()
	{ // �o�Oopen�Mclose�ҩI�s��printLine��k�C�]���o�Oprivate�A�ҥH�u��b�����O���ϥΡC
		System.out.print("+"); // ��X"+"�O�������ئ�m�C
		for (int i = 0; i < width; i++)
		{ // ��Xwidth��"-"�A
			System.out.print("-"); // ��@�u�q�C
		}
		System.out.println("+"); // ��X"+"�O�������ئ�m�C
	}
}
