package com.rafael.easygasws.entidades;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id")
    , @NamedQuery(name = "Endereco.findByLatitude", query = "SELECT e FROM Endereco e WHERE e.latitude = :latitude")
    , @NamedQuery(name = "Endereco.findByLongitude", query = "SELECT e FROM Endereco e WHERE e.longitude = :longitude")
    , @NamedQuery(name = "Endereco.findByRuaAlameda", query = "SELECT e FROM Endereco e WHERE e.ruaAlameda = :ruaAlameda")
    , @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero")
    , @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")
    , @NamedQuery(name = "Endereco.findByDescricao", query = "SELECT e FROM Endereco e WHERE e.descricao = :descricao")
    , @NamedQuery(name = "Endereco.findByPlaceId", query = "SELECT e FROM Endereco e WHERE e.placeId = :placeId")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 30)
    @Column(name = "longitude")
    private String longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "rua_alameda")
    private String ruaAlameda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 5)
    @Column(name = "numero")
    private String numero;
    @Size(max = 10)
    @Column(name = "cep")
    private String cep;
    @Size(max = 15)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 100)
    @Column(name = "place_id")
    private String placeId;
    @JoinTable(name = "usuario_endereco", joinColumns = {
        @JoinColumn(name = "endereco_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    private List<Distribuidora> distribuidoraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    private List<Pedido> pedidoList;

    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String ruaAlameda, String bairro) {
        this.id = id;
        this.ruaAlameda = ruaAlameda;
        this.bairro = bairro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRuaAlameda() {
        return ruaAlameda;
    }

    public void setRuaAlameda(String ruaAlameda) {
        this.ruaAlameda = ruaAlameda;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
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
    public List<Distribuidora> getDistribuidoraList() {
        return distribuidoraList;
    }

    public void setDistribuidoraList(List<Distribuidora> distribuidoraList) {
        this.distribuidoraList = distribuidoraList;
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
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", ruaAlameda=" + ruaAlameda + ", bairro=" + bairro + ", numero=" + numero + ", cep=" + cep + ", descricao=" + descricao + ", placeId=" + placeId + ", usuarioList=" + usuarioList + ", distribuidoraList=" + distribuidoraList + ", pedidoList=" + pedidoList + '}';
    }

}
