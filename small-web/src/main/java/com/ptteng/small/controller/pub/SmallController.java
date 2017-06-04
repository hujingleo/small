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
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.model.User;
import com.ptteng.small.pub.service.ArticleService;
import com.ptteng.small.pub.service.ManagerService;
import com.ptteng.small.pub.service.UserService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;
import com.qding.common.util.HttpClientUtil;

import net.sf.json.JSONObject;

@Controller
public class SmallController {

	private static final Log log = LogFactory.getLog(SmallController.class);
	@Autowired
	private UserService userService;
	private static String reqURL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx5f5a39b2145844f1&secret=6cebfb5ae1cce89071540c65ebdaffda&grant_type=authorization_code";

	/**
	 * 小程序用户信息验证接口
	 */
	@RequestMapping(value = "/a/onlogin", method = RequestMethod.GET)
	public String sort(HttpServletRequest request, HttpServletResponse response, ModelMap model, String code,
			String city, String avatarUrl, String country, String gender, String language, String nickName,
			String province) throws Exception {

		log.info("save user : code= " + code);
		try{
		reqURL += "&js_code=" + code;
		String json = HttpClientUtil.sendGetRequest(reqURL, "UTF-8");
		JSONObject jsStr = JSONObject.fromObject(json);
		log.info(jsStr);
		if (null != jsStr.getString("openid") && !"".equals(jsStr.getString("openid"))) {
			User user = new User();
			if (DataUtils.isNotNullOrEmpty(avatarUrl))
				user.setAvatarUrl(avatarUrl);
			if (DataUtils.isNotNullOrEmpty(city))
				user.setCity(city);
			if (DataUtils.isNotNullOrEmpty(country))
				user.setCountry(country);
			if (DataUtils.isNotNullOrEmpty(gender))
				user.setGender(gender);
			if (DataUtils.isNotNullOrEmpty(language))
				user.setLanguage(language);
			if (DataUtils.isNotNullOrEmpty(nickName))
				user.setNickName(nickName);
			if (DataUtils.isNotNullOrEmpty(province))
				user.setProvince(province);
			user.setSessionKey(jsStr.getString("session_key") + "");
			user.setOpenid(jsStr.getString("openid") + "");
			user.setUpdateAt(System.currentTimeMillis());
			user.setCreateAt(System.currentTimeMillis());
			// 判断更新还是新增
			Map<String, Object> map = DynamicUtil.getUserListByOpenid(jsStr.getString("openid"));
			List<Long> idLists = userService.getIdsByDynamicCondition(User.class, map, 0, Integer.MAX_VALUE);
			if (idLists.size() > 0) {
				userService.update(user);
			} else {
				userService.insert(user);
			}
			model.addAttribute("openid", jsStr.getString("openid"));
			model.addAttribute("code", 0);
		} else {
			log.info(jsStr.getString("errcode"));
		}
		}catch(Exception e){
			model.addAttribute("code", -10000);
		}
		return "/data/jsonopenid";
	}

}
