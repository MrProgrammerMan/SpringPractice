package no.oslomet.klatrestudy.entitites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import no.oslomet.klatrestudy.repositories.OrganizorRepository;
import no.oslomet.klatrestudy.entities.Organizor;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class OrganizorRepositoryTest {
    @Autowired
    private OrganizorRepository repo;
    
    @Test
    void createFiveAndCheckGetAllReturnsFive() {
        for (int i = 0; i < 5; i++) {
            Organizor org = new Organizor();
            org.setName("Joker Events");
            org.setOrgNum(123456789);
            repo.save(org);
        }

        List<Organizor> all = repo.findAll();
        assertThat(all).hasSize(5);
    }
}
