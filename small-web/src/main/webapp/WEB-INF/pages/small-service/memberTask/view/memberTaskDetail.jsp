<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="memberTask" id="current_nav">
	<div id="memberTaskDetailApp" ng-app="memberTaskDetailApp">
		<div ng-controller="memberTaskDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="memberTaskForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="memberTaskId" ng-model="memberTask.id" ng-bind="memberTask.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderTaskId" class="col-sm-2 control-label">厂家任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderTaskId" ng-model="memberTask.venderTaskId" ng-bind="memberTask.venderTaskId" placeholder="请输入厂家任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageId" class="col-sm-2 control-label">库位id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageId" ng-model="memberTask.storageId" ng-bind="memberTask.storageId" placeholder="请输入库位id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageName" class="col-sm-2 control-label">库位名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageName" ng-model="memberTask.storageName" ng-bind="memberTask.storageName" placeholder="请输入库位名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageProvince" class="col-sm-2 control-label">库位的省</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageProvince" ng-model="memberTask.storageProvince" ng-bind="memberTask.storageProvince" placeholder="请输入库位的省" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageCity" class="col-sm-2 control-label">库位的市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageCity" ng-model="memberTask.storageCity" ng-bind="memberTask.storageCity" placeholder="请输入库位的市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageAddress" class="col-sm-2 control-label">库位的详细地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageAddress" ng-model="memberTask.storageAddress" ng-bind="memberTask.storageAddress" placeholder="请输入库位的详细地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberId" class="col-sm-2 control-label">外勤id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberId" ng-model="memberTask.memberId" ng-bind="memberTask.memberId" placeholder="请输入外勤id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberName" class="col-sm-2 control-label">外勤名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberName" ng-model="memberTask.memberName" ng-bind="memberTask.memberName" placeholder="请输入外勤名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beginAt" class="col-sm-2 control-label">进场时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beginAt" ng-model="memberTask.beginAt" ng-bind="memberTask.beginAt" placeholder="请输入进场时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="planBeginAt" class="col-sm-2 control-label">计划日期（年月日）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="planBeginAt" ng-model="memberTask.planBeginAt" ng-bind="memberTask.planBeginAt" placeholder="请输入计划日期（年月日）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">外勤任务状态（-1：已取消；0：未开始；1：执行中；2：已重开；3：已完成；4：已通过；5：已关闭）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="memberTask.status" ng-bind="memberTask.status" placeholder="请输入外勤任务状态（-1：已取消；0：未开始；1：执行中；2：已重开；3：已完成；4：已通过；5：已关闭）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="isWithdraw" class="col-sm-2 control-label">是否被撤回</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="isWithdraw" ng-model="memberTask.isWithdraw" ng-bind="memberTask.isWithdraw" placeholder="请输入是否被撤回" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="withdrawAt" class="col-sm-2 control-label">撤回的时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="withdrawAt" ng-model="memberTask.withdrawAt" ng-bind="memberTask.withdrawAt" placeholder="请输入撤回的时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="withdrawTime" class="col-sm-2 control-label">撤回的次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="withdrawTime" ng-model="memberTask.withdrawTime" ng-bind="memberTask.withdrawTime" placeholder="请输入撤回的次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="withdrawCause" class="col-sm-2 control-label">撤回的原因</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="withdrawCause" ng-model="memberTask.withdrawCause" ng-bind="memberTask.withdrawCause" placeholder="请输入撤回的原因" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="nextMemberTaskId" class="col-sm-2 control-label">接手已撤回的外勤任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="nextMemberTaskId" ng-model="memberTask.nextMemberTaskId" ng-bind="memberTask.nextMemberTaskId" placeholder="请输入接手已撤回的外勤任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">分配者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="memberTask.createBy" ng-bind="memberTask.createBy" placeholder="请输入分配者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="memberTask.updateBy" ng-bind="memberTask.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateMemberTask(memberTask)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/memberTask">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/memberTask/memberTaskDetail.js"></script>
