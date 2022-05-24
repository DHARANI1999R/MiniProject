package mypack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Login 
{
	AdminActions adminActions=new AdminActions();
	StudentActions studentActions=new StudentActions();
	Scanner scanner = new Scanner(System.in);
	ArrayList<Person> list = new ArrayList<Person>(); 
	ObjectOutputStream out = null;
	ListIterator<Person>iterator = null;
	Person person = new Person();
	File file = new File("Person.txt");
	
	ObjectInputStream in = null;
	boolean flag;
	
   
	public ArrayList<Person> register() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the role");
		String role = scanner.next();
		System.out.println("Enter the Mobile number");
		String mobilenumber = scanner.next();
		System.out.println("Enter the username");
		String name = scanner.next();
		
		if (UsernameValidator.userNameValidation(name)) {
			System.out.println("valid username");
			System.out.println("Enter the Password");
			String password = scanner.next();
			if (PassWordValidator.passWordValidation(password)) {
				System.out.println("valid password");
				System.out.println("Enter the confirmpassword");
				String confirmPassword = scanner.next();
				if(password.equals(confirmPassword)) {
					//added
					list.add(new Person(name,password, mobilenumber,role));
					ObjectOutputStream out = null;
					out = new ObjectOutputStream(new FileOutputStream(file));
					out.writeObject(list);
					out.close();
					flag=true;
				}else {
					System.out.println("Password does not match");
					flag=false;
				}
				
			}else {
				System.out.println("Enter a valid password");
				flag=false;
			}
		}else {
			System.out.println("Not a valid user name");
			flag=false;
		}
		if(flag==true) {
			return list;
		}else {
			return null; 
		}
	}

	public void signIn() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("enter the Username");
		String signinName = scanner.next();
		System.out.println("enter the password");
		String signinPassword = scanner.next();
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("Person.txt"));
		List<Person> list=(List<Person>)objectInputStream.readObject();
		iterator = list.listIterator();
		
		
		while (iterator.hasNext()) {
			person = (Person) iterator.next();
			
			if (signinName.equalsIgnoreCase(person.name) && signinPassword.equalsIgnoreCase(person.password)) {
				System.out.println("Login Successfully");
				flag = false;
				
				if (person.role.equals("admin")) {
					char ch = ' ';
					
					System.out.println("admin");
					do {
						System.out.println("*****************");
						System.out.println("** HII Admin!YOU CAN DO BELOW ACTIONS ****");
						System.out.println("*****************");
						System.out.println("1: ADD COURSES");
						System.out.println("2: DELETE COURSES");
						System.out.println("3: UPDATE COURSES");
						System.out.println("4: DISPLAY COURSES");
						System.out.println("5: PAYMENT RECEIPT");
						System.out.println("*****************");
						System.out.println();
						System.out.println("What you do wish to check from the above list");
						int option = scanner.nextInt();
						switch (option) {
						case 1:
							adminActions.addCourses();
							
							break;
						case 2:
							adminActions.deleteCourses();
							break;
						case 3:
							System.out.println("Enter the courseId to Update ");
							int update_courseId=scanner.nextInt();
							adminActions.updateCourses(update_courseId);
							break;
						case 4:
							adminActions.displayCourses();
							break;
						case 5:
							adminActions.paymentReceipt();
							break;
							default :
								System.out.println("There is no such a option");
						}

						System.out.println("do you want to contiue admin operations then press 'y'");
						ch = scanner.next().charAt(0);
					} while (ch == 'y' || ch == 'Y');
					//break;
				} else if (person.role.equals("student")) {
					System.out.println("Student");				
					flag = false;
					char ch=' ';
					do {
						System.out.println("************************************************");
						System.out.println("HII User!YOU CAN DO BELOW OPERATIONS");
						System.out.println("************************************************");
						System.out.println("1: VIEW COURSES");
						System.out.println("2: ENROLL COURSES");
						
						System.out.println("Enter the option to continue from the above list");
						int choice=scanner.nextInt();
						switch(choice) {
						case 1:
							studentActions.viewCourses();
							
							break;
						case 2:
							studentActions.enrollCourses();
							break;
							default :
								System.out.println("There is no such a operation");
                        
						}
						System.out.println("if you want to continue user operations press 'y' otherwise 'n'");
					ch=scanner.next().charAt(0);
				}while(ch=='y'||ch=='Y');

			}
			}else
				System.out.println("Failed");
		
		

	}
	}
				
					
				
}
