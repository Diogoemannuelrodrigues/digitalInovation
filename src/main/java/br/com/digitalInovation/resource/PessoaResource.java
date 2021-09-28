package br.com.digitalInovation.resource;

import br.com.digitalInovation.entidade.Pessoa;
import br.com.digitalInovation.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> findPessoa(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.buscaPessoaPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveCategoria(@RequestBody Pessoa pessoa) {
        Pessoa pessoaNew = pessoaService.salvarPessoas(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> pessoas() {
        List<Pessoa> listPessoas = pessoaService.listarPessoas();
        return listPessoas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoa1 = pessoaService.alterarPessoa(pessoa);
        return ResponseEntity.ok().body(pessoa1);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pessoa> deletaProduto(@PathVariable Integer id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }


}
