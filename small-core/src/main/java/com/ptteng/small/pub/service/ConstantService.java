package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.Constant;

import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ConstantService extends BaseDaoService {

    public Long insert(Constant constant) throws ServiceException, ServiceDaoException;

    public List<Constant> insertList(List<Constant> constantList) throws ServiceException, ServiceDaoException;

    public boolean delete(Long id) throws ServiceException, ServiceDaoException;

    public boolean update(Constant constant) throws ServiceException, ServiceDaoException;

    public boolean updateList(List<Constant> constantList) throws ServiceException, ServiceDaoException;

    public Constant getObjectById(Long id) throws ServiceException, ServiceDaoException;

    public List<Constant> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countConstantIdsByType(String type) throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Long getConstantIdByKey(String key) throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getConstantIdsByType(String type, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Long getConstantIdByKeyAndType(String key, String type) throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getConstantIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countConstantIds() throws ServiceException, ServiceDaoException;

    public String getValue(String key, String type) throws ServiceException, ServiceDaoException;

}
