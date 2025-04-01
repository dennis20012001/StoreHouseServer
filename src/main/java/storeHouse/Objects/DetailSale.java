package storeHouse.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_sale")
public class DetailSale implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 173550304553800533L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long detailId;

		@ManyToOne
		@JoinColumn(name = "sale_id", nullable = false)
		private Sales sale;

		@ManyToOne
		@JoinColumn(name = "product_id", nullable = false)
		private Product product;

		@Column(nullable = false)
		private int quantity;

		@Column(nullable = false, precision = 10, scale = 2)
		private BigDecimal unitPrice;

		public Long getDetailId() {
			return detailId;
		}

		public void setDetailId(Long detailId) {
			this.detailId = detailId;
		}

		public Sales getSale() {
			return sale;
		}

		public void setSale(Sales sale) {
			this.sale = sale;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
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
			return Objects.hash(detailId, product, quantity, sale, unitPrice);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DetailSale other = (DetailSale) obj;
			return Objects.equals(detailId, other.detailId) && Objects.equals(product, other.product)
					&& quantity == other.quantity && Objects.equals(sale, other.sale)
					&& Objects.equals(unitPrice, other.unitPrice);
		}

		@Override
		public String toString() {
			return "DetailSale [detailId=" + detailId + ", sale=" + sale + ", product=" + product + ", quantity="
					+ quantity + ", unitPrice=" + unitPrice + "]";
		}
		
		
	}

