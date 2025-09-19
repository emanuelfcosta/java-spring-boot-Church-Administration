package br.com.emanuelcosta.church.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private LocalDate foundationdate;
    private String cnpj;
    private String phone;


    @OneToMany(mappedBy = "church")
    @JsonIgnore
    private List<Member> members = new ArrayList<>();

    public Church() {
    }

    public Church(Long id, String name, String responsible, String website, String type, String address, String city, String state, LocalDate foundationdate, String cnpj, String phone) {
        this.id = id;
        this.name = name;
        this.responsible = responsible;
        this.website = website;
        this.type = type;
        this.address = address;
        this.city = city;
        this.state = state;
        this.foundationdate = foundationdate;
        this.cnpj = cnpj;
        this.phone = phone;
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

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getFoundationdate() {
        return foundationdate;
    }

    public void setFoundationdate(LocalDate foundationdate) {
        this.foundationdate = foundationdate;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member){
        members.add(member);
        member.setChurch(this);
    }

    public void removeMember(Member member){
        members.remove(member);
        member.setChurch(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Church church = (Church) o;
        return Objects.equals(id, church.id) && Objects.equals(name, church.name) && Objects.equals(responsible, church.responsible) && Objects.equals(website, church.website) && Objects.equals(type, church.type) && Objects.equals(address, church.address) && Objects.equals(city, church.city) && Objects.equals(state, church.state) && Objects.equals(foundationdate, church.foundationdate) && Objects.equals(cnpj, church.cnpj) && Objects.equals(phone, church.phone) && Objects.equals(members, church.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, responsible, website, type, address, city, state, foundationdate, cnpj, phone, members);
    }

    @Override
    public String toString() {
        return "Church{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", responsible='" + responsible + '\'' +
                ", website='" + website + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", foundationdate=" + foundationdate +
                ", cnpj='" + cnpj + '\'' +
                ", phone='" + phone + '\'' +
                ", memberCount=" + members.size() +
                '}';
    }
}
