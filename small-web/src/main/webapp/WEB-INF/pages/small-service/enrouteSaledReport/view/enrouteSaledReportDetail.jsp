<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="enrouteSaledReport" id="current_nav">
	<div id="enrouteSaledReportDetailApp" ng-app="enrouteSaledReportDetailApp">
		<div ng-controller="enrouteSaledReportDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="enrouteSaledReportForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="enrouteSaledReportId" ng-model="enrouteSaledReport.id" ng-bind="enrouteSaledReport.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberTaskId" class="col-sm-2 control-label">外勤任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberTaskId" ng-model="enrouteSaledReport.memberTaskId" ng-bind="enrouteSaledReport.memberTaskId" placeholder="请输入外勤任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorId" class="col-sm-2 control-label">经销商id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorId" ng-model="enrouteSaledReport.distributorId" ng-bind="enrouteSaledReport.distributorId" placeholder="请输入经销商id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorShortName" class="col-sm-2 control-label">经销商名称简称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorShortName" ng-model="enrouteSaledReport.distributorShortName" ng-bind="enrouteSaledReport.distributorShortName" placeholder="请输入经销商名称简称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="headStorageId" class="col-sm-2 control-label">本部库位id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="headStorageId" ng-model="enrouteSaledReport.headStorageId" ng-bind="enrouteSaledReport.headStorageId" placeholder="请输入本部库位id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="headStorageName" class="col-sm-2 control-label">本部库位名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="headStorageName" ng-model="enrouteSaledReport.headStorageName" ng-bind="enrouteSaledReport.headStorageName" placeholder="请输入本部库位名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="headStorageAddress" class="col-sm-2 control-label">本部库位地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="headStorageAddress" ng-model="enrouteSaledReport.headStorageAddress" ng-bind="enrouteSaledReport.headStorageAddress" placeholder="请输入本部库位地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="headStorageContactName" class="col-sm-2 control-label">本部库位联系人名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="headStorageContactName" ng-model="enrouteSaledReport.headStorageContactName" ng-bind="enrouteSaledReport.headStorageContactName" placeholder="请输入本部库位联系人名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="headStorageContactPhone" class="col-sm-2 control-label">本部库位联系人电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="headStorageContactPhone" ng-model="enrouteSaledReport.headStorageContactPhone" ng-bind="enrouteSaledReport.headStorageContactPhone" placeholder="请输入本部库位联系人电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beginAt" class="col-sm-2 control-label">进场时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beginAt" ng-model="enrouteSaledReport.beginAt" ng-bind="enrouteSaledReport.beginAt" placeholder="请输入进场时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="planBeginAt" class="col-sm-2 control-label">计划日期（年月日）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="planBeginAt" ng-model="enrouteSaledReport.planBeginAt" ng-bind="enrouteSaledReport.planBeginAt" placeholder="请输入计划日期（年月日）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="auditDirection" class="col-sm-2 control-label">审计位置的方向</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="auditDirection" ng-model="enrouteSaledReport.auditDirection" ng-bind="enrouteSaledReport.auditDirection" placeholder="请输入审计位置的方向" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="auditDistance" class="col-sm-2 control-label">审计位置的距离</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="auditDistance" ng-model="enrouteSaledReport.auditDistance" ng-bind="enrouteSaledReport.auditDistance" placeholder="请输入审计位置的距离" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="enrouteNum" class="col-sm-2 control-label">在途车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="enrouteNum" ng-model="enrouteSaledReport.enrouteNum" ng-bind="enrouteSaledReport.enrouteNum" placeholder="请输入在途车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="saledNum" class="col-sm-2 control-label">已售车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="saledNum" ng-model="enrouteSaledReport.saledNum" ng-bind="enrouteSaledReport.saledNum" placeholder="请输入已售车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachStorageId" class="col-sm-2 control-label">各个库位id拼接的字符串（包括本部）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachStorageId" ng-model="enrouteSaledReport.eachStorageId" ng-bind="enrouteSaledReport.eachStorageId" placeholder="请输入各个库位id拼接的字符串（包括本部）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachStorageNum" class="col-sm-2 control-label">各个库位车辆数拼接的字符串（包括本部），与each_storage_id一一对应</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachStorageNum" ng-model="enrouteSaledReport.eachStorageNum" ng-bind="enrouteSaledReport.eachStorageNum" placeholder="请输入各个库位车辆数拼接的字符串（包括本部），与each_storage_id一一对应" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="otherNum" class="col-sm-2 control-label">其他车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="otherNum" ng-model="enrouteSaledReport.otherNum" ng-bind="enrouteSaledReport.otherNum" placeholder="请输入其他车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态(0:未做；1：报告已上传；2：需重做)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="enrouteSaledReport.status" ng-bind="enrouteSaledReport.status" placeholder="请输入状态(0:未做；1：报告已上传；2：需重做)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="enrouteSaledReport.createBy" ng-bind="enrouteSaledReport.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="enrouteSaledReport.updateBy" ng-bind="enrouteSaledReport.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateEnrouteSaledReport(enrouteSaledReport)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/enrouteSaledReport">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/enrouteSaledReport/enrouteSaledReportDetail.js"></script>
