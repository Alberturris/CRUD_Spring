/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserrano.dao;

import aserrano.entidades.Cliente;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alberturris
 */
@Repository
public class ClienteDAO implements InterfaceClienteDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public List<Cliente> getClientes() {
        
        // Obtener session
        Session session = sessionFactory.getCurrentSession();
        // Crear la consulta
        Query<Cliente> query = session.createQuery("from Cliente", Cliente.class);
        
        // Ejecutar la query y devolver resultados
        List<Cliente> listaClientes = query.getResultList();
        
        return listaClientes;
    }

    @Override
    @Transactional
    public void insertarCliente(Cliente cliente) {
        // Obtener session
        Session session = sessionFactory.getCurrentSession();
        // Insertar el cliente
        //session.save(cliente);
        session.saveOrUpdate(cliente);
    }

    @Override
    @Transactional
    public Cliente getCliente(int id) {
        // Obtener session
        Session session = sessionFactory.getCurrentSession();
        
        // Obtener la session del cliente seleccionado
        Cliente cliente = session.get(Cliente.class, id);
        
        return cliente;
    }

    @Override
    @Transactional
    public void eliminarCliente(int id) {
        
        Session session = sessionFactory.getCurrentSession();
        
        // Borrar el cliente de la BBDD utilizando como criterio su ID
        /*Query consulta = session.createQuery("delete from Cliente where id=:IdCliente");
        consulta.setParameter("IdCliente", id);
        
        consulta.executeUpdate();*/
        
        session.delete(session.get(Cliente.class, id));
    }
    
}
