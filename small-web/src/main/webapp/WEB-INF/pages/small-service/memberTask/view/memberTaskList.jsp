<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="memberTask" id="current_nav">
<div id="memberTaskApp" ng-app="memberTaskApp">
	<div ng-controller="memberTaskController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>MemberTask管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addMemberTask(memberTask)">新增</span>
		    </span>
	
			<paging url="/web/a/memberTask">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家任务id</td>
			        				                    <td>库位id</td>
			        				                    <td>库位名字</td>
			        				                    <td>库位的省</td>
			        				                    <td>库位的市</td>
			        				                    <td>库位的详细地址</td>
			        				                    <td>外勤id</td>
			        				                    <td>外勤名字</td>
			        				                    <td>进场时间</td>
			        				                    <td>计划日期（年月日）</td>
			        				                    <td>外勤任务状态（-1：已取消；0：未开始；1：执行中；2：已重开；3：已完成；4：已通过；5：已关闭）</td>
			        				                    <td>是否被撤回</td>
			        				                    <td>撤回的时间</td>
			        				                    <td>撤回的次数</td>
			        				                    <td>撤回的原因</td>
			        				                    <td>接手已撤回的外勤任务id</td>
			        				                    <td>分配时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>分配者</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="memberTask in data">				
									                    <td ng-bind="memberTask.id" ></td>
			        				                    <td ng-bind="memberTask.venderTaskId" ></td>
			        				                    <td ng-bind="memberTask.storageId" ></td>
			        				                    <td ng-bind="memberTask.storageName" ></td>
			        				                    <td ng-bind="memberTask.storageProvince" ></td>
			        				                    <td ng-bind="memberTask.storageCity" ></td>
			        				                    <td ng-bind="memberTask.storageAddress" ></td>
			        				                    <td ng-bind="memberTask.memberId" ></td>
			        				                    <td ng-bind="memberTask.memberName" ></td>
			        				                    <td ng-bind="memberTask.beginAt" ></td>
			        				                    <td ng-bind="memberTask.planBeginAt" ></td>
			        				                    <td ng-bind="memberTask.status" ></td>
			        				                    <td ng-bind="memberTask.isWithdraw" ></td>
			        				                    <td ng-bind="memberTask.withdrawAt" ></td>
			        				                    <td ng-bind="memberTask.withdrawTime" ></td>
			        				                    <td ng-bind="memberTask.withdrawCause" ></td>
			        				                    <td ng-bind="memberTask.nextMemberTaskId" ></td>
			        				                    <td ng-bind="memberTask.createAt" ></td>
			        				                    <td ng-bind="memberTask.updateAt" ></td>
			        				                    <td ng-bind="memberTask.createBy" ></td>
			        				                    <td ng-bind="memberTask.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateMemberTask(memberTask.id)" /> 
							<input type="button" value="删除" ng-click="deleteMemberTask(memberTask.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/memberTask/memberTaskList.js"></script>
