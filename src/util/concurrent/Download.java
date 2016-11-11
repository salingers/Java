package util.concurrent;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Download
{
	public static void main(String[] args) throws Exception
	{
		URL[] urls =
		{ new URL("http://openhome.cc/Gossip/Encoding/"), new URL("http://openhome.cc/Gossip/Scala/"),
				new URL("http://openhome.cc/Gossip/JavaScript/"), new URL("http://openhome.cc/Gossip/Python/") };

		String[] fileNames =
		{ "Encoding.html", "Scala.html", "JavaScript.html", "Python.html" };

		// new Pages(urls, fileNames, new DirectExecutor()).download();
		// new Pages(urls, fileNames, new ThreadPerTaskExecutor()).download();

		ExecutorService executorService = Executors.newCachedThreadPool();
		new Pages(urls, fileNames, executorService).download();
		executorService.shutdown();
	}
}
