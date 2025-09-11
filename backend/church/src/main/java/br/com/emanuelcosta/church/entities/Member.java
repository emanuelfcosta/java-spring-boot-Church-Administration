package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_member")
public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = -1303819586164641973L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String role;
    private LocalDate baptismDate;
    private String admission;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String address;
    private String state;
    private String occupation;
}
