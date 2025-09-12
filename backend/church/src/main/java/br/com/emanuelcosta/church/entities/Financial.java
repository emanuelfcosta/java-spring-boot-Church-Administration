package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_financial")
public class Financial implements Serializable {
    @Serial
    private static final long serialVersionUID = 5168523477713772192L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; //income, expense
    private BigDecimal amount;
    private LocalDate theDate;
    private String paymentMethod; // cash, credit card

    public Financial() {
    }

    public Financial(Long id, String type, BigDecimal amount, LocalDate theDate, String paymentMethod) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.theDate = theDate;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTheDate() {
        return theDate;
    }

    public void setTheDate(LocalDate theDate) {
        this.theDate = theDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Financial financial = (Financial) o;
        return Objects.equals(id, financial.id) && Objects.equals(type, financial.type) && Objects.equals(amount, financial.amount) && Objects.equals(theDate, financial.theDate) && Objects.equals(paymentMethod, financial.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, theDate, paymentMethod);
    }

    @Override
    public String toString() {
        return "Financial{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", theDate=" + theDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

