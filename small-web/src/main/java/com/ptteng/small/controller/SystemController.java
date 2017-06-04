package com.ptteng.small.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ptteng.common.storage.util.ImgStorageUtil;
import com.ptteng.small.admin.util.CookieConstant;
import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.model.Role;
import com.ptteng.small.pub.service.ManagerService;
import com.ptteng.small.pub.service.RoleService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.FileUtil;
import com.qding.common.util.http.cookie.CookieUtil;
import com.qding.common.util.json.GsonUtil;
import com.qding.common.util.pwd.PasswordUtils;

@Controller
public class SystemController {
	private static final Log log = LogFactory.getLog(SystemController.class);
    @Autowired
    private ImgStorageUtil imgStorageUtil;
	@Autowired
	private ManagerService managerService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private CookieUtil cookieUtil;

	/**
	 * 游戏准备
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer page,
			Integer size) throws Exception {
		log.info(" welcome to manager index ");

		return "/index";
	}

	/**
	 * 游戏准备
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer page,
			Integer size) throws Exception {
		log.info(" welcome to manager index ");
		return "/test";
	}

	@RequestMapping(value = "/nologin")
	public String noLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer page,
			Integer size) throws Exception {
		log.info(" login wrong ");
		model.addAttribute("code", -5018);
		return "/data/json";
	}

	@RequestMapping(value = "/noPermissin")
	public String noPermission(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer page,
			Integer size) throws Exception {
		log.info(" login noPermission ");
		model.addAttribute("code", -5020);
		return "/data/json";
	}

	// @RequestMapping(value = "/web/a/publics/del/{id}", method =
	// RequestMethod.DELETE)
	// public String delete(HttpServletRequest request,
	// HttpServletResponse response, ModelMap model, @PathVariable long id) {
	// log.info(" welcome to publics delete ");
	// if (id == 0) {
	// model.addAttribute("success", false);
	// model.addAttribute("message", "未选择公众号");
	// model.addAttribute("result", null);
	// return "/data/json";
	// }
	// try {
	// boolean success = this.publicsService.delete(id);
	// if (success) {
	// model.addAttribute("success", true);
	// model.addAttribute("message", "删除成功");
	// model.addAttribute("result", null);
	// } else {
	// model.addAttribute("success", false);
	// model.addAttribute("message", "删除失败");
	// model.addAttribute("result", null);
	// }
	// } catch (Throwable t) {
	// log.error(t.getMessage());
	// log.error("delete publics list error,id is " + id);
	// model.addAttribute("success", false);
	// model.addAttribute("message", "删除失败");
	// model.addAttribute("result", null);
	// }
	//
	// return "/data/json";
	// }
	//

	/**
	 * 管理员登录
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param name
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value = "/a/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model, String name,
			String pwd) {
		log.info(" welcome to manager login ");

		try {
			List<Long> managerIds = this.managerService.getManagerIdsByName(name, 0, Integer.MAX_VALUE);
			log.info(name + " get managerIDs  " + managerIds);
			if (managerIds == null || managerIds.isEmpty() || managerIds.size() > 1) {
				log.info(name + " not get any user ");
				model.addAttribute("code", -5003);

			} else {
				log.info(name + "  get user " + managerIds.get(0));
				Manager manager = this.managerService.getObjectById(managerIds.get(0));
				if (PasswordUtils.authenticatePassword(manager.getPwd(), pwd)
						&& manager.getStatus().equals(Manager.STATUS_USING)) {
					log.info(managerIds.get(0) + " login ");
					Map<String, String> maps = new HashMap();
					maps.put(CookieConstant.Cookie_WEB_ManagerName, manager.getName());

					// maps.put(CookieConstant.Cookie_WEB_PuserPublicsHash,
					// manager.getPublicsHash());
					// maps.put(CookieConstant.Cookie_WEB_PuserPublicsHash,
					// "-2042484612");

					maps.put(CookieUtil.USER_ID, manager.getId() + "");
					cookieUtil.setIdentity(request, response, maps, manager.getId());

					Role role = roleService.getObjectById(manager.getRoleID());
					if (role == null) {
						log.error("not get any role  " + manager.getRoleID());
						model.addAttribute("code", -7001);
						return "/data/json";

					}
//					// 海川新增功能，判断账号如果是厂家身份，则判断厂家是否禁用，如果禁用则提示登录失败，厂家已禁用
//					Map<String, Object> mapManager = new HashMap<String, Object>();
//					mapManager = DynamicUtil.getVenderByMangerId(manager.getId());
//					List<Long> idVenders = venderService.getIdsByDynamicCondition(Vender.class, mapManager, 0,
//							Integer.MAX_VALUE);
//					if (idVenders.size() > 0) {
//						// 判断厂家的状态，如果禁用提示登录失败
//						Vender vender = venderService.getObjectById(idVenders.get(0));
//						if (DataUtils.isNotNullOrEmpty(vender.getManagerId())) {
//							if ("0".equals(vender.getStatus())) {
//								//厂家禁用
//								model.addAttribute("code", -7015);
//								return "/data/json";
//							}
//						}
//					}
					model.addAttribute("code", 0);
					model.addAttribute("manager", manager);
					model.addAttribute("role", role);
					log.info(managerIds.get(0) + " login over ");
				} else {
					log.info(managerIds.get(0) + " has wrong pwd ");
					model.addAttribute("code", -5004);
					model.addAttribute("result", null);
				}
			}

		} catch (Throwable t) {
			log.error(t.getMessage(), t);
			log.error("manager login error,name is  " + name);
			model.addAttribute("code", -1);
			model.addAttribute("result", null);
		}

		return "/data/login";
	}

	/**
	 * 退出系统
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/a/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info(" welcome to manager logout ");

		try {
			cookieUtil.clearCookie(response);

			model.addAttribute("code", 0);
			model.addAttribute("result", "/login/index");

		} catch (Throwable t) {
			log.error(t.getMessage(), t);
			log.error("manager logout error  ");
			model.addAttribute("code", -5005);
			model.addAttribute("result", null);
		}

		return "/data/json";
	}

	/**
	 * 返回登陆用户信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/a/u/manager", method = RequestMethod.GET)
	public String getUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info(" welcome to manager getmanager ");

		try {
			if (null != cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID)) {
				String userId = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
				String userName = cookieUtil.getKeyIdentity(request, CookieConstant.Cookie_WEB_ManagerName);
				String publicsHash = cookieUtil.getKeyIdentity(request, CookieConstant.Cookie_WEB_ManagerPublicsHash);

				Map<String, String> maps = new HashMap();
				maps.put(CookieConstant.Cookie_WEB_ManagerName, userName);
				maps.put(CookieConstant.Cookie_WEB_ManagerPublicsHash, publicsHash);
				maps.put(CookieUtil.USER_ID, userId);
				Manager manager = managerService.getObjectById(Long.valueOf(userId));

				model.addAttribute("code", 0);
				model.addAttribute("result", GsonUtil.toJson(manager));
			} else {
				model.addAttribute("code", -5001);
				model.addAttribute("result", null);
			}
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
			log.error("manager logout error  ");
			model.addAttribute("code", -5001);
			model.addAttribute("result", null);
		}

		return "/data/json";
	}
	//
	// @RequestMapping(value = "/web/a/publics/add", method =
	// RequestMethod.POST)
	// public String update(HttpServletRequest request,
	// HttpServletResponse response, ModelMap model, String name,
	// String appID, String appSecret, String account, String pwd) {
	// log.info(" welcome to publics add ");
	// log.info("name=" + name + " account=" + account + " appID="
	// + appID + " appSecret=" + appSecret + " pwd=" + pwd);
	// try {
	// Publics publics = new Publics();
	// publics.setName(name);
	// publics.setAccount(account);
	// publics.setAppID(appID);
	// publics.setAppSecret(appSecret);
	// publics.setPwd(pwd);
	// publics.setToken(DataUtils.getSimpleUUID());
	// publics.setHash(DataUtils.hash(appID + appSecret));
	// log.info("to add publics = " + publics.toString());
	// long id = this.publicsService.insert(publics);
	// log.info("id==="+id);
	// if (id > 0) {
	// model.addAttribute("success", true);
	// model.addAttribute("message", "新增成功");
	// model.addAttribute("result", null);
	// } else {
	// model.addAttribute("success", false);
	// model.addAttribute("message", "新增失败");
	// model.addAttribute("result", null);
	// }
	// } catch (Throwable t) {
	// log.error(t.getMessage());
	// log.error("add publics list error");
	// model.addAttribute("success", false);
	// model.addAttribute("message", "新增失败");
	// model.addAttribute("result", null);
	// }
	//
	// return "/data/json";
	// }
	
	//38 .图片上传
    @RequestMapping(value = "/a/u/file/{module}", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model,
                             @RequestParam MultipartFile file, @PathVariable String module)
            throws Exception {
        log.info("hello upload " + module);
        if (StringUtils.isBlank(module)) {
            log.info("type is null");
        }
        int code = 0;
        log.info(file.getOriginalFilename());

        try {

            String extend = FileUtil.getFileExtension(file.getOriginalFilename());

            String fileName = UUID.randomUUID().toString() + "." + extend;
            log.info("new name is " + fileName);
//			String filePath = "/temp/" + fileName;
            String filePath = "/data/file/small/" + module + "/" + fileName;
            String dirPath = "/data/file/small/" + module;

            File dir = new File("/data/file/small/" + module);
            if (dir.exists()) {
                log.info("创建目录" + dirPath + "失败，目标目录已经存在");
            } else {
                //创建目录
                if (dir.mkdirs()) {
                    log.info("创建目录" + dirPath + "成功！");
                } else {
                    log.info("创建目录" + dirPath + "失败！");
                }
            }

            File tempPic = new File(filePath);
            file.transferTo(tempPic);
            String url = this.imgStorageUtil.imgStorage(null, "small/"+ module + "/"
                    + fileName, filePath);
            log.info(module + " upload success ,and file name is " + fileName
                    + "temp path is " + filePath + " access url is " + url);
			tempPic.delete();
//			log.info(file.getOriginalFilename() + " delete success ");
            model.addAttribute("url", url);
            model.addAttribute("code", 0);

            return "/common/img";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
        }

        return "/common/success";
    }
}
