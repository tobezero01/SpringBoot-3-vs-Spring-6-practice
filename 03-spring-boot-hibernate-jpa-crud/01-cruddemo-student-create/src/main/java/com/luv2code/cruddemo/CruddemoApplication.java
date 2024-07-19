package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner  commandLineRunner(StudentDao studentDao) {

		return runner -> {
			//createStudent(studentDao);
			deleteAll(studentDao);
			createMultipleStudent(studentDao);
			//System.out.println("Hello world");
			//readStudent(studentDao);

			//queryForStudents(studentDao);
			//queryForStudentByLastName(studentDao);

			//updateStudent(studentDao);

			//deleteStudent(studentDao);


		};
	}


	void deleteAll(StudentDao studentDao) {
		System.out.println("\nStart delete ALL");
		int numRows = studentDao.deleteAll();
		System.out.println("Rows delete : " + numRows);
		System.out.println("End delete ALL \n");
	}

	public void deleteStudent(StudentDao studentDao) {
		System.out.println("\n Start delete");
		int id = 3;
		//Student student = studentDao.findbyId(id);

		studentDao.delete(id);
		queryForStudents(studentDao);
		System.out.println("End delete \n");
	}

	public void updateStudent(StudentDao studentDao) {
		System.out.println("\n Start update");
		int id = 1;
		Student student = studentDao.findbyId(id);
		student.setFirstName("DinhDuc");

		studentDao.update(student);
		//studentDao.save(student);
		System.out.println(student.toString());
		System.out.println("End update \n");
	}

	public void queryForStudentByLastName(StudentDao studentDao) {
		System.out.println("\nStart find by LastName");
		List<Student> students = studentDao.findByLastName("Duc");

		for (Student s : students) {
			System.out.println(s.toString());
		}

		System.out.println("End find by LastName\n");
	}

	public void queryForStudents(StudentDao studentDao) {
		// get a list student
		System.out.println("\nGet all Student ");
		List<Student> students = studentDao.finAllList();

		for(Student s : students) {
			System.out.println(s.toString());
		}

		System.out.println("End select all\n");
	}

	public void readStudent(StudentDao studentDao)  {

		Student stdent2 = studentDao.findbyId(8);

		System.out.println(stdent2.toString());

	}


	public void createMultipleStudent(StudentDao studentDao) {
		System.out.println("Creating many student object ... ");
		Student temStudent = new Student("Nhu","Duc", "Ducnhuad@gmmil.com");
		Student temStudent1 = new Student("Nguyen","Tung", "Ducnhuad@gmmil.com");

		Student temStudent2 = new Student("Tran","Kien", "Ducnhuad@gmmil.com");

		studentDao.save(temStudent);
		studentDao.save(temStudent1);
		studentDao.save(temStudent2);

	}
	public void createStudent(StudentDao studentDao) {

		// create
		System.out.println("Creating new student object ... ");
		Student temStudent = new Student("Duc2","nhu", "Ducnhuad@gmmil.com");

		// saving
		studentDao.save(temStudent);

		//
		System.out.println("Saved student  Id = " + temStudent.getId());

	}

//	private void createMultipleStudents(StudentDAO studentDAO) {
//
//		// create multiple students
//		System.out.println("Creating 3 student objects ...");
//		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
//		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
//		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
//
//		// save the student objects
//		System.out.println("Saving the students ...");
//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);
//	}
//

}







