package com.example.sqldemo;

import com.example.sqldemo.dao.StudentDAO;
import com.example.sqldemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqldemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student
		int studentID = 1;
		Student theStudent = studentDAO.findById(studentID);
		//update student
		theStudent.setLastName("Bar");
		//save student
		studentDAO.update(theStudent);
		//display changes
		System.out.println(studentDAO.findById(1));
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list
		for (Student e : theStudents) {
			System.out.println(e);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		//create
		Student newStudent = new Student("Find me", "If you can", "nowhere@tobefound.com");
		//save
		studentDAO.save(newStudent);
		//display of saved
		int theId = newStudent.getId();
		System.out.println("The ID created was: " + theId);
		//retrieve
		Student retrieved = studentDAO.findById(theId);
		//display found
		System.out.println(retrieved);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("creating new object student");
		Student tempStudent = new Student("Paul", "Doe", "this.is@sparta.com");
		// save the student object
		System.out.println("Saving student");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("saved student. ID is: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("creating multiple students");
		Student tempStudent1 = new Student("Paul", "Doe", "this.is@sparta.com");
		Student tempStudent2 = new Student("Mary", "Dawn", "hey.ho@lets.go");
		Student tempStudent3 = new Student("Paul", "brown", "yay@yoy.com");

		//saving them
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> s = studentDAO.findByLastName("Doe");

		for (Student e : s) {
			System.out.println(e);
		}


	}

}
