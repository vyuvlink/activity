package cn.com.act.service.impl;

import cn.com.act.dao.HelloDao;
import cn.com.act.po.ActivityPo;
import cn.com.act.po.ScenePo;
import cn.com.act.po.SchemePo;
import cn.com.act.service.HelloService;
import cn.com.act.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public int generateActivitys(Integer qty) {
        List<ActivityPo> actList = new ArrayList<>();
        List<SchemePo> schemeList = new ArrayList<>();
        List<ScenePo> sceneList = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            ActivityPo po = new ActivityPo();
            double random = Math.random();
            boolean isThen50 = random > 0.5;
            long activity_id = SnowFlake.nextId();
            if (isThen50) {
                int max = (int) (Math.random() * 10);
                for (int j = 0; j < max; j++) {
                    ActivityPo cpo = new ActivityPo();
                    po.setRel_id(activity_id);
                }
                po.setType(1);
                po.setRel_id(0L);
            } else {
                po.setScheme_id(0L);
                po.setType(0);
                po.setRel_id(1L);
            }
            po.setId(activity_id);
            po.setName("alex的测试活动" + activity_id);
            po.setCover("http://127.0.0.1:3001/pGIbSV-565Y38IcjPdiB_0or.jpg");
            po.setStart_time(1661696711);
            po.setEnd_time(1664294400);
            po.setState(1);
            actList.add(po);
        }
        int act_flag = helloDao.generateActivitys(actList);
        int scheme_flag = helloDao.generateSchemes(schemeList);
        int scene_flag = helloDao.generateScenes(sceneList);
        System.out.printf("act_flag = %d, scheme_flag = %d, scene_flag = %d", act_flag, scheme_flag, scene_flag);
        return act_flag == 1 && scheme_flag == 1 && scene_flag == 1 ? 1 : 0;
    }
}
