package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.Article;

import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface ArticleService extends BaseDaoService {

    public Long insert(Article article) throws ServiceException, ServiceDaoException;

    public List<Article> insertList(List<Article> articleList) throws ServiceException, ServiceDaoException;

    public boolean delete(Long id) throws ServiceException, ServiceDaoException;

    public boolean update(Article article) throws ServiceException, ServiceDaoException;

    public boolean updateList(List<Article> articleList) throws ServiceException, ServiceDaoException;

    public Article getObjectById(Long id) throws ServiceException, ServiceDaoException;

    public List<Article> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source)
            throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countArticleIdsBySourceOrderByPublishat(String source) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countArticleIdsByTypeAndStatusOrderByPublishat(Integer type, Integer status)
            throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleIdsBySourceOrderByPublishat(String source, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleIdsByTypeAndStatusOrderByPublishat(Integer type, Integer status, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleIdsByTypeAndStatus(Integer type, Integer status, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException;

    public List<Long> getArticleIdsByType(Integer type, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public List<Long> getArticleIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException;

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    public Integer countArticleIds() throws ServiceException, ServiceDaoException;

    /**
     * 给用户保存相应活动的奖品
     * 
     * @param user
     * @param now
     */
    // public void savaActivityPrizeForUser(User user ,Long now,Integer type);

    /**
     * 根据type获取到article里面的push（type：4表示的是push管理）
     * 
     * @param type
     * @return
     */
    public List<Long> getArticleIdsBytype(Integer type);

}
