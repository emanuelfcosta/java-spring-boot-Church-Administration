package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_study")
public class Study implements Serializable {
    @Serial
    private static final long serialVersionUID = 5866592032460492738L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate theDate;
    private String subject;
    private String description;
    private String notes;


    public Study() {
    }

    public Study(Long id, LocalDate theDate, String subject, String description, String notes) {
        this.id = id;
        this.theDate = theDate;
        this.subject = subject;
        this.description = description;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }



    public LocalDate getTheDate() {
        return theDate;
    }

    public void setTheDate(LocalDate theDate) {
        this.theDate = theDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Study study = (Study) o;
        return Objects.equals(id, study.id) && Objects.equals(theDate, study.theDate) && Objects.equals(subject, study.subject) && Objects.equals(description, study.description) && Objects.equals(notes, study.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theDate, subject, description, notes);
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", theDate=" + theDate +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}


