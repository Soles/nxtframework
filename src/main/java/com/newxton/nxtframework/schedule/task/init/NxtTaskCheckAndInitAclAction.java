package com.newxton.nxtframework.schedule.task.init;

import com.newxton.nxtframework.entity.NxtAclAction;
import com.newxton.nxtframework.service.NxtAclActionService;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/12/5
 * @address Shenzhen, China
 * @copyright NxtFramework
 */
@Component
public class NxtTaskCheckAndInitAclAction {

    private Logger logger = LoggerFactory.getLogger(NxtTaskCheckAndInitAclAction.class);

    @Resource
    private NxtAclActionService nxtAclActionService;

    /**
     * 检查NxtAclAction表里面的class是否齐全，不全就自动添加
     * 这个任务比较特殊，每次启动都要执行一次，所以最后不需要setJobStatus(0)；并且同时单独一个实例执行。
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void exec(){

        logger.info("初始化[ACL的Action]数据任务，开始执行");

        //*************************任务代码**开始************************************************

        List<NxtAclAction> aclActionList = nxtAclActionService.queryAll(new NxtAclAction());
        Set<String> actionClassSet = new HashSet<>();
        for (NxtAclAction nxtAclAction :
                aclActionList) {
            actionClassSet.add(nxtAclAction.getActionClass());
        }
        String basePackages = "com.newxton.nxtframework.controller.api.admin.";
        Reflections reflections = new Reflections(basePackages);
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(RestController.class);

        List<Class<?>> classList = new LinkedList<Class<?>>(classSet);

        for (Class<?> item :
                classList) {
            String className = item.getName().replace(basePackages,"");
            String actionName = className.replace("NxtApiAdmin","").replace("Controller","");
            if (className.contains("Login") || className.contains("Logout")){
                continue;
            }
            if (!actionClassSet.contains(className)){
                //插入
                NxtAclAction nxtAclAction = new NxtAclAction();
                nxtAclAction.setActionClass(className);
                nxtAclAction.setActionName(actionName);
                nxtAclActionService.insert(nxtAclAction);
            }
        }

        //*************************任务代码**结束************************************************

        logger.info("初始化[ACL的Action]任务，成功执行完毕");

    }

}
