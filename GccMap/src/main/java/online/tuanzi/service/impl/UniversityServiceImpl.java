package online.tuanzi.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import online.tuanzi.dao.*;
import online.tuanzi.domain.*;
import online.tuanzi.domain.Class;
import online.tuanzi.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private CanteenDao canteenDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private DormitoryBuildingDao dormitoryBuildingDao;
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private SportsFieldDao sportsFieldDao;
    @Autowired
    private TeachingBuildingDao teachingBuildingDao;

    /**
     * 根据 university 来获取所有跟这个学校有关的id，name，left，right
     *
     * @param university 大学名称（只有一个学校暂时用不上）
     * @return
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object[]> findAllSimpleUniversityDatum(String university) {
//        List<Map<String, Object>> lists = new ArrayList<>();
        Map<String, Object[]> maps = new HashMap<>();
        try {
            List<Canteen> canteenList = canteenDao.selectList(null);
//            Canteen[] canteens = canteenList.toArray(new Canteen[canteenList.size()]);
//            for (Canteen canteen : canteenList) {
//                maps.put(String.valueOf(canteen.getCanteenId()),canteen);
//            }

//            List<Class> classList = classDao.selectList(null);
//            List<Dormitory> dormitoryList = dormitoryDao.selectList(null);
            List<DormitoryBuilding> dormitoryBuildingList = dormitoryBuildingDao.selectList(null);
            List<Shop> shopList = shopDao.selectList(null);
//            assert shopList == null;
//            throw new RuntimeException();
            List<SportsField> sportsFieldList = sportsFieldDao.selectList(null);
            List<TeachingBuilding> teachingBuildingList = teachingBuildingDao.selectList(null);

            //添加数据id，name，left，right
            /**
             * {'datas': [{'id': '1', 'left': 'left:' + '66%', 'top': 'top:' + '55%', 'name': '第一教学楼'}]}
             */
            List<Object> lists = new ArrayList<>();
            Map<String, String> map = null;
            for (Canteen canteen : canteenList) {
                map = new HashMap<>();
                map.put("id", "Canteen#" + canteen.getCanteenId());
                map.put("left", "left:" + canteen.getLeft() + "%");
                map.put("top", "top:" + canteen.getTop() + "%");
                map.put("name", canteen.getCanteenName());
                lists.add(map);
            }

            for (DormitoryBuilding dormitoryBuilding : dormitoryBuildingList) {
                map = new HashMap<>();
                map.put("id", "DormitoryBuilding#" + dormitoryBuilding.getDormitoryBuildingId());
                map.put("left", "left:" + dormitoryBuilding.getLeft() + "%");
                map.put("top", "top:" + dormitoryBuilding.getTop() + "%");
                map.put("name", dormitoryBuilding.getDormitoryBuildingName());
                lists.add(map);
            }

            for (Shop shop : shopList) {
                map = new HashMap<>();
                map.put("id", "Shop#" + shop.getShopId());
                map.put("left", "left:" + shop.getLeft() + "%");
                map.put("top", "top:" + shop.getTop() + "%");
                map.put("name", shop.getShopName());
                lists.add(map);
            }

            for (SportsField sportsField : sportsFieldList) {
                map = new HashMap<>();
                map.put("id", "SportsField#" + sportsField.getSportsFieldId());
                map.put("left", "left:" + sportsField.getLeft() + "%");
                map.put("top", "top:" + sportsField.getTop() + "%");
                map.put("name", sportsField.getSportsFieldName());
                lists.add(map);
            }

            for (TeachingBuilding teachingBuilding : teachingBuildingList) {
                map = new HashMap<>();
                map.put("id", "TeachingBuilding#" + teachingBuilding.getTeachingBuildingId());
                map.put("left", "left:" + teachingBuilding.getLeft() + "%");
                map.put("top", "top:" + teachingBuilding.getTop() + "%");
                map.put("name", teachingBuilding.getTeachingBuildingName());
                lists.add(map);
            }

            maps.put("datas", lists.toArray());
//            maps.put("canteenList", canteenList);
//            maps.put("classList", classList);
//            maps.put("dormitoryList", dormitoryList);
//            maps.put("dormitoryBuildingList", dormitoryBuildingList);
//            maps.put("shopList", shopList);
//            maps.put("teachingBuildingList", teachingBuildingList);
//            maps.put("sportsFieldList", sportsFieldList);
        } catch (Exception e) {
            e.printStackTrace();
            //捕捉到异常直接清空
            maps.clear();
        } finally {
//            System.out.println("是否为空1"+(lists==null));
            //无论怎样都会返回列表
            return maps;
        }

        //封装数据
//        return lists;
    }

    @Override
    public Map<String, Object> findDetailData(String architectureName, int architectureId) {
//        String className = "";
//        //利用反射获取指定数据
//        if ("Canteen".equals(architectureName)||"Class".equals(architectureName)||"Dormitory".equals(architectureName)
//                ||"DormitoryBuilding".equals(architectureName)||"Shop".equals(architectureName)
//                ||"SportsField".equals(architectureName)||"TeachingBuilding".equals(architectureName)){
//            className = "online.tuanzi.dao."+architectureName+"Dao";
//        }
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> detailData = null;
        String data = "";
        /**
         * {
         *  type:建筑类型（饭堂、教学楼、宿舍等，根据不同的类型渲染不同的页面结构）,
         *  datas:建筑数据（可以是直接一长串字符串，比如说宿舍这些没什么好介绍的就可
         *      以直接是字符串显示出来，可以是键值对数组，比如说教学楼这些就用键值对数组展示有什么课室等等）
         * }
         */
        switch (architectureName) {
            case "Canteen":
                detailData = canteenDao.findDetailData(architectureId);
                /**
                 * {
                 *     "datas": "鲜果缘水果捞、家家味焗饭、柳州螺蛳粉、客家风味小炒、SITTER茶空间、新一鸡排.汉堡.小串、阿妈靓食原味汤粉、一炖天香、星辰潮记风味、眷村阿嬷粢饭團、肠粉猪杂汤饭、粤肠玖肠粉、张率麻辣烫麻辣香锅",
                 *     "class": "Canteen"
                 * }
                 */
                for (Map<String, Object> datum : detailData) {
                    data += datum.get("shop_name")+"、";
                }
                data = data.substring(0,data.length()-1);
                map.put("class","Canteen");
                map.put("datas", data);
                break;
            case "DormitoryBuilding":
                detailData = dormitoryBuildingDao.findDetailData(architectureId);
                /**
                 * [ { "dormitory_building_height": 6, "dormitory_building_name": "4号公寓","dormitory_building_type": "女" }，... ]
                 */
                map.put("class","DormitoryBuilding");
                map.put("datas", detailData);
                break;
            case "SportsField":
                detailData = sportsFieldDao.findDetailData(architectureId);
                /**
                 * [{ "sports_field_name": "广商足球场", "sports_field_floor": 1, "sports_field_usertype": "学生+老师" } ]
                 */
                map.put("class","SportsField");
                map.put("datas", detailData);
                break;
            case "TeachingBuilding":
                detailData = teachingBuildingDao.findDetailData(architectureId);
                /**
                 * [{teaching_building_name=第一教学楼, class_floorid=102, teaching_building_id=1,
                 * teaching_building_height=6, class_name=广州商学院学生健身中心, class_floor=1}, ...]
                 */
                map.put("class","TeachingBuilding");
                map.put("datas", detailData);
                break;
            default:
                map.put("class","");
                map.put("datas", new ArrayList<>());
        }
        System.out.println(map);
        return map;
    }

}
