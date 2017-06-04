/**
 *
 */
package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Manager;
import com.ptteng.small.pub.service.ManagerService;

import org.osoa.sca.annotations.Reference;

import java.util.List;
import java.util.Map;

public class ManagerSCAClient implements ManagerService {

    private ManagerService managerService;

    public ManagerService getManagerService() {
        return managerService;
    }

    @Reference
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public Long insert(Manager manager) throws ServiceException, ServiceDaoException {

        return managerService.insert(manager);

    }

    @Override
    public List<Manager> insertList(List<Manager> managerList) throws ServiceException, ServiceDaoException {

        return managerService.insertList(managerList);

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {

        return managerService.delete(id);

    }

    @Override
    public boolean update(Manager manager) throws ServiceException, ServiceDaoException {

        return managerService.update(manager);

    }

    @Override
    public boolean updateList(List<Manager> managerList) throws ServiceException, ServiceDaoException {

        return managerService.updateList(managerList);

    }

    @Override
    public Manager getObjectById(Long id) throws ServiceException, ServiceDaoException {

        return managerService.getObjectById(id);

    }

    @Override
    public List<Manager> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        return managerService.getObjectsByIds(ids);

    }

    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getManagerIdsByName(String name, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        return managerService.getManagerIdsByName(name, start, limit);

    }

    @Override
    public List<Long> getManagerIdsByRoleID(Long roleID, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        return managerService.getManagerIdsByRoleID(roleID, start, limit);

    }

    @Override
    public List<Long> getManagerIdsByRoleIDAndStatus(Long roleID, String status, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        return managerService.getManagerIdsByRoleIDAndStatus(roleID, status, start, limit);

    }

    @Override
    public List<Long> getManagerIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return managerService.getManagerIds(start, limit);
    }

    @Override
    public Long getUserIdByMobile(String mobile) throws ServiceException, ServiceDaoException {
        return managerService.getUserIdByMobile(mobile);
    }

    @Override
    public Integer countManagerIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return managerService.countManagerIds();
    }

    @Override
    public List<Long> getManagerIdsByCondition(Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return managerService.getManagerIdsByCondition(conditions, start, limit);
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return managerService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return managerService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        managerService.deleteList(clz, ids);

    }

}
