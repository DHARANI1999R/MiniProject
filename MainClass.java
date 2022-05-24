package mypack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		Login login=new Login();
		ArrayList<Person> list=new ArrayList<Person>();
		System.out.println("***********************************");
		System.out.println("WELCOME TO COURSE MANAGEMENT SYSTEM");
		System.out.println("***********************************");
		Scanner scanner=new Scanner(System.in);
		char ch ;
		int option;
		do
		{
			System.out.println("*******************************");
			System.out.println("1:Register");
			System.out.println("2:Login");
			System.out.println("3:Logout");
			
			System.out.println("ENTER THE OPTION: ");
			System.out.println("*******************************"); 
			option = scanner.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("Register");
				
				if(login.register()== null)
				{
					System.out.println("Register Failed");
				}else
					System.out.println("Registered Successfully");
				
			
				break;
			case 2:
				System.out.println("Login");
				login.signIn();
				break;
			case 3:
				System.out.println("Logout");
				ch='n';
				break;
				default :
					System.out.println("There is no option");
					break;
			
				}
			System.out.println("DO YOU WANT TO CONTINUE PRESS 'y' or 'n'");
			ch = scanner.next().charAt(0);
			
		}while((ch == 'y') || (ch == 'Y'));
			scanner.close();
		
			
		
		

	}

	
}
