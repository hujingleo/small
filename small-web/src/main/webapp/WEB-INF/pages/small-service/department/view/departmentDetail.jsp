<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="department" id="current_nav">
	<div id="departmentDetailApp" ng-app="departmentDetailApp">
		<div ng-controller="departmentDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="departmentForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="departmentId" ng-model="department.id" ng-bind="department.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">部门名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="department.name" ng-bind="department.name" placeholder="请输入部门名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态 (1正常0禁用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="department.status" ng-bind="department.status" placeholder="请输入状态 (1正常0禁用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyId" class="col-sm-2 control-label">公司ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyId" ng-model="department.companyId" ng-bind="department.companyId" placeholder="请输入公司ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDepartment(department)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/department">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/department/departmentDetail.js"></script>
