/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.dao.PerfilDao;
import com.demo.dao.impl.PerfilDaoImpl;
import com.demo.model.Perfil;
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
@ManagedBean(name="perfilBean")
@SessionScoped
public class PerfilBean implements  Serializable{

    private Perfil perfil;
    private List<Perfil> perfiles;

    public Perfil getPerfil() {
        if(perfil==null){
            perfil=new Perfil();
        }
        return perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getPerfiles() {
        PerfilDao perfilDao=new PerfilDaoImpl();
        perfiles=perfilDao.buscarTodos();
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
      
    public PerfilBean() {
    }
    
    public void inicioPerfil() {
        perfil = new Perfil();
    }
    
    public void prepararPerfil(Integer id) {
        PerfilDao perfilDao= new PerfilDaoImpl();
        perfil = perfilDao.buscraPorId(id);
    }
    
    public void agregarPerfil() {
        PerfilDao perfilDao= new PerfilDaoImpl();
        perfilDao.agregar(perfil);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado")); 
        perfil = new Perfil();
    }
    
    public void actualizarPerfil(){
        
        if(perfil.getIngresoD() == true ){
            perfil.setDespacho(true);
        }else if(perfil.getIngresoD() == false ){
            perfil.setDespacho(false);
        }
        
        if(perfil.getIngresoS() == true  ){
            perfil.setSeguimiento(true);
        }else if(perfil.getIngresoS() == false){
            perfil.setSeguimiento(false);
        }
        
        if(perfil.getPerfil() == true || perfil.getUsuario() == true){
            perfil.setConfiguracion(true);
        }else if(perfil.getPerfil() == false && perfil.getUsuario() == false){
            perfil.setConfiguracion(false);
        }
                 
        PerfilDao perfilDao = new PerfilDaoImpl();
        perfilDao.actualizar(perfil);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado")); 
        perfil = new Perfil();  
    }
    public void eliminarPerfil() {
        PerfilDao perfilDao= new PerfilDaoImpl();
        perfilDao.eliminar(perfil);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminado")); 
        perfil = new Perfil();
    }
}
