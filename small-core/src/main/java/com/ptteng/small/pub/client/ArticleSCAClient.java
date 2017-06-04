package com.ptteng.small.pub.client; /**
                                        * 
                                        */

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Article;
import com.ptteng.small.pub.service.ArticleService;

import org.osoa.sca.annotations.Reference;

import java.util.List;
import java.util.Map;

public class ArticleSCAClient implements ArticleService {

    private ArticleService articleService;

    public ArticleService getArticleService() {
        return articleService;
    }

    @Reference
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public Long insert(Article article) throws ServiceException, ServiceDaoException {

        return articleService.insert(article);

    }

    @Override
    public List<Article> insertList(List<Article> articleList) throws ServiceException, ServiceDaoException {

        return articleService.insertList(articleList);

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {

        return articleService.delete(id);

    }

    @Override
    public boolean update(Article article) throws ServiceException, ServiceDaoException {

        return articleService.update(article);

    }

    @Override
    public boolean updateList(List<Article> articleList) throws ServiceException, ServiceDaoException {

        return articleService.updateList(articleList);

    }

    @Override
    public Article getObjectById(Long id) throws ServiceException, ServiceDaoException {

        return articleService.getObjectById(id);

    }

    @Override
    public List<Article> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        return articleService.getObjectsByIds(ids);

    }

    @Override
    public Integer countArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source)
            throws ServiceException, ServiceDaoException {
        return articleService.countArticleIdsByStatusAndSourceOrderByPublishat(status, source);
    }

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getArticleIdsByTypeAndStatusOrderByPublishat(Integer type, Integer status, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException {

        return articleService.getArticleIdsByTypeAndStatusOrderByPublishat(type, status, start, limit);

    }

    @Override
    public List<Long> getArticleIdsByTypeAndStatus(Integer type, Integer status, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        return articleService.getArticleIdsByTypeAndStatus(type, status, start, limit);
    }

    @Override
    public List<Long> getArticleIdsByType(Integer type, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        return articleService.getArticleIdsByType(type, start, limit);
    }

    /**
     *
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countArticleIdsByTypeAndStatusOrderByPublishat(Integer type, Integer status)
            throws ServiceException, ServiceDaoException {

        return articleService.countArticleIdsByTypeAndStatusOrderByPublishat(type, status);

    }

    @Override
    public List<Long> getArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException {
        return articleService.getArticleIdsByStatusAndSourceOrderByPublishat(status, source, start, limit);
    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getArticleIdsBySourceOrderByPublishat(String source, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        return articleService.getArticleIdsBySourceOrderByPublishat(source, start, limit);

    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countArticleIdsBySourceOrderByPublishat(String source) throws ServiceException, ServiceDaoException {

        return articleService.countArticleIdsBySourceOrderByPublishat(source);

    }

    @Override
    public List<Long> getArticleIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleService.getArticleIds(start, limit);
    }

    @Override
    public Integer countArticleIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleService.countArticleIds();
    }

    // @Override
    // public void savaActivityPrizeForUser(User user, Long now, Integer type) {
    // articleService.savaActivityPrizeForUser(user,now,type);
    // return;
    // }

    @Override
    public List<Long> getArticleIdsBytype(Integer type) {
        return articleService.getArticleIdsBytype(type);
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        articleService.deleteList(clz, ids);

    }

}
