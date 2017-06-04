package com.ptteng.small.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ptteng.small.admin.util.DynamicUtil;
import com.ptteng.small.pub.model.Advice;
import com.qding.common.util.DataUtils;
import javassist.expr.NewArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptteng.small.pub.model.Message;
import com.ptteng.small.pub.service.MessageService;
import com.ptteng.small.admin.util.DateUtil;
/**
 * Message  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 *
 */
@Controller
public class MessageController {
    private static final Log log = LogFactory.getLog(MessageController.class);

    @Autowired
    private MessageService messageService;


    /**
     * 用户获取该用户的消息列表
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/message/search", method = RequestMethod.GET)
    public String getMessageListJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model,String id,Integer page, Integer size)
            throws Exception {
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

        log.info("get data : id= " + id);
        List<Long> messageIdList = null ;
        List<Message> messageList = new ArrayList<Message>();
        try {
            Map<String, Object> param = DynamicUtil.getMessageByOpenId(id);
            messageIdList = messageService.getIdsByDynamicCondition(Message.class,param,start, size);
            messageList = messageService.getObjectsByIds(messageIdList);
            int total = messageIdList.size();
            log.info("get messageList ids is " + messageIdList);
            for(Message message:messageList)
            {
				//设置createTime
				if(DataUtils.isNotNullOrEmpty(message.getCreateAt()))
				{
					message.setCreateTime(DateUtil.timeCycle(message.getCreateAt()));
				}
            }
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("messageList", messageList);

            log.info("success! data is "+ messageList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get messageList error,ids is  " + messageIdList);
            model.addAttribute("code", -100000);
        }

        return "/admin/message/json/messageListJson";
    }


    /**
     * 后台获取消息列表
     * @param request
     * @param response
     * @param model
     * @param
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/message/search", method = RequestMethod.GET)
    public String getMultiMessageListJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model,Integer page, Integer size)
            throws Exception {
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
       // log.info("get data : id= " + id);
        List<Long> messageIdList = new ArrayList<Long>();
        List<Message> messageList = new ArrayList<Message>();
        try {
            //暂时不做动态查询,保留
          //Map<String, Object> param = DynamicUtil.getMessageByOpenId(id);
           // log.info("get param is "+param);
            messageIdList = messageService.getMessageIds(start, size);
            messageList = messageService.getObjectsByIds(messageIdList);
            int total = messageIdList.size();
            log.info("get messageList ids is " + messageIdList);

            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("messageList", messageList);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get messageList error,ids is  " + messageIdList);
            model.addAttribute("code", -100000);
        }

        return "/admin/message/json/messageListJson";
    }


    /**
     * 修改article 的上架下架状态
     *
     * @param request
     * @param response
     * @param model
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/message/status", method = RequestMethod.PUT)
    public String updateMessageJson(HttpServletRequest request, HttpServletResponse response,
                                    ModelMap model, Long id, Integer status)
        throws Exception {
      if (id == null) {
        model.addAttribute("code", -1000);
        log.info("put message error aid is null");
        return "/data/json";
      }
      
      Message message = messageService.getObjectById(id);
      // Integer status = article.getStatus();
      log.info("update message status : message id ,status = " + id + " , " + status);
      
      
      try {
        
        // 修改status
        message.setStatus(status);
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
        
        messageService.update(message);
        
        model.addAttribute("code", 0);
        
      }
      catch (Throwable t) {
        t.printStackTrace();
        log.error(t.getMessage());
        log.error("update message error,id is  " + id);
        model.addAttribute("code", -100000);
        
      }
      
      return "/data/json";
    }
    /**
     * 获取单个消息明细
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/message/{id}", method = RequestMethod.GET)
    public String getMessageJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        try {
            Message message = messageService.getObjectById(id);
            log.info("get message data is " + message);

            model.addAttribute("code", 0);

            model.addAttribute("message", message);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get message error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/admin/message/json/messageDetailJson";
    }

    /**
     * 编辑消息,编辑openId可将消息发送给单个或所有用户
     * @param request
     * @param response
     * @param model
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/message/{id}", method = RequestMethod.PUT)
    public String updateMessageJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Message message) throws Exception {

        log.info("update message : message= " + message);

        try {

            messageService.update(message);

            model.addAttribute("code", 0);

            model.addAttribute("message", message);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update message error,id is  " + message.getId());
            model.addAttribute("code", -6003);

        }

        return "/data/json";
    }

    /**
     * 新增一条消息即发送
     * @param request
     * @param response
     * @param model
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/message", method = RequestMethod.POST)
    public String addmessageJson(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                                Message message) throws Exception {

        log.info("insert message : = " + message);

        if (DataUtils.isNullOrEmpty(message.getOpenId())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(message.getContent())) {

            model.addAttribute("code", -4014);
            return "common/fail";
        }

        try {
            message.setId(null);
            message.setCreateAt(System.currentTimeMillis());
            Long id = messageService.insert(message);
            log.info("add message success , id is " + id);
            model.addAttribute("id", id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add message error ");
            model.addAttribute("code", -6002);
        }
        return "/data/json";
    }

    @RequestMapping(value = "/a/message/{id}", method = RequestMethod.DELETE)
    public String deleteMessageJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("delete message : id= " + id);
        try {
            messageService.delete(id);

            log.info("add message success");
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete message error,id is  " + id);
            model.addAttribute("code", -6004);

        }

        return "/data/json";
    }

}

