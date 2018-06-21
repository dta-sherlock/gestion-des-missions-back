package dev.repository;

import dev.model.Nature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Nature, Integer> {
    Nature findByNom(String nom);
}
