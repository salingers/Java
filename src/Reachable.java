
import java.awt.*;
import java.io.*;
import java.util.*;

public class Reachable extends Vector
{

		public static void main(String args[])
		{
				Reachable r = new Reachable();
				// r.fillElement();
				System.out.println("before serialize" + r);
				try
				{
						FileOutputStream fos = new FileOutputStream("myData.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(r);
						oos.close();
				} catch (IOException ioe)
				{
						System.out.println(ioe.toString());
				}
				r = null;

				try
				{
						FileInputStream fis = new FileInputStream("myData.ser");
						ObjectInputStream ois = new ObjectInputStream(fis);
						r = (Reachable) ois.readObject();
						ois.close();
				} catch (OptionalDataException od)
				{
				} catch (ClassNotFoundException cfe)
				{
				} catch (IOException ioe)
				{
						System.out.println(ioe.toString());
				}
				System.out.println("be serialized" + r);

				Frame f = new Frame();
				f.setSize(100, 100);
				f.setVisible(true);

		}

		public Reachable()
		{
				this.addElement(Color.red);
				this.addElement(new Integer(99));
				this.addElement(new Point(10, 20));
		}

}