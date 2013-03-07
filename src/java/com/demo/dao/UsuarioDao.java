/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.Usuario;
import java.util.List;

public interface UsuarioDao {
    
    public Usuario buscarPorUsuario(Usuario usuario);
    public void agregar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public List<Usuario> buscarCliente();
    public Usuario buscraPorId(Integer id); 
    
}
