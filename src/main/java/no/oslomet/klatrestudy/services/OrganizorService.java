package no.oslomet.klatrestudy.services;

import no.oslomet.klatrestudy.entities.Organizor;
import no.oslomet.klatrestudy.repositories.OrganizorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class OrganizorService {
    private final OrganizorRepository repo;

    public OrganizorService(OrganizorRepository organizorRepository) {
        this.repo = organizorRepository;
    }

    // Create
    @Transactional
    public Organizor createOrganizor(Organizor organizor) {
        return repo.save(organizor);
    }

    // Read
    public Optional<Organizor> getOrganizorById(Long id) {
        return repo.findById(id);
    }
    public List<Organizor> getAllOrganizors() {
        return repo.findAll();
    }

    // Update
    @Transactional
    public Optional<Organizor> updateOrganizor(Long id, Organizor organizor) {
        if (repo.existsById(id)) {
            organizor.setId(id);
            return Optional.of(repo.save(organizor));
        }
        return Optional.empty();
    }

    // Delete
    @Transactional
    public boolean deleteOrganizor(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}