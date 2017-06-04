<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="inspect" id="current_nav">
<div id="inspectApp" ng-app="inspectApp">
	<div ng-controller="inspectController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Inspect管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addInspect(inspect)">新增</span>
		    </span>
	
			<paging url="/web/a/inspect">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家任务id</td>
			        				                    <td>外勤任务id</td>
			        				                    <td>经销商名字</td>
			        				                    <td>车辆vin码</td>
			        				                    <td>还款日期</td>
			        				                    <td>审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）</td>
			        				                    <td>出库日</td>
			        				                    <td>备注</td>
			        				                    <td>出库单图</td>
			        				                    <td>合格证通知图</td>
			        				                    <td>其他图</td>
			        				                    <td>状态（0：未做；1：已上传；2：需重做）</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="inspect in data">				
									                    <td ng-bind="inspect.id" ></td>
			        				                    <td ng-bind="inspect.venderTaskId" ></td>
			        				                    <td ng-bind="inspect.memberTaskId" ></td>
			        				                    <td ng-bind="inspect.distributorName" ></td>
			        				                    <td ng-bind="inspect.vinNo" ></td>
			        				                    <td ng-bind="inspect.settlementDate" ></td>
			        				                    <td ng-bind="inspect.auditResult" ></td>
			        				                    <td ng-bind="inspect.removeStorageAt" ></td>
			        				                    <td ng-bind="inspect.comment" ></td>
			        				                    <td ng-bind="inspect.removeStorageImg" ></td>
			        				                    <td ng-bind="inspect.qualifiedImg" ></td>
			        				                    <td ng-bind="inspect.otherImg" ></td>
			        				                    <td ng-bind="inspect.status" ></td>
			        				                    <td ng-bind="inspect.createAt" ></td>
			        				                    <td ng-bind="inspect.updateAt" ></td>
			        				                    <td ng-bind="inspect.createBy" ></td>
			        				                    <td ng-bind="inspect.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateInspect(inspect.id)" /> 
							<input type="button" value="删除" ng-click="deleteInspect(inspect.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/inspect/inspectList.js"></script>
