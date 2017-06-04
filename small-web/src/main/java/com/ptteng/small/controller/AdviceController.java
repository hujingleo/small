package com.ptteng.small.controller;

import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.admin.util.RoleUtil;
import com.ptteng.small.pub.model.*;
import com.ptteng.small.pub.service.AdviceService;
import com.ptteng.small.pub.service.MessageService;
import com.ptteng.small.pub.service.UserService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujin on 2017/5/17.
 */
@Controller
public class AdviceController {

    private static final Log log = LogFactory.getLog(AdviceController.class);

    @Autowired
    private AdviceService adviceService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
//    @Autowired
//    private CookieUtil cookieUtil;


    /**
     * 获取建议列表
     *
     * @param request
     * @param response
     * @param model
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/advice/search", method = RequestMethod.GET)
    public String getAdviceJsionList(HttpServletRequest request, HttpServletResponse response,
                                     ModelMap model, Integer page, Integer size) throws Exception {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }

        log.info("pageList : page= " + start + " , size=" + size);
        List<Long> totalids = null;
        List<Long> ids = null;
        List<Advice> adviceList = null;
        try {
            List<HashMap<String, Object>> adviceDataList = new ArrayList<HashMap<String, Object>>();
            ids = adviceService.getAdviceIds(start, size);
            totalids = adviceService.getAdviceIds(page, Integer.MAX_VALUE);
            adviceList = adviceService.getObjectsByIds(ids);
            int total = totalids.size();
            log.info("get adviceList data  id is " + ids);

            for (Advice advice : adviceList) {
                HashMap<String, Object> adviceDataMap = new HashMap<String, Object>();
                String oid = advice.getOpenId();
                Map<String, Object> param1 = DynamicUtil.getUserByOpenId(oid);
                User user = new User();
                List<Long> userIds = userService.getIdsByDynamicCondition(User.class, param1, 0, Integer.MAX_VALUE);
                if (userIds.size() > 0) {
                    user = userService.getObjectById(userIds.get(0));
                    if (DataUtils.isNotNullOrEmpty(user)) {
                        adviceDataMap.put("userAvatarUrl", user.getAvatarUrl());
                        adviceDataMap.put("nickName", user.getNickName());
                    }
                }
                adviceDataMap.put("id", advice.getId());
                adviceDataMap.put("adviceCreateBy", oid);
                adviceDataMap.put("adviceDescription", advice.getDescription());
                adviceDataMap.put("adviceCreateAt", advice.getCreateAt());
                adviceDataMap.put("adviceContactInformation", advice.getContactInformation());

                adviceDataList.add(adviceDataMap);
            }
            model.addAttribute("adviceDataList", adviceDataList);
            model.addAttribute("code", 0);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("page", page);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get adviceDataList error,page is  " + start + " , size " + size);
            // for test
            model.addAttribute("code", -100000);
        }
        return "/admin/advice/json/adviceDataListJson";
    }

    /**
     *新增建议
     * @param request
     * @param response
     * @param model
     * @param advice
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/advice", method = RequestMethod.POST)
    public String addadviceJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                 Advice advice) throws Exception {

        log.info("insert advice : = " + advice);

        if (DataUtils.isNullOrEmpty(advice.getOpenId())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(advice.getDescription())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(advice.getContactInformation())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }

        try {
            advice.setId(null);
            advice.setCreateAt(System.currentTimeMillis());
            Long id = adviceService.insert(advice);
            log.info("add advice success , id is " + id);
            model.addAttribute("id", id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add advice error ");
            model.addAttribute("code", -6002);
        }

        return "/data/json";
    }




    /**
     * 获取单个建议
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/advice/{id}", method = RequestMethod.GET)
    public String getAdviceJson(HttpServletRequest request, HttpServletResponse response,
                                ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get  advice : advice id = " + id);

        try {
            Advice advice = adviceService.getObjectById(id);
            model.addAttribute("code", 0);
            model.addAttribute("advice", advice);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get advice error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/admin/advice/json/adviceDetailJson";
    }
    //回复意见
    @RequestMapping(value = "/a/u/advice/{id}", method = RequestMethod.PUT)
    public String updateAdviceJson(HttpServletRequest request, HttpServletResponse response,
                                ModelMap model, @PathVariable Long id,String content)
            throws Exception {

        log.info("update  advice : advice id = " + id);

        try {
            Advice advice = adviceService.getObjectById(id);
            //更新advice表
            advice.setReplyContent(content);
            //更新message表
            Message message=new Message();
            message.setId(null);
            message.setContent(content);
            message.setOpenId(advice.getOpenId());
            messageService.insert(message);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get advice error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/data/json";
    }

}
