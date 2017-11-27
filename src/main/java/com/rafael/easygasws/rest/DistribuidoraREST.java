package com.rafael.easygasws.rest;

import com.rafael.easygasws.entidades.Distribuidora;
import com.rafael.easygasws.repositorios.DistribuidoraRepository;
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
@Path("distribuidoras")
public class DistribuidoraREST {

    private Distribuidora distribuidora;
    private DistribuidoraRepository distribuidoraRepository;

    @Context
    private UriInfo context;

    public DistribuidoraREST() {
    }

    @PostConstruct
    public void init() {
        distribuidora = new Distribuidora();
        distribuidoraRepository = new DistribuidoraRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Distribuidora> todasDistribuidoras() {
        return distribuidoraRepository.findAll();
    }

}
