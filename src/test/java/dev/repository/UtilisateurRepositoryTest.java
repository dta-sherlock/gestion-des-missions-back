package dev.repository;

import dev.model.Utilisateur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UtilisateurRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    Utilisateur utilisateurTest = new Utilisateur();
    Utilisateur utilisateurTest2 = new Utilisateur();

    @Before
    public void setUp(){
        utilisateurTest.setNom("Utilisateur Test");
        testEntityManager.persist(utilisateurTest);
        utilisateurTest2.setNom("Utilisateur Test 2");
        testEntityManager.persist(utilisateurTest2);
        testEntityManager.flush();
    }

    @Test
    public void testFindAll(){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();

        assertThat(utilisateurList).isNotEmpty();
    }

    @Test
    public void testFindByNom(){

        Utilisateur found = utilisateurRepository.findByNom(utilisateurTest.getNom());

        assertThat(found.getNom()).isEqualTo(utilisateurTest.getNom());
    }

    @Test
    public void testDelete(){

        utilisateurRepository.delete(utilisateurTest2);

        Utilisateur found = utilisateurRepository.findByNom(utilisateurTest2.getNom());

        assertThat(found).isNull();
    }
}
