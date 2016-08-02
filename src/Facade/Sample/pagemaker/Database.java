package Facade.Sample.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {    //�ŧiprivate�H�Knew�ɷ|���ͪ������
    }
    public static Properties getProperties(String dbname) { //�q��Ʈw�W�٨��oProperties
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
