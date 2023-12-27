package pack1;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.InputStream;

public class test3 {

	public static void main(String args[]) {
		String url="jdbc:mysql://localhost:3306/data1";
		String username="root";
		String password="Root";
		
		String filePath="C://siddhi//MJImage1.jpg";
		
		try {
			Connection conn = DriverManager.getConnection(url , username , password);
			
			String sql="INSERT INTO tb8(name,img)values(?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "NATURE");
			
			InputStream inputStream  = new FileInputStream(new File(filePath));
			statement.setBlob(2, inputStream);
			
			int row = statement.executeUpdate();
			if(row > 0){
				System.out.println("A contact was inserted with photo image.");
			}
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
