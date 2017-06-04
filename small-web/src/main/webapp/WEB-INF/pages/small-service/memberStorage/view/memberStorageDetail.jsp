<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="memberStorage" id="current_nav">
	<div id="memberStorageDetailApp" ng-app="memberStorageDetailApp">
		<div ng-controller="memberStorageDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="memberStorageForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="memberStorageId" ng-model="memberStorage.id" ng-bind="memberStorage.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberTaskId" class="col-sm-2 control-label">外勤任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberTaskId" ng-model="memberStorage.memberTaskId" ng-bind="memberStorage.memberTaskId" placeholder="请输入外勤任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberStorageImg" class="col-sm-2 control-label">人库合影图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberStorageImg" ng-model="memberStorage.memberStorageImg" ng-bind="memberStorage.memberStorageImg" placeholder="请输入人库合影图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="keyImg" class="col-sm-2 control-label">车辆钥匙图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="keyImg" ng-model="memberStorage.keyImg" ng-bind="memberStorage.keyImg" placeholder="请输入车辆钥匙图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="keyImg" class="col-sm-2 control-label">其他图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="keyImg" ng-model="memberStorage.keyImg" ng-bind="memberStorage.keyImg" placeholder="请输入其他图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageId" class="col-sm-2 control-label">库位id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageId" ng-model="memberStorage.storageId" ng-bind="memberStorage.storageId" placeholder="请输入库位id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageName" class="col-sm-2 control-label">库位名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageName" ng-model="memberStorage.storageName" ng-bind="memberStorage.storageName" placeholder="请输入库位名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态（0：未做；1：已上传；2：需重做）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="memberStorage.status" ng-bind="memberStorage.status" placeholder="请输入状态（0：未做；1：已上传；2：需重做）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="memberStorage.createBy" ng-bind="memberStorage.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="memberStorage.updateBy" ng-bind="memberStorage.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateMemberStorage(memberStorage)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/memberStorage">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/memberStorage/memberStorageDetail.js"></script>
