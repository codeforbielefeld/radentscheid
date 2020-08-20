package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import de.codefor.bielefeld.radentscheid.unfallserver.domain.Accident;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccidentRepoTests {

    @Autowired
    AccidentRepo accidentRepo;


    @Test
    public void testFindOne() {
        // given

        // when
        Accident accident = accidentRepo.findOne("96697");

        // then
        Assert.assertEquals("96697", accident.id());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindOneNotFound() {
        // given

        // when
        accidentRepo.findOne("0");

        // then
    }

    @Test
    public void testFindAll() {
        // given
        List<Accident> allAccidents = new ArrayList<>();

        // when
        Iterable<Accident> all = accidentRepo.findAll();
        all.forEach(allAccidents::add);

        // then
        Assert.assertTrue(allAccidents.size() > 1);
    }

    @Test
    public void testCount() {
        // given

        // when
        Long count = accidentRepo.count();

        // then
        Assert.assertEquals(357, count.longValue());
    }

    @Test
    public void testExists() {
        // given

        // when
        boolean exists = accidentRepo.exists("96697");

        // then
        Assert.assertTrue(exists);
    }

    @Test
    public void testExistsNotExists() {
        // given

        // when
        boolean exists = accidentRepo.exists("-1");

        // then
        Assert.assertFalse(exists);
    }


}
