<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="report" id="current_nav">
<div id="reportApp" ng-app="reportApp">
	<div ng-controller="reportController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Report管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addReport(report)">新增</span>
		    </span>
	
			<paging url="/web/a/report">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家任务id</td>
			        				                    <td>经销商id</td>
			        				                    <td>经销商简称</td>
			        				                    <td>计划开始时间</td>
			        				                    <td>进场时间（盘库开始时间）</td>
			        				                    <td>完成时间</td>
			        				                    <td>车型</td>
			        				                    <td>多个团队的id拼接的字符串(;间隔)</td>
			        				                    <td>多个团队名字拼接的字符串(;间隔)</td>
			        				                    <td>多个团队的id拼接的字符串(;间隔)</td>
			        				                    <td>多个团队名字拼接的字符串(;间隔)</td>
			        				                    <td>库位数</td>
			        				                    <td>车辆数</td>
			        				                    <td>照片数</td>
			        				                    <td>已审计次数</td>
			        				                    <td>盘库在途数</td>
			        				                    <td>盘库在库数</td>
			        				                    <td>盘库已售数</td>
			        				                    <td>盘库其他数</td>
			        				                    <td>倒查在途数</td>
			        				                    <td>倒查在库数</td>
			        				                    <td>倒查已售数</td>
			        				                    <td>倒查其他数</td>
			        				                    <td>已审计的本部数</td>
			        				                    <td>已审计的二网数</td>
			        				                    <td>已审计的临展数</td>
			        				                    <td>未报备二网</td>
			        				                    <td>本部盘库车辆数</td>
			        				                    <td>二网盘库车辆数</td>
			        				                    <td>临展盘库车辆数</td>
			        				                    <td>经销商签字</td>
			        				                    <td>初审时间</td>
			        				                    <td>终审时间</td>
			        				                    <td>审核结果</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="report in data">				
									                    <td ng-bind="report.id" ></td>
			        				                    <td ng-bind="report.venderTaskId" ></td>
			        				                    <td ng-bind="report.distributorId" ></td>
			        				                    <td ng-bind="report.distributorShortName" ></td>
			        				                    <td ng-bind="report.planBeginAt" ></td>
			        				                    <td ng-bind="report.beginAt" ></td>
			        				                    <td ng-bind="report.endAt" ></td>
			        				                    <td ng-bind="report.carType" ></td>
			        				                    <td ng-bind="report.eachTeamId" ></td>
			        				                    <td ng-bind="report.eachTeamName" ></td>
			        				                    <td ng-bind="report.eachMemberId" ></td>
			        				                    <td ng-bind="report.eachMemberName" ></td>
			        				                    <td ng-bind="report.storageNum" ></td>
			        				                    <td ng-bind="report.carNum" ></td>
			        				                    <td ng-bind="report.photoNum" ></td>
			        				                    <td ng-bind="report.auditFinishTimes" ></td>
			        				                    <td ng-bind="report.inventoryEnrouteNum" ></td>
			        				                    <td ng-bind="report.inventoryInstoreNum" ></td>
			        				                    <td ng-bind="report.inventorySaledNum" ></td>
			        				                    <td ng-bind="report.inventoryOtherNum" ></td>
			        				                    <td ng-bind="report.inspectEnrouteNum" ></td>
			        				                    <td ng-bind="report.inspectInstoreNum" ></td>
			        				                    <td ng-bind="report.inspectSaledNum" ></td>
			        				                    <td ng-bind="report.inspectOtherNum" ></td>
			        				                    <td ng-bind="report.centraStorageNum" ></td>
			        				                    <td ng-bind="report.secondStorageNum" ></td>
			        				                    <td ng-bind="report.showStorageNum" ></td>
			        				                    <td ng-bind="report.unknownSecondStorage" ></td>
			        				                    <td ng-bind="report.centraStorageCarNum" ></td>
			        				                    <td ng-bind="report.secondStorageCarNum" ></td>
			        				                    <td ng-bind="report.showStorageCarNum" ></td>
			        				                    <td ng-bind="report.distributorSignImg" ></td>
			        				                    <td ng-bind="report.firstJudgeAt" ></td>
			        				                    <td ng-bind="report.finalJudgeAt" ></td>
			        				                    <td ng-bind="report.judgeResult" ></td>
			        				                    <td ng-bind="report.createBy" ></td>
			        				                    <td ng-bind="report.updateBy" ></td>
			        				                    <td ng-bind="report.updateAt" ></td>
			        				                    <td ng-bind="report.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateReport(report.id)" /> 
							<input type="button" value="删除" ng-click="deleteReport(report.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/report/reportList.js"></script>
