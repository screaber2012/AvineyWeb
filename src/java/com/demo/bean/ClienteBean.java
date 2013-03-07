/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;


import com.demo.dao.ClienteDao;
import com.demo.dao.impl.ClienteDaoImpl;
import com.demo.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Flopez
 */
@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean implements Serializable{

    private Cliente cliente;
    private List<Cliente> clientes;

    public Cliente getCliente() {
        if(cliente==null){
            cliente=new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        ClienteDao clienteDao=new ClienteDaoImpl();
        clientes=clienteDao.buscarTodos();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
  
    public ClienteBean() {
    }
    
    public void prepararCliente(Integer id) {
        ClienteDao clienteDao=new ClienteDaoImpl();
        cliente=clienteDao.buscraPorId(id);
    }
    
    public void inicioCliente() {
        cliente = new Cliente();
    }
    
    public void agregarCliente() {
        ClienteDao clienteDao=new ClienteDaoImpl();
        clienteDao.insertar(cliente);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado")); 
        cliente = new Cliente();
    }
    
    public void actualizarCliente(){
        ClienteDao clienteDao=new ClienteDaoImpl();
        clienteDao.actualizar(cliente);
        FacesContext context = FacesContext.getCurrentInstance();               
        context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado")); 
        cliente = new Cliente();
    
    }
    
    public void eliminarCliente(){
        ClienteDao clienteDao=new ClienteDaoImpl();
        clienteDao.eliminar(cliente);
        FacesContext context = FacesContext.getCurrentInstance();             
        context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminados")); 
        cliente = new Cliente();
    
    }
}
