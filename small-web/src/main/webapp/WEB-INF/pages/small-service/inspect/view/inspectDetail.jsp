<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="inspect" id="current_nav">
	<div id="inspectDetailApp" ng-app="inspectDetailApp">
		<div ng-controller="inspectDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="inspectForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="inspectId" ng-model="inspect.id" ng-bind="inspect.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderTaskId" class="col-sm-2 control-label">厂家任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderTaskId" ng-model="inspect.venderTaskId" ng-bind="inspect.venderTaskId" placeholder="请输入厂家任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberTaskId" class="col-sm-2 control-label">外勤任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberTaskId" ng-model="inspect.memberTaskId" ng-bind="inspect.memberTaskId" placeholder="请输入外勤任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorName" class="col-sm-2 control-label">经销商名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorName" ng-model="inspect.distributorName" ng-bind="inspect.distributorName" placeholder="请输入经销商名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="vinNo" class="col-sm-2 control-label">车辆vin码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="vinNo" ng-model="inspect.vinNo" ng-bind="inspect.vinNo" placeholder="请输入车辆vin码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="settlementDate" class="col-sm-2 control-label">还款日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="settlementDate" ng-model="inspect.settlementDate" ng-bind="inspect.settlementDate" placeholder="请输入还款日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="auditResult" class="col-sm-2 control-label">审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="auditResult" ng-model="inspect.auditResult" ng-bind="inspect.auditResult" placeholder="请输入审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="removeStorageAt" class="col-sm-2 control-label">出库日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="removeStorageAt" ng-model="inspect.removeStorageAt" ng-bind="inspect.removeStorageAt" placeholder="请输入出库日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="comment" class="col-sm-2 control-label">备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="comment" ng-model="inspect.comment" ng-bind="inspect.comment" placeholder="请输入备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="removeStorageImg" class="col-sm-2 control-label">出库单图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="removeStorageImg" ng-model="inspect.removeStorageImg" ng-bind="inspect.removeStorageImg" placeholder="请输入出库单图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="qualifiedImg" class="col-sm-2 control-label">合格证通知图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="qualifiedImg" ng-model="inspect.qualifiedImg" ng-bind="inspect.qualifiedImg" placeholder="请输入合格证通知图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="otherImg" class="col-sm-2 control-label">其他图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="otherImg" ng-model="inspect.otherImg" ng-bind="inspect.otherImg" placeholder="请输入其他图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态（0：未做；1：已上传；2：需重做）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="inspect.status" ng-bind="inspect.status" placeholder="请输入状态（0：未做；1：已上传；2：需重做）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="inspect.createBy" ng-bind="inspect.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="inspect.updateBy" ng-bind="inspect.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateInspect(inspect)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/inspect">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/inspect/inspectDetail.js"></script>
