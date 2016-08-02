package TemplateMethod.Sample;

public abstract class AbstractDisplay { //©â¶HÃþ§OAbstractDisplay
    public abstract void open();        // ¥Ñ¤lÃþ§O¹ê§@ªº©â¶H¤èªk¡]1¡^open
    public abstract void print();       // ¥Ñ¤lÃþ§O¹ê§@ªº©â¶H¤èªk¡]2¡^print
    public abstract void close();       // ¥Ñ¤lÃþ§O¹ê§@ªº©â¶H¤èªk¡]3¡^close
    public final void display() {       // ¦b¦¹©â¶HÃþ§O¤¤¹ê§@ªº¤èªkdisplay
        open();                             // ¥ýopen¡K
        for (int i = 0; i < 5; i++) {       // ¤ÏÂÐ5¦¸print¡K
            print();                    
        }
        close();                            //¡K³Ì«áclose°_¨Ó¡C³o´N¬O¹ê§@display¤èªk®Éªº¤º®e“à—eB
    }
}
