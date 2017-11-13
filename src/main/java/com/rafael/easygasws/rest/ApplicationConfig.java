package com.rafael.easygasws.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Rafael Carlos Oliveira
 * @since 13/11/2017
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.rafael.easygasws.rest.UsuarioREST.class);
        resources.add(com.rafael.easygasws.util.GsonMessageBodyHandler.class);
    }

}
