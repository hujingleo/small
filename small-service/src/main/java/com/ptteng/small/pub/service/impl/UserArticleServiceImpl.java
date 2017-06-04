package com.ptteng.small.pub.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.UserArticle;
import com.ptteng.small.pub.service.UserArticleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class UserArticleServiceImpl extends BaseDaoServiceImpl implements UserArticleService {

 

	private static final Log log = LogFactory.getLog(UserArticleServiceImpl.class);


	@Autowired
	private Dao dao;
		   
		@Override
		public Long insert(UserArticle userArticle)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userArticle);

		if (userArticle == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		userArticle.setCreateAt(currentTimeMillis);
		userArticle.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(userArticle);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userArticle);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserArticle> insertList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userArticleList == null ? "null" : userArticleList.size()));
      
		List<UserArticle> resultList = null;

		if (CollectionUtils.isEmpty(userArticleList)) {
			return new ArrayList<UserArticle>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticle userArticle : userArticleList) {
			userArticle.setCreateAt(currentTimeMillis);
			userArticle.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UserArticle>) dao.batchSave(userArticleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userArticleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(UserArticle.class, id);
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
		public boolean update(UserArticle userArticle)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userArticle == null ? "null" : userArticle.getId()));

		boolean result = false;

		if (userArticle == null) {
			return true;
		}

		userArticle.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(userArticle);
		} catch (DaoException e) {
			log.error(" update wrong : " + userArticle);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userArticle);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userArticleList == null ? "null" : userArticleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userArticleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticle userArticle : userArticleList) {
			userArticle.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userArticleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userArticleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userArticleList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserArticle getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserArticle userArticle = null;

		if (id == null) {
			return userArticle;
		}

		try {
			userArticle = (UserArticle) dao.get(UserArticle.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userArticle;		
		}	
		  
    	   
		@Override
		public List<UserArticle> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserArticle> userArticle = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserArticle>();
		}

		try {
			userArticle = (List<UserArticle>) dao.getList(UserArticle.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userArticle == null ? "null" : userArticle.size()));
    
		return userArticle;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserArticleIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserArticleIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserArticleIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserArticleIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserArticleIds " ) ;
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

