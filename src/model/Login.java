package model;

public class Login {
	private String login;
	private String password;
	private static int authorization = -1;
	private static int my_id = 0;

	public static int getMy_id() {
		return my_id;
	}

	public static void setMy_id(int my_id) {
		Login.my_id = my_id;
	}

	public Login() {

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

	@Override
	public String toString() {
		return "Login: " + login + " password: " + password;
	}

	public int getAuthorization() {
		return authorization;
	}

	public void setAuthorization(int authorization) {
		this.authorization = authorization;
	}

}
