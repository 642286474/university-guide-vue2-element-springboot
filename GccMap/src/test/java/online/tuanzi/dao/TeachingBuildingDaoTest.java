package online.tuanzi.dao;

import online.tuanzi.GccmapApplication;
import online.tuanzi.domain.TeachingBuilding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GccmapApplication.class)
public class TeachingBuildingDaoTest {
    @Autowired
    private TeachingBuildingDao teachingBuildingDao;

    @Test
    public void findDetailData() {
        System.out.println(teachingBuildingDao.findDetailData(1));
    }
}