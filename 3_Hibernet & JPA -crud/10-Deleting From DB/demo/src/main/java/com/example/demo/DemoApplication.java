package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);}

        @Bean
        public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
            return runner->{
                //createStudent(studentDAO);

                //createMultipleStudents(studentDAO);

                //readStudent(studentDAO);

                //queryForStudents(studentDAO);
                
                //queryForFindByLastName(studentDAO);

                //updateStudent(studentDAO);

                //updateAllStudent(studentDAO);

                //deleteBasedOnLastName(studentDAO);

                deleteOnId(studentDAO);

            };
        }

    private void deleteOnId(StudentDAO studentDAO) {
        int id = 5;
        studentDAO.deleteById(id);

    }

    private void deleteBasedOnLastName(StudentDAO studentDAO) {
        String lastName="paul";

        studentDAO.deleteOne(lastName);
    }

    private void updateAllStudent(StudentDAO studentDAO) {
        //retrive all student
//        List<Student> studentList = studentDAO.findAll();
//
//        //update every one at a time
//        for(Student tempStudent : studentList){
//            tempStudent.setLastName("Coder");
//            studentDAO.update(tempStudent);
//        }

        //OR
            //using object
//        Student tempStudent = new Student();
//        tempStudent.setLastName("Coder");
//        studentDAO.updateAll(tempStudent);

        String newLastName = "peekaBoo";
        studentDAO.updateAll(newLastName);

        List<Student> studentList1 = studentDAO.findAll();

        for(Student temp:studentList1)
            System.out.println(temp);

    }

    private void updateStudent(StudentDAO studentDAO) {
        //retriev student based on id (pk)
        int studentId =1;
        System.out.println("Getting Student with Id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        //change last name to Scooby
        System.out.println("Updating studnet ... ");
        myStudent.setLastName("Bijwe");


        //update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("Updated Student: " + myStudent);

    }

    private void queryForFindByLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findByLastName("Bijwe");

        for(Student temp: studentList)
            System.out.println(temp);

    }

    private void queryForStudents(StudentDAO studentDAO) {
    //get a list of studnets
        List<Student> studentList = studentDAO.findAll();

    //display it
        for(Student temp : studentList)
        System.out.println(temp );

    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ....");
        Student tempStudent = new Student("Mayank" , "Bijwe", "XYZ@gmail.com");

        //save the student object
        System.out.println("Saving the Student..");

        studentDAO.save(tempStudent);

        //Display id of the saved student
        System.out.println("Saved student. Generated ID: " + tempStudent.getId());

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student objects ....");
        Student tempStudent1 = new Student("John" , "Doe", "abc@gmail.com");
        Student tempStudent2 = new Student("Mary" , "Jone", "pqr@gmail.com");
        Student tempStudent3 = new Student("Spoody" , "Man", "ac@gmail.com");

        //save multiple student
        System.out.println("Saving 3 student objects..");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void readStudent(StudentDAO studentDAO) {

        //create a student object
        System.out.println("Creating new Student...");
        Student tempStudent = new Student("Daffy" , "Duck", "daffy@gmail.com");

        //save the student
        System.out.println("Saving student objects..");
        studentDAO.save(tempStudent);

        //display id of the saved student
        int tempId=tempStudent.getId();
        System.out.println("Saved Student Id: " + tempId);

        //retrieve student based on id using pk
        System.out.println("Retriving student with given id: " + tempId);
        Student myStudent = studentDAO.findById(tempId);

        //display student
        System.out.println("Gotchaaa");
        System.out.println(myStudent);


    }


}
