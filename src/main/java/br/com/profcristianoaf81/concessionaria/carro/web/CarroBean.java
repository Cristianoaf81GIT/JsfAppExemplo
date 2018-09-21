
package br.com.profcristianoaf81.concessionaria.carro.web;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.profcristianoaf81.concessionaria.carro.Carro;
import br.com.profcristianoaf81.concessionaria.carro.CarroRN;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import java.util.List;
import org.hibernate.Session;

@ManagedBean(name="carroBean")
@SessionScoped
public class CarroBean {
    
    private Carro carro=new Carro();
    private List<Carro> lista=null;
    private Session session;
    
    public void setSession(Session session){
        this.session = session;
    }
    
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    public String salvar(){
        CarroRN carroRN = new CarroRN();
        carroRN.salvar(carro);
        this.carro = new Carro();
        return "cadastro";
    }
    
    public String deletar(Carro carro){
     CarroRN carroRN = new CarroRN();
     carroRN.deletaCarro(carro);
     getLista();
     return "cadastro";
    }
    
    public String atualizaCarro(Carro carro){
     this.carro = carro;
     return "";
    }
    
    public String novo(){
        this.carro = new Carro();
        return "cadastro";
    }
    
    
    
    public List<Carro> getLista(){
        
            CarroRN carroRN = new CarroRN();
            this.lista = carroRN.listar();
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tabela");
            return this.lista;
    }
    
    /*public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado!", "O carro foi cadastrado com sucesso ");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }*/
}
