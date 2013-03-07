/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.dao.UsuarioDao;
import com.demo.dao.impl.UsuarioDaoImpl;
import com.demo.model.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Flopez
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private Usuario usuario;

  
    public LoginBean() {
    }
    
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
        
        UsuarioDao usuarioDao=new UsuarioDaoImpl();
        usuario=usuarioDao.buscarPorUsuario(usuario);
        if(usuario != null) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Usuario");  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
    
    public Usuario getUsuario() {
        if(usuario==null){
            usuario= new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
