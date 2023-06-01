package br.edu.uninassau.contato.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uninassau.contato.entity.Contato;
import br.edu.uninassau.contato.repository.ContatoRepository;

@RestController
public class ContatoController {
	@Autowired
	private ContatoRepository contatoRepository;
	
	@PostMapping("/contato")
	public String saveContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
		return "Contato salvo com sucesso!";
	}
	
	@GetMapping("/contato")
	public List<Contato> getcontato(){
		return contatoRepository.findAll();
	}
	
	@PutMapping("/contato/{id}")
	public String updateContato(@PathVariable("id") Long id, @RequestBody Contato contatoUpdate) {
	    Optional<Contato> oldContato = contatoRepository.findById(id);
	    String msg = null;

	    if (oldContato.isPresent()) {
	        Contato contato = oldContato.get();
	        contato.setNome(contatoUpdate.getNome());
	        contato.setEmail(contatoUpdate.getEmail());
	        contatoRepository.save(contato);
	        msg = "Contato atualizado com sucesso";
	    } else {
	        msg = "Contato não localizado!";
	    }
	    return msg;
	}

	
	@DeleteMapping("/contato/{id}")
	public String deleteContato(@PathVariable("id") Long id) {
	    Optional<Contato> contato = contatoRepository.findById(id);
	    String msg = null;

	    if (contato.isPresent()) {
	        contatoRepository.delete(contato.get());
	        msg = "Contato excluído com sucesso";
	    } else {
	        msg = "Contato não localizado!";
	    }
	    return msg;
	}

}
