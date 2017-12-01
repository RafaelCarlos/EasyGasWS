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
import javax.persistence.ManyToMany;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone")
    , @NamedQuery(name = "Usuario.findByIdFacebook", query = "SELECT u FROM Usuario u WHERE u.idFacebook = :idFacebook")
    , @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo")
    , @NamedQuery(name = "Usuario.findByToken", query = "SELECT u FROM Usuario u WHERE u.token = :token")
    , @NamedQuery(name = "Usuario.findByDataCadastro", query = "SELECT u FROM Usuario u WHERE u.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Usuario.findByTokenFcm", query = "SELECT u FROM Usuario u WHERE u.tokenFcm = :tokenFcm")
    , @NamedQuery(name = "Usuario.findByDataAtualizacao", query = "SELECT u FROM Usuario u WHERE u.dataAtualizacao = :dataAtualizacao")
    , @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Usuario.findByIdGoogle", query = "SELECT u FROM Usuario u WHERE u.idGoogle = :idGoogle")})
public class Usuario implements Serializable {

    public enum TipoUsuario {
        ADMINISTRADOR, ENTREGADOR, CLIENTE, SUPORTE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 255)
    @Column(name = "id_facebook")
    private String idFacebook;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @Size(max = 255)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Size(max = 255)
    @Column(name = "token_fcm")
    private String tokenFcm;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
    @Size(max = 100)
    @Column(name = "id_google")
    private String idGoogle;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Endereco> enderecoList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Distribuidora> distribuidoraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Configuracao> configuracaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Avaliacao> avaliacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Entregador> entregadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Feedback> feedbackList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Cartao> cartaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Carteira> carteiraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Pedido> pedidoList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String email, String senha, String telefone, String idFacebook, boolean ativo, String token, Date dataCadastro, String tokenFcm, Date dataAtualizacao, TipoUsuario tipoUsuario, String idGoogle) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.idFacebook = idFacebook;
        this.ativo = ativo;
        this.token = token;
        this.dataCadastro = dataCadastro;
        this.tokenFcm = tokenFcm;
        this.dataAtualizacao = dataAtualizacao;
        this.tipoUsuario = tipoUsuario;
        this.idGoogle = idGoogle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTokenFcm() {
        return tokenFcm;
    }

    public void setTokenFcm(String tokenFcm) {
        this.tokenFcm = tokenFcm;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(String idGoogle) {
        this.idGoogle = idGoogle;
    }

    @XmlTransient
    @JsonIgnore
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
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
    public List<Configuracao> getConfiguracaoList() {
        return configuracaoList;
    }

    public void setConfiguracaoList(List<Configuracao> configuracaoList) {
        this.configuracaoList = configuracaoList;
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
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Cartao> getCartaoList() {
        return cartaoList;
    }

    public void setCartaoList(List<Cartao> cartaoList) {
        this.cartaoList = cartaoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Carteira> getCarteiraList() {
        return carteiraList;
    }

    public void setCarteiraList(List<Carteira> carteiraList) {
        this.carteiraList = carteiraList;
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
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone=" + telefone + ", idFacebook=" + idFacebook + ", ativo=" + ativo + ", token=" + token + ", dataCadastro=" + dataCadastro + ", tokenFcm=" + tokenFcm + ", dataAtualizacao=" + dataAtualizacao + ", tipoUsuario=" + tipoUsuario + ", idGoogle=" + idGoogle + ", enderecoList=" + enderecoList + ", distribuidoraList=" + distribuidoraList + ", configuracaoList=" + configuracaoList + ", avaliacaoList=" + avaliacaoList + ", entregadorList=" + entregadorList + ", feedbackList=" + feedbackList + ", cartaoList=" + cartaoList + ", carteiraList=" + carteiraList + ", pedidoList=" + pedidoList + '}';
    }

}
