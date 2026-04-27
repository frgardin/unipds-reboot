package com.felipegardin;

import java.util.List;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {
    
    @GET
    public List<Pessoa> getPessoas() {
        return Pessoa.listAll();
    }

    @GET
    @Path("/anoNascimento")
    public List<Pessoa> getPessoasByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
        return Pessoa.findByAnoNascimento(anoNascimento);
    }


    @POST
    @Transactional
    public Pessoa addPessoa(Pessoa pessoa) {
        pessoa.id = null;
        pessoa.persist();
        return pessoa;
    }

    @PUT
    @Transactional
    public Pessoa alterPessoa(Pessoa pessoa) {
        Pessoa p = Pessoa.findById(pessoa.id);
        p.nome = pessoa.nome;
        p.anoNascimento = pessoa.anoNascimento;
        return p;
    }

    @DELETE
    @Transactional
    public void deletePessoa(int id) {
        Pessoa.deleteById(id);
    }
}
