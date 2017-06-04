/**
 * 
 */
package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Constant;
import com.ptteng.small.pub.service.ConstantService;

import java.util.List;
import java.util.Map;

public class ConstantSCAClient implements ConstantService {

    private ConstantService constantService;

    public ConstantService getConstantService() {
        return constantService;
    }

    public void setConstantService(ConstantService constantService) {
        this.constantService = constantService;
    }

    @Override
    public Long insert(Constant constant) throws ServiceException, ServiceDaoException {

        return constantService.insert(constant);

    }

    @Override
    public List<Constant> insertList(List<Constant> constantList) throws ServiceException, ServiceDaoException {

        return constantService.insertList(constantList);

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {

        return constantService.delete(id);

    }

    @Override
    public boolean update(Constant constant) throws ServiceException, ServiceDaoException {

        return constantService.update(constant);

    }

    @Override
    public boolean updateList(List<Constant> constantList) throws ServiceException, ServiceDaoException {

        return constantService.updateList(constantList);

    }

    @Override
    public Constant getObjectById(Long id) throws ServiceException, ServiceDaoException {

        return constantService.getObjectById(id);

    }

    @Override
    public List<Constant> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        return constantService.getObjectsByIds(ids);

    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Long getConstantIdByKey(String key) throws ServiceException, ServiceDaoException {

        return constantService.getConstantIdByKey(key);

    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getConstantIdsByType(String type, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        return constantService.getConstantIdsByType(type, start, limit);

    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Long getConstantIdByKeyAndType(String key, String type) throws ServiceException, ServiceDaoException {

        return constantService.getConstantIdByKeyAndType(key, type);

    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countConstantIdsByType(String type) throws ServiceException, ServiceDaoException {

        return constantService.countConstantIdsByType(type);

    }

    @Override
    public List<Long> getConstantIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return constantService.getConstantIds(start, limit);
    }

    @Override
    public Integer countConstantIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return constantService.countConstantIds();
    }

    @Override
    public String getValue(String key, String type) throws ServiceException, ServiceDaoException {
        return constantService.getValue(key, type);
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return constantService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return constantService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        constantService.deleteList(clz, ids);

    }

}
