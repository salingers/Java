package frank.java.chapter13.loader;

import java.security.NoSuchAlgorithmException;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 用于演示系统默认提供的类加载器的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class SystemClassLoaderShow {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		ClassLoader l1 = SystemClassLoaderShow.class.getClassLoader();
		System.out.println("系统/应用类加载器：\t" + l1);
		System.out.println("扩展类加载器：\t" + l1.getParent());
		System.out.println("引导类加载器：" + l1.getParent().getParent());
		
		// rt.jar 中的类由 BootStrap ClassLoader 加载
		ClassLoader l2 = String.class.getClassLoader();
		System.out.println(l2);

		// ext/*.jar 中的类由 Extensions ClassLoader 加载
		ClassLoader l3 = AESKeyGenerator.class.getClassLoader();
		System.out.println(l3);		
	}

}
