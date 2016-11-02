package frank.java.chapter13.loader;

import java.security.NoSuchAlgorithmException;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * �鈭�內蝟餌��恕����掩��蝸������
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class SystemClassLoaderShow
{

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		ClassLoader l1 = SystemClassLoaderShow.class.getClassLoader();
		System.out.println("蝟餌��/摨蝐餃�蝸�嚗t" + l1);
		System.out.println("�撅掩��蝸�嚗t" + l1.getParent());
		System.out.println("撘紡蝐餃�蝸�嚗�" + l1.getParent().getParent());

		// rt.jar 銝剔�掩� BootStrap ClassLoader ��蝸
		ClassLoader l2 = String.class.getClassLoader();
		System.out.println(l2);

		// ext/*.jar 銝剔�掩� Extensions ClassLoader ��蝸
		ClassLoader l3 = AESKeyGenerator.class.getClassLoader();
		System.out.println(l3);
	}

}
