package com.ptteng.small.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.common.util.PasswordUtils;
import com.gemantic.common.util.StringUtil;
import com.gemantic.common.util.http.cookie.MD5Util;
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.model.Role;
import com.ptteng.small.pub.service.ManagerService;
import com.ptteng.small.pub.service.RoleService;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import com.qding.common.util.http.cookie.RequestUtil;
import org.apache.commons.lang3.RandomStringUtils;
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

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Manager crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 *
 */
@Controller
public class ManagerController {
    private static final Log log = LogFactory.getLog(ManagerController.class);

    @Autowired
    private ManagerService managerService;
    // @Autowired
    // private PuserPublicsRelationService puserPublicsRelationService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CookieUtil cookieUtil;

    @Resource(name = "managerServiceConfig")
    private Map<String, String> managerServiceConfig;
    private boolean isCaptcha = false;

    @Resource(name = "accountConfig")
    private Map<String, String> accountConfig;

    @RequestMapping(value = "/web/c/manager", method = RequestMethod.GET)
    public String getPuserList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {

        log.info("/web/manager  to /manager/view/managerList");

        return "/manager/view/managerList";
    }

    // // 生成图形验证码
    // @RequestMapping(value = "/a/captcha/generate", method =
    // RequestMethod.GET)
    // public void captchaGenerate(HttpServletRequest request,
    // HttpServletResponse response, ModelMap model) throws Exception {
    // log.info("To captchaGenerate ------------------");
    // try {
    // // 设置页面不缓存
    // response.reset();
    // response.setHeader("Pragma", "No-cache");
    // response.setHeader("Cache-Control", "no-cache");
    // response.setDateHeader("Expires", 0);
    // response.setContentType("image/gif");
    //
    // // 生成随机字符
    // String randomStr = RandomStringUtils.randomAlphabetic(4).toUpperCase();
    // log.info("randomStr: " + randomStr);
    // // 存入cookie
    // response.addCookie(new Cookie("captcha", MD5Util.getMd5Sum(randomStr)));
    //
    // // 生成图片流
    // BufferedImage bi = new CaptchaUtil().generate(165, 40,
    // randomStr).getImage();
    // // 创建输出流
    // OutputStream out = response.getOutputStream();
    // // 将图片写入到输出流中去
    // ImageIO.write(bi, "JPG", out);
    // // 强制刷新
    // out.flush();
    // // 关闭输出流
    // out.close();
    // } catch (Exception e) {
    // log.error("get captchaGenerate error", e);
    // model.addAttribute("code", -1);
    // }
    //
    // }

    // // 验证图形验证码
    // @RequestMapping(value = "/a/captcha/verify", method = RequestMethod.GET)
    // public String captchaVerify(HttpServletRequest request,
    // HttpServletResponse response, ModelMap model,
    // String inputValue) throws Exception {
    // log.info("To captchaVerify ------------------");
    //
    // log.info("inputValue: " + inputValue);
    //
    // try {
    // String cookieValue = "";
    // try {
    // cookieValue = RequestUtil.getCookie(request, "captcha").getValue();
    // } catch (Exception e) {
    // log.error("got error when getCookie");
    // }
    // log.info("cookieValue: " + cookieValue);
    //
    // if (StringUtils.isBlank(inputValue) || StringUtils.isBlank(cookieValue))
    // {
    // model.addAttribute("code", -2009);
    // return "/common/success";
    // }
    //
    // String md5Value = "";
    // try {
    // md5Value = MD5Util.getMd5Sum(inputValue.toUpperCase());
    // } catch (NoSuchAlgorithmException e) {
    // log.error("got error when getMD5");
    // }
    //
    // log.info("md5Value: " + md5Value);
    //
    // if (md5Value.equals(cookieValue)) {
    // isCaptcha = true;
    // model.addAttribute("code", 0);
    // } else {
    // isCaptcha = false;
    // model.addAttribute("code", -2009);
    // }
    // } catch (Exception e) {
    // log.error("get captchaVerify error", e);
    // model.addAttribute("code", -1);
    // }
    //
    // return "/common/success";
    // }
    //
    //
    //

