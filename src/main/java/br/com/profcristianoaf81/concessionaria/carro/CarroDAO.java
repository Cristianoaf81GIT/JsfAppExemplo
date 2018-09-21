
package br.com.profcristianoaf81.concessionaria.carro;

import java.util.List;

public interface CarroDAO {
  public void salvar(Carro carro);
  public void excluir(Carro carro);
  public void atualizar(Carro carro);
  public List<Carro> carrosListar();
  
}
