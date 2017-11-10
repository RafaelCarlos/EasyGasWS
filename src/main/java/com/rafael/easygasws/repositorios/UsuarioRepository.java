package com.rafael.easygasws.repositorios;

import com.rafael.easygasws.entidades.Usuario;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 10/11/2017
 */
public class UsuarioRepository extends RepositorioGenerico<Integer, Usuario> {

    public UsuarioRepository() {
        super(Usuario.class);
    }

}
