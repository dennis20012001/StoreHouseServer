package storeHouse.Objects;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7337035534787335578L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "CIF", nullable = false, unique = true, length = 9)
    private String CIF;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "paid", nullable = false)
    private boolean paid;

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", user=" + user + ", CIF=" + CIF + ", date=" + date + ", total="
				+ total + ", paid=" + paid + "]";
	}
}
