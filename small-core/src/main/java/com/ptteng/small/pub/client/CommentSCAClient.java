/**
 * 
 */
package com.ptteng.small.pub.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.small.pub.model.Comment;
import com.ptteng.small.pub.service.CommentService;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Reference;

public class CommentSCAClient implements CommentService {

    private CommentService commentService;

	public CommentService getCommentService() {
		return commentService;
	}
	
	@Reference
	public void setCommentService(CommentService commentService) {
		this.commentService =commentService;
	}
	
	
			   
		@Override
		public Long insert(Comment comment)throws ServiceException, ServiceDaoException{
		
		return commentService.insert(comment);
		          
		
		}	
		  
    	   
		@Override
		public List<Comment> insertList(List<Comment> commentList)throws ServiceException, ServiceDaoException{
		
		return commentService.insertList(commentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return commentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Comment comment)throws ServiceException, ServiceDaoException{
		
		return commentService.update(comment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Comment> commentList)throws ServiceException, ServiceDaoException{
		
		return commentService.updateList(commentList);
		          
		
		}	
		  
    	   
		@Override
		public Comment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return commentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Comment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return commentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getCommentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commentService.getCommentIds(start, limit);
	}

	@Override
	public Integer countCommentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commentService.countCommentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return commentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   commentService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.commentService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

