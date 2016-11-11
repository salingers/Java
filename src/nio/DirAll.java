package nio;

import java.io.IOException;
import java.nio.file.*;

import cc.openhome.ConsoleFileVisitor;

public class DirAll
{
	public static void main(String[] args) throws IOException
	{
		Files.walkFileTree(Paths.get(args[0]), new ConsoleFileVisitor());
	}
}
