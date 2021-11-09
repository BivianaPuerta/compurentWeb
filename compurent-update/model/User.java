package com.compurent.compurent.model;

import java.io.Serializable;
//import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String name;
    private String email;
    private String password;
    //private Date insertDateTime;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="user")
    @JsonIgnoreProperties("user")
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="user")
    @JsonIgnoreProperties("user")
    private List<Reservation> reservations;

    @OneToOne
    @JsonIgnoreProperties({"users","rols"})
    private Rol rol;

   
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    // public Date getInsertDateTime() {
    //     return insertDateTime;
    // }
    // public void setInsertDateTime(Date insertDateTime) {
    //     this.insertDateTime = insertDateTime;
    // }

    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

