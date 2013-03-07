/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao;

import com.demo.model.Transaccion;
import java.util.List;

/**
 *
 * @author Flopez
 */
public interface TransaccionDao {
    public void insertar(Transaccion transaccion);
    public void actualizar(Transaccion transaccion);
    public void eliminar(Transaccion transaccion);
    public Transaccion buscraPorId(Integer id);
    public List<Transaccion> buscarTodos(); 
    public List<Transaccion> buscarListaId(String id);
    
}
