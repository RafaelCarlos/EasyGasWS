package com.rafael.easygasws.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "distribuidora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidora.findAll", query = "SELECT d FROM Distribuidora d")
    , @NamedQuery(name = "Distribuidora.findById", query = "SELECT d FROM Distribuidora d WHERE d.id = :id")
    , @NamedQuery(name = "Distribuidora.findByNomeFantasia", query = "SELECT d FROM Distribuidora d WHERE d.nomeFantasia = :nomeFantasia")
    , @NamedQuery(name = "Distribuidora.findByRazaoSocial", query = "SELECT d FROM Distribuidora d WHERE d.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "Distribuidora.findByStatusAberto", query = "SELECT d FROM Distribuidora d WHERE d.statusAberto = :statusAberto")
    , @NamedQuery(name = "Distribuidora.findByHorarioAberto", query = "SELECT d FROM Distribuidora d WHERE d.horarioAberto = :horarioAberto")
    , @NamedQuery(name = "Distribuidora.findByHorarioFechado", query = "SELECT d FROM Distribuidora d WHERE d.horarioFechado = :horarioFechado")
    , @NamedQuery(name = "Distribuidora.findByCnpj", query = "SELECT d FROM Distribuidora d WHERE d.cnpj = :cnpj")
    , @NamedQuery(name = "Distribuidora.findByIncricaoEstadual", query = "SELECT d FROM Distribuidora d WHERE d.incricaoEstadual = :incricaoEstadual")})
public class Distribuidora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_aberto")
    private boolean statusAberto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario_aberto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioAberto;
    @Column(name = "horario_fechado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioFechado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "incricao_estadual")
    private String incricaoEstadual;
    @JoinTable(name = "usuario_distribuidora", joinColumns = {
        @JoinColumn(name = "distribuidora_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidoraId")
    private List<Avaliacao> avaliacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidoraId")
    private List<Entregador> entregadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidoraId")
    private List<Produto> produtoList;
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco enderecoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidoraId")
    private List<Pedido> pedidoList;

    public Distribuidora() {
    }

    public Distribuidora(Integer id) {
        this.id = id;
    }

    public Distribuidora(Integer id, String nomeFantasia, String razaoSocial, boolean statusAberto, Date horarioAberto, String cnpj, String incricaoEstadual) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.statusAberto = statusAberto;
        this.horarioAberto = horarioAberto;
        this.cnpj = cnpj;
        this.incricaoEstadual = incricaoEstadual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean getStatusAberto() {
        return statusAberto;
    }

    public void setStatusAberto(boolean statusAberto) {
        this.statusAberto = statusAberto;
    }

    public Date getHorarioAberto() {
        return horarioAberto;
    }

    public void setHorarioAberto(Date horarioAberto) {
        this.horarioAberto = horarioAberto;
    }

    public Date getHorarioFechado() {
        return horarioFechado;
    }

    public void setHorarioFechado(Date horarioFechado) {
        this.horarioFechado = horarioFechado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIncricaoEstadual() {
        return incricaoEstadual;
    }

    public void setIncricaoEstadual(String incricaoEstadual) {
        this.incricaoEstadual = incricaoEstadual;
    }

    @XmlTransient
    @JsonIgnore
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Entregador> getEntregadorList() {
        return entregadorList;
    }

    public void setEntregadorList(List<Entregador> entregadorList) {
        this.entregadorList = entregadorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Distribuidora other = (Distribuidora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Distribuidora{" + "id=" + id + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", statusAberto=" + statusAberto + ", horarioAberto=" + horarioAberto + ", horarioFechado=" + horarioFechado + ", cnpj=" + cnpj + ", incricaoEstadual=" + incricaoEstadual + ", usuarioList=" + usuarioList + ", avaliacaoList=" + avaliacaoList + ", entregadorList=" + entregadorList + ", produtoList=" + produtoList + ", enderecoId=" + enderecoId + ", pedidoList=" + pedidoList + '}';
    }

}
