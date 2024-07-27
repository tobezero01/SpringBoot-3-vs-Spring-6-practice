package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//findById(appDAO);
			//deleteInstructorById(appDAO);

			//createInstructorWithCourse(appDAO);

			//findInstructorWithCourse(appDAO);
			//findCoursesByInstructorId(appDAO);

			//findInstructorByIdJoinFetch(appDAO);
			updateInstructor(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 3;

		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setFirstName("NHU DINH ");
		appDAO.updateInstructor(instructor);
		System.out.println(instructor);
	}
	private void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int id = 3;

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

	}
	private void findCoursesByInstructorId(AppDAO appDAO) {
		int id = 3;

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		System.out.println(courses);
	}
	private void findInstructorWithCourse(AppDAO appDAO) {
		int id = 3;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor.getCourses());
	}
	private void createInstructorWithCourse(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("Air Guitar 1");
		Course course2 = new Course("Information tech 1" );

		tempInstructor.addCourse(course1);
		tempInstructor.addCourse(course2);

		appDAO.save(tempInstructor);
	}

	private void findDetailById(AppDAO appDAO) throws Exception{
		int id = 3;
		InstructorDetail instructorDetail = appDAO.findDetailById(id);
		System.out.println(instructorDetail.toString());
	}

	private void findById(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor.toString());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
	}

	private void deleteDetailById(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteDetailById(id);
	}
	private void createInstructor(AppDAO appDAO) {


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}








