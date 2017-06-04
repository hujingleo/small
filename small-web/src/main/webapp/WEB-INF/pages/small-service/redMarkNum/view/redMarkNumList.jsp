<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="redMarkNum" id="current_nav">
<div id="redMarkNumApp" ng-app="redMarkNumApp">
	<div ng-controller="redMarkNumController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>RedMarkNum管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRedMarkNum(redMarkNum)">新增</span>
		    </span>
	
			<paging url="/web/a/redMarkNum">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家任务id</td>
			        				                    <td>外勤数</td>
			        				                    <td>照片数</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="redMarkNum in data">				
									                    <td ng-bind="redMarkNum.id" ></td>
			        				                    <td ng-bind="redMarkNum.venderTaskId" ></td>
			        				                    <td ng-bind="redMarkNum.memberNum" ></td>
			        				                    <td ng-bind="redMarkNum.photoNum" ></td>
			        				                    <td ng-bind="redMarkNum.createAt" ></td>
			        				                    <td ng-bind="redMarkNum.updateAt" ></td>
			        				                    <td ng-bind="redMarkNum.createBy" ></td>
			        				                    <td ng-bind="redMarkNum.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRedMarkNum(redMarkNum.id)" /> 
							<input type="button" value="删除" ng-click="deleteRedMarkNum(redMarkNum.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/redMarkNum/redMarkNumList.js"></script>
