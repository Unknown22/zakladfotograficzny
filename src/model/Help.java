package model;

public class Help {

	private int id_help;
	private String email;
	private String message;

	
	public Help(){
		
	}
	
	public Help(String email, String message) {
		this.email = email;
		this.message = message;
	}

	public int getId_help() {
		return id_help;
	}

	public void setId_help(int id_help) {
		this.id_help = id_help;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

