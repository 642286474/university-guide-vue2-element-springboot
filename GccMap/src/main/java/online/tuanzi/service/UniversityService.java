package online.tuanzi.service;

import java.util.Map;

public interface UniversityService {
    Map<String, Object[]> findAllSimpleUniversityDatum(String university);

    Map<String, Object> findDetailData(String architectureName, int architectureId);
}
