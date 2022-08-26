package cn.com.act.service.impl;

import cn.com.act.dao.ActivityDao;
import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.SaveActivityParams;
import cn.com.act.po.ActivityPo;
import cn.com.act.po.SchemePo;
import cn.com.act.service.ActivityService;
import cn.com.act.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public ActivityDto saveActivity(SaveActivityParams saveActivityParams) {
        if (saveActivityParams.getId() == null) {
            saveActivityParams.setId(SnowFlake.nextId());
        }
        System.out.printf(saveActivityParams.toString());
        return new ActivityDto();
    }

    public ActivityDto queryActivity(Long id, String name, Integer state) {
//        ActivityPo po = activityDao.queryActivity(id,name,state);
//        ActivityDto dto = new ActivityDto();
//        dto.setScheme_id(po.getScheme_id().toString());
//        dto.setId(po.getId().toString());
//        dto.setName(po.getName());
//        dto.setState(po.getState());
//        dto.setScene(po.getScene());
//        dto.setContext(po.getContext());
//        dto.setStart_time(po.getStart_time());
//        dto.setEnd_time(po.getEnd_time());
//
//        if (po.getScheme_id() == 0) {
//            List<ActivityPo> poList = activityDao.queryMultiActivity(id);
//            List<SchemePo> sList = new ArrayList<SchemePo>();
//            for (ActivityPo p : poList){
//                SchemePo s = new SchemePo();
//                s.setId(p.getScene_id());
//                s.setType(p.getType());
//                sList.add(s);
//            }
//            dto.setScheme_list(sList);
//        }
        List<ActivityPo> poList = activityDao.queryActivitys(id);
        ActivityDto dto = new ActivityDto();
        List<SchemePo> sList = new ArrayList<SchemePo>();
        if (poList.size() > 0) {
            for (ActivityPo p : poList) {
                if (p.getScheme_id() == 0) {
                    dto.setScheme_id(p.getScheme_id().toString());
                    dto.setId(p.getId().toString());
                    dto.setName(p.getName());
                    dto.setState(p.getState());
                    dto.setScene(p.getScene());
                    dto.setContext(p.getContext());
                    dto.setStart_time(p.getStart_time());
                    dto.setEnd_time(p.getEnd_time());
                } else {
                    SchemePo s = new SchemePo();
                    s.setId(p.getScene_id());
                    s.setType(p.getType());
                    sList.add(s);
                }
            }
            if (sList.size() > 0) {
                dto.setScheme_list(sList);
            }
        }

        return dto;
    }

    public String saveScheme(String scene) {
        String query_scene = scene == null ? "" : scene;
        return query_scene;
    }

    public String sceneEncode(String scene) {
        String query_scene = scene == null ? "" : scene;
        return query_scene;
    }
}
