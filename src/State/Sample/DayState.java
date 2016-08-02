package State.Sample;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {                                // �غc�l��private
    }
    public static State getInstance() {                 // ���o�ߤ@������
        return singleton;
    }
    public void doClock(Context context, int hour) {    // �]�w�ɶ�
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context) {                // �ϥΪ��w
        context.recordLog("�ϥΪ��w(�դ�)");
    }
    public void doAlarm(Context context) {              // ĵ�a
        context.callSecurityCenter("ĵ�a(�դ�)");
    }
    public void doPhone(Context context) {              // �@��q��
        context.callSecurityCenter("�@�몺�q��(�դ�)");
    }
    public String toString() {                          // ��X�r��
        return "[�դ�]";
    }
}
