package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 01/12/2017
 */
@Entity
@Table(name = "carteira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carteira.findAll", query = "SELECT c FROM Carteira c")
    , @NamedQuery(name = "Carteira.findById", query = "SELECT c FROM Carteira c WHERE c.id = :id")
    , @NamedQuery(name = "Carteira.findBySaldo", query = "SELECT c FROM Carteira c WHERE c.saldo = :saldo")})
public class Carteira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carteiraId")
    private List<BoletoCarteira> boletoCarteiraList;

    public Carteira() {
    }

    public Carteira(Integer id) {
        this.id = id;
    }

    public Carteira(Integer id, BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    @JsonIgnore
    public List<BoletoCarteira> getBoletoCarteiraList() {
        return boletoCarteiraList;
    }

    public void setBoletoCarteiraList(List<BoletoCarteira> boletoCarteiraList) {
        this.boletoCarteiraList = boletoCarteiraList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Carteira other = (Carteira) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carteira{" + "id=" + id + ", saldo=" + saldo + ", usuarioId=" + usuarioId + ", boletoCarteiraList=" + boletoCarteiraList + '}';
    }

}
