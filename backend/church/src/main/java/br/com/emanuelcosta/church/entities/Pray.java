package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pray")
public class Pray implements Serializable {
    @Serial
    private static final long serialVersionUID = -1510847396349085035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private String description;
    private String priority; // urgent, high, medium, low
    private String status; // done, not done

    public Pray() {
    }

    public Pray(Long id, String reason, String description, String priority, String status) {
        this.id = id;
        this.reason = reason;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Long getId() {
        return id;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pray pray = (Pray) o;
        return Objects.equals(id, pray.id) && Objects.equals(reason, pray.reason) && Objects.equals(description, pray.description) && Objects.equals(priority, pray.priority) && Objects.equals(status, pray.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reason, description, priority, status);
    }

    @Override
    public String toString() {
        return "Pray{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


