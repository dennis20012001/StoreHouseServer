package storeHouse.Objects;

import java.io.Serializable;
import java.util.Arrays;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1350406165074818831L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "mail", unique = true, length = 100)
	private String mail;
	
	@Column(name = "image")
    @Lob
    private String image;

	@Column(name = "pass", length = 255)
	private String pass;

	@Enumerated(EnumType.STRING)
	@Column(name = "rol", nullable = false)
	private Role rol;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	public Long getIdUser() {
		return userId;
	}

	public void setIdUser(Long idUser) {
		this.userId = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public enum Role {
		USUARIO, ADMINISTRADOR
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mail=" + mail + ", image=" + image
				+ ", pass=" + pass + ", rol=" + rol + ", enabled=" + enabled + "]";
	}
}
