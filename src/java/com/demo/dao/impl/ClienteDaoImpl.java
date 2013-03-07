/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.impl;

import com.demo.dao.ClienteDao;
import com.demo.model.Cliente;
import com.demo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Flopez
 */
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public void insertar(Cliente cliente) {
        cliente.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        cliente.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        cliente.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(cliente);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Cliente buscraPorId(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Cliente) session.load(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Cliente").list();
    }

    @Override
    public Cliente buscarPorUsuario(Cliente cliente) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        String sql="select u from Cliente u where usuario=:user and clave=:pass";
        Query query= session.createQuery(sql);
        query.setString("user", cliente.getUsuario());
        query.setString("pass", cliente.getClave());
        return (Cliente) query.uniqueResult();
    }

 
    
}
