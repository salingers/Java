package cc.openhome;
public class ProxyDemo {
    public static void main(String[] args) { 
        LoggingHandler loggingHandler  = new LoggingHandler();  
        I18N helloProxy = (I18N) loggingHandler.bind(new HelloSpeaker()); 
        helloProxy.hello("Justin");
    }
} 
