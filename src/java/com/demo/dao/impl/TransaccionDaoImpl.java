/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.impl;

import com.demo.dao.TransaccionDao;
import com.demo.model.Cliente;
import com.demo.model.Transaccion;
import com.demo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Flopez
 */
public class TransaccionDaoImpl implements TransaccionDao{

    @Override
    public void insertar(Transaccion transaccion) {
        transaccion.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Transaccion transaccion) {
         transaccion.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Transaccion transaccion) {
        transaccion.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(transaccion);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Transaccion buscraPorId(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Transaccion) session.load(Transaccion.class, id);
    }

    @Override
    public List<Transaccion> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Transaccion").list();
    }

    @Override
    public List<Transaccion> buscarListaId(String id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Transaccion where cliente='"+id+"'").list();
    }
    
}
