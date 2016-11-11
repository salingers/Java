package io;

import java.io.*;
import java.awt.*;

public class SpecialMathod implements Serializable
{
		private String data;
		private transient String transientData;

		public SpecialMathod()
		{
				data = "Hi data";
				transientData = "Hello transientData";
		}

		public static void main(String args[])
		{
				SpecialMathod sm = new SpecialMathod();

				System.out.println("before serialize");
				System.out.println(sm.data);
				System.out.println(sm.transientData);

				try
				{
						FileOutputStream fos = new FileOutputStream("myData.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(sm);
						oos.close();
				} catch (IOException ioe)
				{
						System.out.println(ioe.toString());
				}

				sm = null;

				try
				{
						FileInputStream fis = new FileInputStream("myData.ser");
						ObjectInputStream ois = new ObjectInputStream(fis);
						sm = (SpecialMathod) ois.readObject();
						ois.close();
				} catch (OptionalDataException od)
				{
				} catch (ClassNotFoundException cfe)
				{
				} catch (IOException ioe)
				{
						System.out.println(ioe.toString());
				}

				System.out.println("after serialized");
				System.out.println(sm.data);
				System.out.println(sm.transientData);

				Frame f = new Frame();
				f.setSize(100, 100);
				f.setVisible(true);

		}

		private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
		{
				ois.defaultReadObject();

				this.data = ois.readUTF();
				this.transientData = "transientData be reseted";
				System.out.println("readObject() is called");
		}

		private void writeObject(ObjectOutputStream oos) throws IOException
		{
				oos.defaultWriteObject();

				oos.writeUTF("change Data");
				System.out.println("writeObject() is called");
		}
}
