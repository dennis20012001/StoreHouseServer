package storeHouse.base.DTOs;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class SaleDTO {
	
    private Long productId;
    private Long userId;
    private Date date;
    private BigDecimal total;
	
    // Getters y Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

	@Override
	public int hashCode() {
		return Objects.hash(date, productId, total, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleDTO other = (SaleDTO) obj;
		return Objects.equals(date, other.date) && Objects.equals(productId, other.productId)
				&& Objects.equals(total, other.total) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "SaleDTO [productId=" + productId + ", userId=" + userId + ", date=" + date + ", total=" + total + "]";
	}
}
