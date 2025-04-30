package no.oslomet.klatrestudy.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import no.oslomet.klatrestudy.entities.Organizor;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class OrganizorRepositoryDbIntegrationTest {
    @Autowired
    private OrganizorRepository repo;
    
    @Test
    void testSaveAndFindById() {
        Organizor organizor = new Organizor();
        organizor.setName("Test Organizor");
        organizor.setOrgNum(12345);
        
        // Save the organizor
        Organizor savedOrganizor = repo.save(organizor);
        
        // Find by ID
        Organizor foundOrganizor = repo.findById(savedOrganizor.getId()).orElse(null);
        
        assertThat(foundOrganizor).isNotNull();
        assertThat(foundOrganizor.getName()).isEqualTo("Test Organizor");
        assertThat(foundOrganizor.getOrgNum()).isEqualTo(12345);
    }
}