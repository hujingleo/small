package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Advice;
import com.ptteng.small.pub.service.AdviceService;
import jdk.nashorn.internal.ir.annotations.Reference;

import java.util.List;
import java.util.Map;

/**
 * Created by hujin on 2017/5/17.
 */
public class AdviceSCAClient implements AdviceService {
    private AdviceService adviceService;

    public AdviceService getAdviceService() {
        return adviceService;
    }
@Reference
    public void setAdviceService(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @Override
    public Long insert(Advice advice) throws ServiceException, ServiceDaoException {
        return adviceService.insert(advice);
    }

    @Override
    public List<Advice> insertList(List<Advice> adviceList) throws ServiceException, ServiceDaoException {
        return adviceService.insertList(adviceList);
    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        return adviceService.delete(id);
    }

    @Override
    public boolean update(Advice advice) throws ServiceException, ServiceDaoException {
        return adviceService.update(advice);
    }

    @Override
    public boolean updateList(List<Advice> adviceList) throws ServiceException, ServiceDaoException {
        return adviceService.updateList(adviceList);
    }

    @Override
    public Advice getObjectById(Long id) throws ServiceException, ServiceDaoException {
        return adviceService.getObjectById(id);
    }

    @Override
    public List<Advice> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        return adviceService.getObjectsByIds(ids);
    }

    @Override
    public List<Long> getAdviceIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return adviceService.getAdviceIds(start, limit);
    }

    @Override
    public Integer countAdviceIds() throws ServiceException, ServiceDaoException {
        return adviceService.countAdviceIds();
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> condition, Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return adviceService.getIdsByDynamicCondition(clz, condition, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1) throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        return adviceService.fakeDelete(clz,id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        adviceService.deleteList(clz, ids);
    }
}
