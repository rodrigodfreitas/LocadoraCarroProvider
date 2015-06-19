/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.beans;

import com.pos.ejb.InterfaceNamedQueries;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 *
 * @author lightyear
 */
@Entity@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "IDENTIFICADOR", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue( value = "USUARIO")
@TableGenerator(allocationSize = 1, initialValue = 1, name = "pessoa_seq")
@NamedQueries(value = {
    @NamedQuery(name = InterfaceNamedQueries.LOGIN, query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
})

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "pessoa_seq", strategy = GenerationType.TABLE)
    private Long id;

    private String email;
    private String senha;
    private String nome;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.senha);
        hash = 13 * hash + Objects.hashCode(this.nome);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if(!Objects.equals(this.nome, other.nome)) {        
            return false;
        }
        return true;
    }
    
    

}
