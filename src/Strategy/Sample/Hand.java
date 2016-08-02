package Strategy.Sample;

public class Hand {
    public static final int HANDVALUE_GUU = 0;  // ��ܥ��Y����
    public static final int HANDVALUE_CHO = 1;  // ��ܰŤM����
    public static final int HANDVALUE_PAA = 2;  // ��ܥ�����
    public static final Hand[] hand = {         // ��ܲq����ժ�3�ӹ��
        new Hand(HANDVALUE_GUU),
        new Hand(HANDVALUE_CHO),
        new Hand(HANDVALUE_PAA),
    };
    private static final String[] name = {      // �q����ժ��r��
        "���Y", "�ŤM", "��",
    };
    private int handvalue;                      // �q����դ���
    private Hand(int handvalue) {
        this.handvalue = handvalue;
    }
    public static Hand getHand(int handvalue) { // �q�Ȩ��o���
        return hand[handvalue];
    }
    public boolean isStrongerThan(Hand h) {     // �YthisĹ�Lh�A�h��true
        return fight(h) == 1;
    }
    public boolean isWeakerThan(Hand h) {       // �Ythis�鵹h�A�h��true
        return fight(h) == -1;
    }
    private int fight(Hand h) {                 // ����h��0�A�Ythis�ӥX�h��1�B�Yh�ӥX�h��-1
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }
    public String toString() {                  // �ഫ���r��
        return name[handvalue];
    }
}
