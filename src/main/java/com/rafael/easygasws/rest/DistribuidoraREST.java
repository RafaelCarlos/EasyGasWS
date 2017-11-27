package com.rafael.easygasws.rest;

import com.google.gson.Gson;
import com.rafael.easygasws.entidades.Distribuidora;
import com.rafael.easygasws.entidades.Endereco;
import com.rafael.easygasws.repositorios.DistribuidoraRepository;
import com.rafael.easygasws.repositorios.EnderecoRepository;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 27/11/2017
 */
@Path("distribuidoras")
public class DistribuidoraREST {

    private Distribuidora distribuidoraPersist;
    private DistribuidoraRepository distribuidoraRepository;

    @Context
    private UriInfo context;

    public DistribuidoraREST() {
    }

    @PostConstruct
    public void init() {
        distribuidoraPersist = new Distribuidora();
        distribuidoraRepository = new DistribuidoraRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Distribuidora> todasDistribuidoras() {
        return distribuidoraRepository.findAll();
    }

    @GET
    @Path("porid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Distribuidora porId(@PathParam("id") int id) {

        return distribuidoraRepository.getPorId(id);
    }
    
    @POST
    @Path("novo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novoUsuario(Distribuidora distribuidora) {

        Response response = null;
        System.out.println("Valor para inserir: " + distribuidora.toString());

        Gson g = new Gson();
//        Usuario user = g.fromJson(content, Usuario.class);
        distribuidora.setNomeFantasia(distribuidora.getNomeFantasia());
        distribuidora.setRazaoSocial(distribuidora.getRazaoSocial());
        distribuidora.setStatusAberto(true);
        distribuidora.setCnpj(distribuidora.getCnpj());
        distribuidora.setIncricaoEstadual(distribuidora.getIncricaoEstadual());
        
        distribuidora.setHorarioAberto(new Date());
        distribuidora.setHorarioFechado(new Date());
        
        Endereco endereco = new EnderecoRepository().getPorId(1);
        distribuidora.setEnderecoId(endereco);
        String valor = distribuidora.toString();

        
        if (distribuidoraRepository.salvar(distribuidora)) {
            response = Response.status(Response.Status.CREATED).entity(distribuidora).build();
//            return "Usuário Adicionadod com sucesso!";
//            return user.toString();

        } else {
//            return "Erro ao Adicionar usuário!";
            response = Response.status(Response.Status.NO_CONTENT).build();
        }

        return response;
    }

}
