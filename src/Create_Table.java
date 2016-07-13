import java.net.URL;
import java.sql.*;

class Create_Table
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
								uid = arg[1];
						else
								uid = "";

						if (arg.length > 2)
								pwd = arg[2];
						else
								pwd = "";

						Connection conn_to_db = DriverManager.getConnection(url, uid, pwd);

						Statement query_string = conn_to_db.createStatement();

						try
						{
								query_string.executeUpdate("DROP TABLE store");
						} catch (Exception e)
						{
						}

						query_string.executeUpdate("CREATE TABLE store (id INT,name CHAR(25))");

						String store_data[][] =
						{
										{ "1", "ABCD" },
										{ "2", "EFGH" },
										{ "3", "IJKL" },
										{ "4", "MNOP" },
										{ "5", "QRST" },
										{ "6", "UVWX" } };

						PreparedStatement preparedto = conn_to_db
										.prepareStatement("INSERT INTO store (id,name) VALUES (?,?)");

						for (int i = 0; i < store_data.length; i++)
						{
								preparedto.setInt(1, Integer.parseInt(store_data[i][0]));
								preparedto.setString(2, store_data[i][1]);

								preparedto.executeUpdate();
						}

						query_string.close();
						conn_to_db.close();

						System.out.println("Create Table to DataBase Successfully!!....");
				} catch (Exception e)
				{
						System.out.println(e.getMessage());
						e.printStackTrace();
				}
		}
}