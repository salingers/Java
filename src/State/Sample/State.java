package State.Sample;

public interface State
{
	public abstract void doClock(Context context, int hour); // �]�w�ɶ�

	public abstract void doUse(Context context); // �ϥΪ��w

	public abstract void doAlarm(Context context); // ĵ�a

	public abstract void doPhone(Context context); // �@��q��
}
