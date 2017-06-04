package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.Message;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

/**
 * Created by hujin on 2017/5/17.
 */

@Remotable
public interface MessageService extends BaseDaoService{

    public Long insert(Message message) throws ServiceException, ServiceDaoException;

    public List<Message> insertList(List<Message> messageList) throws ServiceException, ServiceDaoException;

    public boolean delete(Long id) throws ServiceException, ServiceDaoException;

    public boolean update(Message message) throws ServiceException, ServiceDaoException;

    public boolean updateList(List<Message> messageList) throws ServiceException, ServiceDaoException;

    public Message getObjectById(Long id) throws ServiceException, ServiceDaoException;

    public List<Message> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;



    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getMessageIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;

    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countMessageIds() throws ServiceException, ServiceDaoException;

}
