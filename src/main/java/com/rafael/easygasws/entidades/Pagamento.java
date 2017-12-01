package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 01/12/2017
 */
@Entity
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
    , @NamedQuery(name = "Pagamento.findById", query = "SELECT p FROM Pagamento p WHERE p.id = :id")
    , @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pagamento.findByDataPagamento", query = "SELECT p FROM Pagamento p WHERE p.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "Pagamento.findByTipoPagamento", query = "SELECT p FROM Pagamento p WHERE p.tipoPagamento = :tipoPagamento")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_pagamento")
    private String tipoPagamento;
    @ManyToMany(mappedBy = "pagamentoList")
    private List<Cartao> cartaoList;
    @JoinColumn(name = "entrega_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entrega entregaId;

    public Pagamento() {
    }

    public Pagamento(Integer id) {
        this.id = id;
    }

    public Pagamento(Integer id, BigDecimal valor, Date dataPagamento, String tipoPagamento) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @XmlTransient
    @JsonIgnore
    public List<Cartao> getCartaoList() {
        return cartaoList;
    }

    public void setCartaoList(List<Cartao> cartaoList) {
        this.cartaoList = cartaoList;
    }

    public Entrega getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Entrega entregaId) {
        this.entregaId = entregaId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Pagamento other = (Pagamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", valor=" + valor + ", dataPagamento=" + dataPagamento + ", tipoPagamento=" + tipoPagamento + ", cartaoList=" + cartaoList + ", entregaId=" + entregaId + '}';
    }

}
