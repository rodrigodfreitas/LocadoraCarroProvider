/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author lightyear
 */
@Stateless
public class InternoDaoImpl implements InternoDao {

    @PersistenceContext(unitName = "LocadoraCarroProviderPU")
    private EntityManager entityManager;

    @Override
    public boolean salvar(Object obj) {
        try {
            entityManager.persist(obj);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean atualizar(Object obj) {
        try {
            entityManager.merge(obj);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean excluir(Object obj) {
        try {
            entityManager.remove(entityManager.merge(obj));
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
    
    @Override
    public Object consultaSimples(String namedQuerie, Map<?, ?> mapa) {
        try {
            
            Query q = entityManager.createNamedQuery(namedQuerie);
            q = setParametrosNaQuery(q, mapa);
            List l = q.getResultList();
            
            return !l.isEmpty() ? l.get(0) : null;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Query setParametrosNaQuery(Query query, Map<?, ?> mapa) {
        for (String key : (Set<String>) mapa.keySet()) {
            if (mapa.get(key) instanceof Date) {
                query.setParameter(key, (Date) mapa.get(key), TemporalType.DATE);
            } else {
                query.setParameter(key, mapa.get(key));
            }
        }
        return query;
    }
}
