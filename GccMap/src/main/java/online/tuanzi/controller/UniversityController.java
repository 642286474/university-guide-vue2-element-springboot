package online.tuanzi.controller;

import online.tuanzi.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    /**
     * 根据 university 来获取所有跟这个学校有关的id，name，left，right
     *
     * @return
     */
    @PostMapping
    @CrossOrigin
    public Map<String, Object[]> getSimpleDatum(@RequestBody Map<String, String> map) {
        String university = map.get("university");
        Map<String, Object[]> universityDatum = universityService.findAllSimpleUniversityDatum(university);
        return universityDatum;
    }

    /**
     * 点击建筑物返回
     * 返回的是建筑的内容信息
     * post请求，请求参数是建筑id，相应参数是建筑的相关信息，比如体育馆开馆时间等等
     *
     * @return
     */
    @PostMapping("/architecture")
    @CrossOrigin
    public Map<String, Object> getDetailData(@RequestBody Map<String, String> map) throws ClassNotFoundException {
        String atUniversityId = map.get("atUniversityID");
        String requestId = map.get("atArchitectureID");
        String architectureName = requestId.split("#")[0];
        int architectureId = Integer.parseInt(requestId.split("#")[1]);
//        Class<?> aClass = Class.forName("online.tuanzi.domain." + architectureName);
//        System.out.println(aClass);
        String className = "online.tuanzi.domain." + architectureName;
//        Class<?> aClass = Class.forName("online.tuanzi.domain.Canteen");
        Map<String, Object> maps = universityService.findDetailData(architectureName, architectureId);
        return maps;
    }

    /**
     * 获取大学选项数据
     * 数据格式：
     * {'options':[{'id':'001','university':'广州商学院'},{'id':'002','university':'华南师范大学'}]}
     */
    @GetMapping("/options")
    @CrossOrigin
    public Map<String, Object[]> getUniversityOptions() {
        Map<String, String> map = new HashMap<>();
        Object[] lists = new Object[5];
//        map.put("10001","北京大学");
//        map.put("10002","中国人民大学");
//        map.put("10003","清华大学");
//        map.put("10004","北京交通大学");
        map.put("id","10001");
        map.put("university","北京大学");
        lists[0] = map;
        map = new HashMap<>();
        map.put("id","10002");
        map.put("university","中国人民大学");
        lists[1] = map;
        map = new HashMap<>();
        map.put("id","10003");
        map.put("university","清华大学");
        lists[2] = map;
        map = new HashMap<>();
        map.put("id","10004");
        map.put("university","北京交通大学");
        lists[3] = map;
        map = new HashMap<>();
        map.put("id","001");
        map.put("university","广州商学院");
        lists[4] = map;

        Map<String, Object[]> responseData = new HashMap<>();
        responseData.put("options",lists);
        return responseData;
    }
}
