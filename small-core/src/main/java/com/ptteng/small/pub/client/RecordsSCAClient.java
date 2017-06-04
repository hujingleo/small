package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Records;
import com.ptteng.small.pub.service.RecordsService;

import org.osoa.sca.annotations.Reference;

import java.util.List;
import java.util.Map;

/**
 * Created by dell-pc on 2016/5/13.
 */
public class RecordsSCAClient implements RecordsService {

    private RecordsService recordsService;

    public RecordsService getRecordsService() {
        return recordsService;
    }

    @Reference
    public void setRecordsService(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @Override
    public Long insert(Records records) throws ServiceException, ServiceDaoException {
        return recordsService.insert(records);
    }

    @Override
    public List<Records> insertList(List<Records> recordsList) throws ServiceException, ServiceDaoException {
        return recordsService.insertList(recordsList);
    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        return recordsService.delete(id);
    }

    @Override
    public boolean update(Records records) throws ServiceException, ServiceDaoException {
        return recordsService.update(records);
    }

    @Override
    public boolean updateList(List<Records> recordsList) throws ServiceException, ServiceDaoException {
        return recordsService.updateList(recordsList);
    }

    @Override
    public Records getObjectById(Long id) throws ServiceException, ServiceDaoException {
        return recordsService.getObjectById(id);
    }

    @Override
    public List<Records> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        return recordsService.getObjectsByIds(ids);
    }

    @Override
    public List<Long> getRecordsIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        return recordsService.getRecordsIds(start, limit);
    }

    @Override
    public Integer countRecordsIds() throws ServiceException, ServiceDaoException {
        return recordsService.countRecordsIds();
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return recordsService.getIdsByDynamicCondition(aClass, map, integer, integer1);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class aClass, Long aLong) throws ServiceException, ServiceDaoException {
        return recordsService.fakeDelete(aClass, aLong);
    }

    @Override
    public void deleteList(Class aClass, List<Long> list) throws ServiceException, ServiceDaoException {
        recordsService.deleteList(aClass, list);

    }
}