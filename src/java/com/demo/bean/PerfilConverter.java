/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.dao.PerfilDao;
import com.demo.dao.impl.PerfilDaoImpl;
import com.demo.model.Perfil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Flopez
 */
@ManagedBean (name="perfilConvert")
@SessionScoped
public class PerfilConverter implements Converter{

    private static PerfilDao perfilDao= new PerfilDaoImpl();
    
    public PerfilConverter() {
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return perfilDao.buscraPorId(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        Integer codigo=((Perfil) value).getId();
        return String.valueOf(codigo);
    }
}