    // // 5、验证码发送
    // @RequestMapping(value = "/a/code/send", method = RequestMethod.POST)
    // public String sendVerify(HttpServletRequest request,
    // HttpServletResponse response, ModelMap model,
    // String mobile,
    // String type) throws ServiceException, ServiceDaoException {
    // log.info(mobile + " want send sms of type " + type);
    //
    // if (StringUtils.isBlank(mobile)) {
    // log.info(mobile + " want send sms of type " + type + " null mobile ");
    // model.addAttribute("code", -2001);
    // return "/common/success";
    // }
    //
    // if (StringUtils.isBlank(type)) {
    // type = "password";
    // }
    //
    // if ("register".equals(type)) {
    // Long uid = this.managerService.getUserIdByMobile(mobile);
    // if (uid != null) {
    //
    // log.info(type + " is already exist " + mobile);
    //
    // model.addAttribute("code", -2007);
    // return "/common/success";
    // }
    //
    // } else {
    // Long uid = this.managerService.getUserIdByMobile(mobile);
    // if (uid == null) {
    //
    // log.info(type + " is not already exist " + mobile);
    //
    // model.addAttribute("code", -2000);
    // return "/common/success";
    // }
    // }
    //
    // int code = 0;
    //
    // try {
    // String result = this.smsService.sendMsg(mobile, type);
    //// smsService.getSmsIdByMobileAndType(mobile,type);
    //
    // switch (result) {
    // case SmsService.ErrorCode_SMS_InvalidType:
    // code = -2003;
    // break;
    // case SmsService.ErrorCode_SMS_smsMoreThan5:
    // code = -2008;
    // break;
    // default:
    //
    // }
    // if(code == 0){
    // model.addAttribute("code", 0);
    // model.addAttribute("errMsg", "验证码发送成功，请注意查收");
    // return "/data/json5";
    // }else {
    // return "/common/success";
    //
    // }
    //
    //
    //
    // } catch (Exception t) {
    // t.printStackTrace();
    // log.error(t.getMessage());
    // log.error(mobile + " send message error of type " + type);
    // model.addAttribute("code", -1);
    //
    // }
    // return "/common/success";
    //
    // }

    // // 6、忘记密码
    // @RequestMapping(value = "/a/password/forget", method = RequestMethod.PUT)
    // public String rewritepwd(HttpServletRequest request,
    // HttpServletResponse response, ModelMap model, String mobile,
    // String verify, String newpwd) throws Exception {
    // try {
    //
    // // 是否已注册
    // Long uid = managerService.getUserIdByMobile(mobile);
    //
    // // 用户不存在
    // if (uid == null) {
    // log.info(mobile + " not exist ");
    // model.addAttribute("code", -2000);
    //
    // return "/common/success";
    //
    // } else {
    // log.info(mobile + " exist and uid is " + uid);
    // }
    //
    // boolean verifyResult = false;
    //
    // String type = "password";
    //
    // // 测试模式
    // if (verifyModel()) {
    // if ("555555".equals(verify)) {
    // log.info("test ,so not verify mobile ");
    // verifyResult = true;
    // } else {
    // verifyResult = verifyMobileCode(model, mobile, type, verify);
    // }
    // } else {
    // verifyResult = verifyMobileCode(model, mobile, type, verify);
    // }
    //
    // if (verifyResult) {
    // Manager user = managerService.getObjectById(uid);
    //
    // String encodePass = PasswordUtils.encode(newpwd);
    // user.setPwd(encodePass);
    // boolean result = managerService.update(user);
    //
    // log.info(mobile + " change password," + newpwd + "result is " + result);
    // log.error("rewrite password success! ");
    //
    // model.addAttribute("code", 0);
    // } else {
    // log.error("rewritepwd verifycode");
    // model.addAttribute("code", -2005);
    //
    // return "/common/success";
    // }
    //
    // } catch (Throwable t) {
    // t.printStackTrace();
    // log.error(t.getMessage());
    // log.error("add user error ");
    // model.addAttribute("code", -1);
    // }
    //
    // return "/common/success";
    //
    // }
    // // 验证码校验
    // private boolean verifyMobileCode(ModelMap model, String mobile, String
    // type,
    // String verify) throws ServiceException, ServiceDaoException {
    // log.info("log2: mobile is " + mobile + ",type = " + type + ",verify" +
    // verify);
    // // 是否有发送验证码
    // Long sid = smsService.getSmsIdByMobileAndType(mobile, type);
    // log.info("sid is " + sid);
    //
    // if (sid == null) {
    // return false;
    // }
    // // 获取验证码信息
    // Sms sms = smsService.getObjectById(sid);
    // log.info("sms is " + sms);
    // // 获取验证码
    // String message = sms.getMessage();
    // log.info("message is " + message);
    //
    // //发送是否超时
    // Long delay = System.currentTimeMillis() - sms.getSendAt();
    //
    // if (delay > 600000) {
    // log.info("require verify too long");
    // return false;
    // }
    //
    // if (message.equals(verify)) {
    // return true;
    // } else {
    // return false;
    // }
    //
    // }

