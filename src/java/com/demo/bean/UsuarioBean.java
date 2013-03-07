/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;


import com.demo.dao.ClienteDao;
import com.demo.dao.UsuarioDao;
import com.demo.dao.impl.ClienteDaoImpl;
import com.demo.dao.impl.UsuarioDaoImpl;
import com.demo.model.Cliente;
import com.demo.model.Usuario;
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
@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Usuario> clientes;

   

    public Usuario getUsuario() {
        if(usuario==null){
            usuario=new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuarios=usuarioDao.buscarTodos();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
  
    
    public List<Usuario> getClientes() {
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        clientes=usuarioDao.buscarCliente();
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }
    public UsuarioBean() {
    }
    
    public void prepararUsuario(Integer id) {
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuario=usuarioDao.buscraPorId(id);
    }
    
    public void inicioUsuario() {
        usuario = new Usuario();
    }
    
    public void agregarUsuario() {
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuarioDao.agregar(usuario);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado")); 
        usuario = new Usuario();
    }
    
    public void actualizarUsuario(){
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuarioDao.actualizar(usuario);
        FacesContext context = FacesContext.getCurrentInstance();               
        context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado")); 
        usuario = new Usuario();
    
    }
    
    public void eliminarCliente(){
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuarioDao.eliminar(usuario);
        FacesContext context = FacesContext.getCurrentInstance();              
        context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminados")); 
        usuario = new Usuario();
    
    }
}
