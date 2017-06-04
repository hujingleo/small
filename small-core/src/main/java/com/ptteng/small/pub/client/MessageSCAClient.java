package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Message;
import com.ptteng.small.pub.service.MessageService;
import jdk.nashorn.internal.ir.annotations.Reference;

import java.util.List;
import java.util.Map;

/**
 * Created by hujin on 2017/5/17.
 */
public class MessageSCAClient implements MessageService {

    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    @Reference
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Long insert(Message message) throws ServiceException, ServiceDaoException {
        return messageService.insert(message);
    }

    @Override
    public List<Message> insertList(List<Message> messageList) throws ServiceException, ServiceDaoException {
        return messageService.insertList(messageList);
    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        return messageService.delete(id);
    }

    @Override
    public boolean update(Message message) throws ServiceException, ServiceDaoException {
        return messageService.update(message);
    }

    @Override
    public boolean updateList(List<Message> messageList) throws ServiceException, ServiceDaoException {
        return messageService.updateList(messageList);
    }

    @Override
    public Message getObjectById(Long id) throws ServiceException, ServiceDaoException {
        return messageService.getObjectById(id);
    }

    @Override
    public List<Message> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        return messageService.getObjectsByIds(ids);
    }

    @Override
    public List<Long> getMessageIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return messageService.getMessageIds(start, limit);
    }

    @Override
    public Integer countMessageIds() throws ServiceException, ServiceDaoException {
        return messageService.countMessageIds();
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class aClass, Map<String, Object> conditions, Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return messageService.getIdsByDynamicCondition(aClass, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1) throws ServiceException, ServiceDaoException {
        return messageService.getObjectByDynamicCondition(aClass, map, integer, integer1);
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        return messageService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        messageService.deleteList(clz, ids);
    }
}
