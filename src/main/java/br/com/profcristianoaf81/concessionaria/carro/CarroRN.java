/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.concessionaria.carro;

import br.com.profcristianoaf81.concessionaria.carro.util.DAOFactory;
import java.util.List;

public class CarroRN {
    
    @SuppressWarnings("FieldMayBeFinal")
    private CarroDAO carroDAO;
    
    public CarroRN(){
        this.carroDAO = DAOFactory.criarCarroDAO();
    }
    
    public void salvar(Carro carro){
        Integer codigo = carro.getId();
        
        if(codigo == null || codigo == 0){
            this.carroDAO.salvar(carro);
        }else{
            this.carroDAO.atualizar(carro);
        }    
    }
        
    public List<Carro> listar(){
        return this.carroDAO.carrosListar();
    }
    
    public void deletaCarro(Carro carro){
      this.carroDAO.excluir(carro);
      
    }
      
}
