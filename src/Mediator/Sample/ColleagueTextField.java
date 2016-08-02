package Mediator.Sample;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;
    public ColleagueTextField(String text, int columns) {   // �غc�l
        super(text, columns);
    }
    public void setMediator(Mediator mediator) {            // �O�dMediator
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {      // Mediator���ܦ��ġ��L��
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }
    public void textValueChanged(TextEvent e) {             // �Y�r�꦳�ܤơA�h�q��Mediator
        mediator.colleagueChanged();
    }
}
