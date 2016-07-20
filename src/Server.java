import java.io.*;
import java.net.*;

public class Server
{

	public static void main(String args[])
	{
		String data;
		Socket socket;
		ServerSocket sc;
		BufferedReader input;
		PrintWriter output;

		System.out.println("server listening port 1024.......");
		try
		{
			sc = new ServerSocket(1024);
			socket = sc.accept();
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException ioe)
		{
			System.out.println("Exception" + ioe);
			return;
		}
		try
		{
			while (true)
			{
				data = input.readLine();
				if (data == null)
					break;
				else
				{
					output.println("Server get it:" + data);
					output.flush();
				}
				System.out.println("Recieve :" + data);
			}

			socket.close();
		}
		catch (IOException e)
		{
			System.out.println("Exception" + e);
		}
	}
}