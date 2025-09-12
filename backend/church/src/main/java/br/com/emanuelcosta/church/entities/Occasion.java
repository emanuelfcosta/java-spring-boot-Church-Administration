package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_occasion")
public class Occasion implements Serializable {
    @Serial
    private static final long serialVersionUID = -3413568627426028988L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;

    public Occasion() {
    }

    public Occasion(Long id, String name, String description, LocalDate start, LocalDate end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Occasion occasion = (Occasion) o;
        return Objects.equals(id, occasion.id) && Objects.equals(name, occasion.name) && Objects.equals(description, occasion.description) && Objects.equals(start, occasion.start) && Objects.equals(end, occasion.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, start, end);
    }

    @Override
    public String toString() {
        return "Occasion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}


