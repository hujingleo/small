<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="venderTask" id="current_nav">
	<div id="venderTaskDetailApp" ng-app="venderTaskDetailApp">
		<div ng-controller="venderTaskDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="venderTaskForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="venderTaskId" ng-model="venderTask.id" ng-bind="venderTask.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderId" class="col-sm-2 control-label">厂家id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderId" ng-model="venderTask.venderId" ng-bind="venderTask.venderId" placeholder="请输入厂家id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderName" class="col-sm-2 control-label">厂家名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderName" ng-model="venderTask.venderName" ng-bind="venderTask.venderName" placeholder="请输入厂家名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorId" class="col-sm-2 control-label">经销商id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorId" ng-model="venderTask.distributorId" ng-bind="venderTask.distributorId" placeholder="请输入经销商id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorProvince" class="col-sm-2 control-label">经销商的省</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorProvince" ng-model="venderTask.distributorProvince" ng-bind="venderTask.distributorProvince" placeholder="请输入经销商的省" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorCity" class="col-sm-2 control-label">经销商的市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorCity" ng-model="venderTask.distributorCity" ng-bind="venderTask.distributorCity" placeholder="请输入经销商的市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorShortName" class="col-sm-2 control-label">经销商名称简称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorShortName" ng-model="venderTask.distributorShortName" ng-bind="venderTask.distributorShortName" placeholder="请输入经销商名称简称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorName" class="col-sm-2 control-label">经销商名称全称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorName" ng-model="venderTask.distributorName" ng-bind="venderTask.distributorName" placeholder="请输入经销商名称全称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachTeamId" class="col-sm-2 control-label">多个团队的id拼接的字符串</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachTeamId" ng-model="venderTask.eachTeamId" ng-bind="venderTask.eachTeamId" placeholder="请输入多个团队的id拼接的字符串" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachTeamName" class="col-sm-2 control-label">多个团队的名字拼接的字符串，与team_ids一一对应</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachTeamName" ng-model="venderTask.eachTeamName" ng-bind="venderTask.eachTeamName" placeholder="请输入多个团队的名字拼接的字符串，与team_ids一一对应" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="planBeginAt" class="col-sm-2 control-label">计划日期（年月日）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="planBeginAt" ng-model="venderTask.planBeginAt" ng-bind="venderTask.planBeginAt" placeholder="请输入计划日期（年月日）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beginAt" class="col-sm-2 control-label">进场时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beginAt" ng-model="venderTask.beginAt" ng-bind="venderTask.beginAt" placeholder="请输入进场时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="endAt" class="col-sm-2 control-label">完成时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="endAt" ng-model="venderTask.endAt" ng-bind="venderTask.endAt" placeholder="请输入完成时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventoryNum" class="col-sm-2 control-label">盘库数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventoryNum" ng-model="venderTask.inventoryNum" ng-bind="venderTask.inventoryNum" placeholder="请输入盘库数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectNum" class="col-sm-2 control-label">倒查数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectNum" ng-model="venderTask.inspectNum" ng-bind="venderTask.inspectNum" placeholder="请输入倒查数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventoryTotalNum" class="col-sm-2 control-label">盘库总数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventoryTotalNum" ng-model="venderTask.inventoryTotalNum" ng-bind="venderTask.inventoryTotalNum" placeholder="请输入盘库总数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectTotalNum" class="col-sm-2 control-label">倒查总数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectTotalNum" ng-model="venderTask.inspectTotalNum" ng-bind="venderTask.inspectTotalNum" placeholder="请输入倒查总数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributeNum" class="col-sm-2 control-label">分配数，分配了几个外勤任务</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributeNum" ng-model="venderTask.distributeNum" ng-bind="venderTask.distributeNum" placeholder="请输入分配数，分配了几个外勤任务" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="completeNum" class="col-sm-2 control-label">完成数，分配的外勤任务中已完成了几个</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="completeNum" ng-model="venderTask.completeNum" ng-bind="venderTask.completeNum" placeholder="请输入完成数，分配的外勤任务中已完成了几个" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">厂家任务状态（-1：已取消；0：未分配；1：未开始；2：执行中；3：已重开；4：已完成；5：已关闭）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="venderTask.status" ng-bind="venderTask.status" placeholder="请输入厂家任务状态（-1：已取消；0：未分配；1：未开始；2：执行中；3：已重开；4：已完成；5：已关闭）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="venderTask.createBy" ng-bind="venderTask.createBy" placeholder="请输入创建者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributeAt" class="col-sm-2 control-label">分配时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributeAt" ng-model="venderTask.distributeAt" ng-bind="venderTask.distributeAt" placeholder="请输入分配时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributeBy" class="col-sm-2 control-label">分配者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributeBy" ng-model="venderTask.distributeBy" ng-bind="venderTask.distributeBy" placeholder="请输入分配者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="closeAt" class="col-sm-2 control-label">关闭时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="closeAt" ng-model="venderTask.closeAt" ng-bind="venderTask.closeAt" placeholder="请输入关闭时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="closeBy" class="col-sm-2 control-label">关闭者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="closeBy" ng-model="venderTask.closeBy" ng-bind="venderTask.closeBy" placeholder="请输入关闭者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="venderTask.updateBy" ng-bind="venderTask.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateVenderTask(venderTask)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/venderTask">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/venderTask/venderTaskDetail.js"></script>
