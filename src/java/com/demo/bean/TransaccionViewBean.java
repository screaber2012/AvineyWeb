/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.dao.TransaccionDao;
import com.demo.dao.impl.TransaccionDaoImpl;
import com.demo.model.Transaccion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Flopez
 */
@ManagedBean (name="transaccionviewBean")
@SessionScoped
public class TransaccionViewBean {

    private Transaccion transaccion;
    private List<Transaccion> transaccions ;
    private String nombre;

    
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = loginBean.getUsuario().getCodigo();
    }
    
    public Transaccion getTransaccion() {
        if(transaccion==null){
            transaccion=new Transaccion();
        }
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public List<Transaccion> getTransaccions() {
        TransaccionDao transaccionDao= new TransaccionDaoImpl();
    
        if(loginBean.getUsuario().getPerfil().getDespacho()==true){
        transaccions = transaccionDao.buscarTodos();  
        }else{       
        transaccions = transaccionDao.buscarListaId(loginBean.getUsuario().getCodigo());
        }
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }
    
    public TransaccionViewBean() {
    }
    
     public void prepararTransaccion(Integer id) {
        TransaccionDao transaccionDao= new TransaccionDaoImpl();      
        transaccion = transaccionDao.buscraPorId(id);
        
    }
    
    public void inicioTransaccion() {
        transaccion = new Transaccion();
    }
    
    public void agregarTransaccion() {
        TransaccionDao transaccionDao= new TransaccionDaoImpl();
        transaccionDao.insertar(transaccion);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado")); 
        transaccion = new Transaccion();
    }
    
    public void actualizarTransaccion(){
           
        TransaccionDao transaccionDao= new TransaccionDaoImpl();
        transaccionDao.actualizar(transaccion);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado")); 
        transaccion = new Transaccion();
    
    }
    
    public void eliminarTransaccion(){
           
        TransaccionDao transaccionDao= new TransaccionDaoImpl();
        transaccionDao.eliminar(transaccion);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminado")); 
        transaccion = new Transaccion();
    
    }
    
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Edited", ((Transaccion) event.getObject()).getCliente());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Transaccion) event.getObject()).getDestino());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
}
