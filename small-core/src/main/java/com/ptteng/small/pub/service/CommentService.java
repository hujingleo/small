package com.ptteng.small.pub.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.small.pub.model.Comment;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface CommentService extends BaseDaoService {

	



   		   
		
		public Long insert(Comment comment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Comment> insertList(List<Comment> commentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Comment comment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Comment> commentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Comment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Comment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getCommentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countCommentIds() throws ServiceException, ServiceDaoException;
	

}

