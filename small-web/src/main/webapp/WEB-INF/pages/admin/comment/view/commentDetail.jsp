<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="comment" id="current_nav">
	<div id="commentDetailApp" ng-app="commentDetailApp">
		<div ng-controller="commentDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="commentForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="commentId" ng-model="comment.id" ng-bind="comment.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="openId" class="col-sm-2 control-label">用户id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="openId" ng-model="comment.openId" ng-bind="comment.openId" placeholder="请输入用户id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="comment.content" ng-bind="comment.content" placeholder="请输入内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updatAt" class="col-sm-2 control-label">数据更新时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updatAt" ng-model="comment.updatAt" ng-bind="comment.updatAt" placeholder="请输入数据更新时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateComment(comment)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/comment">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/small-pub-service/comment/commentDetail.js"></script>
