package dev.repository;

import dev.model.Mission;
import dev.model.Nature;
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
public class MissionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private MissionRepository missionRepository;

    Mission missionTest = new Mission();
    Mission missionTest2 = new Mission();

    @Before
    public void setUp(){
        Nature natureTest = new Nature();
        natureTest.setName("Nature test");
        missionTest2.setNature(natureTest);

        testEntityManager.persist(natureTest);
        testEntityManager.persist(missionTest);
        testEntityManager.persist(missionTest2);

        testEntityManager.flush();
    }

    @Test
    public void testFindAll(){
        List<Mission> missionList = missionRepository.findAll();

        assertThat(missionList).isNotEmpty();
    }

    @Test
    public void testFindByNatureName(){
        List <Mission> found = missionRepository.findByNatureNom(missionTest2.getNature().getName());

        assertThat(found).contains(missionTest2);
    }

    @Test
    public void testDelete(){
        missionRepository.delete(missionTest2);

        List <Mission> found = missionRepository.findByNatureNom(missionTest2.getNature().getName());

        assertThat(found).isEmpty();
    }
}
