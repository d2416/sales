package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salesianostriana.dam.correduriacrm.model.Seguros;

  // en los ejemplos no se utiliza esta etiqueta, por qué no la utilizan?
public interface ISegurosRepository extends JpaRepository<Seguros, Long> {

}
