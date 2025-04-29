package storeHouse.base.DTOs;

import java.math.BigDecimal;
import java.util.Objects;

public class DetailsSaleDTO {
	private Long saleId;
    private Long productId;
    private int quantity;
    private BigDecimal unitPrice;
    
 // Getters y Setters
    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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
		return Objects.hash(productId, quantity, saleId, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsSaleDTO other = (DetailsSaleDTO) obj;
		return Objects.equals(productId, other.productId) && quantity == other.quantity
				&& Objects.equals(saleId, other.saleId) && Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "DetailsSaleDTO [saleId=" + saleId + ", productId=" + productId + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + "]";
	}
}
