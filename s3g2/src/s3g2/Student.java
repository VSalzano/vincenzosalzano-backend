package s3g2;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
	
	private int id;
	private String name;
	private String lastName;
	private String gender;
	private LocalDate birthdate;
	private double avVote;
	private double minVote;
	private double maxVote;
	
	public Student(String name, String lastName, String gender, LocalDate birthdate, double avVote,
			double minVote, double maxVote) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avVote = avVote;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}
	
	public Student(int id, String name, String lastName, String gender, LocalDate birthdate, double avVote,
			double minVote, double maxVote) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avVote = avVote;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public double getAvVote() {
		return avVote;
	}

	public void setAvVote(double avVote) {
		this.avVote = avVote;
	}

	public double getMinVote() {
		return minVote;
	}

	public void setMinVote(double minVote) {
		this.minVote = minVote;
	}

	public double getMaxVote() {
		return maxVote;
	}

	public void setMaxVote(double maxVote) {
		this.maxVote = maxVote;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", birthdate="
				+ birthdate + ", avVote=" + avVote + ", minVote=" + minVote + ", maxVote=" + maxVote + "]";
	}
	
	

}
