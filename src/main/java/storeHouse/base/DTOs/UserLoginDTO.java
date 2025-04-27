package storeHouse.base.DTOs;

//Se utiliza para enviar el token una vez realizado el login
public class UserLoginDTO {
	private String username;
	private String password;

	// Getters y setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
