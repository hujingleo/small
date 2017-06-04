package com.ptteng.small.pub.client; /**
                                        * 
                                        */

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.ArticleType;
import com.ptteng.small.pub.service.ArticleTypeService;

import org.osoa.sca.annotations.Reference;

import java.util.List;
import java.util.Map;

public class ArticleTypeSCAClient implements ArticleTypeService {

    private ArticleTypeService articleTypeService;

    public ArticleTypeService getArticleTypeService() {
        return articleTypeService;
    }

    @Reference
    public void setArticleTypeService(ArticleTypeService articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

    @Override
    public Long insert(ArticleType articleType) throws ServiceException, ServiceDaoException {

        return articleTypeService.insert(articleType);

    }

    @Override
    public List<ArticleType> insertList(List<ArticleType> articleTypeList) throws ServiceException, ServiceDaoException {

        return articleTypeService.insertList(articleTypeList);

    }

    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {

        return articleTypeService.delete(id);

    }

    @Override
    public boolean update(ArticleType articleType) throws ServiceException, ServiceDaoException {

        return articleTypeService.update(articleType);

    }

    @Override
    public boolean updateList(List<ArticleType> articleTypeList) throws ServiceException, ServiceDaoException {

        return articleTypeService.updateList(articleTypeList);

    }

    @Override
    public ArticleType getObjectById(Long id) throws ServiceException, ServiceDaoException {

        return articleTypeService.getObjectById(id);

    }

    @Override
    public List<ArticleType> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        return articleTypeService.getObjectsByIds(ids);

    }


    @Override
    public List<Long> getArticleTypeIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleTypeService.getArticleTypeIds(start, limit);
    }

    @Override
    public Integer countArticleTypeIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleTypeService.countArticleTypeIds();
    }

    

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleTypeService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }

    @Override
    public Object getObjectByDynamicCondition(Class aClass, Map<String, Object> map, Integer integer, Integer integer1)
            throws ServiceException, ServiceDaoException {
        return null;
    }

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return articleTypeService.fakeDelete(clz, id);
    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        articleTypeService.deleteList(clz, ids);

    }

}
