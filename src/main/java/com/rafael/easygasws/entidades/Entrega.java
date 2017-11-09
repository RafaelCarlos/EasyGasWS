package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 09/11/2017
 */
@Entity
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findById", query = "SELECT e FROM Entrega e WHERE e.id = :id")
    , @NamedQuery(name = "Entrega.findByStatus", query = "SELECT e FROM Entrega e WHERE e.status = :status")
    , @NamedQuery(name = "Entrega.findByLatitudeAtual", query = "SELECT e FROM Entrega e WHERE e.latitudeAtual = :latitudeAtual")
    , @NamedQuery(name = "Entrega.findByLongitudeAtual", query = "SELECT e FROM Entrega e WHERE e.longitudeAtual = :longitudeAtual")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Size(max = 50)
    @Column(name = "latitude_atual")
    private String latitudeAtual;
    @Size(max = 50)
    @Column(name = "longitude_atual")
    private String longitudeAtual;
    @JoinColumn(name = "entregador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entregador entregadorId;
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedido pedidoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregaId")
    private List<Pagamento> pagamentoList;

    public Entrega() {
    }

    public Entrega(Integer id) {
        this.id = id;
    }

    public Entrega(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLatitudeAtual() {
        return latitudeAtual;
    }

    public void setLatitudeAtual(String latitudeAtual) {
        this.latitudeAtual = latitudeAtual;
    }

    public String getLongitudeAtual() {
        return longitudeAtual;
    }

    public void setLongitudeAtual(String longitudeAtual) {
        this.longitudeAtual = longitudeAtual;
    }

    public Entregador getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(Entregador entregadorId) {
        this.entregadorId = entregadorId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
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
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrega{" + "id=" + id + ", status=" + status + ", latitudeAtual=" + latitudeAtual + ", longitudeAtual=" + longitudeAtual + ", entregadorId=" + entregadorId + ", pedidoId=" + pedidoId + ", pagamentoList=" + pagamentoList + '}';
    }

}
