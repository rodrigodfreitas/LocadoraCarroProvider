/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.service;

import com.pos.beans.Usuario;
import com.pos.ejb.InterfaceNamedQueries;
import com.pos.ejb.InternoDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author lightyear
 */
@WebService(serviceName = "InternoUsuario")
@Stateless()
public class InternoUsuario {

        @EJB
    private InternoDao dao;
    private Map<String, Object> mapa;
    

    @WebMethod(operationName = "logar")
    public boolean logar( @WebParam(name = "email")String email, @WebParam(name = "senha")String senha) {
        mapa = new HashMap<>();
        mapa.put("email", email);
        mapa.put("senha", senha);
        return dao.consultaSimples(InterfaceNamedQueries.LOGIN, mapa) != null ? true : false;
    }

    @WebMethod(operationName = "cadastrar")
    public boolean cadastrarUsuario(@WebParam(name = "user")Usuario user) {
        return dao.salvar(user);
    }

    @WebMethod(operationName = "atualizar")
    public boolean atualizarUsuario(@WebParam(name = "user")Usuario user) {
        return dao.atualizar(user);
    }

    @WebMethod(operationName = "remover")
    public boolean removerUsuario(@WebParam(name = "user")Usuario user) {
        return dao.excluir(user);
    }

    
}
