package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.ArticleType;

import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ArticleTypeService extends BaseDaoService {

    public Long insert(ArticleType articleType) throws ServiceException, ServiceDaoException;

    public List<ArticleType> insertList(List<ArticleType> articleTypeList) throws ServiceException, ServiceDaoException;

    public boolean delete(Long id) throws ServiceException, ServiceDaoException;

    public boolean update(ArticleType articleType) throws ServiceException, ServiceDaoException;

    public boolean updateList(List<ArticleType> articleTypeList) throws ServiceException, ServiceDaoException;

    public ArticleType getObjectById(Long id) throws ServiceException, ServiceDaoException;

    public List<ArticleType> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

   
    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleTypeIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countArticleTypeIds() throws ServiceException, ServiceDaoException;

   

}
