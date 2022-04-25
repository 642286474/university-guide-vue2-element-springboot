package online.tuanzi.dao;

import online.tuanzi.GccmapApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GccmapApplication.class)
public class CanteenDaoTest {

    @Autowired
    private CanteenDao canteenDao;

    @Test
    public void findDetailData() {
        System.out.println(canteenDao.findDetailData(3));
    }
}