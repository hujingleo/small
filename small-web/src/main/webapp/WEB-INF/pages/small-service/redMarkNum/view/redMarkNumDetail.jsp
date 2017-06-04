<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="redMarkNum" id="current_nav">
	<div id="redMarkNumDetailApp" ng-app="redMarkNumDetailApp">
		<div ng-controller="redMarkNumDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="redMarkNumForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="redMarkNumId" ng-model="redMarkNum.id" ng-bind="redMarkNum.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderTaskId" class="col-sm-2 control-label">厂家任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderTaskId" ng-model="redMarkNum.venderTaskId" ng-bind="redMarkNum.venderTaskId" placeholder="请输入厂家任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberNum" class="col-sm-2 control-label">外勤数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberNum" ng-model="redMarkNum.memberNum" ng-bind="redMarkNum.memberNum" placeholder="请输入外勤数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="photoNum" class="col-sm-2 control-label">照片数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="photoNum" ng-model="redMarkNum.photoNum" ng-bind="redMarkNum.photoNum" placeholder="请输入照片数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="redMarkNum.createBy" ng-bind="redMarkNum.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="redMarkNum.updateBy" ng-bind="redMarkNum.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateRedMarkNum(redMarkNum)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/redMarkNum">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/redMarkNum/redMarkNumDetail.js"></script>
