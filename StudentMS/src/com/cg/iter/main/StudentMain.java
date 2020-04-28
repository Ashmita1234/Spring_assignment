package com.cg.iter.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.iter.bean.Address;
import com.cg.iter.bean.Student;
import com.cg.iter.service.StudentService;

public class StudentMain {
	
	
	private StudentService sService;

	public StudentMain() {
		
		
		//accepts annotated classes as input. For instance, @Configuration or @Component . 
		//Beans can be looked up with scan() or registered with register() .
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();	
		appContext.scan("com.cg.iter");    //specifies the package we want to scan
		appContext.refresh();  //entire app will be reloaded or recreated
		
		sService = (StudentService) appContext.getBean("studentService");
		System.out.println(sService);
		Scanner scan = new Scanner(System.in);int choice = 0;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Student");
				System.out.println("Enter <houseId> <City>");
				Address addr = new Address(scan.nextInt(),scan.next());
				System.out.println("Enter <ID> <Name> <Mobile> <Subject>");
				Student stud = new Student(scan.nextInt(),scan.next(),
						          scan.nextLong(),scan.next(),addr);
				boolean success = sService.create(stud);
				if(success) {
					System.out.println("Student saved");
				}
				else {
					System.out.println("Could not save student");
				}
				break;
			case 2:
				
				System.out.println("Enter Student Id");
				Student student = sService.findStudentById(scan.nextInt());
				if(student==null) {
					System.out.println("Student not found");
				}
				else {
					System.out.println(student);
				}
				break;
			case 3:
				
				System.out.println("Enter Student Id");
				Student upStudent = sService.findStudentById(scan.nextInt());
				if(upStudent!=null) {
					System.out.println("Enter <Name> <Mobile> <Subject>");
					upStudent.setName(scan.next());
					upStudent.setMobile(scan.nextLong());
					upStudent.setSubject(scan.next());
					Address AddressUp = upStudent.getAddress();
					
					System.out.println("Enter<City>");
					AddressUp.setCity(scan.next());
					
					upStudent.setAddress(AddressUp);
					
					if(sService.updateStudent(upStudent)) {
						System.out.println("Updated sucessfully");
					}
					else {
						System.out.println("Fail to update");
					}
				}
				else {
					System.out.println("Student not found");
				}
				break;
			case 4:
				System.out.println("Enter Student Id");
				if(sService.deleteStudent(scan.nextInt())) {
					System.out.println("Removed sucessfully");
				}
				
				break;
			
			case 5:
				System.out.println("Exiting Program");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 5 only");
				break;
			}
		}
	}
		private int getChoice(Scanner scan) {
			int choice = 0;
			System.out.println("STUDENT MANAGEMENT");
			System.out.println("1. Create Student");
			System.out.println("2. Find Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit Program");
			System.out.println("Choose the option from above");
			try {
			choice = scan.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("Please choose a number");
				scan.nextLine();
			}
			return choice;
		}		
		
	
	public static void main(String[] args) {
		new StudentMain();
	}

}
