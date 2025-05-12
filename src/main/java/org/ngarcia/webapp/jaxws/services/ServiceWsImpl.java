package org.ngarcia.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.ngarcia.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.ngarcia.webapp.jaxws.services.ServicioWs")
public class ServiceWsImpl implements ServicioWs {

    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("SALUDAR instancia " + this);
        contador ++;
        System.out.println("SALUDAR Contador: "+contador);
        return "Hola " + persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("java"), new Curso("genexus"), new Curso("sql server"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("CURSO CREADO " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
