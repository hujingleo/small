package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.Advice;
import com.ptteng.small.pub.model.Article;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

/**
 * Created by hujin on 2017/5/17.
 */
@Remotable
public interface AdviceService extends BaseDaoService{

    public Long insert(Advice advice) throws ServiceException, ServiceDaoException;

    public List<Advice> insertList(List<Advice> adviceList) throws ServiceException, ServiceDaoException;

    public boolean delete(Long id) throws ServiceException, ServiceDaoException;

    public boolean update(Advice advice) throws ServiceException, ServiceDaoException;

    public boolean updateList(List<Advice> adviceList) throws ServiceException, ServiceDaoException;

    public Advice getObjectById(Long id) throws ServiceException, ServiceDaoException;

    public List<Advice> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;


    public List<Long> getAdviceIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;


    public Integer countAdviceIds() throws ServiceException, ServiceDaoException;

}
