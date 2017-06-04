<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="report" id="current_nav">
	<div id="reportDetailApp" ng-app="reportDetailApp">
		<div ng-controller="reportDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="reportForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="reportId" ng-model="report.id" ng-bind="report.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderTaskId" class="col-sm-2 control-label">厂家任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderTaskId" ng-model="report.venderTaskId" ng-bind="report.venderTaskId" placeholder="请输入厂家任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorId" class="col-sm-2 control-label">经销商id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorId" ng-model="report.distributorId" ng-bind="report.distributorId" placeholder="请输入经销商id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorShortName" class="col-sm-2 control-label">经销商简称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorShortName" ng-model="report.distributorShortName" ng-bind="report.distributorShortName" placeholder="请输入经销商简称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="planBeginAt" class="col-sm-2 control-label">计划开始时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="planBeginAt" ng-model="report.planBeginAt" ng-bind="report.planBeginAt" placeholder="请输入计划开始时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beginAt" class="col-sm-2 control-label">进场时间（盘库开始时间）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beginAt" ng-model="report.beginAt" ng-bind="report.beginAt" placeholder="请输入进场时间（盘库开始时间）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="endAt" class="col-sm-2 control-label">完成时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="endAt" ng-model="report.endAt" ng-bind="report.endAt" placeholder="请输入完成时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="carType" class="col-sm-2 control-label">车型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="carType" ng-model="report.carType" ng-bind="report.carType" placeholder="请输入车型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachTeamId" class="col-sm-2 control-label">多个团队的id拼接的字符串(;间隔)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachTeamId" ng-model="report.eachTeamId" ng-bind="report.eachTeamId" placeholder="请输入多个团队的id拼接的字符串(;间隔)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachTeamName" class="col-sm-2 control-label">多个团队名字拼接的字符串(;间隔)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachTeamName" ng-model="report.eachTeamName" ng-bind="report.eachTeamName" placeholder="请输入多个团队名字拼接的字符串(;间隔)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachMemberId" class="col-sm-2 control-label">多个团队的id拼接的字符串(;间隔)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachMemberId" ng-model="report.eachMemberId" ng-bind="report.eachMemberId" placeholder="请输入多个团队的id拼接的字符串(;间隔)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="eachMemberName" class="col-sm-2 control-label">多个团队名字拼接的字符串(;间隔)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="eachMemberName" ng-model="report.eachMemberName" ng-bind="report.eachMemberName" placeholder="请输入多个团队名字拼接的字符串(;间隔)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="storageNum" class="col-sm-2 control-label">库位数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="storageNum" ng-model="report.storageNum" ng-bind="report.storageNum" placeholder="请输入库位数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="carNum" class="col-sm-2 control-label">车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="carNum" ng-model="report.carNum" ng-bind="report.carNum" placeholder="请输入车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="photoNum" class="col-sm-2 control-label">照片数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="photoNum" ng-model="report.photoNum" ng-bind="report.photoNum" placeholder="请输入照片数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="auditFinishTimes" class="col-sm-2 control-label">已审计次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="auditFinishTimes" ng-model="report.auditFinishTimes" ng-bind="report.auditFinishTimes" placeholder="请输入已审计次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventoryEnrouteNum" class="col-sm-2 control-label">盘库在途数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventoryEnrouteNum" ng-model="report.inventoryEnrouteNum" ng-bind="report.inventoryEnrouteNum" placeholder="请输入盘库在途数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventoryInstoreNum" class="col-sm-2 control-label">盘库在库数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventoryInstoreNum" ng-model="report.inventoryInstoreNum" ng-bind="report.inventoryInstoreNum" placeholder="请输入盘库在库数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventorySaledNum" class="col-sm-2 control-label">盘库已售数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventorySaledNum" ng-model="report.inventorySaledNum" ng-bind="report.inventorySaledNum" placeholder="请输入盘库已售数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inventoryOtherNum" class="col-sm-2 control-label">盘库其他数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inventoryOtherNum" ng-model="report.inventoryOtherNum" ng-bind="report.inventoryOtherNum" placeholder="请输入盘库其他数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectEnrouteNum" class="col-sm-2 control-label">倒查在途数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectEnrouteNum" ng-model="report.inspectEnrouteNum" ng-bind="report.inspectEnrouteNum" placeholder="请输入倒查在途数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectInstoreNum" class="col-sm-2 control-label">倒查在库数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectInstoreNum" ng-model="report.inspectInstoreNum" ng-bind="report.inspectInstoreNum" placeholder="请输入倒查在库数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectSaledNum" class="col-sm-2 control-label">倒查已售数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectSaledNum" ng-model="report.inspectSaledNum" ng-bind="report.inspectSaledNum" placeholder="请输入倒查已售数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inspectOtherNum" class="col-sm-2 control-label">倒查其他数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inspectOtherNum" ng-model="report.inspectOtherNum" ng-bind="report.inspectOtherNum" placeholder="请输入倒查其他数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="centraStorageNum" class="col-sm-2 control-label">已审计的本部数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="centraStorageNum" ng-model="report.centraStorageNum" ng-bind="report.centraStorageNum" placeholder="请输入已审计的本部数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="secondStorageNum" class="col-sm-2 control-label">已审计的二网数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="secondStorageNum" ng-model="report.secondStorageNum" ng-bind="report.secondStorageNum" placeholder="请输入已审计的二网数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="showStorageNum" class="col-sm-2 control-label">已审计的临展数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="showStorageNum" ng-model="report.showStorageNum" ng-bind="report.showStorageNum" placeholder="请输入已审计的临展数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="unknownSecondStorage" class="col-sm-2 control-label">未报备二网</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="unknownSecondStorage" ng-model="report.unknownSecondStorage" ng-bind="report.unknownSecondStorage" placeholder="请输入未报备二网" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="centraStorageCarNum" class="col-sm-2 control-label">本部盘库车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="centraStorageCarNum" ng-model="report.centraStorageCarNum" ng-bind="report.centraStorageCarNum" placeholder="请输入本部盘库车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="secondStorageCarNum" class="col-sm-2 control-label">二网盘库车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="secondStorageCarNum" ng-model="report.secondStorageCarNum" ng-bind="report.secondStorageCarNum" placeholder="请输入二网盘库车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="showStorageCarNum" class="col-sm-2 control-label">临展盘库车辆数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="showStorageCarNum" ng-model="report.showStorageCarNum" ng-bind="report.showStorageCarNum" placeholder="请输入临展盘库车辆数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributorSignImg" class="col-sm-2 control-label">经销商签字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributorSignImg" ng-model="report.distributorSignImg" ng-bind="report.distributorSignImg" placeholder="请输入经销商签字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="firstJudgeAt" class="col-sm-2 control-label">初审时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="firstJudgeAt" ng-model="report.firstJudgeAt" ng-bind="report.firstJudgeAt" placeholder="请输入初审时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="finalJudgeAt" class="col-sm-2 control-label">终审时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="finalJudgeAt" ng-model="report.finalJudgeAt" ng-bind="report.finalJudgeAt" placeholder="请输入终审时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="judgeResult" class="col-sm-2 control-label">审核结果</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="judgeResult" ng-model="report.judgeResult" ng-bind="report.judgeResult" placeholder="请输入审核结果" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="report.createBy" ng-bind="report.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="report.updateBy" ng-bind="report.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateReport(report)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/report">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/report/reportDetail.js"></script>
