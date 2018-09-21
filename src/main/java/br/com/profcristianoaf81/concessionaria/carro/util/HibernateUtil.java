/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.concessionaria.carro.util;

import org.hibernate.HibernateException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author cristianoaf81
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            
            StandardServiceRegistryBuilder construtorServico = new StandardServiceRegistryBuilder();
            construtorServico.applySettings(cfg.getProperties());
            StandardServiceRegistry servico = construtorServico.build();
            
            return cfg.buildSessionFactory(servico);
            
        }catch(HibernateException e){
            System.out.println("Erro Criacao sessionFactory "+e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
       
    }
    
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
