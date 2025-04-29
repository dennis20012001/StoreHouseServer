package storeHouse.base.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;


    @Column(name = "CIF", nullable = false, length = 9)
    private String CIF;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total", nullable = false)
    private BigDecimal  total;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
    private User userId;
    
    @OneToMany(mappedBy = "invoiceId", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<ProductInvoice> productInvoices;

    public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public List<ProductInvoice> getProductInvoices() {
		return productInvoices;
	}

	public void setProductInvoices(List<ProductInvoice> productInvoices) {
		this.productInvoices = productInvoices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CIF, date, invoiceId, paid, productInvoices, total, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(CIF, other.CIF) && Objects.equals(date, other.date)
				&& Objects.equals(invoiceId, other.invoiceId) && paid == other.paid
				&& Objects.equals(total, other.total)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", userId=" + userId + ", CIF=" + CIF + ", date=" + date + ", total="
				+ total + ", paid=" + paid +  "]";
	}

	
}

