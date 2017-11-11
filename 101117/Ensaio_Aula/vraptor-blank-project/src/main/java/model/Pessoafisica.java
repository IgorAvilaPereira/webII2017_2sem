/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iapereira
 */
@Entity
@Table(name = "pessoafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoafisica.findAll", query = "SELECT p FROM Pessoafisica p")
    , @NamedQuery(name = "Pessoafisica.findById", query = "SELECT p FROM Pessoafisica p WHERE p.id = :id")
    , @NamedQuery(name = "Pessoafisica.findByCpf", query = "SELECT p FROM Pessoafisica p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Pessoafisica.findByNome", query = "SELECT p FROM Pessoafisica p WHERE p.nome = :nome")})
public class Pessoafisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ManyToOne
    private Endereco enderecoId;

    public Pessoafisica() {
    }

    public Pessoafisica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoafisica)) {
            return false;
        }
        Pessoafisica other = (Pessoafisica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoafisica[ id=" + id + " ]";
    }
    
}
