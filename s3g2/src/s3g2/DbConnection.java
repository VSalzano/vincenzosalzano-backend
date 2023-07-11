package s3g2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "school";
	String user = "postgres";
	String pass = "root";
	Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, user, pass);
		st = conn.createStatement();
		createStudentsTable ();
		System.out.println("Connessione stabilita");
	}
	
	public void createStudentsTable () throws SQLException {
		String sql =  " CREATE TABLE IF NOT EXISTS school_students ("
				+ "		id SERIAL PRIMARY KEY,"
				+ " 	name VARCHAR NOT NULL,"
				+ "		last_name VARCHAR NOT NULL,"
				+ "		gender VARCHAR NOT NULL,"
				+ "     birthdate DATE NOT NULL,"
	            + "     av_vote DECIMAL DEFAULT 0,"
	            + "     min_vote DECIMAL DEFAULT 0,"
	            + "     max_vote DECIMAL DEFAULT 0"
				+ " );" ;
	st.executeUpdate(sql);
	System.out.println("Students table created");
		
	}
	
	public void insertStudent (Student s) throws SQLException {
		String sql = " INSERT INTO school_students (name, last_name, gender, birthdate, av_vote, min_vote, max_vote) "
				   + "VALUES ('"+s.getName()+"', '"+s.getLastName()+"', '"+ s.getGender()+"', '"+s.getBirthdate()+"', '"+s.getAvVote()+"', '"+s.getMinVote()+"', '"+s.getMaxVote()+"');";
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastName() + " created!");
		
	}
	
	public void updateStudent(Student s) throws SQLException {
		st.executeUpdate("UPDATE school_students SET "
                + "name='"+s.getName()+"', "
                + "last_name='"+s.getLastName()+"', "
                + "gender='"+s.getGender()+"', "
                + "birthdate='"+s.getBirthdate()+"', "
                + "av_vote='"+s.getAvVote()+"', "
                + "min_vote='"+s.getMinVote()+"', "
                + "max_vote='"+s.getMaxVote()+"' "
                + "WHERE id="+s.getId());
		System.out.println(s.getName() + " " + s.getLastName() + " udpated!");
	}
	
	public void deleteStudent(Student s) throws SQLException {
		String sql = "DELETE FROM school_students WHERE id = " + s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastName() + " deleted");
	}
	
	public Student bestStudent() throws SQLException {
		String sql = "SELECT * FROM school_students ORDER BY av_vote DESC LIMIT 1";
		ResultSet rs = st.executeQuery(sql); 
		Student bestStudent = null;
		if(rs.next()) {
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			String lastName = rs.getString("last_name");
			String gender = rs.getString("gender");
			LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
			double avVote = rs.getDouble("av_vote");
			double minVote = rs.getDouble("min_vote");
			double maxVote = rs.getDouble("max_vote");
			bestStudent = new Student(id1, name, lastName, gender, birthdate, avVote, minVote, maxVote);	
		}
		return bestStudent;
	}
	
	public Student readStudent(int id) throws SQLException {
		String sql = "SELECT * FROM school_students WHERE id = " + id;
		ResultSet rs = st.executeQuery(sql);
		Student s = null;
		if(rs.next()) {
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			String lastName = rs.getString("last_name");
			String gender = rs.getString("gender");
			LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
			double avVote = rs.getDouble("av_vote");
			double minVote = rs.getDouble("min_vote");
			double maxVote = rs.getDouble("max_vote");
			s = new Student(id1, name, lastName, gender, birthdate, avVote, minVote, maxVote);	
		}
		return s;
	}

}
