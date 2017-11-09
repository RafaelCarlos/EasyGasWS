/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shang
 */
@Entity
@Table(name = "boleto_carteira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletoCarteira.findAll", query = "SELECT b FROM BoletoCarteira b")
    , @NamedQuery(name = "BoletoCarteira.findById", query = "SELECT b FROM BoletoCarteira b WHERE b.id = :id")
    , @NamedQuery(name = "BoletoCarteira.findByValorBoleto", query = "SELECT b FROM BoletoCarteira b WHERE b.valorBoleto = :valorBoleto")
    , @NamedQuery(name = "BoletoCarteira.findByConfirmacaoPagamento", query = "SELECT b FROM BoletoCarteira b WHERE b.confirmacaoPagamento = :confirmacaoPagamento")
    , @NamedQuery(name = "BoletoCarteira.findByDataVencimento", query = "SELECT b FROM BoletoCarteira b WHERE b.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "BoletoCarteira.findByDataEmissao", query = "SELECT b FROM BoletoCarteira b WHERE b.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "BoletoCarteira.findByStatus", query = "SELECT b FROM BoletoCarteira b WHERE b.status = :status")})
public class BoletoCarteira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_boleto")
    private BigDecimal valorBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmacao_pagamento")
    private boolean confirmacaoPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;
    @Column(name = "data_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "carteira_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carteira carteiraId;

    public BoletoCarteira() {
    }

    public BoletoCarteira(Integer id) {
        this.id = id;
    }

    public BoletoCarteira(Integer id, BigDecimal valorBoleto, boolean confirmacaoPagamento, Date dataVencimento, String status) {
        this.id = id;
        this.valorBoleto = valorBoleto;
        this.confirmacaoPagamento = confirmacaoPagamento;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public boolean getConfirmacaoPagamento() {
        return confirmacaoPagamento;
    }

    public void setConfirmacaoPagamento(boolean confirmacaoPagamento) {
        this.confirmacaoPagamento = confirmacaoPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Carteira getCarteiraId() {
        return carteiraId;
    }

    public void setCarteiraId(Carteira carteiraId) {
        this.carteiraId = carteiraId;
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
        if (!(object instanceof BoletoCarteira)) {
            return false;
        }
        BoletoCarteira other = (BoletoCarteira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafael.easygasws.entidades.BoletoCarteira[ id=" + id + " ]";
    }
    
}