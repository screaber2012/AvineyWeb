/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.Cliente;
import java.util.List;

/**
 *
 * @author Flopez
 */
public interface ClienteDao {
    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente buscraPorId(Integer id);  
    public List<Cliente> buscarTodos(); 
    public Cliente buscarPorUsuario(Cliente cliente);
}
