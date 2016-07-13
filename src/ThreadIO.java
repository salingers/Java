

import java.awt.*;
import java.applet.Applet; 
import java.awt.event.*;
import java.io.*;

public class ThreadIO extends Applet {
    PipedWriter pw1to2;
    PipedReader pr2to1;
    PipedThread pipedthread1;
    PipedThread pipedthread2;
    Thread t1=null;
    Thread t2=null;  

    public void init() {
            pw1to2=new PipedWriter();
            pr2to1=new PipedReader();       

       try { 
         pw1to2.connect(pr2to1);  
         pr2to1.connect(pw1to2);  
      }
      catch (IOException ioe) {}        
        pipedthread1=new PipedThread(pw1to2);
        pipedthread2=new PipedThread(pr2to1); 
               
        t1=new Thread( pipedthread1);      
        t2=new Thread( pipedthread2); 

        this.setLayout(new GridLayout(1,2,10,10));
        this.add(pipedthread1);
        this.add(pipedthread2); 
    }
   public void start() {
     if(t1!=null) 
        t1.start();
      if(t2!=null) 
       t2.start();   
   }
   public Insets insets() {
     return new Insets(10,10,20,20);
   }
}

class PipedThread extends Panel implements Runnable {
    PipedWriter pw;
    PipedReader pr;
    Label Iread;
    Label Iwrite;
    int mode=-1;
    public PipedThread(PipedWriter pw) {
        mode=0;
         this.pw=pw;
         setLabel(); 
    } 
    public PipedThread(PipedReader pr) {
         mode=1;
         this.pr=pr;          
         setLabel();
    }
    public void setLabel() {
       Font font=new Font("細明體",Font.PLAIN,15);

       Label lab;
       if (mode==0) {
         this.setLayout(new GridLayout(2,1,10,10));
         this.add("North",lab=new Label("我是寫入執行緒",Label.CENTER));
         this.add("South",Iwrite=new Label("",Label.CENTER));  
         lab.setFont(font);
         Iwrite.setFont(font);  
       }
       else if(mode==1) {        
         this.setLayout(new GridLayout(2,1,10,10));
         this.add("North",lab=new Label("我是讀出執行緒",Label.CENTER));
         this.add("South",Iread=new Label("",Label.CENTER)); 
         lab.setFont(font);
         Iread.setFont(font);  
       }
    } 

    public void run() {     
         int i=0;
        while (true) {
           if(mode==0) {
             char writeTo[]=new char[1];
             try {
              writeTo[0]=(char)Math.floor(Math.random() * 256);
              pw.write(writeTo,0,1);
              pw.flush();  
              Iwrite.setText("傳送"+String.valueOf(writeTo));
             }
             catch(IOException ioe) {} 
           }
          else if(mode==1) {
             char readFrom[]=new char[1];
             try {
              int s=pr.read(readFrom,i,1); 
              if (s==-1) {
                 Iread.setText("沒資料"); }
              else {
                 Iread.setText("讀到"+String.valueOf(readFrom[0]));
              }  
              i++;
             }
             catch(IOException ioe) {} 
           }
           try {Thread.sleep(1000);}
//           try {Thread.sleep(500+500*(int)Math.floor(Math.random() * 4)); }
          catch (InterruptedException e) {}
        }
    }
}
