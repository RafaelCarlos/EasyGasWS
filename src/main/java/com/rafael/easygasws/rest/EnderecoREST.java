package com.rafael.easygasws.rest;

import com.google.gson.Gson;
import com.rafael.easygasws.entidades.Endereco;
import com.rafael.easygasws.repositorios.EnderecoRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 27/11/2017
 */
@Path("enderecos")
public class EnderecoREST {

    @Context
    private UriInfo context;

    private Endereco enderecoPersist;
    private EnderecoRepository enderecoRepository;

    @PostConstruct
    public void init() {
        enderecoPersist = new Endereco();
        enderecoRepository = new EnderecoRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> todosEnderecos() {

        Gson g = new Gson();

        return enderecoRepository.findAll();
    }

}
