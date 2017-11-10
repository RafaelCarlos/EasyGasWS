package com.rafael.easygasws.repositorios;

import com.rafael.easygasws.entidades.Usuario;
import java.util.List;

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

    public List<Usuario> porSobrenome(String nome) {

        String jpql = "SELECT u FROM Usuario u WHERE u.nome like ? ";

        return find(jpql, nome);
    }

}
