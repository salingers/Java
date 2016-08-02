package State.Sample;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {                              // �غc�l��private
    }
    public static State getInstance() {                 // ���o�ߤ@������
        return singleton;
    }
    public void doClock(Context context, int hour) {    // �]�w�ɶ�
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {                // �ϥΪ��w
        context.callSecurityCenter("���`�G�߶��ϥΪ��w�I");
    }
    public void doAlarm(Context context) {              // ĵ�a
        context.callSecurityCenter("ĵ�a(�߶�)");
    }
    public void doPhone(Context context) {              // �@��q��
        context.recordLog("�߶����q�ܿ���");
    }
    public String toString() {                          // ��X�r��
        return "[�߶�]";
    }
}
