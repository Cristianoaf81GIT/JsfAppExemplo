
package br.com.profcristianoaf81.concessionaria.carro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
public class Carro implements Serializable{

    private static final long serialVersionUID = 5117167192734144701L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String marca;
    private String modelo;
    
    @Temporal(TemporalType.DATE)
    private Date fabricacao;
    
    
    private Double preco;
    
    @Transient
    private SimpleDateFormat formato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFabricacao() {
        
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDataFormatada(){
     this.formato = new SimpleDateFormat("yyyy");
     String dataFormatada = formato.format(fabricacao);
     return dataFormatada;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.marca);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + Objects.hashCode(this.fabricacao);
        hash = 97 * hash + Objects.hashCode(this.preco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fabricacao, other.fabricacao)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
