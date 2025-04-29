package storeHouse.base.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total", nullable = false)
    private BigDecimal total;
    
    @OneToMany(mappedBy = "saleId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetailsSale> detailsSales;

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetailsSale> getDetailsSales() {
		return detailsSales;
	}

	public void setDetailsSales(List<DetailsSale> detailsSales) {
		this.detailsSales = detailsSales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, detailsSales, productId, saleId, total, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(date, other.date) && Objects.equals(detailsSales, other.detailsSales)
				&& Objects.equals(productId, other.productId) && Objects.equals(saleId, other.saleId)
				&& Objects.equals(total, other.total) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", productId=" + productId + ", userId=" + userId + ", date=" + date
				+ ", total=" + total + "]";
	}
}