package State.Sample;

public interface Context
{

	public abstract void setClock(int hour); // �]�w�ɶ�

	public abstract void changeState(State state); // ���A�ܤ�

	public abstract void callSecurityCenter(String msg); // �I�s�O������

	public abstract void recordLog(String msg); // �O�����߫O�d�O��
}
