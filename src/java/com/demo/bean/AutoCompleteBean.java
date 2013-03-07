/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.dao.PerfilDao;
import com.demo.dao.impl.PerfilDaoImpl;
import com.demo.model.Perfil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Luis Angel
 */
@ManagedBean (name="autoCompleteBean")
@SessionScoped
public class AutoCompleteBean {

    private String text;
        
        private Perfil selectedPerfil;
        
        private List<Perfil> perfiles;
      
        public AutoCompleteBean() {
                   
        }

       
        public Perfil getSelectedPerfil() {
            if(selectedPerfil==null){
            selectedPerfil=new Perfil();
            }
            return selectedPerfil;
        }

        public void setSelectedPerfil(Perfil selectedPerfil) {
            this.selectedPerfil = selectedPerfil;
        }

      
        public List<Perfil> getPerfiles() {
            PerfilDao perfilDao=new PerfilDaoImpl();
            perfiles=perfilDao.buscarTodos();
            return perfiles;
        }

        public void setPerfiles(List<Perfil> perfiles) {
            this.perfiles = perfiles;
        }
        
        public String getText() {
                return text;
        }
        
        public void setText(String text) {
                this.text = text;
        }
        
        public List<String> complete(String query) {
                List<String> results = new ArrayList<String>();
                
                for (int i = 0; i < 10; i++) {
                        results.add(query + i);
                }
                
                return results;
        }
        
        public List<Perfil> completePlayer(String query) {
                List<Perfil> suggestions = new ArrayList<Perfil>();
                
                for(Perfil p : perfiles) {
                        if(p.getDescripcion().startsWith(query))
                                suggestions.add(p);
                }
                
                return suggestions;
        }
        
        public void handleSelect(SelectEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);
                
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
}
