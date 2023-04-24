package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Pix;

@Repository
public interface PixRepository extends JpaRepository<Pix,Long>{

}
