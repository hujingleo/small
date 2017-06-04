<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="userArticle" id="current_nav">
	<div id="userArticleDetailApp" ng-app="userArticleDetailApp">
		<div ng-controller="userArticleDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userArticleForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userArticleId" ng-model="userArticle.id" ng-bind="userArticle.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="articleId" class="col-sm-2 control-label">文章id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="articleId" ng-model="userArticle.articleId" ng-bind="userArticle.articleId" placeholder="请输入文章id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="openId" class="col-sm-2 control-label">用户id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="openId" ng-model="userArticle.openId" ng-bind="userArticle.openId" placeholder="请输入用户id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updatAt" class="col-sm-2 control-label">数据更新时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updatAt" ng-model="userArticle.updatAt" ng-bind="userArticle.updatAt" placeholder="请输入数据更新时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserArticle(userArticle)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userArticle">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/small-pub-service/userArticle/userArticleDetail.js"></script>
