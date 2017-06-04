package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.UserArticle;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserArticleService extends BaseDaoService {

	



   		   
		
		public Long insert(UserArticle userArticle)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticle> insertList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserArticle userArticle)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserArticle getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticle> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserArticleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserArticleIds() throws ServiceException, ServiceDaoException;
	

}

