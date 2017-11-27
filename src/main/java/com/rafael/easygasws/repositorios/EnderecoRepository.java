package com.rafael.easygasws.repositorios;

import com.rafael.easygasws.entidades.Endereco;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 27/11/2017
 */
public class EnderecoRepository extends RepositorioGenerico<Integer, Endereco> {

    public EnderecoRepository() {
        super(Endereco.class);
    }

}
