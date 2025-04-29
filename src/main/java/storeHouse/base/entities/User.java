package storeHouse.base.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	// Columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "mail", unique = true)
	private String mail;

	@Column(name = "image")
	private String image;

	@Column(name = "pass")
	private String pass;

	@Enumerated(EnumType.STRING)
	@Column(name = "rol", nullable = false)
	private Role rol;

	@Column(name = "enabled")
	private Boolean enabled = true;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Invoice> invoices;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Sale> sales;

	public enum Role {
		USUARIO, ADMINISTRADOR
	}

	// Getters and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, image, invoices, mail, name, pass, rol, sales, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(enabled, other.enabled) && Objects.equals(image, other.image)
				&& Objects.equals(invoices, other.invoices) && Objects.equals(mail, other.mail)
				&& Objects.equals(name, other.name) && Objects.equals(pass, other.pass) && rol == other.rol
				&& Objects.equals(sales, other.sales) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mail=" + mail + ", image=" + image + ", pass=" + pass
				+ ", rol=" + rol + ", enabled=" + enabled + "]";
	}
}
