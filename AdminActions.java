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

public class AdminActions 
{
	Scanner scanner=new Scanner(System.in);
	List<Course> list=new ArrayList<Course>();
	ObjectOutputStream out = null;
	ListIterator<Course>iterator = null;
	ObjectInputStream in = null;
	File file1 = new File("Course.txt");
	File file2 = new File("Enroll.txt");
	Course course=new Course();
	Enroll enroll=new Enroll();
	

	public List<Course> addCourses() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome Admin!!you can add multiple users");
		System.out.println();
		System.out.println("How many users do you want to add");
		int userCount=scanner.nextInt();
		//ArrayList<UserDetails> addList = new ArrayList<UserDetails>();
		
		for (int i=0;i<userCount;i++) {
			System.out.println("Enter the courseId");
			int courseId=scanner.nextInt();
			System.out.println("Enter the courseName");
			String courseName=scanner.next();
			System.out.println("Enter the courseDuration");
			int courseDuration=scanner.nextInt();
			
			
			list.add(new Course(courseId,courseName,courseDuration));
			}
		out = new ObjectOutputStream(new FileOutputStream(file1));//it is used to write the userdetails into file
		out.writeObject(list);
		out.close();
		return list;
		
	}



	public void deleteCourses() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter the courseId to delete");
		int delete_courseId=scanner.nextInt();
		in = new ObjectInputStream(new FileInputStream(file1));
		
		list = (List<Course>) in.readObject();
		in.close();
		boolean flag=false;
		ListIterator<Course>iterator = list.listIterator();
		//ListIterator<Course>iterator =list.listIterator();;
		//traversing file
		while (iterator.hasNext()) {
			System.out.println("3");
			//System.out.println(iterator2.next());
			 course = (Course)iterator.next();
			if (course.courseId==(delete_courseId)) {
				iterator.remove();
				System.out.println("2");
				flag = true;
				break;
			}
		}
		if(flag)
		{
			out = new ObjectOutputStream(new FileOutputStream(file1));//it is used to write the userdetails into file
			out.writeObject(list);
			out.close();
		}else
		{
			System.out.println("There is no course with this courseId"+delete_courseId);
		}
		
	}



	public void displayCourses() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		in = new ObjectInputStream(new FileInputStream(file1));
		list = (List<Course>) in.readObject();
		in.close();
		ListIterator<Course>iterator = list.listIterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		
	}



	public void updateCourses(int update_courseId) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		in = new ObjectInputStream(new FileInputStream(file1));
		list = (List<Course>) in.readObject();
		in.close();
		iterator = list.listIterator();
		while (iterator.hasNext()) {
			course=(Course)iterator.next();
		if(course.courseId==update_courseId){
			System.out.println("what do you want to update");
			System.out.println("1:CourseId");
			System.out.println("2:CourseName");
			System.out.println("3:CourseDuration");
			int choose = scanner.nextInt();
			switch(choose) {
			case 1:
				System.out.println("Enter the CourseId to update");
				int courseId =scanner.nextInt();
				course.setCourseId(courseId);
				flag=false;
				break;
			case 2:
				System.out.println("Enter the CourseName to update");
				String courseName =scanner.next();
				course.setCourseName(courseName);
				flag=false;
				break;
			case 3:
				System.out.println("Enter the CourseDuration to update");
				int courseDuration =scanner.nextInt();
				course.setCourseDuration(courseDuration);
				flag=false;
				break;
				default:
					System.out.println("There is no such a option");
			}
			
			
		}
		}
		if(flag) {
			System.out.println("there is no record with this no "+update_courseId);
		}else
			System.out.println("Course details Updated Successfully");
		out = new ObjectOutputStream(new FileOutputStream(file1));// it is used to write the coursedetails into file
		out.writeObject(list);
		out.close();
		
		
		
	}



	public void paymentReceipt() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		in = new ObjectInputStream(new FileInputStream(file2));
		List<Enroll> list1=new ArrayList<Enroll>();
		list1 = (List<Enroll>) in.readObject();
		in.close();
		ListIterator<Enroll>iterator = list1.listIterator();
		while(iterator.hasNext())
		{
			enroll=(Enroll)iterator.next();
			System.out.println("Name : "+enroll.userName);
			System.out.println("CourseEnrolled : "+enroll.courseName);
			System.out.println("PaymentStatus : "+enroll.paymentStatus);
			break;
			
		}
		
		
	}
	

}
