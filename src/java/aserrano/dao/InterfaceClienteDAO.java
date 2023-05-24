/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserrano.dao;

import aserrano.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Alberturris
 */
public interface InterfaceClienteDAO {
    
    // Devuelve los clientes
    public List<Cliente> getClientes();
    
    // Inserta un cliente
    public void insertarCliente(Cliente cliente);

    // Devuelve un cliente según su id
    public Cliente getCliente(int id);

    // Elimina un cliente según su id
    public void eliminarCliente(int id);
}
