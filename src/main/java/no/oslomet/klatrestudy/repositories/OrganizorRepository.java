package no.oslomet.klatrestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import no.oslomet.klatrestudy.entities.Organizor;

public interface OrganizorRepository extends JpaRepository<Organizor, Long> {
    // Spring Data JPA will automatically implement basic CRUD operations
}