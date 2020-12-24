package com.newxton.nxtframework.component;

import com.newxton.nxtframework.entity.*;
import com.newxton.nxtframework.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/10/21
 * @address Shenzhen, China
 * @copyright NxtFramework
 */
@Component
public class NxtAclComponent {

    private Logger logger = LoggerFactory.getLogger(NxtAclComponent.class);

    @Resource
    private NxtAclActionService nxtAclActionService;

    /**
     * ClassName -> ActionId 映射表
     * @return
     */
    public Map<String,Long> getMapClassNameToActionId(){
        List<NxtAclAction> list = nxtAclActionService.queryAll(new NxtAclAction());
        Map<String,Long> mapClassNameToActionId = new HashMap<>();
        for (NxtAclAction nxtAclAction : list) {
            mapClassNameToActionId.put(nxtAclAction.getActionClass(),nxtAclAction.getId());
        }
        logger.info("getMapClassNameToActionId");
        return mapClassNameToActionId;
    }

    @Resource
    private NxtAclUserActionService nxtAclUserActionService;

    /**
     * 用户直接关联的权限Action
     * @param userId
     * @return
     */
    public Set<Long> getUserActionIdSet(Long userId){
        Set<Long> userActionSet = new HashSet<>();
        NxtAclUserAction nxtAclUserAction = new NxtAclUserAction();
        nxtAclUserAction.setUserId(userId);
        List<NxtAclUserAction> list = nxtAclUserActionService.queryAll(nxtAclUserAction);
        for (NxtAclUserAction item : list) {
                userActionSet.add(item.getActionId());
        }
        logger.info("getUserActionIdSet:{}",userId);
        return userActionSet;
    }

    @Resource
    private NxtAclRoleGroupService nxtAclRoleGroupService;

    /**
     * 用户通过角色关联的权限
     * @param userId
     * @return
     */
    public Set<Long> getUserRoleGroupActionIdSet(Long userId){
        Set<Long> userActionSet = new HashSet<>();
        /*再间接通过角色、权限组查询用户拥有的权限*/
        //角色 -> 权限组
        List<NxtAclRoleGroup> listAclRoleGroup = nxtAclRoleGroupService.queryAll(new NxtAclRoleGroup());
        //权限组 -> 权限ID
        Map<Long,Set<Long>> mapGroupIdToActionIdSet = getMapGroupIdToActionIdSet();
        //1、查询用户的角色
        List<NxtAclUserRole> listAclUserRole = getListAclUserRole(userId);
        for (NxtAclUserRole nxtAclUserRole : listAclUserRole) {
            //2、查询该role关联的group
            Long roleId = nxtAclUserRole.getRoleId();
            for (NxtAclRoleGroup nxtAclRoleGroup : listAclRoleGroup) {
                if (nxtAclRoleGroup.getRoleId().equals(roleId)) {
                    Long groupId = nxtAclRoleGroup.getGroupId();
                    //3、查询该groupId关联的action
                    if (mapGroupIdToActionIdSet.containsKey(groupId)) {
                        userActionSet.addAll(mapGroupIdToActionIdSet.get(groupId));
                    }
                }
            }
        }
        logger.info("getUserRoleGroupActionIdSet:{}",userId);
        return userActionSet;
    }

    @Resource
    private NxtAclGroupActionService nxtAclGroupActionService;

    /**
     * 取 权限组 -> 权限ID集合 映射表
     * @return
     */
    private Map<Long,Set<Long>> getMapGroupIdToActionIdSet(){
        Map<Long,Set<Long>> mapGroupIdToActionIdSet = new HashMap<>();
        List<NxtAclGroupAction> list = nxtAclGroupActionService.queryAll(new NxtAclGroupAction());
        for (NxtAclGroupAction nxtAclGroupAction : list) {
            if (!mapGroupIdToActionIdSet.containsKey(nxtAclGroupAction.getGroupId())){
                mapGroupIdToActionIdSet.put(nxtAclGroupAction.getGroupId(),new HashSet<>());
            }
            mapGroupIdToActionIdSet.get(nxtAclGroupAction.getGroupId()).add(nxtAclGroupAction.getActionId());
        }
        logger.info("getMapGroupIdToActionIdSet");
        return mapGroupIdToActionIdSet;
    }


    @Resource
    private NxtAclUserRoleService nxtAclUserRoleService;

    /**
     * 取某个用户的角色列表
     * @param userId
     * @return
     */
    private List<NxtAclUserRole> getListAclUserRole(Long userId){
        NxtAclUserRole nxtAclUserRole = new NxtAclUserRole();
        nxtAclUserRole.setUserId(userId);
        List<NxtAclUserRole> list = nxtAclUserRoleService.queryAll(nxtAclUserRole);
        return list;
    }

}
