package com.newxton.nxtframework.controller.api.admin;

import com.newxton.nxtframework.component.NxtUploadImageComponent;
import com.newxton.nxtframework.entity.NxtBanner;
import com.newxton.nxtframework.entity.NxtUploadfile;
import com.newxton.nxtframework.service.NxtBannerService;
import com.newxton.nxtframework.service.NxtUploadfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/8/26
 * @address Shenzhen, China
 * @copyright NxtFramework
 */
@RestController
public class NxtApiAdminBannerListController {

    @Resource
    private NxtBannerService nxtBannerService;

    @Resource
    private NxtUploadfileService nxtUploadfileService;

    @Resource
    private NxtUploadImageComponent nxtUploadImageComponent;

    @RequestMapping(value = "/api/admin/banner/list", method = RequestMethod.POST)
    public Map<String, Object> index() {

        Map<String, Object> result = new HashMap<>();
        result.put("status", 0);
        result.put("message", "");

        List<NxtBanner> list = nxtBannerService.queryAll(new NxtBanner());

        Map<String,Object> jsonData = new HashMap<>();
        List<String> locationList = new ArrayList<>();

        List<Long> picFileIdList = new ArrayList<>();

        for (NxtBanner nxtBanner : list) {
            picFileIdList.add(nxtBanner.getUploadfileId());
        }

        //查询图片url
        List<NxtUploadfile> nxtUploadfileList = nxtUploadfileService.selectByIdSet(0,picFileIdList.size(),picFileIdList);
        Map<Long,Object> fileIdMapUrlPath = new HashMap<>();
        for (NxtUploadfile nxtUploadfile : nxtUploadfileList) {
            fileIdMapUrlPath.put(nxtUploadfile.getId(),nxtUploadfile.getUrlpath());
        }


        for (NxtBanner nxtBanner :
                list) {
            String locationName = nxtBanner.getLocationName();
            if (!jsonData.containsKey(locationName)){
                List itemList = new ArrayList();
                jsonData.put(locationName,itemList);
                locationList.add(locationName);
            }

            if (fileIdMapUrlPath.containsKey(nxtBanner.getUploadfileId())) {
                List itemList = (List)jsonData.get(locationName);

                Map<String,Object> itemMap = new HashMap<>();
                itemMap.put("banner_picture_id",nxtBanner.getUploadfileId());
                String urlPath = fileIdMapUrlPath.get(nxtBanner.getUploadfileId()).toString();
                itemMap.put("banner_picture_url", nxtUploadImageComponent.convertImagePathToDomainImagePath(urlPath));
                itemMap.put("banner_href_url", nxtBanner.getClickUrl());

                picFileIdList.add(nxtBanner.getUploadfileId());

                itemList.add(itemMap);
            }

        }

        List resultList = new ArrayList();
        for (String locationName :
                locationList) {
            Map<String,Object> resultListItem = new HashMap<>();
            resultListItem.put("location_name",locationName);
            resultListItem.put("banner",jsonData.get(locationName));
            resultList.add(resultListItem);
        }

        result.put("list",resultList);

        return result;

    }

}
