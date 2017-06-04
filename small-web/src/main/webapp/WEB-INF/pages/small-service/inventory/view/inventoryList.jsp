<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="inventory" id="current_nav">
<div id="inventoryApp" ng-app="inventoryApp">
	<div ng-controller="inventoryController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Inventory管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addInventory(inventory)">新增</span>
		    </span>
	
			<paging url="/web/a/inventory">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家任务id</td>
			        				                    <td>外勤任务id</td>
			        				                    <td>经销商名字</td>
			        				                    <td>车辆vin码</td>
			        				                    <td>车辆编号</td>
			        				                    <td>车型</td>
			        				                    <td>新车/二手车</td>
			        				                    <td>审计结果（0：在途；1：在库；2：已售；30：其他之故障；31：其他之SOT；32：其他之未报备二网；33：延迟还款）</td>
			        				                    <td>里程数</td>
			        				                    <td>车的颜色</td>
			        				                    <td>备注</td>
			        				                    <td>vin码图</td>
			        				                    <td>里程图</td>
			        				                    <td>铭牌图</td>
			        				                    <td>整车图</td>
			        				                    <td>其他图</td>
			        				                    <td>状态（0：未做；1：已上传；2：需重做）</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="inventory in data">				
									                    <td ng-bind="inventory.id" ></td>
			        				                    <td ng-bind="inventory.venderTaskId" ></td>
			        				                    <td ng-bind="inventory.memberTaskId" ></td>
			        				                    <td ng-bind="inventory.distributorName" ></td>
			        				                    <td ng-bind="inventory.vinNo" ></td>
			        				                    <td ng-bind="inventory.unitNo" ></td>
			        				                    <td ng-bind="inventory.make" ></td>
			        				                    <td ng-bind="inventory.assetCond" ></td>
			        				                    <td ng-bind="inventory.auditResult" ></td>
			        				                    <td ng-bind="inventory.mileage" ></td>
			        				                    <td ng-bind="inventory.color" ></td>
			        				                    <td ng-bind="inventory.comment" ></td>
			        				                    <td ng-bind="inventory.vinNoImg" ></td>
			        				                    <td ng-bind="inventory.mileageImg" ></td>
			        				                    <td ng-bind="inventory.nameplateImg" ></td>
			        				                    <td ng-bind="inventory.carImg" ></td>
			        				                    <td ng-bind="inventory.otherImg" ></td>
			        				                    <td ng-bind="inventory.status" ></td>
			        				                    <td ng-bind="inventory.createAt" ></td>
			        				                    <td ng-bind="inventory.updateAt" ></td>
			        				                    <td ng-bind="inventory.createBy" ></td>
			        				                    <td ng-bind="inventory.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateInventory(inventory.id)" /> 
							<input type="button" value="删除" ng-click="deleteInventory(inventory.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/inventory/inventoryList.js"></script>
