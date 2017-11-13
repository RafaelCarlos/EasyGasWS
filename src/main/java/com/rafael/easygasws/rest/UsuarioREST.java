/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafael.easygasws.rest;

import com.google.gson.Gson;
import com.rafael.easygasws.entidades.Usuario;
import com.rafael.easygasws.repositorios.UsuarioRepository;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Rafael Carlos Oliveira
 * @since 13/11/2017
 */
@Path("usuarios")
public class UsuarioREST {

    @Context
    private UriInfo context;

    public UsuarioREST() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getJson() {
        //TODO return proper representation object
//        Gson g = new Gson();
//        String str = "Olá";
//        g.toJson(str);
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        List<Usuario> usuarios = usuarioRepository.retornaViewUsers();

        return usuarios;
    }

    @POST
    @Path("novo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novoUsuario(String content) {

        Response response = null;

        Gson g = new Gson();
        Usuario user = g.fromJson(content, Usuario.class);
        Usuario usuarioPersist = new Usuario();

        usuarioPersist.setNome(user.getNome());
        usuarioPersist.setEmail(user.getEmail());
        usuarioPersist.setTelefone(user.getTelefone());
//        user.setNome(nome);
//        user.setEmail(email);
//        user.setTelefone(telefone);
//        user.setDataCadastro(new Date());
        usuarioPersist.setTipoUsuario(Usuario.TipoUsuario.CLIENTE);
        usuarioPersist.setAtivo(true);
        String valor = usuarioPersist.toString();
        System.out.println("Valor para inserir: " + valor);

        UsuarioRepository usuarioRepository = new UsuarioRepository();

//        usuarioRepository.salvar(user);
        if (usuarioRepository.salvar(usuarioPersist)) {
            response = Response.status(Response.Status.OK).entity(usuarioPersist).build();
//            return "Usuário Adicionadod com sucesso!";
//            return user.toString();

        } else {
//            return "Erro ao Adicionar usuário!";
            response = Response.status(Response.Status.NO_CONTENT).build();
        }

        return response;
    }

    /**
     * PUT method for updating or creating an instance of UsuarioREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
