package br.com.emanuelcosta.church.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_church")
public class Church implements Serializable  {


    @Serial
    private static final long serialVersionUID = 4699771122126004074L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String responsible;
    private String website;
    private String type;
    private String address;
    private String city;
    private String state;


}
