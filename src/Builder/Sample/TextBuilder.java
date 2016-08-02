package Builder.Sample;

public class TextBuilder extends Builder
{
	private StringBuffer buffer = new StringBuffer(); // �}�l�b�����إߤ��

	public void makeTitle(String title)
	{ // �@���r�榡�����D
		buffer.append("==============================\n"); // ����
		buffer.append("�y" + title + "�z\n"); // ���y�z�����D
		buffer.append("\n"); // �Ŧ�
	}

	public void makeString(String str)
	{ // �@���r�榡���r��
		buffer.append('��' + str + "\n"); // �������r��
		buffer.append("\n"); // �Ŧ�
	}

	public void makeItems(String[] items)
	{ // �@���r�榡������
		for (int i = 0; i < items.length; i++)
		{
			buffer.append("�E" + items[i] + "\n"); // ���E������
		}
		buffer.append("\n"); // �Ŧ�
	}

	public void close()
	{ // �������
		buffer.append("==============================\n"); // ����
	}

	public String getResult()
	{ // �������
		return buffer.toString(); // ��StringBuffer�ഫ��String
	}
}
