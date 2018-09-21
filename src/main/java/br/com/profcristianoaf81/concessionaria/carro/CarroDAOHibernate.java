/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.concessionaria.carro;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;




public class CarroDAOHibernate implements CarroDAO{

private Session session;
private List<Carro> lista;

public void setSession(Session session){
    this.session = session;
}
    
    
    @Override
    public void salvar(Carro carro) {
         this.session.saveOrUpdate(carro); 
    }

    @Override
    public void excluir(Carro carro) {
        this.session.delete(carro);
    }
    
    @Override
    public void atualizar(Carro carro){
       this.session.merge(carro);
       this.session.flush();
       this.session.clear();
        
    }
    
    @Override
    public List<Carro> carrosListar() {
        //Criteria criteria = this.session.createCriteria(Carro.class);
        //return  criteria.list();
        Query q = session.createSQLQuery("Select * from Carro").addEntity(Carro.class);
        this.lista = q.list();
        return (List<Carro>) this.lista;
    }
    
}
