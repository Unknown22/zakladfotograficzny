package model;

public class Login {
	private String login;
	private String password;

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

}
