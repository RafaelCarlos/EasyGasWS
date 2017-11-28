package com.rafael.easygasws.rest;

import com.google.gson.Gson;
import com.rafael.easygasws.entidades.Usuario;
import com.rafael.easygasws.repositorios.UsuarioRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

    private Usuario usuarioPersist;
    private UsuarioRepository usuarioRepository;

    @Context
    private UriInfo context;

    public UsuarioREST() {
    }

    @PostConstruct
    private void init() {
        this.usuarioPersist = new Usuario();
        this.usuarioRepository = new UsuarioRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Usuario> todosUsuarios() {
        //TODO return proper representation object
//        Gson g = new Gson();
//        String str = "Olá";
//        g.toJson(str);

        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @GET
    @Path("porid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario usuarioPorId(@PathParam("id") int id) {
        //TODO return proper representation object
//        Gson g = new Gson();
//        String str = "Olá";
//        g.toJson(str);

        usuarioPersist = usuarioRepository.getPorId(id);
        return usuarioPersist;
    }

    @GET
    @Path("pornome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> usuarioPorNome(@PathParam("nome") String nome) {
        //TODO return proper representation object
//        Gson g = new Gson();
//        String str = "Olá";
//        g.toJson(str);
        System.out.println("Nome recebido para consulta: " + nome);
        UsuarioRepository user = new UsuarioRepository();
        List<Usuario> usuarios = user.userByName(nome);
        System.out.println("Pesquisa por nome: " + usuarios);
        return usuarios;
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario loginEmail(@PathParam("email") String email, @PathParam("senha") String senha) {

        usuarioPersist = usuarioRepository.loginUsuarioEmail(email, senha);

        return usuarioPersist;

    }

    @POST
    @Path("novo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response novoUsuario(Usuario user) {

        Response response = null;
        System.out.println("Valor para inserir: " + user.toString());

        Gson g = new Gson();
//        Usuario user = g.fromJson(content, Usuario.class);
        usuarioPersist.setNome(user.getNome());
        usuarioPersist.setEmail(user.getEmail());
        usuarioPersist.setTelefone(user.getTelefone());
//        user.setNome(nome);
//        user.setEmail(email);
//        user.setTelefone(telefone);
        usuarioPersist.setDataCadastro(new Date());
        usuarioPersist.setTipoUsuario(Usuario.TipoUsuario.CLIENTE);
        usuarioPersist.setAtivo(true);
        String valor = usuarioPersist.toString();

//        usuarioRepository.salvar(user);
        if (usuarioRepository.salvar(usuarioPersist)) {
            response = Response.status(Response.Status.CREATED).entity(usuarioPersist).build();
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

    @PUT
    @Path("editar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, Usuario entity) {
        Response response = null;
        usuarioPersist = usuarioRepository.getPorId(id);

        usuarioPersist.setNome(entity.getNome());
        usuarioPersist.setEmail(entity.getEmail());
        usuarioPersist.setTelefone(entity.getTelefone());
        usuarioPersist.setSenha(entity.getSenha());

        if (usuarioRepository.atualizar(usuarioPersist)) {
            response = Response.status(Response.Status.OK).build();

            return response;
        } else {
            response = Response.status(Response.Status.NO_CONTENT).build();

            return response;
        }

    }

    @DELETE
    @Path("excluir/{id}")
    public Response excluir(@PathParam("id") int id) {
        usuarioPersist = usuarioRepository.getPorId(id);
        Response response = null;
        if (usuarioRepository.excluir(usuarioPersist)) {
            response = Response.status(Response.Status.OK).build();

            return response;
        } else {
//            return "Erro ao Adicionar usuário!";
            response = Response.status(Response.Status.NO_CONTENT).build();
            return response;
        }
    }
}
