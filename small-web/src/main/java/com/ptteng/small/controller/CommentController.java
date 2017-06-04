package com.ptteng.small.controller;

import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.pub.model.Article;
import com.ptteng.small.pub.model.Comment;
import com.ptteng.small.pub.model.User;
import com.ptteng.small.pub.service.ArticleService;
import com.ptteng.small.pub.service.CommentService;
import com.ptteng.small.pub.service.UserService;
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
import java.util.*;
import com.ptteng.small.admin.util.DateUtil;
/**
 * Comment crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class CommentController {
	private static final Log log = LogFactory.getLog(CommentController.class);

	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;

	// @RequestMapping(value = "/a/appointComment", method = RequestMethod.GET)
	// public String getappointCommentJson(HttpServletRequest request,
	// HttpServletResponse response, ModelMap model,String openId,Long articleId
	// )
	// throws Exception {
	//
	// log.info("get data : openId , articleId = " + openId +" "+articleId );
	//
	//
	// if (DataUtils.isNullOrEmpty(openId)) {
	//
	// model.addAttribute("code", -4014);
	// return "common/fail";
	// }
	// if (DataUtils.isNullOrEmpty(articleId)){
	//
	// model.addAttribute("code", -4014);
	// return "common/fail";
	// }
	// List<Long> appointCommentId = null;
	// List<Comment> commentList = null;
	// try {
	// Map<String, Object> param=
	// DynamicUtil.getCommentByOpenIdAndArticleId(openId,articleId);
	// appointCommentId =
	// commentService.getIdsByDynamicCondition(Comment.class,param,0,Integer.MAX_VALUE);
	// commentList = commentService.getObjectsByIds(appointCommentId);
	// log.info("get comment data is " + appointCommentId);
	// model.addAttribute("code", 0);
	// model.addAttribute("commentList", commentList);
	//
	// } catch (Throwable t) {
	// t.printStackTrace();
	// log.error(t.getMessage());
	// log.error("get comment error,id is " + appointCommentId);
	// model.addAttribute("code", -100000);
	// }
	//
	// return "/admin/comment/json/appointCommentDetailJson";
	// }

	/**
	 * 获取某条评论
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/comment/{id}", method = RequestMethod.GET)
	public String getCommentJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable Long id) throws Exception {

		log.info("get data : id= " + id);
		try {
			Comment comment = commentService.getObjectById(id);
			log.info("get comment data is " + comment);

			model.addAttribute("code", 0);

			model.addAttribute("comment", comment);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get comment error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/admin/comment/json/commentDetailJson";
	}

	/**
	 * 获取某文章评论列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/comment/search/{id}", method = RequestMethod.GET)
	public String getCommentListJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable Long id, Integer page, Integer size) throws Exception {

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

		// User user = null;
		List<Long> ids = null;
		List<Long> totalids = null;
		List<Comment> commentList = null;
		log.info("get data : articleId = " + id);
		try {
			List<HashMap<String, Object>> commentDataList = new ArrayList<HashMap<String, Object>>();
			
			Map<String, Object> param = DynamicUtil.getCommentByArticleId(id);
			ids = commentService.getIdsByDynamicCondition(Comment.class, param, start, size);
			totalids = commentService.getIdsByDynamicCondition(Comment.class, param, 0, Integer.MAX_VALUE);
			commentList = commentService.getObjectsByIds(ids);
			int total = totalids.size();
//			int totalPage = 0;
//			if (total%size == 0 ){
//			 totalPage = total/size;
//			}else {
//				totalPage = total/size + 1 ;
//			}
			log.info("get commentList data  id is " + ids);

			for (Comment comment : commentList) {
				HashMap<String, Object> commentDataMap = new HashMap<String, Object>();
				String oid = comment.getOpenId();
				Map<String, Object> param1 = DynamicUtil.getUserByOpenId(oid);
				User user = new User();
				List<Long> userIds = userService.getIdsByDynamicCondition(User.class, param1, 0, Integer.MAX_VALUE);
				if (userIds.size() > 0) {
				
					user = userService.getObjectById(userIds.get(0));
					if (DataUtils.isNotNullOrEmpty(user)) {
						commentDataMap.put("userAvatarUrl", user.getAvatarUrl());
						commentDataMap.put("nickName", user.getNickName());
					}
				}
				//设置createTime
				commentDataMap.put("createTime", DateUtil.timeCycle(comment.getCreateAt()));
				commentDataMap.put("commentOpenId", oid);
				commentDataMap.put("commentContent", comment.getContent());
				commentDataMap.put("commentCreateAt", comment.getCreateAt());

				commentDataList.add(commentDataMap);
			}

			model.addAttribute("commentDataList", commentDataList);
			model.addAttribute("code", 0);
			model.addAttribute("size", size);
			model.addAttribute("total", total);
			model.addAttribute("page", page);
//			model.addAttribute("totalPage",totalPage);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get commentDataList error,id is  " + ids);
			model.addAttribute("code", -100000);
		}

		return "/admin/comment/json/commentDataListJson";
	}


	/**
	 * 新增评论
	 * @param request
	 * @param response
	 * @param model
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/comment", method = RequestMethod.POST)
	public String addCommentJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			Comment comment) throws Exception {

		log.info("insert comment : comment= " + comment);

		if (DataUtils.isNullOrEmpty(comment.getOpenId())) {

			model.addAttribute("code", -4014);
			return "common/fail";
		}
		if (DataUtils.isNullOrEmpty(comment.getArticleId())) {

			model.addAttribute("code", -4014);
			return "common/fail";
		}
		if (DataUtils.isNullOrEmpty(comment.getContent())) {

			model.addAttribute("code", -4014);
			return "common/fail";
		}

		try {
			//文章评论数加1
			Article article=articleService.getObjectById( comment.getArticleId());
			if(null!=article&&DataUtils.isNotNullOrEmpty(article.getCommentNum()))
			{
				article.setCommentNum(article.getCommentNum()+1);
				articleService.update(article);
			}
			comment.setId(null);
			comment.setCreateAt(System.currentTimeMillis());
			Long id = commentService.insert(comment);
			log.info("add comment success , id is " + id);
			model.addAttribute("id", id);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add comment error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}


	/**
	 * 删除不当评论
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/a/comment/{id}", method = RequestMethod.DELETE)
	public String deleteCommentJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable Long id) throws Exception {

		log.info("delete comment : id= " + id);
		try {
			commentService.delete(id);

			log.info("add comment success");
			model.addAttribute("id", id);
			model.addAttribute("code", 0);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete comment error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}

}
