package storeHouse.base.DTOs;

import java.util.Objects;

import storeHouse.base.entities.User;

//DTO para recibir los datos de usuario
public class UserDTO {

	private String name;
	private String mail;
	private String image;
	private String pass;
	private User.Role rol;
	private Boolean enabled;

	// Getters y Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User.Role getRol() {
		return rol;
	}

	public void setRol(User.Role rol) {
		this.rol = rol;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, image, mail, name, pass, rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(enabled, other.enabled) && Objects.equals(image, other.image)
				&& Objects.equals(mail, other.mail) && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass) && rol == other.rol;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", mail=" + mail + ", image=" + image + ", pass=" + pass + ", rol=" + rol
				+ ", enabled=" + enabled + "]";
	}
}
