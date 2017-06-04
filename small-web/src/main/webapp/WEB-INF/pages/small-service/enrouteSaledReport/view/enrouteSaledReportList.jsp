<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="enrouteSaledReport" id="current_nav">
<div id="enrouteSaledReportApp" ng-app="enrouteSaledReportApp">
	<div ng-controller="enrouteSaledReportController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>EnrouteSaledReport管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addEnrouteSaledReport(enrouteSaledReport)">新增</span>
		    </span>
	
			<paging url="/web/a/enrouteSaledReport">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>外勤任务id</td>
			        				                    <td>经销商id</td>
			        				                    <td>经销商名称简称</td>
			        				                    <td>本部库位id</td>
			        				                    <td>本部库位名字</td>
			        				                    <td>本部库位地址</td>
			        				                    <td>本部库位联系人名字</td>
			        				                    <td>本部库位联系人电话</td>
			        				                    <td>进场时间</td>
			        				                    <td>计划日期（年月日）</td>
			        				                    <td>审计位置的方向</td>
			        				                    <td>审计位置的距离</td>
			        				                    <td>在途车辆数</td>
			        				                    <td>已售车辆数</td>
			        				                    <td>各个库位id拼接的字符串（包括本部）</td>
			        				                    <td>各个库位车辆数拼接的字符串（包括本部），与each_storage_id一一对应</td>
			        				                    <td>其他车辆数</td>
			        				                    <td>状态(0:未做；1：报告已上传；2：需重做)</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="enrouteSaledReport in data">				
									                    <td ng-bind="enrouteSaledReport.id" ></td>
			        				                    <td ng-bind="enrouteSaledReport.memberTaskId" ></td>
			        				                    <td ng-bind="enrouteSaledReport.distributorId" ></td>
			        				                    <td ng-bind="enrouteSaledReport.distributorShortName" ></td>
			        				                    <td ng-bind="enrouteSaledReport.headStorageId" ></td>
			        				                    <td ng-bind="enrouteSaledReport.headStorageName" ></td>
			        				                    <td ng-bind="enrouteSaledReport.headStorageAddress" ></td>
			        				                    <td ng-bind="enrouteSaledReport.headStorageContactName" ></td>
			        				                    <td ng-bind="enrouteSaledReport.headStorageContactPhone" ></td>
			        				                    <td ng-bind="enrouteSaledReport.beginAt" ></td>
			        				                    <td ng-bind="enrouteSaledReport.planBeginAt" ></td>
			        				                    <td ng-bind="enrouteSaledReport.auditDirection" ></td>
			        				                    <td ng-bind="enrouteSaledReport.auditDistance" ></td>
			        				                    <td ng-bind="enrouteSaledReport.enrouteNum" ></td>
			        				                    <td ng-bind="enrouteSaledReport.saledNum" ></td>
			        				                    <td ng-bind="enrouteSaledReport.eachStorageId" ></td>
			        				                    <td ng-bind="enrouteSaledReport.eachStorageNum" ></td>
			        				                    <td ng-bind="enrouteSaledReport.otherNum" ></td>
			        				                    <td ng-bind="enrouteSaledReport.status" ></td>
			        				                    <td ng-bind="enrouteSaledReport.createAt" ></td>
			        				                    <td ng-bind="enrouteSaledReport.updateAt" ></td>
			        				                    <td ng-bind="enrouteSaledReport.createBy" ></td>
			        				                    <td ng-bind="enrouteSaledReport.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateEnrouteSaledReport(enrouteSaledReport.id)" /> 
							<input type="button" value="删除" ng-click="deleteEnrouteSaledReport(enrouteSaledReport.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/enrouteSaledReport/enrouteSaledReportList.js"></script>
