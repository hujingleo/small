<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="venderTask" id="current_nav">
<div id="venderTaskApp" ng-app="venderTaskApp">
	<div ng-controller="venderTaskController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>VenderTask管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addVenderTask(venderTask)">新增</span>
		    </span>
	
			<paging url="/web/a/venderTask">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家id</td>
			        				                    <td>厂家名称</td>
			        				                    <td>经销商id</td>
			        				                    <td>经销商的省</td>
			        				                    <td>经销商的市</td>
			        				                    <td>经销商名称简称</td>
			        				                    <td>经销商名称全称</td>
			        				                    <td>多个团队的id拼接的字符串</td>
			        				                    <td>多个团队的名字拼接的字符串，与team_ids一一对应</td>
			        				                    <td>计划日期（年月日）</td>
			        				                    <td>进场时间</td>
			        				                    <td>完成时间</td>
			        				                    <td>盘库数</td>
			        				                    <td>倒查数</td>
			        				                    <td>盘库总数</td>
			        				                    <td>倒查总数</td>
			        				                    <td>分配数，分配了几个外勤任务</td>
			        				                    <td>完成数，分配的外勤任务中已完成了几个</td>
			        				                    <td>厂家任务状态（-1：已取消；0：未分配；1：未开始；2：执行中；3：已重开；4：已完成；5：已关闭）</td>
			        				                    <td>创建时间</td>
			        				                    <td>创建者</td>
			        				                    <td>分配时间</td>
			        				                    <td>分配者</td>
			        				                    <td>关闭时间</td>
			        				                    <td>关闭者</td>
			        				                    <td>更新时间</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="venderTask in data">				
									                    <td ng-bind="venderTask.id" ></td>
			        				                    <td ng-bind="venderTask.venderId" ></td>
			        				                    <td ng-bind="venderTask.venderName" ></td>
			        				                    <td ng-bind="venderTask.distributorId" ></td>
			        				                    <td ng-bind="venderTask.distributorProvince" ></td>
			        				                    <td ng-bind="venderTask.distributorCity" ></td>
			        				                    <td ng-bind="venderTask.distributorShortName" ></td>
			        				                    <td ng-bind="venderTask.distributorName" ></td>
			        				                    <td ng-bind="venderTask.eachTeamId" ></td>
			        				                    <td ng-bind="venderTask.eachTeamName" ></td>
			        				                    <td ng-bind="venderTask.planBeginAt" ></td>
			        				                    <td ng-bind="venderTask.beginAt" ></td>
			        				                    <td ng-bind="venderTask.endAt" ></td>
			        				                    <td ng-bind="venderTask.inventoryNum" ></td>
			        				                    <td ng-bind="venderTask.inspectNum" ></td>
			        				                    <td ng-bind="venderTask.inventoryTotalNum" ></td>
			        				                    <td ng-bind="venderTask.inspectTotalNum" ></td>
			        				                    <td ng-bind="venderTask.distributeNum" ></td>
			        				                    <td ng-bind="venderTask.completeNum" ></td>
			        				                    <td ng-bind="venderTask.status" ></td>
			        				                    <td ng-bind="venderTask.createAt" ></td>
			        				                    <td ng-bind="venderTask.createBy" ></td>
			        				                    <td ng-bind="venderTask.distributeAt" ></td>
			        				                    <td ng-bind="venderTask.distributeBy" ></td>
			        				                    <td ng-bind="venderTask.closeAt" ></td>
			        				                    <td ng-bind="venderTask.closeBy" ></td>
			        				                    <td ng-bind="venderTask.updateAt" ></td>
			        				                    <td ng-bind="venderTask.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateVenderTask(venderTask.id)" /> 
							<input type="button" value="删除" ng-click="deleteVenderTask(venderTask.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/venderTask/venderTaskList.js"></script>
