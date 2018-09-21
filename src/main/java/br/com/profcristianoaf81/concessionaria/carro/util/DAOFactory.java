/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.concessionaria.carro.util;

import br.com.profcristianoaf81.concessionaria.carro.*;


public class DAOFactory {
    
        public static CarroDAO criarCarroDAO(){
            CarroDAOHibernate carroDAO = new CarroDAOHibernate();
            carroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
            return carroDAO;
        }
    
}
