/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lightyear
 */
@Entity
public class Reserva implements Serializable {

    @Id
    @SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)   
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    private String email;

    @OneToOne
    private Locadora locadora;

    private Carro carro;
    
    private float total;

    public Reserva() {
    }

    public Reserva(Date dataInicio, Date dataFim, String email, Locadora locadora, Carro carro, float total) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.email = email;
        this.locadora = locadora;
        this.carro = carro;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        total = this.carro.getValor();
        this.total = total;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.dataInicio);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.locadora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.locadora, other.locadora)) {
            return false;
        }
        return true;
    }

  
    

}
