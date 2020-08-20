package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import de.codefor.bielefeld.radentscheid.unfallserver.domain.Kind;
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
public class KindRepoTests {

    @Autowired
    KindRepo kindRepo;


    @Test
    public void testFindOne() {
        // given

        // when
        Kind kindOne = kindRepo.findOne(1);

        // then
        Assert.assertEquals(1, kindOne.id());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindOneNotFound() {
        // given

        // when
        kindRepo.findOne(-1);

        // then
    }

    @Test
    public void testFindAll() {
        // given
        List<Kind> allKinds = new ArrayList<>();

        // when
        Iterable<Kind> all = kindRepo.findAll();
        all.forEach(allKinds::add);

        // then
        Assert.assertEquals(11, allKinds.size());
    }

    @Test
    public void testCount() {
        // given

        // when
        Long count = kindRepo.count();

        // then
        Assert.assertEquals(11, count.longValue());
    }

    @Test
    public void testExists() {
        // given

        // when
        boolean exists = kindRepo.exists(1);

        // then
        Assert.assertTrue(exists);
    }

    @Test
    public void testExistsNotExists() {
        // given

        // when
        boolean exists = kindRepo.exists(-1);

        // then
        Assert.assertFalse(exists);
    }


}
