/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.beans.Carro;
import com.pos.beans.Locadora;
import com.pos.beans.Reserva;
import com.pos.beans.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lightyear
 */
@Stateless
public class ReservaDaoImpl implements ReservaDao {

    @PersistenceContext(unitName = "LocadoraCarroProviderPU")
    EntityManager em;

    InternoDaoImpl dao;
    
    public ReservaDaoImpl() {
    }

    @Override
    public boolean criarReserva(Reserva r) {
        if (r.getCarro().isDisponivel() == true) {
                 em.persist(r);
                 Carro c = r.getCarro();
                    c.setDisponivel(false);
                em.merge(c);
            
           
            return true;
        }
        return false;

    }

    @Override
    public List<Reserva> listarReservas() {
        return (List<Reserva>) em.createQuery("select r from Reserva r").getResultList();
    }

    @Override
    public List<Reserva> verificarReservasPorData(Date data) {
        Query q = em.createQuery("select r from Reserva r where r.dataInicial = :datainicio");
        q.setParameter("dataInicial", new Date());
        return q.getResultList();
        
    }
    
    @Override
    public List<Locadora> buscarLocadoraPorCidade(String cidade) {
        Query q = em.createQuery("select l from Locadora l where l.cidade = :cidade");
        q.setParameter("cidade", cidade);
        return q.getResultList();
    }
    
    @Override
    public List<Carro> listarCarrosPorLocadora(String cnpj) {
        Query q = em.createQuery("select c from Locadora l join l.carros c where l.cnpj = :cnpj and c.disponivel = TRUE");
        q.setParameter("cnpj", cnpj);
        return q.getResultList();
    }

    public boolean usuarioExiste(String email) {
        List<Usuario> users;
        Query q = em.createQuery("select u from Usuario u where u.email = :email");
        q.setParameter("email", email);
        users = q.getResultList();
        return users.size() > 0;

    }

    @Override
    public List<Carro> listarCarros() {
        Query q = em.createQuery("select c from Carro c");
        return q.getResultList();
    }
}
