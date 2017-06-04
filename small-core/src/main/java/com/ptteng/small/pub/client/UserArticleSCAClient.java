/**
 * 
 */
package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.UserArticle;
import com.ptteng.small.pub.service.UserArticleService;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Reference;

public class UserArticleSCAClient implements UserArticleService {

    private UserArticleService userArticleService;

	public UserArticleService getUserArticleService() {
		return userArticleService;
	}
	
	@Reference
	public void setUserArticleService(UserArticleService userArticleService) {
		this.userArticleService =userArticleService;
	}
	
	
			   
		@Override
		public Long insert(UserArticle userArticle)throws ServiceException, ServiceDaoException{
		
		return userArticleService.insert(userArticle);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticle> insertList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException{
		
		return userArticleService.insertList(userArticleList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserArticle userArticle)throws ServiceException, ServiceDaoException{
		
		return userArticleService.update(userArticle);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticle> userArticleList)throws ServiceException, ServiceDaoException{
		
		return userArticleService.updateList(userArticleList);
		          
		
		}	
		  
    	   
		@Override
		public UserArticle getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticle> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userArticleService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getUserArticleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleService.getUserArticleIds(start, limit);
	}

	@Override
	public Integer countUserArticleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleService.countUserArticleIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userArticleService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userArticleService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

