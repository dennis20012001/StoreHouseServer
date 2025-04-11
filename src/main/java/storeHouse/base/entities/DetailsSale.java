package storeHouse.base.entities;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_sale")
public class DetailsSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale saleId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Sale getSaleId() {
		return saleId;
	}

	public void setSaleId(Sale saleId) {
		this.saleId = saleId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detailId, productId, quantity, saleId, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsSale other = (DetailsSale) obj;
		return Objects.equals(detailId, other.detailId) && Objects.equals(productId, other.productId)
				&& quantity == other.quantity && Objects.equals(saleId, other.saleId)
				&& Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "DetailsSale [detailId=" + detailId + ", saleId=" + saleId + ", productId=" + productId + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + "]";
	}
}

