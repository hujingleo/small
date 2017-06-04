package com.ptteng.small.controller.pub;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.storage.util.ImgStorageUtil;
import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.pub.model.Article;
import com.ptteng.small.pub.model.ArticleType;
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.service.ArticleTypeService;
import com.ptteng.small.pub.service.ManagerService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;

@Controller
public class ArticleTypeController {
  
  private static final Log log = LogFactory.getLog(ArticleTypeController.class);
  
  private final String Img_Module_Common = "common";
  
  @Autowired
  private ArticleTypeService articleTypeService;
  
  @Autowired
  private ManagerService managerService;
  
  @Autowired
  private com.qding.common.util.http.cookie.CookieUtil cookieUtil;
  

  
  /**
   * 单个查询展示内容
   *
   * @param request
   * @param response
   * @param model
   * @param aid
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/article/type/{id}", method = RequestMethod.GET)
  public String getArticleJson(HttpServletRequest request, HttpServletResponse response,
                               ModelMap model, @PathVariable Long id)
      throws Exception {
    
    log.info("get data : id= " + id);
    try {
      if (id == null) {
        model.addAttribute("code", -1004);
        return "/data/json";
      }
      else {
        
        ArticleType articleType = articleTypeService.getObjectById(id);
        if (articleType == null) {
          model.addAttribute("code", -9003);
          return "/data/json";
        }
        else {
          log.info("get articleType data is " + articleType);
          model.addAttribute("code", 0);
          model.addAttribute("article", articleType);
        }
      }
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("get articleType error,id is  " + id);
      model.addAttribute("code", -100000);
    }
    
    return "/admin/articleType/json/articleTypeDetailJson";
  }
  
  /**
   * 修改article
   *
   * @param request
   * @param response
   * @param model
   * @param article
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/u/article/type/{id}", method = RequestMethod.PUT)
  public String updateArticleJson(HttpServletRequest request, HttpServletResponse response,
                                  ModelMap model, ArticleType articleType, @PathVariable Long id)
      throws Exception {
    
    log.info("update article : articleType= " + articleType);
    
    try {
      
      if (articleType == null) {
        model.addAttribute("code", -1004);
        
        return "/data/json";
      }
      //在原有的基础上修改
      ArticleType articleTypeReal=articleTypeService.getObjectById(articleType.getId());
      
      // if (DataUtils.isNullOrEmpty(article.getImg())) {
      // model.addAttribute("code", -4014);
      // return "common/success";
      // }
      Long uid = Long.valueOf(
          cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
      
      articleTypeReal.setUpdateBy(uid);
      articleTypeReal.setId(id);
      articleTypeReal.setName(articleType.getName());
      
      log.info("update article : article= " + articleType);
      articleTypeService.update(articleTypeReal);
      
      model.addAttribute("code", 0);
      
      model.addAttribute("articleType", articleTypeReal);
      
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("update article error,id is  " + articleType.getId());
      model.addAttribute("code", -100000);
    }
    return "/data/json";
  }
  
  /**
   * 修改article 的上架下架状态
   *
   * @param request
   * @param response
   * @param model
   * @param
   * @param aid
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/u/article/type/status", method = RequestMethod.PUT)
  public String updateArticleJson(HttpServletRequest request, HttpServletResponse response,
                                  ModelMap model, Long id, Integer status)
      throws Exception {
    if (id == null) {
      model.addAttribute("code", -1000);
      log.info("put articleType error aid is null");
      return "/data/json";
    }
    
    ArticleType articleType = articleTypeService.getObjectById(id);
    // Integer status = article.getStatus();
    log.info("update articleType status : articleType id ,status = " + id + " , " + status);
    
    
    try {
      
      Long uid = Long.valueOf(
          cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
      
      articleType.setUpdateBy(uid);
      // 修改status
      articleType.setStatus(status);
      // log.info("article is " + article);
      // if (Article.Status_Unpublished.equals(status)) {
      // log.info("change strtus4");
      // article.setStatus(Article.Status_Published);// 取消发布
      // } else {
      // log.info("change strtus5");
      // Long time = System.currentTimeMillis();
      // article.setStatus(Article.Status_Unpublished);// 发布内容
      // article.setPublishat(time);
      // }
      
      // article.setId(null);//为啥要把id设为空？
      
      articleTypeService.update(articleType);
      
      model.addAttribute("code", 0);
      
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("update article error,id is  " + id);
      model.addAttribute("code", -100000);
      
    }
    
    return "/data/json";
  }
  
  /**
   * 添加内容
   *
   * @param request
   * @param response
   * @param model
   * @param article
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/u/article/type", method = RequestMethod.POST)
  public String addArticleJson(HttpServletRequest request, HttpServletResponse response,
                               ModelMap model, ArticleType articleType)
      throws Exception {
    
    log.info("update article : articleType= " + articleType);
    
    try {
      if (articleType == null) {
        model.addAttribute("code", -1004);
        return "/data/json";
      }
      Integer status = articleType.getStatus();
      if (status == null) {
        model.addAttribute("code", -9016);
        return "/data/json";
      }
      // if (Article.Status_Unpublished == article.getStatus()) {
      // article.setStatus(Article.Status_Unpublished);// 保存草稿，不发布\
      // article.setPublishat(0L);
      // } else if (Article.Status_Published == article.getStatus()) {
      // Long time = System.currentTimeMillis();
      // article.setStatus(Article.Status_Published);// 发布
      // article.setPublishat(time);
      // } else {
      // article.setStatus(Article.Status_Unpublished);
      // }
      
        // 默认下架
        if (articleType.getStatus() != ArticleType.Status_Published)
          articleType.setStatus(ArticleType.Status_Unpublished);
      
      log.info("===============================" + articleType.getStatus());
      Long uid = Long.valueOf(
          cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
      articleType.setCreateBy(uid);
      articleType.setUpdateBy(uid);
      articleType.setId(null);
      //默认sort为零
      Long aid = articleTypeService.insert(articleType);
      log.info("article id is " + aid);
      model.addAttribute("code", 0);
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("add articleType error ");
      model.addAttribute("code", -100000);
    }
    
    return "/data/json";
  }
  
  /**
   * 删除内容
   *
   * @param request
   * @param response
   * @param model
   * @param id
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/u/article/type/{id}", method = RequestMethod.DELETE)
  public String deleteArticleJson(HttpServletRequest request, HttpServletResponse response,
                                  ModelMap model, @PathVariable Long id)
      throws Exception {
    
    log.info("delete article : id= " + id);
    try {
      articleTypeService.delete(id);
      
      log.info("add article success");
      model.addAttribute("code", 0);
      
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("delete articleType error,id is  " + id);
      model.addAttribute("code", -100000);
      
    }
    
    return "/data/json";
  }
  /**
   * 批量获取文章详细信息 小程序端
   *
   * @param request
   * @param response
   * @param model
   * @param ids
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/article/type/list", method = RequestMethod.GET)
  public String getMultiArticleJsonSmall(HttpServletRequest request, HttpServletResponse response,
                                    ModelMap model, String title, String author, Long startAt,
                                    Long endAt, Long type, Long status, Long industry, Integer page,
                                    Integer size)
      throws Exception {
    
    if (page == null || page <= 0) {
      page = 1;
    }
    
    if (size == null || size <= 0) {
      size = 10;
    }
    
    int start = (page - 1) * size;
    if (start < 0) {
      start = 0;
    }
    List<ArticleType> articleTypeList = null;
    try {
      
      Map<String, Object> param = DynamicUtil.getArticleTypeListBySmall();
      List<Long> ids = articleTypeService.getIdsByDynamicCondition(ArticleType.class, param, start, size);
      List<Long> count = articleTypeService.getIdsByDynamicCondition(ArticleType.class, param, 0,
          Integer.MAX_VALUE);
      articleTypeList = articleTypeService.getObjectsByIds(ids);
      log.info("get articleTypelist is " + articleTypeList);
      model.addAttribute("code", 0);
      model.addAttribute("size", size);
      model.addAttribute("total", count.size());
      model.addAttribute("articleTypeList", articleTypeList);
    }
    catch (Throwable t) {
      log.error(t.getMessage());
      log.error("get article error", t);
      model.addAttribute("code", -1);
    }
    
    return "/admin/articleType/json/articleTypeMultiJson";
  }
  
  /**
   * 批量获取文章详细信息
   *
   * @param request
   * @param response
   * @param model
   * @param ids
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/article/type/search", method = RequestMethod.GET)
  public String getMultiArticleJson(HttpServletRequest request, HttpServletResponse response,
                                    ModelMap model, String title, String author, Long startAt,
                                    Long endAt, Long type, Long status, Long industry, Integer page,
                                    Integer size)
      throws Exception {
    
    if (page == null || page <= 0) {
      page = 1;
    }
    
    if (size == null || size <= 0) {
      size = 10;
    }
    
    int start = (page - 1) * size;
    if (start < 0) {
      start = 0;
    }
    List<ArticleType> articleTypeList = null;
    try {
      
      Map<String, Object> param = DynamicUtil.getArticleTypeList();
      List<Long> ids = articleTypeService.getIdsByDynamicCondition(ArticleType.class, param, start, size);
      List<Long> count = articleTypeService.getIdsByDynamicCondition(ArticleType.class, param, 0,
          Integer.MAX_VALUE);
      articleTypeList = articleTypeService.getObjectsByIds(ids);
      log.info("get articleTypelist is " + articleTypeList);
      model.addAttribute("code", 0);
      model.addAttribute("size", size);
      model.addAttribute("total", count.size());
      model.addAttribute("articleTypeList", articleTypeList);
    }
    catch (Throwable t) {
      log.error(t.getMessage());
      log.error("get article error", t);
      model.addAttribute("code", -1);
    }
    
    return "/admin/articleType/json/articleTypeMultiJson";
  }
  
  
  /**
   * 保存排序的接口
   *
   * @param request
   * @param response
   * @param model
   * @param ids
   *        id序号数组
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/a/u/article/type/sort", method = RequestMethod.POST)
  public String sort(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                     @RequestBody List<Long> ids)
      throws Exception {
    
    log.info("sort article : ids= " + ids);
    
    try {
      List<ArticleType> lists = this.articleTypeService.getObjectsByIds(ids);
      
      int index = 10;
      for (ArticleType articleType : lists) {
        articleType.setSort(index);
        index = index + 10;
      }
      this.articleTypeService.updateList(lists);
      
      model.addAttribute("code", 0);
    }
    catch (Throwable t) {
      t.printStackTrace();
      log.error(t.getMessage());
      log.error("add bookUnit error ");
      model.addAttribute("code", -1);
    }
    
    return "/data/json";
  }
  
  private Integer getMaxSort() throws ServiceException, ServiceDaoException {
    
    Map<String, Object> params = DynamicUtil.getArticleIdsOrderBySort();
    List<Long> maxs = this.articleTypeService.getIdsByDynamicCondition(ArticleType.class, params, 0,
        Integer.MAX_VALUE);
    Integer max = 0;
    if (CollectionUtils.isEmpty(maxs)) {
      log.info("first order ");
      
    }
    else {
      Long maxID = maxs.get(maxs.size() - 1);
      log.info(" maxID = " + maxID);
      max = this.articleTypeService.getObjectById(maxID).getSort();
      if (null == max) {
        max = 0;
      }
      log.info("quiz max order is " + max);
    }
    return max + 1;
  }
  
}
