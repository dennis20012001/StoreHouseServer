package storeHouse.Objects;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    public Long getSaleId() { return saleId; }
    public void setSaleId(Long saleId) { this.saleId = saleId; }

    public Users getUser() { return users; }
    public void setUser(Users user) { this.users = user; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    @Override
    public int hashCode() {
        return Objects.hash(date, saleId, total, users);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sales other = (Sales) obj;
        return Objects.equals(date, other.date) && Objects.equals(saleId, other.saleId)
                && Objects.equals(total, other.total) && Objects.equals(users, other.users);
    }

    @Override
    public String toString() {
        return "Sales [saleId=" + saleId + ", users=" + users + ", total=" + total + ", date=" + date + "]";
    }
}
