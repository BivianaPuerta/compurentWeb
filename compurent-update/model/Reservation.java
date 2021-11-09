/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compurent.compurent.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *
 * @author Biviana Puerta
 */
@Entity
@Table(name="reservation")
/**
 * @class Reservation
 * 
 */
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    //private Date insertDateTime;

    /**
     * Many to One (Reservation to Computer)
     */
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservations")
    private Computer computer;

    @ManyToOne
    @JoinColumn(name="idUser")
    @JsonIgnoreProperties({"messages", "reservations"})
    private User user;

    /**
     * Many to One(Reservation to Client)
     */
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    private String score;

    // @ManyToOne
    // @JoinColumn(name="stateId")
    // @JsonIgnoreProperties("reservation")
    // private State state;

    /**
     * Getter and Setter
     * @return idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     * Getter and Setter
     * @return idstarDate
     */
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter and Setter
     * @return devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * Getter and Setter
     * @return status
     */
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
     /**
     * Getter and Setter
     * @return computer
     */
    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
      /**
     * Getter and Setter
     * @return client
     */
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
      /**
     * Getter and Setter
     * @return score
     */
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
      // public Date getInsertDateTime() {
    //     return insertDateTime;
    // }
    // public void setInsertDateTime(Date insertDateTime) {
    //     this.insertDateTime = insertDateTime;
    // }
    
    // public State getState() {
    //     return state;
    // }
    // public void setState(State state) {
    //     this.state = state;
    // }
    
}
