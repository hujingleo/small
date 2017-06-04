/**
 *
 */
package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Role;
import com.ptteng.small.pub.service.RoleService;

import org.osoa.sca.annotations.Reference;

import java.util.List;
import java.util.Map;

public class RoleSCAClient implements RoleService {

    private RoleService roleService;

    public RoleService getRoleService() {
        return roleService;
    }

    @Reference
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Long insert(Role role) throws ServiceException, ServiceDaoException {

        return roleService.insert(role);

    }

    @Override
    public List<Role> insertList(List<Role> roleList) throws ServiceException, ServiceDaoException {

        return roleService.insertList(roleList);

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {

        return roleService.delete(id);

    }

    @Override
    public boolean update(Role role) throws ServiceException, ServiceDaoException {

        return roleService.update(role);

    }

    @Override
    public boolean updateList(List<Role> roleList) throws ServiceException, ServiceDaoException {

        return roleService.updateList(roleList);

    }

    @Override
    public Role getObjectById(Long id) throws ServiceException, ServiceDaoException {

        return roleService.getObjectById(id);

    }

    @Override
    public List<Role> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        return roleService.getObjectsByIds(ids);

    }

    @Override
    public List<Long> getRoleIdsByName(String name, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return roleService.getRoleIdsByName(name, start, limit);
    }

    @Override
    public List<Long> getRoleIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return roleService.getRoleIds(start, limit);
    }

    @Override
    public Integer countRoleIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return roleService.countRoleIds();
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return roleService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return roleService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        roleService.deleteList(clz, ids);

    }

}
