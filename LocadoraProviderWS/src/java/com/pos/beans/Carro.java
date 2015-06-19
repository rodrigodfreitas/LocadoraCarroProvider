/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author lightyear
 */
@Entity
public class Carro implements Serializable{

    
    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String placa;
   
    private String modelo;
    private float valor;
    private int ano;
    private boolean disponivel;

    
    public Carro() {
    }

    public Carro(String modelo, float valor, int ano, String placa, boolean disponivel) {
        this.modelo = modelo;
        this.valor = valor;
        this.ano = ano;
        this.placa = placa;
        this.disponivel = disponivel;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.modelo);
        hash = 89 * hash + Float.floatToIntBits(this.valor);
        hash = 89 * hash + this.ano;
        hash = 89 * hash + Objects.hashCode(this.placa);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

}
