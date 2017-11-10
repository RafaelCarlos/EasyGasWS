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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author shang
 */
@Path("usuarios")
public class UsuarioREST {
    
    @Context
    private UriInfo context;
    
    public UsuarioREST() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        Gson g = new Gson();
        String str = "Olá";
        g.toJson(str);
        return "Olá";
    }
    
    @POST
    @Path("novo")
    @Produces(MediaType.APPLICATION_JSON)
    public String novoUsuario() {
        Usuario user = new Usuario();
        user.setNome("Rafael Carlos");
        user.setEmail("rafael@email.com");
        user.setTelefone("(63) 98134-7540");
        user.setDataCadastro(new Date());
        user.setTipoUsuario(Usuario.TipoUsuario.SUPORTE);
        user.setAtivo(true);
        
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        
        usuarioRepository.salvar(user);
        if (usuarioRepository.salvar(user)) {
            return "Usuário Adicionadod com sucesso!";
        } else {
            return "Erro ao Adicionar usuário!";
        }
    }

    /**
     * PUT method for updating or creating an instance of UsuarioREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content
    ) {
    }
}
