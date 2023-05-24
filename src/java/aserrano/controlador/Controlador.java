/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserrano.controlador;


import aserrano.dao.InterfaceClienteDAO;
import aserrano.entidades.Cliente;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Alberturris
 */
@Controller
@RequestMapping("/controlador")
public class Controlador {
    
    @Autowired
    private InterfaceClienteDAO clienteDAO;
    
    @GetMapping("/lista")
    public String listaClientes(Model model){
        
        // Obtener los clientes desde el DAO
        List<Cliente> listaClientes = clienteDAO.getClientes();
        
        // Agregar los clientes al modelo
        model.addAttribute("clientes", listaClientes);
        
        return "lista-clientes";
    }
    
    @GetMapping("/agregarCliente")
    public String agregarCliente(Model model){
        
        // Bind de datos de los clientes
        Cliente cliente = new Cliente();
        
        model.addAttribute("cliente", cliente);
        
        return "formularioCliente";
    }
    
    @PostMapping("/insertarCliente")
    public String insertarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, 
            Model model,
            BindingResult validacionResultado){
        
        if(validacionResultado.hasErrors()){
            return "redirect:/controlador/agregarCliente";
        }else{
            // Insertar cliente a la BBDD
            clienteDAO.insertarCliente(cliente);
            return "redirect:/controlador/lista";
        }
        
        
    }
    
    @GetMapping("/muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("clienteId") int id, Model model){
        
        // Obtener el cliente cuyo id pasamos por parámetro
        Cliente cliente = clienteDAO.getCliente(id);
        
        // Establecer el cliente como atributo del modelo
        
        model.addAttribute("cliente", cliente);
        
        // Enviar al formulario
        
        return "formularioCliente";
    }
    
    @GetMapping("/eliminar")
    public String eliminaRegistro(@RequestParam("clienteId") int id){
        
        // Eliminar cliente
        clienteDAO.eliminarCliente(id);
        
        // Redireccionar a la lista de clientes
        return "redirect:/controlador/lista";
        
    }
}
