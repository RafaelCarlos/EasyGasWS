package com.rafael.easygasws.repositorios;

import com.rafael.easygasws.entidades.Usuario;
import java.util.List;
import javax.persistence.CacheStoreMode;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 10/11/2017
 */
public class UsuarioRepository extends RepositorioGenerico<Integer, Usuario> {

    public UsuarioRepository() {
        super(Usuario.class);
    }

    public List<Usuario> porTipoUsuario(String nomeTipo) {

        String jpql = "SELECT u FROM Usuario u WHERE u.TipoUsuario like ? ";

        return find(jpql, nomeTipo);
    }

    public List<Usuario> retornaViewUsers() {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM usuarios_view ", Usuario.class);
        q.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
        return q.getResultList();
    }

    public List<Usuario> userNamedQuery() {

        TypedQuery<Usuario> named = getEntityManager().createNamedQuery("Usuario.findAll", Usuario.class);

        return named.getResultList();

    }

    public List<Usuario> porSobrenome(String nome) {

        String jpql = "SELECT u FROM Usuario u WHERE u.nome like ? ";

        return find(jpql, nome);
    }

}
