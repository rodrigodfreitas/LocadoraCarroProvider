/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.beans.Carro;
import com.pos.beans.Locadora;
import com.pos.beans.Reserva;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.inject.Named;

/**
 *
 * @author lightyear
 */
@Remote
@Named(value = "DaoReserva")
public interface ReservaDao {    

    public boolean criarReserva(Reserva r);

    public List<Reserva> listarReservas();
    
    public List<Reserva> verificarReservasPorData(Date data);

    public List<Locadora> buscarLocadoraPorCidade(String cidade);
    
    public List<Carro> listarCarros();

    public List<Carro> listarCarrosPorLocadora(String cnpj);

}
