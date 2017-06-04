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
import com.ptteng.small.pub.model.User;
import com.ptteng.small.pub.service.UserService;

public class UserServiceImpl extends BaseDaoServiceImpl implements UserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	private Dao dao;
    @Override
    public Long insert(User user) throws ServiceException, ServiceDaoException {

        log.info(" insert data : " + user);

        if (user == null) {
            return null;
        }

        long currentTimeMillis = System.currentTimeMillis();
        user.setCreateAt(currentTimeMillis);
        user.setUpdateAt(currentTimeMillis);

        Long result = null;
        try {
            result = (Long) dao.save(user);
        } catch (DaoException e) {
            log.error(" insert wrong : " + user);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" insert data success : " + result);

        return result;
    }

    @Override
    public List<User> insertList(List<User> userList) throws ServiceException, ServiceDaoException {

        log.info(" insert lists : " + (userList == null ? "null" : userList.size()));

        List<User> resultList = null;

        if (CollectionUtils.isEmpty(userList)) {
            return new ArrayList<User>();
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (User user : userList) {
            user.setCreateAt(currentTimeMillis);
            user.setUpdateAt(currentTimeMillis);
        }

        try {
            resultList = (List<User>) dao.batchSave(userList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + userList);
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
            result = dao.delete(User.class, id);
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
    public boolean update(User user) throws ServiceException, ServiceDaoException {

        log.info(" update data : " + (user == null ? "null" : user.getId()));

        boolean result = false;

        if (user == null) {
            return true;
        }

        user.setUpdateAt(System.currentTimeMillis());

        try {
            result = dao.update(user);
        } catch (DaoException e) {
            log.error(" update wrong : " + user);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + user);
        }
        return result;
    }

    @Override
    public boolean updateList(List<User> userList) throws ServiceException, ServiceDaoException {

        log.info(" update lists : " + (userList == null ? "null" : userList.size()));

        boolean result = false;

        if (CollectionUtils.isEmpty(userList)) {
            return true;
        }

        long currentTimeMillis = System.currentTimeMillis();
        for (User user : userList) {
            user.setUpdateAt(currentTimeMillis);
        }

        try {
            result = dao.batchUpdate(userList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + userList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" update lists success : " + userList.size());

        return result;
    }

    @Override
    public User getObjectById(Long id) throws ServiceException, ServiceDaoException {

        log.info(" get data : " + id);

        User user = null;

        if (id == null) {
            return user;
        }

        try {
            user = (User) dao.get(User.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + id);

        return user;
    }

    @Override
    public List<User> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {

        log.info(" get lists : " + (ids == null ? "null" : ids));

        List<User> user = null;

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<User>();
        }

        try {
            user = (List<User>) dao.getList(User.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }

        log.info(" get data success : " + (user == null ? "null" : user.size()));

        return user;
    }

   
    @Override
    public List<Long> getUserIds(Integer start, Integer limit) throws ServiceException, ServiceDaoException {

        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        try {
            idList = dao.getIdList("getUserIdsAll", new Object[] {}, start, limit, false);
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
    public Integer countUserIds() throws ServiceException, ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getUserIdsAll", new Object[] {});
        } catch (DaoException e) {
            log.error(" count by getUserIds ");
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

  

}
