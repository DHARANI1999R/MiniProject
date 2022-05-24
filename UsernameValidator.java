package mypack;
import java.util.regex.*;


	public class UsernameValidator {

		public static boolean userNameValidation(String name)
	    {
			 String regex="^[a-zA-Z][a-zA-z0-9_]{6,19}$";
	    Pattern pattern = Pattern.compile(regex);
	    
	    if(name==null)
	    	System.out.println("You cannot enter a empty username");
	    Matcher matcher = pattern.matcher(name);
	    
	    return matcher.matches();
		}

		
	}