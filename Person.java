package mypack;
import java.io.Serializable;

public class Person implements Serializable
{
	public String name;
	public String password;
	public String mobileno;
	public String role; 
	
	public Person()
	{
		super();
	}
	public Person(String name,String password,String mobileno,String role)
	{
		this.name=name;
		this.password=password;
		this.mobileno=mobileno;
		this.role=role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", mobileno=" + mobileno + ", role=" + role + "]";
	}
	

}
