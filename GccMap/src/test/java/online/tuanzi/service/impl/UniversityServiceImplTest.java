package online.tuanzi.service.impl;


import online.tuanzi.GccmapApplication;
import online.tuanzi.service.UniversityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GccmapApplication.class)
public class UniversityServiceImplTest {

    @Autowired
    private UniversityService universityService;

    @Test
    public void findAllSimpleUniversityDatum() {
        String university = "";
        Map<String, Object[]> mapList = universityService.findAllSimpleUniversityDatum(university);
//        for (Map<String, Object> map : mapList) {
//            System.out.println(map);
//        }
    }
}