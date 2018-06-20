package dev.repository;

import dev.model.Nature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NatureRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private  NatureRepository natureRepository;

    Nature natureTest = new Nature();
    Nature natureTest2 = new Nature();

    @Before
    public void setUp(){
        natureTest.setName("Test");
        testEntityManager.persist(natureTest);
        natureTest2.setName("Test2");
        testEntityManager.persist(natureTest2);
        testEntityManager.flush();
    }

    @Test
    public void testFindAll() {
        List<Nature> natureList = natureRepository.findAll();

        assertThat(natureList).isNotEmpty();
    }

    @Test
    public void testFindByName() {
        Nature found = natureRepository.findByName(natureTest.getName());
        assertThat(found.getName()).isEqualTo(natureTest.getName());
    }

    @Test
    public void testDelete() {
        natureRepository.delete(natureTest2);
        assertThat(natureRepository.findByName(natureTest2.getName())).isNull();
    }
}
