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
import com.ptteng.small.admin.util.DateUtil;
import com.ptteng.small.pub.model.Article;
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.service.ArticleService;
import com.ptteng.small.pub.service.ManagerService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;

@Controller
public class ArticleController {

	private static final Log log = LogFactory.getLog(ArticleController.class);

	private final String Img_Module_Common = "common";

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private com.qding.common.util.http.cookie.CookieUtil cookieUtil;

	/**
	 * 无需修改名字的文件尾缀，<b>必须有序存放</b> <br>
	 * 例如："apk" < "jpeg" < "jpg"
	 */
	private static final String[] suffixs = { "apk", "jpeg", "jpg", "png" };

	@Autowired
	private ImgStorageUtil imgStorageUtil;

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
	@RequestMapping(value = "/a/article/{aid}", method = RequestMethod.GET)
	public String getArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable Long aid, Long preId, Long nextId) throws Exception {

		log.info("get data : id= " + aid);
		try {
			if (aid == null) {
				model.addAttribute("code", -1004);
				return "/data/json";
			} else {

				Article article = articleService.getObjectById(aid);

				if (article == null) {
					model.addAttribute("code", -9003);
					return "/data/json";
				} else {
					// 播放次数加一
					if (DataUtils.isNotNullOrEmpty(article.getPlayNum())) {
						if (DataUtils.isNotNullOrEmpty(article.getPlayNum())) {
							article.setPlayNum(article.getPlayNum() + 1);
							articleService.update(article);
						}
					}
					// 设置createTime
					if (DataUtils.isNotNullOrEmpty(article.getPublishat())) {
						article.setCreateTime(DateUtil.timeCycle(article.getPublishat()));
					}
					// 放nextId和preId
					article.setNextId(nextId);
					article.setPreId(preId);
					log.info("get article data is " + article);
					model.addAttribute("code", 0);
					model.addAttribute("article", article);
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get article error,id is  " + aid);
			model.addAttribute("code", -100000);
		}

		return "/admin/article/json/articleDetailJson";
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
	@RequestMapping(value = "/a/u/article/{aid}", method = RequestMethod.PUT)
	public String updateArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			Article article, @PathVariable Long aid) throws Exception {

		log.info("update article : article= " + article);

		try {

			if (article == null) {
				model.addAttribute("code", -1004);

				return "/data/json";
			}

			if (DataUtils.isNullOrEmpty(article.getType())) {
				model.addAttribute("code", -4013);
				return "common/success";
			}

			// if (DataUtils.isNullOrEmpty(article.getImg())) {
			// model.addAttribute("code", -4014);
			// return "common/success";
			// }
			if (DataUtils.isNullOrEmpty(article.getTitle())) {
				model.addAttribute("code", -4015);
				return "common/success";
			}
			if (article.getType().equals(Article.About_Us) && article.getStatus().equals(Article.Status_Published)) {
				Map<String, Object> articleParams = DynamicUtil.getArticleList(null, null, null, null,
						Article.About_Us.longValue(), Article.Status_Published.longValue(), null);
				List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class, articleParams, 0,
						Integer.MAX_VALUE);
				log.info("articleIds get by type and status is " + articleIds);
				if (CollectionUtils.isNotEmpty(articleIds)) {
					log.info("rticleIds get by type and status is not empty");
					model.addAttribute("code", -11000);
					return "/common/success";
				}
			}
			Long uid = Long
					.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

			article.setUpdateBy(uid);
			article.setPublishat(System.currentTimeMillis());
			article.setId(aid);

			Manager manager = managerService.getObjectById(uid);
			article.setAuthor(manager.getName());
			log.info("update article : article= " + article);
			articleService.update(article);

			model.addAttribute("code", 0);

			model.addAttribute("article", article);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article error,id is  " + article.getId());
			model.addAttribute("code", -100000);
		}
		return "/data/json";
	}

	/**
	 * 点赞接口
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/article/love", method = RequestMethod.PUT)
	public String updateArticleJsonL(HttpServletRequest request, HttpServletResponse response, ModelMap model, Long id)
			throws Exception {
		if (id == null) {
			model.addAttribute("code", -1000);
			log.info("put article error aid is null");
			return "/data/json";
		}

		Article article = articleService.getObjectById(id);
		// Integer status = article.getStatus();
		log.info("update article status : article id ,status = " + id);

		try {
			if (DataUtils.isNotNullOrEmpty(article.getThumbUpNum())) {
				article.setThumbUpNum(article.getThumbUpNum() + 1);
			}
			articleService.update(article);

			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article error,id is  " + id);
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
	@RequestMapping(value = "/a/u/article/status", method = RequestMethod.PUT)
	public String updateArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, Long id,
			Integer status) throws Exception {
		if (id == null) {
			model.addAttribute("code", -1000);
			log.info("put article error aid is null");
			return "/data/json";
		}

		Article article = articleService.getObjectById(id);
		// Integer status = article.getStatus();
		log.info("update article status : article id ,status = " + id + " , " + status);
		/* 如果内容是关于我们，且需要上架时，需要进行唯一判断 */
		if (article.getType().equals(Article.About_Us) && status.equals(Article.Status_Published)) {
			log.info("modify the type-aboutUs");
			Map<String, Object> articleParams = DynamicUtil.getArticleList(null, null, null, null,
					Article.About_Us.longValue(), Article.Status_Published.longValue(), null);
			List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class, articleParams, 0,
					Integer.MAX_VALUE);
			log.info("articleIds get by type and status is " + articleIds);
			if (CollectionUtils.isNotEmpty(articleIds)) {
				log.info("rticleIds get by type and status is not empty");
				model.addAttribute("code", -11000);
				return "/common/success";
			}
		}

		try {

			Long uid = Long
					.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));

			article.setUpdateBy(uid);
			// 修改status
			article.setStatus(status);
			article.setPublishat(System.currentTimeMillis());
			if (status == 2L)
				article.setPublishat(System.currentTimeMillis());
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
			Manager manager = managerService.getObjectById(uid);
			article.setAuthor(manager.getName());

			// article.setId(null);//为啥要把id设为空？

			articleService.update(article);

			model.addAttribute("code", 0);

		} catch (Throwable t) {
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
	@RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
	public String addArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			Article article) throws Exception {

		log.info("update article : article= " + article);

		try {
			if (article == null) {
				model.addAttribute("code", -1004);
				return "/data/json";
			}
			Integer status = article.getStatus();
			if (status == null) {
				model.addAttribute("code", -9016);
				return "/data/json";
			}
			if (DataUtils.isNullOrEmpty(article.getType() == null)) {

				model.addAttribute("code", -9018);
				return "common/success";
			}
			if (DataUtils.isNullOrEmpty(article.getTitle())) {
				model.addAttribute("code", -11001);
				return "common/success";
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

			if (article.getType().equals(Article.About_Us)) {
				log.info("skip the status change");
				/* 如果内容是关于我们，且需要上架时，需要进行唯一判断 */
				if (status.equals(Article.Status_Published)) {
					log.info("verify the type-aboutUs");
					Map<String, Object> articleParams = DynamicUtil.getArticleList(null, null, null, null,
							Article.About_Us.longValue(), Article.Status_Published.longValue(), null);
					List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class, articleParams, 0,
							Integer.MAX_VALUE);
					log.info("articleIds get by type and status is " + articleIds);
					if (CollectionUtils.isNotEmpty(articleIds)) {
						log.info("articleIds get by type and status is not empty");
						model.addAttribute("code", -11000);
						return "/common/success";
					}
				}
			} else {
				// 默认下架
				if (article.getStatus() != Article.Status_Published)
					article.setStatus(Article.Status_Unpublished);
			}

			log.info("===============================" + article.getStatus());
			Long uid = Long
					.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
			article.setCreateBy(uid);
			article.setUpdateBy(uid);
			Manager manager = managerService.getObjectById(uid);
			article.setAuthor(manager.getName());
			article.setId(null);
			article.setPublishat(System.currentTimeMillis());
			article.setThumbUpNum(0);
			article.setPlayNum(0);
			article.setCommentNum(0);
			Long aid = articleService.insert(article);
			log.info("article id is " + aid);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add article error ");
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
	@RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.DELETE)
	public String deleteArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable Long id) throws Exception {

		log.info("delete article : id= " + id);
		try {
			articleService.delete(id);

			log.info("add article success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete article error,id is  " + id);
			model.addAttribute("code", -100000);

		}

		return "/data/json";
	}

	/**
	 * 批量获取文章详细信息 小程序
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/article/list", method = RequestMethod.GET)
	public String getMultiArticleJsonSmall(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String title, String author, Long startAt, Long endAt, Long type, Long status, Long industry, Integer page,
			Integer size, Integer isBanner, String currentId) throws Exception {

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
		List<Article> articleList = null;
		try {

			Map<String, Object> param = DynamicUtil.getArticleListSmall(title, author, startAt, endAt, type, status,
					industry, isBanner, currentId);
			List<Long> ids = articleService.getIdsByDynamicCondition(Article.class, param, start, size);
			List<Long> count = articleService.getIdsByDynamicCondition(Article.class, param, 0, Integer.MAX_VALUE);
			articleList = articleService.getObjectsByIds(ids);
			for (int i = 0; i < articleList.size(); i++) {
				if (null != articleList.get(i).getPublishat() && !"".equals(articleList.get(i).getPublishat())) {
					articleList.get(i).setCreateTime(DateUtil.timeCycle(articleList.get(i).getPublishat()));
				}
				// 放上一首、下一首id
				if (i == 0) {

				} else {
					articleList.get(i).setNextId(articleList.get(i - 1).getId());
				}
				if (i == articleList.size() - 1) {

				} else {
					articleList.get(i).setPreId(articleList.get(i + 1).getId());
				}
			}
			log.info("get articlelist is " + articleList);
			model.addAttribute("code", 0);
			model.addAttribute("size", size);
			model.addAttribute("total", count.size());
			model.addAttribute("articleList", articleList);
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get article error", t);
			model.addAttribute("code", -1);
		}

		return "/admin/article/json/articleMultiJson";
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
	@RequestMapping(value = "/a/article/search", method = RequestMethod.GET)
	public String getMultiArticleJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String title, String author, Long startAt, Long endAt, Long type, Long status, Long industry, Integer page,
			Integer size) throws Exception {

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
		List<Article> articleList = null;
		try {

			Map<String, Object> param = DynamicUtil.getArticleList(title, author, startAt, endAt, type, status,
					industry);
			List<Long> ids = articleService.getIdsByDynamicCondition(Article.class, param, start, size);
			List<Long> count = articleService.getIdsByDynamicCondition(Article.class, param, 0, Integer.MAX_VALUE);
			articleList = articleService.getObjectsByIds(ids);
			log.info("get articlelist is " + articleList);
			model.addAttribute("code", 0);
			model.addAttribute("size", size);
			model.addAttribute("total", count.size());
			model.addAttribute("articleList", articleList);
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get article error", t);
			model.addAttribute("code", -1);
		}

		return "/admin/article/json/articleMultiJson";
	}

	/**
	 * 根据type查找已发布内容
	 *
	 * @param page
	 * @param size
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Article> getArticleListByType(Integer page, Integer size, Integer type) throws Exception {

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
		List<Long> ids = articleService.getArticleIdsByTypeAndStatusOrderByPublishat(type, Article.Status_Published,
				start, size);
		log.info("get countArticleIdsByTypeAndStatusOrderByPublishat size is " + ids);

		List<Article> articleList = articleService.getObjectsByIds(ids);
		log.info("get article data is " + articleList);

		return articleList;
	}

	/**
	 * 保存排序的接口
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param ids
	 *            id序号数组
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/u/article/sort", method = RequestMethod.POST)
	public String sort(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestBody List<Long> ids) throws Exception {

		log.info("sort article : ids= " + ids);

		try {
			List<Article> lists = this.articleService.getObjectsByIds(ids);

			int index = 10;
			for (Article article : lists) {
				article.setOrder(index);
				index = index + 10;
			}
			this.articleService.updateList(lists);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add bookUnit error ");
			model.addAttribute("code", -1);
		}

		return "/data/json";
	}

	private Integer getMaxSort() throws ServiceException, ServiceDaoException {

		Map<String, Object> params = DynamicUtil.getArticleIdsOrderBySort();
		List<Long> maxs = this.articleService.getIdsByDynamicCondition(Article.class, params, 0, Integer.MAX_VALUE);
		Integer max = 0;
		if (CollectionUtils.isEmpty(maxs)) {
			log.info("first order ");

		} else {
			Long maxID = maxs.get(maxs.size() - 1);
			log.info(" maxID = " + maxID);
			max = this.articleService.getObjectById(maxID).getOrder();
			if (null == max) {
				max = 0;
			}
			log.info("quiz max order is " + max);
		}
		return max + 1;
	}

}
