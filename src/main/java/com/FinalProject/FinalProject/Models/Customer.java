package com.FinalProject.FinalProject.Models;


import net.bytebuddy.build.ToStringPlugin;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerid")
    private String customerid;
    /* @OneToOne
    @PrimaryKeyJoinColumn(name = "transactionid")
    Transaction transaction;*/
  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")  //send fetch
    private List<Transaction> transactions;*/



    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phonenumber")
    private String phonenumber;


    public Customer() {
    }

    public Customer(String customerid, String firstname, String lastname, String phonenumber) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;

    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
