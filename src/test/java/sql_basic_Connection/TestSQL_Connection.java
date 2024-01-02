package sql_basic_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQL_Connection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Hr","Testing@12");
		
		String Sql="select * from employees";
		
		PreparedStatement prepareStatement = connection.prepareStatement(Sql);
		ResultSet executeQuery = prepareStatement.executeQuery();
		
		System.out.println("Emp.ID"+ " 	"+ "FirstName");
		
		while (executeQuery.next())
		{
			
			int int1 = executeQuery.getInt("EMPLOYEE_ID");
			String string = executeQuery.getString("FIRST_NAME");
			
			System.out.println(+int1+" 	"+string);
		}
		
		connection.close();
	}

}
