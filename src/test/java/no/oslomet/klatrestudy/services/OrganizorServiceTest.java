package no.oslomet.klatrestudy.services;

import no.oslomet.klatrestudy.entities.Organizor;
import no.oslomet.klatrestudy.repositories.OrganizorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrganizorServiceTest {

    private OrganizorRepository repo;
    private OrganizorService service;

    @BeforeEach
    void setUp() {
        repo = mock(OrganizorRepository.class);
        service = new OrganizorService(repo);
    }

    @Test
    void createOrganizor_savesEntityAndReturnsIt() {
        Organizor input = new Organizor(); // use a real entity or builder
        Organizor saved = new Organizor();
        saved.setId(1L);

        when(repo.save(input)).thenReturn(saved);

        Organizor result = service.createOrganizor(input);

        assertEquals(1L, result.getId());
        verify(repo).save(input);
    }

    @Test
    void getOrganizorById_existingId_returnsOrganizor() {
        Organizor organizor = new Organizor();
        organizor.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(organizor));

        Optional<Organizor> result = service.getOrganizorById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void getAllOrganizors_returnsAllEntities() {
        Organizor o1 = new Organizor();
        Organizor o2 = new Organizor();
        when(repo.findAll()).thenReturn(List.of(o1, o2));

        List<Organizor> result = service.getAllOrganizors();

        assertEquals(2, result.size());
        verify(repo).findAll();
    }

    @Test
    void updateOrganizor_existingId_updatesAndReturnsOrganizor() {
        Organizor input = new Organizor();
        Organizor updated = new Organizor();
        updated.setId(2L);

        when(repo.existsById(2L)).thenReturn(true);
        when(repo.save(any())).thenReturn(updated);

        Optional<Organizor> result = service.updateOrganizor(2L, input);

        assertTrue(result.isPresent());
        assertEquals(2L, result.get().getId());

        ArgumentCaptor<Organizor> captor = ArgumentCaptor.forClass(Organizor.class);
        verify(repo).save(captor.capture());
        assertEquals(2L, captor.getValue().getId());
    }

    @Test
    void updateOrganizor_nonExistingId_returnsEmpty() {
        when(repo.existsById(99L)).thenReturn(false);

        Optional<Organizor> result = service.updateOrganizor(99L, new Organizor());

        assertTrue(result.isEmpty());
        verify(repo, never()).save(any());
    }

    @Test
    void deleteOrganizor_existingId_deletesAndReturnsTrue() {
        when(repo.existsById(3L)).thenReturn(true);

        boolean result = service.deleteOrganizor(3L);

        assertTrue(result);
        verify(repo).deleteById(3L);
    }

    @Test
    void deleteOrganizor_nonExistingId_returnsFalse() {
        when(repo.existsById(404L)).thenReturn(false);

        boolean result = service.deleteOrganizor(404L);

        assertFalse(result);
        verify(repo, never()).deleteById(any());
    }
}