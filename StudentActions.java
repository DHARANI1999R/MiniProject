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

public class StudentActions 
{
	Scanner scanner=new Scanner(System.in);
	List<Course> list=new ArrayList<Course>();
	Course course=new Course();
	ObjectOutputStream out = null;
	ListIterator<Course>iterator = null;
	ObjectInputStream in = null;
	File file2 = new File("Enroll.txt");
	File file1 = new File("Course.txt");
	

	public void viewCourses() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		in = new ObjectInputStream(new FileInputStream(file1));
		list = (List<Course>) in.readObject();
		in.close();
		boolean flag=false;
		ListIterator<Course>iterator = list.listIterator();
		while(iterator.hasNext())
		{
			course=(Course)iterator.next();
			System.out.println();
			System.out.println(course.courseName);
			
		}
		
	}


	public void enrollCourses() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name: ");
		String userName=scanner.next();
		System.out.println("Enter your CourseName: ");
		String courseName=scanner.next();
		System.out.println("Doing Payment: ");
		String paymentStatus=scanner.next();
		List<Enroll> list=new ArrayList<Enroll>();
		list.add(new Enroll(userName,courseName,paymentStatus));
		out = new ObjectOutputStream(new FileOutputStream(file2));//it is used to write the userdetails into file
		out.writeObject(list);
		out.close();
		
		
	}
	

}
