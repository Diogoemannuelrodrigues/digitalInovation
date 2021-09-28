package br.com.digitalInovation.service;

import br.com.digitalInovation.entidade.Pessoa;
import br.com.digitalInovation.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa salvarPessoas(Pessoa pessoa){
          return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa alterarPessoa(Pessoa pessoa) {
        Optional<Pessoa> pAlterada = pessoaRepository.findById(pessoa.getId());
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscaPessoaPorId(Integer id){
        return pessoaRepository.getById(id);
    }


}
