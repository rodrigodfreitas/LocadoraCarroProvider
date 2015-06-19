/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.service;

import com.pos.beans.Carro;
import com.pos.beans.Locadora;
import com.pos.beans.Reserva;
import com.pos.ejb.ReservaDao;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author lightyear
 */
@WebService(serviceName = "LocadoraProviderWS")
@Stateless()
public class LocadoraProviderWS {

    /**
     * This is a sample web service operation
     */@EJB
   private ReservaDao dao;    
    
    @WebMethod(operationName = "criarReserva")
    public boolean criarReserva(@WebParam(name = "reserva") Reserva r) {
        return dao.criarReserva(r);
    }

    @WebMethod(operationName = "pesquisarReserva")
    //Não recomendo
    public List<Reserva> pesquisarReservaPorData(@WebParam(name = "data") Date data) {
       return dao.verificarReservasPorData(data);
    }

    @WebMethod(operationName = "listarReservas")
    public List<Reserva> listarReservas() {
        return dao.listarReservas();
    }

    @WebMethod(operationName = "buscarLocadorasPorCidade")
    public List<Locadora> buscarLocadorasPorCidade(@WebParam(name = "cidade") String cidade) {
        return dao.buscarLocadoraPorCidade(cidade);
    }
    
    @WebMethod(operationName = "listarCarros")
    public List<Carro> listarCarros() {
        return dao.listarCarros();
    }
    
    @WebMethod(operationName = "listarCarrosPorLocadora")
    public List<Carro> listarCarrosPorLocadora(@WebParam(name = "locadoraId") String cnpj) {
        return dao.listarCarrosPorLocadora(cnpj);
    }
}


