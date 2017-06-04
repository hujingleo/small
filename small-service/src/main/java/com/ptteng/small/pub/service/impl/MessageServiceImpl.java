package com.ptteng.small.pub.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.Message;
import com.ptteng.small.pub.service.MessageService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hujin on 2017/5/17.
 */
public class MessageServiceImpl extends BaseDaoServiceImpl implements MessageService {
    private static final Log log = LogFactory.getLog(MessageServiceImpl.class);
	@Autowired
	private Dao dao;
    @Override
    public Long insert(Message message) throws ServiceException, ServiceDaoException {
        log.info(" insert data : " + message);

        if (message == null) {
            return null;
        }

        long currentTimeMillis = System.currentTimeMillis();
        message.setCreateAt(currentTimeMillis);
        message.setUpdateAt(currentTimeMillis);

        Long result = null;
        try {
            result = (Long) dao.save(message);
        } catch (DaoException e) {
            log.error(" insert wrong : " + message);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" insert data success : " + result);

        return result;
    }

    @Override
    public List<Message> insertList(List<Message> messageList) throws ServiceException, ServiceDaoException {
        log.info(" insert lists : " + (messageList == null ? "null" : messageList.size()));

        List<Message> resultList = null;

        if (CollectionUtils.isEmpty(messageList)) {
            return new ArrayList<Message>();
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Message message : messageList) {
            message.setCreateAt(currentTimeMillis);
            message.setUpdateAt(currentTimeMillis);
        }

        try {
            resultList = dao.batchSave(messageList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + messageList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));

        return resultList;

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        log.info(" delete data : " + id);

        boolean result = false;

        if (id == null) {
            return true;
        }

        try {
            result = dao.delete(Message.class, id);
        } catch (DaoException e) {
            log.error(" delete wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" delete data success : " + id);

        return result;

    }

    @Override
    public boolean update(Message message) throws ServiceException, ServiceDaoException {
        log.info(" update data : " + (message == null ? "null" : message.getId()));

        boolean result = false;

        if (message == null) {
            return true;
        }

        message.setUpdateAt(System.currentTimeMillis());

        try {
            result = dao.update(message);
        } catch (DaoException e) {
            log.error(" update wrong : " + message);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + message);
        }
        return result;
    }

    @Override
    public boolean updateList(List<Message> messageList) throws ServiceException, ServiceDaoException {
        log.info(" update lists : " + (messageList == null ? "null" : messageList.size()));

        boolean result = false;

        if (CollectionUtils.isEmpty(messageList)) {
            return true;
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Message message : messageList) {
            message.setUpdateAt(currentTimeMillis);
        }

        try {
            result = dao.batchUpdate(messageList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + messageList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" update lists success : " + messageList.size());

        return result;
    }

    @Override
    public Message getObjectById(Long id) throws ServiceException, ServiceDaoException {
        log.info(" get data : " + id);

        Message message = null;

        if (id == null) {
            return message;
        }

        try {
            message = (Message) dao.get(Message.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + id);

        return message;
    }


    @Override
    public List<Message> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        log.info(" get lists : " + (ids == null ? "null" : ids));

        List<Message> message = null;

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Message>();
        }

        try {
            message = (List<Message>) dao.getList(Message.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + (message == null ? "null" : message.size()));

        return message;
    }


    @Override
    public List<Long> getMessageIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getMessageIdsAll", new Object[] {}, start, limit, false);
        } catch (DaoException e) {
            log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
        }
        return idList;
    }

    @Override
    public Integer countMessageIds() throws ServiceException, ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getMessageIdsAll", new Object[] {});
        } catch (DaoException e) {
            log.error(" count by getMessageIds ");
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  : " + count);
        }
        return count;
    }
}
