package storeHouse.base.entities;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_invoice")
public class ProductInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoiceId;

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

	public Invoice getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Invoice invoiceId) {
		this.invoiceId = invoiceId;
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
		return Objects.hash(detailId, invoiceId, productId, quantity, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInvoice other = (ProductInvoice) obj;
		return Objects.equals(detailId, other.detailId) && Objects.equals(invoiceId, other.invoiceId)
				&& Objects.equals(productId, other.productId) && quantity == other.quantity
				&& Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "ProductInvoice [detailId=" + detailId + ", invoiceId=" + invoiceId + ", productId=" + productId
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
}
