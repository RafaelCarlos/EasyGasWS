package com.rafael.easygasws.repositorios;

import com.rafael.easygasws.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CacheStoreMode;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        //Testando cache na consulta, afim de diminuir o tempo requisições repetitivas.
        q.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
        return q.getResultList();
    }

    public List<Usuario> userNamedQuery() {

        TypedQuery<Usuario> named = getEntityManager().createNamedQuery("Usuario.findAll", Usuario.class);

        return named.getResultList();

    }

//    public List<Usuario> userByNameCriteria(String name) {
//        List<Usuario> entities = new ArrayList<>();
//
//        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
//        Root<Usuario> fromUsuario = query.from(Usuario.class);
//        Expression<String> path = fromUsuario.get("nome");
//
//        Predicate l1 = builder.like(path, name);
//
//        return entities;
//    }
    public List<Usuario> userByName(String nome) {
        String jpql = "select u from Usuario u where u.nome like :nome ";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);

        query.setParameter("nome", "%" + nome + "%");

        List<Usuario> entitades = query.getResultList();

        return entitades;

    }

    public Usuario loginUsuarioEmail(String email, String senha) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha =?2";

        return findOne(jpql, email, senha);

    }

    public List<Usuario> porNome(String nome) {

        String jpql = "SELECT u FROM Usuario u WHERE u.nome like ?1 ";

        return find(jpql, nome);
    }

}
