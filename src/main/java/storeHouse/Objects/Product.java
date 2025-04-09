package storeHouse.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6445534935877895573L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

	@Column(name = "image")
    @Lob
    private String image;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "minimum_amount")
    private int minimumAmount;

    @Column(name = "season", nullable = false)
    private boolean season;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
    
    @Column(name = "sell_price", nullable = false)
    private BigDecimal sellPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isSeason() {
		return season;
	}

	public void setSeason(boolean season) {
		this.season = season;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
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
		this.price = sellPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", image=" + image + ", name=" + name + ", amount=" + amount
				+ ", minimumAmount=" + minimumAmount + ", season=" + season + ", enabled=" + enabled + ", price="
				+ price + ", sellPrice=" + sellPrice + "]";
	}
}
