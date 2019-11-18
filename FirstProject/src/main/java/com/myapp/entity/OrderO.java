package com.myapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int cantitate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column
    private String confirmationNumber;

    public int getId() {
        return id;
    }

    public int getCantitate() {
        return cantitate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
