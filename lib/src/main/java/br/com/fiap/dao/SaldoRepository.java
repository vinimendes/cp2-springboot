package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Saldo;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo,Long>{

}
