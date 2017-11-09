/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafael.easygasws.entidades;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shang
 */
@Entity
@Table(name = "configuracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracao.findAll", query = "SELECT c FROM Configuracao c")
    , @NamedQuery(name = "Configuracao.findById", query = "SELECT c FROM Configuracao c WHERE c.id = :id")
    , @NamedQuery(name = "Configuracao.findByNotificacao", query = "SELECT c FROM Configuracao c WHERE c.notificacao = :notificacao")
    , @NamedQuery(name = "Configuracao.findByEmailPromocional", query = "SELECT c FROM Configuracao c WHERE c.emailPromocional = :emailPromocional")})
public class Configuracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificacao")
    private boolean notificacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email_promocional")
    private boolean emailPromocional;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Configuracao() {
    }

    public Configuracao(Integer id) {
        this.id = id;
    }

    public Configuracao(Integer id, boolean notificacao, boolean emailPromocional) {
        this.id = id;
        this.notificacao = notificacao;
        this.emailPromocional = emailPromocional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }

    public boolean getEmailPromocional() {
        return emailPromocional;
    }

    public void setEmailPromocional(boolean emailPromocional) {
        this.emailPromocional = emailPromocional;
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
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafael.easygasws.entidades.Configuracao[ id=" + id + " ]";
    }
    
}
