package com.ptteng.small.pub.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.Constant;
import com.ptteng.small.pub.service.ConstantService;


public class ConstantServiceImpl extends BaseDaoServiceImpl implements ConstantService {


    private static final Log log = LogFactory.getLog(ConstantServiceImpl.class);


    @Override
    public Long insert(Constant constant) throws ServiceException, ServiceDaoException {


        log.info(" insert data : " + constant);

        if (constant == null) {
            return null;
        }

        long currentTimeMillis = System.currentTimeMillis();
        constant.setCreateAt(currentTimeMillis);
        constant.setUpdateAt(currentTimeMillis);

        Long result = null;
        try {
            result = (Long) dao.save(constant);
        } catch (DaoException e) {
            log.error(" insert wrong : " + constant);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" insert data success : " + result);

        return result;
    }


    @Override
    public List<Constant> insertList(List<Constant> constantList) throws ServiceException, ServiceDaoException {


        log.info(" insert lists : " + (constantList == null ? "null" : constantList.size()));

        List<Constant> resultList = null;

        if (CollectionUtils.isEmpty(constantList)) {
            return new ArrayList<Constant>();
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Constant constant : constantList) {
            constant.setCreateAt(currentTimeMillis);
            constant.setUpdateAt(currentTimeMillis);
        }

        try {
            resultList = (List<Constant>) dao.batchSave(constantList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + constantList);
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
            result = dao.delete(Constant.class, id);
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
    public boolean update(Constant constant) throws ServiceException, ServiceDaoException {


        log.info(" update data : " + (constant == null ? "null" : constant.getId()));

        boolean result = false;

        if (constant == null) {
            return true;
        }

        constant.setUpdateAt(System.currentTimeMillis());

        try {
            result = dao.update(constant);
        } catch (DaoException e) {
            log.error(" update wrong : " + constant);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + constant);
        }
        return result;
    }


    @Override
    public boolean updateList(List<Constant> constantList) throws ServiceException, ServiceDaoException {


        log.info(" update lists : " + (constantList == null ? "null" : constantList.size()));

        boolean result = false;

        if (CollectionUtils.isEmpty(constantList)) {
            return true;
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Constant constant : constantList) {
            constant.setUpdateAt(currentTimeMillis);
        }

        try {
            result = dao.batchUpdate(constantList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + constantList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" update lists success : " + constantList.size());

        return result;
    }


    @Override
    public Constant getObjectById(Long id) throws ServiceException, ServiceDaoException {


        log.info(" get data : " + id);

        Constant constant = null;

        if (id == null) {
            return constant;
        }

        try {
            constant = (Constant) dao.get(Constant.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + id);

        return constant;
    }


    @Override
    public List<Constant> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {


        log.info(" get lists : " + (ids == null ? "null" : ids));

        List<Constant> constant = null;

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Constant>();
        }

        try {
            constant = (List<Constant>) dao.getList(Constant.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + (constant == null ? "null" : constant.size()));

        return constant;
    }


    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Long getConstantIdByKey(String key) throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" get id by key  : " + key);
        }
        Long id = null;

        // TODO 参数检查!

        try {


            id = (Long) dao.getMapping("getConstantIdByKey", new Object[]{key});
        } catch (DaoException e) {
            log.error(" get id wrong by key  : " + key);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get id success : " + id);
        }
        return id;


    }


    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getConstantIdsByType(String type, Integer start, Integer limit) throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" get ids by type,start,limit  : " + type + " , " + start + " , " + limit);
        }
        List<Long> idList = null;

        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getConstantIdsByType", new Object[]{type}, start, limit, false);


        } catch (DaoException e) {
            log.error(" get ids  wrong by type,start,limit)  : " + type + " , " + start + " , " + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
        }
        return idList;


    }


    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Long getConstantIdByKeyAndType(String key, String type) throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" get id by key,type  : " + key + " , " + type);
        }
        Long id = null;

        // TODO 参数检查!

        try {


            id = (Long) dao.getMapping("getConstantIdByKeyAndType", new Object[]{key, type});
        } catch (DaoException e) {
            log.error(" get id wrong by key,type  : " + key + " , " + type);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get id success : " + id);
        }
        return id;


    }


    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countConstantIdsByType(String type) throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" count ids by type  : " + type);
        }
        Integer count = null;


        try {

            count = dao.count("getConstantIdsByType", new Object[]{type});


        } catch (DaoException e) {
            log.error(" count ids  wrong by type)  : " + type);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  success : " + count);
        }
        return count;


    }


    @Override
    public List<Long> getConstantIds(Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;


        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getConstantIdsAll", new Object[]{}, start, limit, false);
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
    public Integer countConstantIds() throws ServiceException,
            ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getConstantIdsAll", new Object[]{});
        } catch (DaoException e) {
            log.error(" count by getConstantIds ");
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  : " + count);
        }
        return count;
    }

    @Override
    public String getValue(String key, String type) throws ServiceException, ServiceDaoException {
        log.info("key:" + key + "type:" + type);
        Long id = getConstantIdByKeyAndType(key, type);
        Constant constant = getObjectById(id);

        String value = constant.getValue();

        return value;
    }

}

