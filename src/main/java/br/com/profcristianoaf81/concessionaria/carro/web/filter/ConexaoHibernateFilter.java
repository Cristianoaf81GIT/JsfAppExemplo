/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.concessionaria.carro.web.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import br.com.profcristianoaf81.concessionaria.carro.util.HibernateUtil;

@WebFilter(urlPatterns = {"*.jsf"})
public class ConexaoHibernateFilter implements Filter {
    private SessionFactory sf;
    
    @Override
    public void init(FilterConfig config) throws ServletException{
        this.sf = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws ServletException{
        
        Session currentSession = this.sf.getCurrentSession();
        Transaction transaction = null;
        
        try{
            transaction = currentSession.beginTransaction();
            chain.doFilter(servletRequest, servletResponse);
            transaction.commit();
            
            if(currentSession.isOpen()){
                currentSession.close();
            }
            
        }catch(Throwable ex){
        
            try{
                if(transaction.isActive()){
                    transaction.rollback();
                }
            }catch(Throwable t){
                t.printStackTrace();
            }
            throw new ServletException(ex);
        }
        
        
    }
    
    public void destroy(){}
}
