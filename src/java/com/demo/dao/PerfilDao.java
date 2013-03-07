/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.Perfil;
import java.util.List;


public interface PerfilDao {
    
    public void agregar(Perfil perfil);
    public void actualizar(Perfil perfil);
    public void eliminar(Perfil perfil);
    public Perfil buscraPorId(Integer id);
    public List<Perfil> buscarTodos();        
}
