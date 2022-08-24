package cn.com.act.service.impl;

import cn.com.act.dao.ActivityDao;
import cn.com.act.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public String sceneDecode(String scene) {
        String query_scene = scene == null ? "" : scene;
        return query_scene;
    }

    public String sceneEncode(String scene) {
        String query_scene = scene == null ? "" : scene;
        return query_scene;
    }
}
