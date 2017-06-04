package com.ptteng.small.pub.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.Article;
import com.ptteng.small.pub.service.ArticleService;

public class ArticleServiceImpl extends BaseDaoServiceImpl implements ArticleService {

    private static final Log log = LogFactory.getLog(ArticleServiceImpl.class);
	@Autowired
	private Dao dao;
    @Override
    public Long insert(Article article) throws ServiceException, ServiceDaoException {

        log.info(" insert data : " + article);

        if (article == null) {
            return null;
        }

        long currentTimeMillis = System.currentTimeMillis();
        article.setCreateAt(currentTimeMillis);
        article.setUpdateAt(currentTimeMillis);

        Long result = null;
        try {
            result = (Long) dao.save(article);
        } catch (DaoException e) {
            log.error(" insert wrong : " + article);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" insert data success : " + result);

        return result;
    }

    @Override
    public List<Article> insertList(List<Article> articleList) throws ServiceException, ServiceDaoException {

        log.info(" insert lists : " + (articleList == null ? "null" : articleList.size()));

        List<Article> resultList = null;

        if (CollectionUtils.isEmpty(articleList)) {
            return new ArrayList<Article>();
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Article article : articleList) {
            article.setCreateAt(currentTimeMillis);
            article.setUpdateAt(currentTimeMillis);
        }

        try {
            resultList = dao.batchSave(articleList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + articleList);
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
            result = dao.delete(Article.class, id);
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
    public boolean update(Article article) throws ServiceException, ServiceDaoException {

        log.info(" update data : " + (article == null ? "null" : article.getId()));

        boolean result = false;

        if (article == null) {
            return true;
        }

        article.setUpdateAt(System.currentTimeMillis());

        try {
            result = dao.update(article);
        } catch (DaoException e) {
            log.error(" update wrong : " + article);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + article);
        }
        return result;
    }

    @Override
    public boolean updateList(List<Article> articleList) throws ServiceException, ServiceDaoException {

        log.info(" update lists : " + (articleList == null ? "null" : articleList.size()));

        boolean result = false;

        if (CollectionUtils.isEmpty(articleList)) {
            return true;
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (Article article : articleList) {
            article.setUpdateAt(currentTimeMillis);
        }

        try {
            result = dao.batchUpdate(articleList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + articleList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" update lists success : " + articleList.size());

        return result;
    }

    @Override
    public Article getObjectById(Long id) throws ServiceException, ServiceDaoException {

        log.info(" get data : " + id);

        Article article = null;

        if (id == null) {
            return article;
        }

        try {
            article = (Article) dao.get(Article.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + id);

        return article;
    }

    @Override
    public List<Article> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        log.info(" get lists : " + (ids == null ? "null" : ids));

        List<Article> article = null;

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Article>();
        }

        try {
            article = (List<Article>) dao.getList(Article.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + (article == null ? "null" : article.size()));

        return article;
    }

    /**
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" get ids by status,source,start,limit  : " + status + " , " + source + " , " + start + " , "
                    + limit);
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
            idList = dao.getIdList("getArticleIdsByStatusAndSourceOrderByPublishat", new Object[] { status, source },
                    start, limit, false);

        } catch (DaoException e) {
            log.error(" get ids  wrong by status,source,start,limit)  : " + status + " , " + source + " , " + start
                    + " , " + limit);
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
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getArticleIdsBySourceOrderByPublishat(String source, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" get ids by source,start,limit  : " + source + " , " + start + " , " + limit);
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
            idList = dao.getIdList("getArticleIdsBySourceOrderByPublishat", new Object[] { source }, start, limit,
                    false);

        } catch (DaoException e) {
            log.error(" get ids  wrong by source,start,limit)  : " + source + " , " + start + " , " + limit);
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
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getArticleIdsByTypeAndStatusOrderByPublishat(Integer type, Integer status, Integer start,
            Integer limit) throws ServiceException, ServiceDaoException {

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
            if (type == 2) {
                idList = dao.getIdList("getArticleIdsByTypeAndStatusOrderByPublishatAscs",
                        new Object[] { type, status }, start, limit, false);

            } else {
                idList = dao.getIdList("getArticleIdsByTypeAndStatusOrderByPublishatDesc",
                        new Object[] { type, status }, start, limit, false);

            }

        } catch (DaoException e) {
            log.error(" get ids  wrong by type,status,start,limit)  : " + type + " , " + status + " ," + start + " , "
                    + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
        }
        return idList;

    }

    @Override
    public List<Long> getArticleIdsByTypeAndStatus(Integer type, Integer status, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {

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

            log.info(" dao = " + dao);
            idList = dao.getIdList("getArticleIdsByTypeAndStatusOrderByPublishatDesc", new Object[] { type, status },
                    start, limit, false);

        } catch (DaoException e) {
            log.error(" get ids  wrong by type,status,start,limit)  : " + type + " , " + status + " ," + start + " , "
                    + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
        }
        return idList;
    }

    @Override
    public List<Long> getArticleIdsByType(Integer type, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
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

            log.info(" dao = " + dao);
            idList = dao.getIdList("getArticleIdsByType", new Object[] { type }, start, limit, false);

        } catch (DaoException e) {
            log.error(" get ids  wrong by type,status,start,limit)  : " + type + " ," + start + " , " + limit);
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
     * 
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countArticleIdsByStatusAndSourceOrderByPublishat(Integer status, String source)
            throws ServiceException, ServiceDaoException {

        if (log.isInfoEnabled()) {
            log.info(" count ids by status,source  : " + status + " , " + source);
        }
        Integer count = null;

        try {

            count = dao.count("getArticleIdsByStatusAndSourceOrderByPublishat", new Object[] { status, source });

        } catch (DaoException e) {
            log.error(" count ids  wrong by status,source)  : " + status + " , " + source);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  success : " + count);
        }
        return count;

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

        if (log.isInfoEnabled()) {
            log.info(" count ids by source  : " + source);
        }
        Integer count = null;

        try {

            count = dao.count("getArticleIdsBySourceOrderByPublishat", new Object[] { source });

        } catch (DaoException e) {
            log.error(" count ids  wrong by source)  : " + source);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  success : " + count);
        }
        return count;

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

        if (log.isInfoEnabled()) {
            log.info(" count ids by type  : " + type);
        }
        Integer count = null;

        try {

            count = dao.count("getArticleIdsByTypeAndStatusOrderByPublishat", new Object[] { type, status });

        } catch (DaoException e) {
            log.error(" count ids  wrong by type,status)  : " + type + " , " + status);
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
    public List<Long> getArticleIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {

        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getArticleIdsAll", new Object[] {}, start, limit, false);
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
    public Integer countArticleIds() throws ServiceException, ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getArticleIdsAll", new Object[] {});
        } catch (DaoException e) {
            log.error(" count by getArticleIds ");
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  : " + count);
        }
        return count;
    }

    // @Override
    // public void savaActivityPrizeForUser(User user, Long now, Integer type) {
    // log.info(" savaActivityPrizeForUser start ... type = "+type);
    // Long userId = user.getId();
    //// 查询是否有注册的精彩活动
    // List<Long> articleIds = null;
    // try {
    // articleIds = this.getArticleIdsByTypeAndStatusOrderByPublishat
    // (Article.TYPE_3, Article.Status_Published, 0, Integer.MAX_VALUE);
    // log.info(" articleIds size = " + articleIds.size());
    // if (articleIds.size() > 0) {
    // List<Article> articles = this.getObjectsByIds(articleIds);
    // for (Article article : articles) {
    // log.info(" situation = " + article.getSituation());
    // if (Article.SITUATION_1.equals(article.getSituation())) {
    // String prize = article.getPrize();
    // log.info(" prize = " + prize);
    // JSONArray jsonArray = JSONArray.fromObject(prize);
    // log.info(" jsonArray = " + jsonArray);
    // Integer prizeSize = jsonArray.size();
    // log.info(" prizeSize = " + prizeSize);
    // for (int i = 0; i < prizeSize; i++) {
    // JSONObject jsonObject = jsonArray.getJSONObject(i);
    // if (Article.ACTIVITY_1.equals(Integer.valueOf((String)
    // jsonObject.get("type")))) {
    // //彩金
    // log.info(" user money add ");
    // //更新user的money和unCashMoney
    // BigDecimal userOldMoney = new BigDecimal(user.getMoney());
    // BigDecimal userNewMoney = userOldMoney.add(new BigDecimal((String)
    // jsonObject.get("content")));
    // user.setMoney(userNewMoney.toString());
    // log.info(" old money = " + userOldMoney + " new = " + userNewMoney);
    //
    //
    // BigDecimal unCashOldMoney = new BigDecimal(user.getUnCashMoney());
    // BigDecimal unCashNewMoney = unCashOldMoney.add(new BigDecimal((String)
    // jsonObject.get("content")));
    // user.setUnCashMoney(unCashNewMoney.toString());
    //
    // //新增记录
    // MoneyHistory moneyHistory = new MoneyHistory();
    // moneyHistory.setUserId(userId);
    // moneyHistory.setMoney((String) jsonObject.get("content"));
    // moneyHistory.setType(MoneyHistory.TYPE_8);
    // log.info(" typeReadable = " +
    // moneyHistory.getMAP_1().get(MoneyHistory.TYPE_8));
    //
    // moneyHistory.setTypeReadable(moneyHistory.getMAP_1().get(MoneyHistory.TYPE_8));
    // moneyHistory.setRechargeTime(now);
    // moneyHistory.setAccountTime(now);
    // moneyHistory.setCashMoney("0");
    // moneyHistory.setUnCashMoney((String) jsonObject.get("content"));
    // moneyHistory.setFlag(MoneyHistory.FLAG_1);
    // moneyHistory.setHappenAt(now);
    // moneyHistory.setCreateBy(userId);
    // moneyHistory.setUpdateBy(userId);
    // log.info(" moneyHistory = " + moneyHistory);
    // Long moneyHistoryId = moneyHistoryService.insert(moneyHistory);
    // log.info(" moneyHistoryId = " + moneyHistoryId);
    //
    // }
    // if (Article.ACTIVITY_2.equals(Integer.valueOf((String)
    // jsonObject.get("type")))) {
    // //体验金
    // log.info(" user score add ");
    // //更新user的score
    // BigDecimal userOldScore = new BigDecimal(user.getScore());
    // BigDecimal userNewScore = userOldScore.add(new BigDecimal((String)
    // jsonObject.get("content")));
    // user.setScore(userNewScore.toString());
    // log.info(" oldscore = " + userOldScore + " new = " + userNewScore);
    // //新增体验金记录
    // ScoreHistory scoreHistory = new ScoreHistory();
    // scoreHistory.setUserId(userId);
    // scoreHistory.setScore((String) jsonObject.get("content"));
    // scoreHistory.setType(ScoreHistory.TYPE_0);
    // log.info(" typeReadable = " +
    // scoreHistory.getMAP_1().get(ScoreHistory.TYPE_0));
    // scoreHistory.setTypeReadable(scoreHistory.getMAP_1().get(ScoreHistory.TYPE_0));
    // scoreHistory.setHappenAt(now);
    // scoreHistory.setFlag(MoneyHistory.FLAG_1);
    // scoreHistory.setCreateBy(userId);
    // scoreHistory.setUpdateBy(userId);
    // Long scoreHistoryId = scoreHistoryService.insert(scoreHistory);
    // log.info(" scoreHistoryId = " + scoreHistoryId);
    // }
    // if (Article.ACTIVITY_3.equals(Integer.valueOf((String)
    // jsonObject.get("type")))) {
    // //红包
    // log.info(" user red add ");
    // List<RedHistory> redHistories = new ArrayList<>();
    // //更新user的red
    // BigDecimal userOldRed = new BigDecimal(user.getRed());
    //
    // //新增红包记录
    //// String redList = (String) jsonObject.get("list");
    //// log.info(" redList = " + redList);
    // JSONArray jsonArray1 = (JSONArray) jsonObject.get("list");
    // log.info(" jsonArray1 = " + jsonArray1);
    // Integer redSize = jsonArray1.size();
    // log.info(" redSize = " + redSize);
    //
    // BigDecimal newAddRed = new BigDecimal("0");
    //
    //
    // for (int j = 0; j < redSize; j++) {
    // JSONObject red = jsonArray1.getJSONObject(j);
    // log.info(" red = " + red);
    // Red red1 = redService.getObjectById(Long.valueOf((String)
    // red.get("id")));
    // log.info(" red1 = " + red1);
    // //如果红包状态是上线状态，才给予用户
    //
    // if (Article.Status_Published.equals(red1.getStatus())) {
    // int count = Integer.valueOf((String) red.get("counts"));
    // for (int k = 0; k < count; k++) {
    // RedHistory redHistory = new RedHistory();
    // redHistory.setRedId(Long.valueOf((String) red.get("id")));
    // redHistory.setUserId(userId);
    // redHistory.setStatus(RedHistory.STATUS_0);
    // redHistory.setSource(RedHistory.SOURCE_2);
    // redHistory.setHappenAt(now);
    // redHistory.setStartAt(red1.getStartAt());
    // redHistory.setEndAt(red1.getEndAt());
    // redHistory.setTotal(red1.getTotal());
    // redHistory.setSubmoney(red1.getSubmoney());
    // redHistory.setName(red1.getName());
    // redHistory.setTypeReadable(red1.getTypeReadable());
    // redHistory.setCreateBy(userId);
    // redHistory.setUpdateBy(userId);
    // log.info(" red1.getSubmoney() = " + red1.getSubmoney());
    // newAddRed = newAddRed.add(new BigDecimal(red1.getSubmoney()));
    // redHistories.add(redHistory);
    // }
    //
    // }
    // log.info(" redHistories size = " + redHistories.size());
    //
    // }
    // log.info(" all redHistories size = " + redHistories.size());
    // redHistoryService.insertList(redHistories);
    // log.info(" newAddRed = " + newAddRed.toString());
    // BigDecimal userNewRed = userOldRed.add(newAddRed);
    // log.info(" newRed = " + userNewRed);
    // user.setRed(userNewRed.toString());
    //
    // }
    //
    // }
    // boolean update1 = userService.update(user);
    // log.info(" update user = " + update1);
    // break;
    // }
    // }
    // }
    // }catch(Throwable t){
    // t.printStackTrace();
    // log.error(t.getMessage());
    // log.error("add user error ");
    // }
    // }

    @Override
    public List<Long> getArticleIdsBytype(Integer type) {
        if (log.isInfoEnabled()) {
            log.info(" get ids by type  : " + type);
        }
        List<Long> idList = null;

        try {
            idList = dao.getIdList("getArticleIdsByType", new Object[] { type }, false);

        } catch (DaoException e) {
            log.error(" get ids  wrong by type,status,start,limit)  : " + type);
            log.error(e);
            e.printStackTrace();
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
        }
        return idList;
    }

}
