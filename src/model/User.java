package model;

public class User {
	//private int id_user;
	private String login;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int id_account_type;
	private int id_department;
	
	User(){
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String fname){
		firstname=fname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public void setLastname(String lname){
		lastname=lname;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public int getIdAccountType(){
		return id_account_type;
	}
	
	public void setIdAccountType(int id){
		this.id_account_type=id;
	}
	
	public int getIdDepartment(){
		return id_department;
	}
	
	public void setIdDepartment(int id){
		this.id_department=id;
	}
}
