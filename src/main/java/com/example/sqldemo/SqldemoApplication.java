package com.example.sqldemo;

import com.example.sqldemo.dao.StudentDAO;
import com.example.sqldemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqldemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);
		};
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
}
