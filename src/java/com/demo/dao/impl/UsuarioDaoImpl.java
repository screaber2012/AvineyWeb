/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dao.impl;

import com.demo.dao.UsuarioDao;
import com.demo.model.Usuario;
import com.demo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Flopez
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        String sql="select u from Usuario u where username=:user and password=:pass";
        Query query= session.createQuery(sql);
        query.setString("user", usuario.getUsername());
        query.setString("pass", usuario.getPassword());
        return (Usuario) query.uniqueResult();
    }

    @Override
    public void agregar(Usuario usuario) {
        usuario.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Insertar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        usuario.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Actualizar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuario.setEstado(true);
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(usuario);
            session.beginTransaction().commit();
        }catch (Exception e){
            System.out.println("Error en Eliminar Deuda Bancaria"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Usuario").list();
    }

    @Override
    public Usuario buscraPorId(Integer id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarCliente() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery(" from Usuario where estado=1 ").list();
    }
    
}
