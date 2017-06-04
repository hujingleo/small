<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="inventory" id="current_nav">
	<div id="inventoryDetailApp" ng-app="inventoryDetailApp">
		<div ng-controller="inventoryDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="inventoryForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="inventoryId" ng-model="inventory.id" ng-bind="inventory.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderTaskId" class="col-sm-2 control-label">厂家任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderTaskId" ng-model="inventory.venderTaskId" ng-bind="inventory.venderTaskId" placeholder="请输入厂家任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberTaskId" class="col-sm-2 control-label">外勤任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberTaskId" ng-model="inventory.memberTaskId" ng-bind="inventory.memberTaskId" placeholder="请输入外勤任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorName" class="col-sm-2 control-label">经销商名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorName" ng-model="inventory.distributorName" ng-bind="inventory.distributorName" placeholder="请输入经销商名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="vinNo" class="col-sm-2 control-label">车辆vin码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="vinNo" ng-model="inventory.vinNo" ng-bind="inventory.vinNo" placeholder="请输入车辆vin码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="unitNo" class="col-sm-2 control-label">车辆编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="unitNo" ng-model="inventory.unitNo" ng-bind="inventory.unitNo" placeholder="请输入车辆编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="make" class="col-sm-2 control-label">车型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="make" ng-model="inventory.make" ng-bind="inventory.make" placeholder="请输入车型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="assetCond" class="col-sm-2 control-label">新车/二手车</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="assetCond" ng-model="inventory.assetCond" ng-bind="inventory.assetCond" placeholder="请输入新车/二手车" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="auditResult" class="col-sm-2 control-label">审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="auditResult" ng-model="inventory.auditResult" ng-bind="inventory.auditResult" placeholder="请输入审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="mileage" class="col-sm-2 control-label">里程数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="mileage" ng-model="inventory.mileage" ng-bind="inventory.mileage" placeholder="请输入里程数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="color" class="col-sm-2 control-label">车的颜色</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="color" ng-model="inventory.color" ng-bind="inventory.color" placeholder="请输入车的颜色" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="comment" class="col-sm-2 control-label">备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="comment" ng-model="inventory.comment" ng-bind="inventory.comment" placeholder="请输入备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="vinNoImg" class="col-sm-2 control-label">vin码图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="vinNoImg" ng-model="inventory.vinNoImg" ng-bind="inventory.vinNoImg" placeholder="请输入vin码图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="mileageImg" class="col-sm-2 control-label">里程图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="mileageImg" ng-model="inventory.mileageImg" ng-bind="inventory.mileageImg" placeholder="请输入里程图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="nameplateImg" class="col-sm-2 control-label">铭牌图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="nameplateImg" ng-model="inventory.nameplateImg" ng-bind="inventory.nameplateImg" placeholder="请输入铭牌图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="carImg" class="col-sm-2 control-label">整车图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="carImg" ng-model="inventory.carImg" ng-bind="inventory.carImg" placeholder="请输入整车图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="otherImg" class="col-sm-2 control-label">其他图</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="otherImg" ng-model="inventory.otherImg" ng-bind="inventory.otherImg" placeholder="请输入其他图" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态（0：未做；1：已上传；2：需重做）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="inventory.status" ng-bind="inventory.status" placeholder="请输入状态（0：未做；1：已上传；2：需重做）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="inventory.createBy" ng-bind="inventory.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="inventory.updateBy" ng-bind="inventory.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateInventory(inventory)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/inventory">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/inventory/inventoryDetail.js"></script>
