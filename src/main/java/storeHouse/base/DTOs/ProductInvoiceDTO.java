package storeHouse.base.DTOs;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductInvoiceDTO {
	private Long invoiceId;
    private Long productId;
    private int quantity;
    private BigDecimal unitPrice;
    
 // Getters y Setters
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
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
		return Objects.hash(invoiceId, productId, quantity, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInvoiceDTO other = (ProductInvoiceDTO) obj;
		return Objects.equals(invoiceId, other.invoiceId) && Objects.equals(productId, other.productId)
				&& quantity == other.quantity && Objects.equals(unitPrice, other.unitPrice);
	}

	@Override
	public String toString() {
		return "ProductInvoiceDTO [invoiceId=" + invoiceId + ", productId=" + productId + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + "]";
	}
}
