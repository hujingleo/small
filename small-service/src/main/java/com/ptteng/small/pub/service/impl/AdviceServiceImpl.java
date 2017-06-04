package com.ptteng.small.pub.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.Advice;
import com.ptteng.small.pub.service.AdviceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujin on 2017/5/17.
 */
public class AdviceServiceImpl extends BaseDaoServiceImpl implements AdviceService {
    private static final Log log = LogFactory.getLog(AdviceServiceImpl.class);
	@Autowired
	private Dao dao;

    @Override
    public Long insert(Advice advice) throws ServiceException, ServiceDaoException {
        log.info("insert data: is " + advice);
        if (null == advice) {
            return null;
        }
        long currenTimeMills = System.currentTimeMillis();
        advice.setCreateAt(currenTimeMills);

        Long result = null;
        try {
            result = (Long) dao.save(advice);
        } catch (DaoException e) {
            log.info("insert error: " + advice);
            log.info(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        log.info("insert data success: " + result);
        return result;
    }

    @Override
    public List<Advice> insertList(List<Advice> adviceList) throws ServiceException, ServiceDaoException {
        log.info("insert lists: " + (adviceList == null ? "null" : adviceList.size()));
        List<Advice> resultList = null;
        if (CollectionUtils.isEmpty(adviceList)) {
            return new ArrayList<Advice>();
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Advice advice : adviceList) {
            advice.setCreateAt(currentTimeMillis);
        }

        try {
            resultList = dao.batchSave(adviceList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + adviceList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        log.info("insert lists success: " + (resultList == null ? "null" : resultList.size()));
        return resultList;
    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        log.info("detele data: " + id);
        boolean result = false;

        if (null == id) {
            return true;
        }

        try {
            result = dao.delete(Advice.class, id);
        } catch (DaoException e) {
            log.error(" delete wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        log.info("delete data success : " + id);
        return result;
    }

    @Override
    public boolean update(Advice advice) throws ServiceException, ServiceDaoException {
        log.info(" update data : " + (advice == null ? "null" : advice.getId()));
        boolean result = false;
        if (advice == null) {
            return true;
        }
        try {
            result = dao.update(advice);
        } catch (DaoException e) {
            log.error(" update wrong : " + advice);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + advice);
        }
        return result;
    }

    @Override
    public boolean updateList(List<Advice> adviceList) throws ServiceException, ServiceDaoException {
        log.info(" update lists : " + (adviceList == null ? "null" : adviceList.size()));
        boolean result = false;
        if (CollectionUtils.isEmpty(adviceList)) {
            return true;
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Advice advice : adviceList) {
        }

        try {
            result = dao.batchUpdate(adviceList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + adviceList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" update lists success : " + adviceList.size());

        return result;
    }

    @Override
    public Advice getObjectById(Long id) throws ServiceException, ServiceDaoException {
        log.info(" get data : " + id);

        Advice advice = null;

        if (id == null) {
            return advice;
        }

        try {
            advice = (Advice) dao.get(Advice.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + id);

        return advice;
    }

    @Override
    public List<Advice> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        log.info(" get lists : " + (ids == null ? "null" : ids));

        List<Advice> advice = null;

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Advice>();
        }

        try {
            advice = (List<Advice>) dao.getList(Advice.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + (advice == null ? "null" : advice.size()));

        return advice;
    }

    @Override
    public List<Long> getAdviceIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getAdviceIdsAll", new Object[] {}, start, limit, false);
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
    public Integer countAdviceIds() throws ServiceException, ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getAdviceIdsAll", new Object[] {});
        } catch (DaoException e) {
            log.error(" count by getAdviceIds ");
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
