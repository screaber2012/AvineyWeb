/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.impl;

import com.demo.dao.PerfilDao;
import com.demo.model.Perfil;
import com.demo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Flopez
 */
public class PerfilDaoImpl implements PerfilDao{

    @Override
    public void actualizar(Perfil perfil) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.merge(perfil);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Perfil"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Perfil buscraPorId(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Perfil) session.load(Perfil.class, id);
    }

    @Override
    public List<Perfil> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Perfil").list();
    }

    @Override
    public void agregar(Perfil perfil) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(perfil);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Agregar Perfil"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Perfil perfil) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(perfil);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Agregar Perfil"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }
    
}
