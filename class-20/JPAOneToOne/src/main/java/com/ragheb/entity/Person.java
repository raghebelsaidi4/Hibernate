package com.ragheb.entity;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    private Integer personId;

    private String personName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", unique = true, nullable = false)
    private Passport passport;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
