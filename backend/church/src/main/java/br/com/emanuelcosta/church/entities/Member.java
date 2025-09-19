package br.com.emanuelcosta.church.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_member")
public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = -1303819586164641973L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;// ACTIVE/disciplined, deceased, inactive
    private String role; // (pastor, elder, deacon, evangelist, worker, youth leader, children's department leader,
    // women's group leader, men's leader, prayer group leader, evangelism leader, worship leader
    private LocalDate baptismDate;
    private String admission; // acclamation, baptism, letter, recommendation, transfer, others
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String address;
    private String state;
    private String occupation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id")

    private Church church;

    public Member() {
    }

    public Member(Long id, String status, String role, LocalDate baptismDate, String admission, String name, String gender, LocalDate birthdate, String address, String state, String occupation, Church church) {
        this.id = id;
        this.status = status;
        this.role = role;
        this.baptismDate = baptismDate;
        this.admission = admission;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
        this.state = state;
        this.occupation = occupation;
        this.church = church;
    }

    public Long getId() {
        return id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getBaptismDate() {
        return baptismDate;
    }

    public void setBaptismDate(LocalDate baptismDate) {
        this.baptismDate = baptismDate;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(status, member.status) && Objects.equals(role, member.role) && Objects.equals(baptismDate, member.baptismDate) && Objects.equals(admission, member.admission) && Objects.equals(name, member.name) && Objects.equals(gender, member.gender) && Objects.equals(birthdate, member.birthdate) && Objects.equals(address, member.address) && Objects.equals(state, member.state) && Objects.equals(occupation, member.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, role, baptismDate, admission, name, gender, birthdate, address, state, occupation);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", baptismDate=" + baptismDate +
                ", admission='" + admission + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", occupation='" + occupation + '\'' +
                ", churchId=" + (church != null ? church.getId() : null) +
                '}';
    }
}
