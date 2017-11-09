/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shang
 */
@Entity
@Table(name = "cartao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartao.findAll", query = "SELECT c FROM Cartao c")
    , @NamedQuery(name = "Cartao.findById", query = "SELECT c FROM Cartao c WHERE c.id = :id")
    , @NamedQuery(name = "Cartao.findByNumeroCartao", query = "SELECT c FROM Cartao c WHERE c.numeroCartao = :numeroCartao")
    , @NamedQuery(name = "Cartao.findByCodigoSeguranca", query = "SELECT c FROM Cartao c WHERE c.codigoSeguranca = :codigoSeguranca")
    , @NamedQuery(name = "Cartao.findByValidade", query = "SELECT c FROM Cartao c WHERE c.validade = :validade")
    , @NamedQuery(name = "Cartao.findByCpf", query = "SELECT c FROM Cartao c WHERE c.cpf = :cpf")})
public class Cartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_cartao")
    private String numeroCartao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo_seguranca")
    private String codigoSeguranca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "validade")
    private String validade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cpf")
    private String cpf;
    @JoinTable(name = "pagamento_cartao", joinColumns = {
        @JoinColumn(name = "cartao_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "pagamento_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Pagamento> pagamentoList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Cartao() {
    }

    public Cartao(Integer id) {
        this.id = id;
    }

    public Cartao(Integer id, String numeroCartao, String codigoSeguranca, String validade, String cpf) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.codigoSeguranca = codigoSeguranca;
        this.validade = validade;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Cartao)) {
            return false;
        }
        Cartao other = (Cartao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafael.easygasws.entidades.Cartao[ id=" + id + " ]";
    }
    
}
