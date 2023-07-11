package s3g2;

import java.sql.SQLException;
import java.time.LocalDate;

public class MainProject {

	public static void main(String[] args) {
		
		
		try {
			DbConnection db = new DbConnection();
			
			Student s1 = new Student("Mario", "Rossi", "male", LocalDate.of(2000, 5, 15), 8.5, 6.0, 9.0);
			System.out.println(s1);
			//db.insertStudent(s1);
	        Student s2 = new Student("Anna", "Verdi", "female", LocalDate.of(2001, 7, 10), 9.0, 7.5, 9.5);
	        //db.insertStudent(s2);
	        Student s3 = new Student("Vincenzo", "Salzano", "male", LocalDate.of(2000, 9, 22), 7.8, 6.5, 8.9);
	        //db.insertStudent(s3);
	        Student s4 = new Student("Lucia", "Neri", "female", LocalDate.of(2002, 3, 5), 8.9, 7.0, 9.2);
	        //db.insertStudent(s4);
	        Student s5 = new Student("Antonio", "Bianchi", "male", LocalDate.of(2001, 11, 18), 7.2, 6.0, 8.5);
	        //db.insertStudent(s5);
			
	        
	        Student student = db.readStudent(2);
	        System.out.println(student);
	        //student.setMinVote(10);
	        //student.setMaxVote(10);
	        //db.updateStudent(student);
	        //db.deleteStudent(student);
	       
	        System.out.println("Best student : " + db.bestStudent());
	        
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}


	}

}
