/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.util;

import java.util.Date;

/**
 *
 * @author Luis Angel
 */
public class Formateador {
    java.util.Date date = new Date();
    java.sql.Date fechaActual;
    public Date fechaMySQL(){
      return fechaActual = new java.sql.Date(date.getTime());   
    }
    
}
