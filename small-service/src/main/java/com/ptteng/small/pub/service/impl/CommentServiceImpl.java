package com.ptteng.small.pub.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.small.pub.model.Comment;
import com.ptteng.small.pub.service.CommentService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CommentServiceImpl extends BaseDaoServiceImpl implements CommentService {

 
	@Autowired
	private Dao dao;
	private static final Log log = LogFactory.getLog(CommentServiceImpl.class);



		   
		@Override
		public Long insert(Comment comment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + comment);

		if (comment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		comment.setCreateAt(currentTimeMillis);
		comment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(comment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + comment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Comment> insertList(List<Comment> commentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (commentList == null ? "null" : commentList.size()));
      
		List<Comment> resultList = null;

		if (CollectionUtils.isEmpty(commentList)) {
			return new ArrayList<Comment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Comment comment : commentList) {
			comment.setCreateAt(currentTimeMillis);
			comment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Comment>) dao.batchSave(commentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + commentList);
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
			result = dao.delete(Comment.class, id);
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
		public boolean update(Comment comment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (comment == null ? "null" : comment.getId()));

		boolean result = false;

		if (comment == null) {
			return true;
		}

		comment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(comment);
		} catch (DaoException e) {
			log.error(" update wrong : " + comment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + comment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Comment> commentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (commentList == null ? "null" : commentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(commentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Comment comment : commentList) {
			comment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(commentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + commentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + commentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Comment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Comment comment = null;

		if (id == null) {
			return comment;
		}

		try {
			comment = (Comment) dao.get(Comment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return comment;		
		}	
		  
    	   
		@Override
		public List<Comment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Comment> comment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Comment>();
		}

		try {
			comment = (List<Comment>) dao.getList(Comment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (comment == null ? "null" : comment.size()));
    
		return comment;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getCommentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCommentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCommentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCommentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCommentIds " ) ;
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

