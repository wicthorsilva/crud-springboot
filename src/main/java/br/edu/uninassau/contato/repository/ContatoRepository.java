package br.edu.uninassau.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uninassau.contato.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