    private boolean verifyModel() {
        return "test".equals(this.accountConfig.get("testModel"));
    }

    /**
     * 修改密码
     * 
     * @param request
     * @param response
     * @param model
     * @param oldPwd
     * @param newPwd
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/pwd", method = RequestMethod.PUT)
    public String updateManagerPassword(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            String oldPwd, String newPwd) throws Exception {
        Long uid = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("do update password params:uid" + uid + ",password=" + oldPwd + ",newpassword=" + newPwd);

        if (oldPwd == null || newPwd == null || oldPwd.trim().equals("") || newPwd.trim().equals("")) {
            log.info(" pwd  is null");
            model.addAttribute("code", -1004);
            return "/data/json";
        }

        if (oldPwd.length() > 200 || oldPwd.length() < 0 || newPwd.length() > 200 || newPwd.length() < 0) {
            log.info(" pwd  is null");
            model.addAttribute("code", -5012);
            return "/data/json";
        }

        String oldPwdEncode = com.gemantic.common.util.PasswordUtils.encode(oldPwd);
        Manager u = managerService.getObjectById(uid);
        if (u.getPwd().equals(oldPwdEncode)) {
            String newenp = com.gemantic.common.util.PasswordUtils.encode(newPwd);
            u.setPwd(newenp);
            u.setUpdateBy(uid);
            managerService.update(u);

            model.addAttribute("code", 0);
        } else {

            model.addAttribute("code", -5006);
            model.addAttribute("result", "你输入的旧密码有误！");
        }

        return "/data/json";
    }

    @RequestMapping(value = "/web/c/password", method = RequestMethod.GET)
    public String getPassword(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {

        log.info("to update password page");

        return "/manager/view/managerPassword";
    }

    @RequestMapping(value = "/web/c/puser/{id}", method = RequestMethod.GET)
    public String getManager(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            @PathVariable Long id) throws Exception {

        log.info("/web/manager/" + id + "  to /manager/view/managerDeail");
        if (null != id) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", 0);
        }

        return "/admin/manager/view/managerDetail";
    }

    /**
     * 获取用户列表
     * 
     * @param request
     * @param response
     * @param model
     * @param page
     * @param size
     * @param roleID
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/manager/", method = RequestMethod.GET)
    public String getManagerJsonList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            Integer page, Integer size, String roleID, String status,String name) throws Exception {

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

        log.info("pageList : page= " + start + " , size=" + size + ",roleID=" + roleID + ",status=" + status);

        try {
            Boolean next = false;
            size += 1;

            Map<String, Object> map = new HashMap<String,Object>();
            if (DataUtils.isNotNullOrEmpty(roleID)) {
                map.put("role_id", roleID);
            }
            if (DataUtils.isNotNullOrEmpty(status)) {
                map.put("status", status);
            }
            if (DataUtils.isNotNullOrEmpty(name)) {
                map.put("name & like ", "%"+name+"%");
            }

            List<Long> ids;
            List<Long> totalids = new ArrayList<Long>();
            if (map.size() > 0) {
                ids = managerService.getManagerIdsByCondition(map, start, size);
                totalids = managerService.getManagerIdsByCondition(map, 0, Integer.MAX_VALUE);

            } else {
                ids = managerService.getManagerIds(start, size);
                totalids = managerService.getManagerIds(0, Integer.MAX_VALUE);

            }

            log.info("get manager size is " + ids.size());

            if (ids != null && ids.size() > 0) {

                if (size.equals(ids.size())) {
                    next = true;
                    log.info("ss  " + ids.subList(0, size - 1));
                    model.addAttribute("ids", ids.subList(0, size - 1));
                } else {
                    log.info("ss  " + ids.subList(0, ids.size()));
                    model.addAttribute("ids", ids.subList(0, ids.size()));
                }
                int totalCnt = ids.size();

                model.addAttribute("code", 0);
                model.addAttribute("page", page);
                model.addAttribute("total", totalCnt);
                model.addAttribute("size", size - 1);
            } else {
                model.addAttribute("ids", ids);
            }
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size - 1);
            model.addAttribute("next", next);

        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get manager list error,page is  " + start + " , size " + size);
            // for test
            model.addAttribute("code", -100000);
        }

        return "/admin/manager/json/managerListJson";
    }

    /**
     * 根据ID查找用户
     * 
     * @param request
     * @param response
     * @param model
     * @param mid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/manager/{mid}", method = RequestMethod.GET)
    public String getManagerJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            @PathVariable Long mid) throws Exception {

        log.info("get data : id= " + mid);
        try {
            List<Long> roleids = roleService.getRoleIds(0, Integer.MAX_VALUE);

            model.addAttribute("mid", mid);

            Manager manager = managerService.getObjectById(mid);
            if (manager == null) {
                log.info(" manager is null " + " id  is " + mid);
                model.addAttribute("code", -5003);
                return "/data/json";
            } else {
                // String rids = "";
                // log.info("get manager data is " + manager);
                // if (rids.length() > 0) {
                // rids = rids.substring(0, rids.length() - 1);
                // }
                manager.setRelationIds("");
                model.addAttribute("code", 0);
                model.addAttribute("manager", manager);
                model.addAttribute("rids", roleids);
            }

        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get manager error,id is  " + mid);
            model.addAttribute("code", -100000);
        }

        return "/admin/manager/json/managerDetailJson";
    }

    /**
     * 批量获取用户详细信息
     * 
     * @param request
     * @param response
     * @param model
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/multi/manager", method = RequestMethod.GET)
    public String getAllManagerJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            Long[] ids) throws Exception {

        log.info("get data : ids= " + ids);
        List<Long> idList = new ArrayList();
        if (ids == null || ids.length <= 0) {
            model.addAttribute("code", 0);
            model.addAttribute("size", 0);
            model.addAttribute("total", 0);

        } else {
            idList = Arrays.asList(ids);
        }
        try {

            if (idList == null || idList.size() <= 0) {
                model.addAttribute("code", 0);
                model.addAttribute("size", 0);
                model.addAttribute("total", 0);
            } else {
                List<Manager> managerList = managerService.getObjectsByIds(idList);
                log.info("get manager data is " + managerList);

                model.addAttribute("code", 0);
                model.addAttribute("size", 0);
                model.addAttribute("total", managerList.size());

                model.addAttribute("managerList", managerList);

            }
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get manager error,ids is  " + idList);
            model.addAttribute("code", -100000);
        }

        return "/admin/manager/json/managerMultiJson";
    }

    @RequestMapping(value = "/web/a/check/manager", method = RequestMethod.GET)
    public String updatePuserJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, String name)
            throws Exception {

        log.info("check name : name = " + name);

        try {
            List<Long> ids = this.managerService.getManagerIdsByName(name, 0, Integer.MAX_VALUE);
            log.info("get ids " + ids.size());

            if (ids.size() > 0) {
                model.addAttribute("code", -5019);
            } else {
                model.addAttribute("code", 0);
            }

        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("check name error,name is  " + name);
            log.error("update manager error code -6003");
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }

    /**
     * 修改用户
     * 
     * @param request
     * @param response
     * @param model
     * @param manager
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/manager/{mid}", method = RequestMethod.PUT)
    public String updateManagerJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            Manager manager) throws Exception {

        log.info("update manager : manager= " + manager);

        try {
            if (StringUtil.isEmpty(manager.getMobile())) {
                model.addAttribute("code", -2002);
                return "/data/json";
            }
            Manager ma = managerService.getObjectById(manager.getId());
            if (ma == null) {
                model.addAttribute("code", -5003);
                log.info(" manager name is null");
                return "/data/json";
            } else {

                if (manager.getName() == null || manager.getName().trim().equals("")) {
                    model.addAttribute("code", -5007);
                    log.info(" manager name is null");
                    return "/data/json";
                } else {
                    if (manager.getName().length() > 50 || manager.getName().length() < 0) {
                        model.addAttribute("code", -2003);
                        log.info(" manager name is " + manager.getName());
                        return "/data/json";
                    }

                }

                if (manager.getPwd() == null || manager.getPwd().trim().equals("")) {
                    log.info(" pwd is null ");
                    manager.setPwd(ma.getPwd());
                } else {
                    if (manager.getPwd().length() > 200 || manager.getPwd().length() < 0) {
                        model.addAttribute("code", -2003);
                        log.info(" manager pwd is " + manager.getPwd());
                        return "/data/json";
                    } else {
                        String newenp = com.gemantic.common.util.PasswordUtils.encode(manager.getPwd());
                        manager.setPwd(newenp);

                    }
                }
                if (manager.getRoleID() == null) {
                    model.addAttribute("code", -7000);
                    log.info(" manager roleid is null");
                    return "/data/json";
                }

                Role role = roleService.getObjectById(manager.getRoleID());
                if (role == null) {
                    log.info(" roleid  not exit ");
                    model.addAttribute("code", -7001);
                    return "/data/json";
                }
                List<Long> managerIds = this.managerService.getManagerIdsByName(manager.getName(), 0,
                        Integer.MAX_VALUE);
                log.info("manager name " + manager.getName());

                if (managerIds != null && managerIds.size() > 0) {
                    if (managerIds.size() == 1 && !(managerIds.get(0).equals(manager.getId()))) {
                        log.info(" manager name is exit ");
                        model.addAttribute("code", -5019);
                        return "/data/json";

                    }
                }

                if (Manager.RESET.equals(manager.getPwd())) {
                    String pwd = managerServiceConfig.get("pwd");
                    manager.setPwd(com.gemantic.common.util.PasswordUtils.encode(pwd));
                }

                // 启用处理
                // if (Manager.STATUS_USING.equals(manager.getStatus())) {
                // // 查询原来的状态
                // Manager p = managerService.getObjectById(manager.getId());
                // if (Manager.STATUS_STOPPED.equals(p.getStatus())) {
                //
                // // 1.该人员所属的角色存在。
                // Role role = roleService.getObjectById(manager.getRoleID());
                // log.info("get role : " + role);
                //
                // // 如角色已停用，则启用失败
                // if (Role.STATUS_STOPPED.equals(role.getStatus())) {
                //
                // log.error("update manager error,id is " + manager.getId());
                // log.error("update manager error code -7006");
                // model.addAttribute("code", -100000);
                //
                // return "/data/json";
                // }
                //
                // // 2.所属的组织都存在。
                //
                // }
                // }

                String userId = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
                log.info("login userId:" + userId);

                manager.setUpdateBy(Long.parseLong(userId));
                manager.setCreateAt(ma.getCreateAt());
                manager.setCreateBy(ma.getCreateBy());
                managerService.update(manager);

                model.addAttribute("code", 0);
                model.addAttribute("manager", manager);
            }
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("update manager error,id is  " + manager.getId());
            log.error("update manager error code -6003");
            model.addAttribute("code", -100000);

        }

        return "/admin/manager/json/managerDetailJson";
    }

    /**
     * 增加用户
     * 
     * @param request
     * @param response
     * @param model
     * @param manager
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/manager", method = RequestMethod.POST)
    public String addManagerJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            Manager manager) throws Exception {

        log.info("add manager : manager= " + manager.getName() + "rid  " + manager.getRoleID());

        try {
            if (StringUtil.isEmpty(manager.getMobile())) {
                model.addAttribute("code", -2002);
                return "/data/json";
            }

            if (manager.getName() == null || manager.getName().trim().equals("")) {
                model.addAttribute("code", -5007);
                log.info(" manager name is null");
                return "/data/json";
            } else {
                if (manager.getName().length() > 50 || manager.getName().length() < 0) {
                    model.addAttribute("code", -2003);
                    log.info(" manager name is " + manager.getName());
                    return "/data/json";
                }

            }

            if (manager.getPwd() == null || manager.getPwd().trim().equals("")) {
                model.addAttribute("code", -5008);
                log.info(" manager pwd is null");
                return "/data/json";
            } else {
                if (manager.getPwd().length() > 200 || manager.getPwd().length() < 0) {
                    model.addAttribute("code", -2003);
                    log.info(" manager pwd is " + manager.getPwd());
                    return "/data/json";
                }
            }
            if (manager.getRoleID() == null) {
                model.addAttribute("code", -7000);
                log.info(" manager roleid is null");
                return "/data/json";
            }

            Role role = roleService.getObjectById(manager.getRoleID());
            if (role == null) {
                log.info(" roleid  not exit ");
                model.addAttribute("code", -7001);
                return "/data/json";
            }
            List<Long> managerIds = this.managerService.getManagerIdsByName(manager.getName(), 0, Integer.MAX_VALUE);
            log.info("manager name " + manager.getName());
            if (managerIds.size() > 0) {
                log.info(" manager name is exit ");
                model.addAttribute("code", -5019);
                return "/data/json";

            }

            manager.setId(null);

            // String pwd = managerServiceConfig.get("pwd");
            // manager.setPwd(com.gemantic.common.util.PasswordUtils.encode(pwd));

            String userId = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
            log.info("login userId:" + userId);
            String encodePass = com.gemantic.common.util.PasswordUtils.encode(manager.getPwd());
            manager.setCreateBy(Long.parseLong(userId));
            manager.setUpdateBy(Long.parseLong(userId));
            // manager.setCreateBy(Long.parseLong("122"));
            // manager.setUpdateBy(Long.parseLong("122"));
            manager.setStatus(Manager.STATUS_USING);
            manager.setPwd(encodePass);
            Long id = managerService.insert(manager);

            // //if (null != userId) {
            // }
            request.setAttribute("objectId", id);
            model.addAttribute("code", 0);
            ;
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("add manager error ");
            model.addAttribute("code", -100000);
        }

        return "/data/json";
    }

    /**
     * 删除用户
     * 
     * @param request
     * @param response
     * @param model
     * @param mid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/manager/{mid}", method = RequestMethod.DELETE)
    public String deleteManagerJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            @PathVariable Long mid) throws Exception {
        String userId = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
        log.info("delete manager : id= " + mid);
        try {
            if (mid == null) {
                log.info(" mid is null");
                model.addAttribute("code", -5013);
                return "/data/json";
            }
            Manager manager = managerService.getObjectById(mid);
            if (manager != null) {
                if (userId.equals(mid.toString())) {
                    log.info("user  id  is " + userId);
                    log.info("mid  id  is " + mid);
                    log.info(userId.equals(mid.toString()));
                    model.addAttribute("code", -4003);
                } else {
                    managerService.delete(mid);
                    log.info("add manager success");
                    model.addAttribute("code", 0);
                }

            } else {
                model.addAttribute("code", -5003);
                return "/data/json";
            }

        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("delete manager error,id is  " + mid);
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }

    /**
     * 根据RoleID查找用户
     * 
     * @param request
     * @param response
     * @param model
     * @param rid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/role/{rid}/manager", method = RequestMethod.GET)
    public String getManagerByRoleIDJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            @PathVariable Long rid, Integer page, Integer size) throws Exception {

        log.info("get data : id= " + rid);
        try {

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

            List<Long> ids = managerService.getManagerIdsByRoleID(rid, start, size);
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", ids.size());
            model.addAttribute("ids", ids);

        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            log.error("get manager error,role id is  " + rid);
            model.addAttribute("code", -100000);
        }

        return "/admin/manager/json/managerListJson";
    }

}
