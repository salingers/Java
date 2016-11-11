package sql;

import java.net.URL;
import java.sql.*;

class Access_List
{
	public static void main(String arg[])
	{
		if (arg.length == 0)
		{
			System.exit(1);
		}

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = arg[0];
			String uid, pwd;

			if (arg.length > 1)
			{
				uid = arg[1];
			}
			else
			{
				uid = "";
			}

			if (arg.length > 2)
			{
				pwd = arg[2];
			}
			else
			{
				pwd = "";
			}

			Connection conn_to_db = DriverManager.getConnection(url, uid, pwd);
			Statement query_string = conn_to_db.createStatement();
			ResultSet query_result = query_string.executeQuery("SELECT * FROM book");

			System.out.println("Name            Telephone       Home            Work            Organization");
			System.err.println("=======         =========       =======         ========        ============");

			while (query_result.next()) //
			{
				String name = query_result.getString("Name");
				String tel = query_result.getString("Telephone");
				String home = query_result.getString("Home_Address");
				String work = query_result.getString("Work_Address");
				String org = query_result.getString("Organization");
				System.out.println(name + "\t" + tel + "\t" + "\t" + home + "\t" + "\t" + work + "\t" + "\t" + org);
			}

			query_string.close();
			conn_to_db.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}