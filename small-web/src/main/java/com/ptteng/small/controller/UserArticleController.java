package com.ptteng.small.controller;

import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.pub.model.UserArticle;
import com.ptteng.small.pub.service.UserArticleService;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

/**
 * UserArticle  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class UserArticleController {
    private static final Log log = LogFactory.getLog(UserArticleController.class);

    @Autowired
    private UserArticleService userArticleService;

    /**
     * 获取对某个文章的一个点赞,以此判断是否可以点赞/取消点赞
     *
     * @param request
     * @param response
     * @param model
     * @param openId
     * @param articleId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/appointUserArticle", method = RequestMethod.GET)
    public String getAppointUserArticleJson(HttpServletRequest request,
                                            HttpServletResponse response, ModelMap model, String openId, Long articleId)
            throws Exception {

        log.info("get data : openId , articleId = " + openId + " " + articleId);


        if (DataUtils.isNullOrEmpty(openId)) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(articleId)) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        List<Long> appointUserArticleId = null;
        List<UserArticle> userArticleList = null;
        try {
            Map<String, Object> param = DynamicUtil.getUserArticleByOpenIdAndArticleId(openId, articleId);
            appointUserArticleId = userArticleService.getIdsByDynamicCondition(UserArticle.class, param, 0, Integer.MAX_VALUE);
            userArticleList = userArticleService.getObjectsByIds(appointUserArticleId);
            log.info("get comment data is " + appointUserArticleId);
            model.addAttribute("code", 0);
            model.addAttribute("commentList", userArticleList);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get comment error,id is  " + appointUserArticleId);
            model.addAttribute("code", -100000);
        }

        return "/admin/userArticle/json/appointUserArticleListJson";
    }

    @RequestMapping(value = "/a/userArticle/{id}", method = RequestMethod.GET)
    public String getUserArticleJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        try {
            UserArticle userArticle = userArticleService.getObjectById(id);
            log.info("get userArticle data is " + userArticle);

            model.addAttribute("code", 0);

            model.addAttribute("userArticle", userArticle);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get userArticle error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/small-pub-service/userArticle/json/userArticleDetailJson";
    }


    /**
     * 添加对某个文章的一个点赞
     *
     * @param request
     * @param response
     * @param model
     * @param userArticle
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/userArticle", method = RequestMethod.POST)
    public String addUserArticleJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, UserArticle userArticle) throws Exception {

        log.info("update userArticle : userArticle= " + userArticle);


        if (DataUtils.isNullOrEmpty(userArticle.getOpenId())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(userArticle.getArticleId())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        String openId = userArticle.getOpenId();
        Long articleId = userArticle.getArticleId();
        List<Long> ids = null;
        Map<String, Object> param = DynamicUtil.getUserArticleByOpenIdAndArticleId(openId, articleId);
        ids = userArticleService.getIdsByDynamicCondition(UserArticle.class, param, 0, Integer.MAX_VALUE);
        if ( ids.size()>0) {
            log.error("add userArticle error,userArticle already existing,ids is  " + ids);
            model.addAttribute("code", -10086);
            return "/common/fail";
        } else {
            try {
                userArticle.setId(null);
                userArticle.setCreateAt(System.currentTimeMillis());
                Long id = userArticleService.insert(userArticle);
                log.info("add success , id is " + id);
                model.addAttribute("id", id);
                model.addAttribute("code", 0);
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("add userArticle error ");
                model.addAttribute("code", -6002);
            }
            return "/data/json";
        }
    }

    /**
     * 取消点赞
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/userArticle/{id}", method = RequestMethod.DELETE)
    public String deleteUserArticleJson(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete userArticle : id= " + id);
        try {
            userArticleService.delete(id);

            log.info("add userArticle success");
            model.addAttribute("id", id);
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete userArticle error,id is  " + id);
            model.addAttribute("code", -6004);

        }

        return "/data/json";
    }
}

