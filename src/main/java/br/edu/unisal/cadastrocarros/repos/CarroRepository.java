package br.edu.unisal.cadastrocarros.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unisal.cadastrocarros.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
