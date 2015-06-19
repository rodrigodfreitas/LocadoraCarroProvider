/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author lightyear
 */
@Remote
public interface InternoDao {
    
    public boolean salvar(Object obj);
    
    public boolean atualizar(Object obj);
    
    public boolean excluir(Object obj); 
    
    public Object consultaSimples(String namedQuerie, Map<?, ?> mapa);
}
