package storeHouse.base.DTOs;

import java.math.BigDecimal;
import java.util.Objects;

import storeHouse.base.entities.User;

public class ProductDTO {

	private String name;
	private String image;
	private int amount;
	private int minimumAmount;
	private Boolean season;
	private Boolean enabled;
	private BigDecimal price;
	private BigDecimal sellPrice;

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
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public Boolean getSeason() {
		return season;
	}

	public void setSeason(Boolean season) {
		this.season = season;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, enabled, image, minimumAmount, name, price, season, sellPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return amount == other.amount && Objects.equals(enabled, other.enabled) && Objects.equals(image, other.image)
				&& minimumAmount == other.minimumAmount && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(season, other.season)
				&& Objects.equals(sellPrice, other.sellPrice);
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", image=" + image + ", amount=" + amount + ", minimumAmount="
				+ minimumAmount + ", season=" + season + ", enabled=" + enabled + ", price=" + price + ", sellPrice="
				+ sellPrice + "]";
	}
}
