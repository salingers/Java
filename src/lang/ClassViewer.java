package lang;

import static java.lang.System.out;
import java.lang.reflect.*;

public class ClassViewer
{
	public static void main(String[] args)
	{
		try
		{
			ClassViewer.view(args[0]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.println("瘝����");
		}
		catch (ClassNotFoundException e)
		{
			out.println("�銝����");
		}
	}

	public static void view(String clzName) throws ClassNotFoundException
	{
		Class clz = Class.forName(clzName);

		showPackageInfo(clz);
		showClassInfo(clz);

		out.println("{");

		showFiledsInfo(clz);
		showConstructorsInfo(clz);
		showMethodsInfo(clz);

		out.println("}");
	}

	private static void showPackageInfo(Class clz)
	{
		Package p = clz.getPackage(); // ����辣隞�銵函隞�
		out.printf("package %s;%n", p.getName());
	}

	private static void showClassInfo(Class clz)
	{
		int modifier = clz.getModifiers(); // �����耨憌曉虜�
		out.printf("%s %s %s", Modifier.toString(modifier), // 撠虜�頧摮葡銵函內
				Modifier.isInterface(modifier) ? "interface" : "class", clz.getName() // ������迂
		);
	}

	private static void showFiledsInfo(Class clz) throws SecurityException
	{
		// ���恐������隞�銵函隞�
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields)
		{
			// 憿舐內甈�耨憌橘��public�rotected�rivate
			out.printf("\t%s %s %s;%n", Modifier.toString(field.getModifiers()), field.getType().getName(), // 憿舐內����迂
					field.getName() // 憿舐內鞈����迂
			);
		}
	}

	private static void showConstructorsInfo(Class clz) throws SecurityException
	{
		// ���恐���遣瑽瘜誨銵函隞�
		Constructor[] constructors = clz.getDeclaredConstructors();
		for (Constructor constructor : constructors)
		{
			// 憿舐內甈�耨憌橘��public�rotected�rivate
			out.printf("\t%s %s();%n", Modifier.toString(constructor.getModifiers()), constructor.getName() // 憿舐內撱箸���迂
			);
		}
	}

	private static void showMethodsInfo(Class clz) throws SecurityException
	{
		// ���恐���瘜�隞�銵函隞�
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods)
		{
			// 憿舐內甈�耨憌橘��public�rotected�rivate
			out.printf("\t%s %s %s();%n", Modifier.toString(method.getModifiers()), method.getReturnType().getName(), // 憿舐內餈��澆���迂
					method.getName() // 憿舐內�瘜�迂
			);
		}
	}
}
