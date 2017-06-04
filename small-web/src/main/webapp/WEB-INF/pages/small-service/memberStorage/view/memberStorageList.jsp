<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="memberStorage" id="current_nav">
<div id="memberStorageApp" ng-app="memberStorageApp">
	<div ng-controller="memberStorageController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>MemberStorage管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addMemberStorage(memberStorage)">新增</span>
		    </span>
	
			<paging url="/web/a/memberStorage">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>外勤任务id</td>
			        				                    <td>人库合影图</td>
			        				                    <td>车辆钥匙图</td>
			        				                    <td>其他图</td>
			        				                    <td>库位id</td>
			        				                    <td>库位名字</td>
			        				                    <td>状态（0：未做；1：已上传；2：需重做）</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="memberStorage in data">				
									                    <td ng-bind="memberStorage.id" ></td>
			        				                    <td ng-bind="memberStorage.memberTaskId" ></td>
			        				                    <td ng-bind="memberStorage.memberStorageImg" ></td>
			        				                    <td ng-bind="memberStorage.keyImg" ></td>
			        				                    <td ng-bind="memberStorage.keyImg" ></td>
			        				                    <td ng-bind="memberStorage.storageId" ></td>
			        				                    <td ng-bind="memberStorage.storageName" ></td>
			        				                    <td ng-bind="memberStorage.status" ></td>
			        				                    <td ng-bind="memberStorage.createAt" ></td>
			        				                    <td ng-bind="memberStorage.updateAt" ></td>
			        				                    <td ng-bind="memberStorage.createBy" ></td>
			        				                    <td ng-bind="memberStorage.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateMemberStorage(memberStorage.id)" /> 
							<input type="button" value="删除" ng-click="deleteMemberStorage(memberStorage.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/memberStorage/memberStorageList.js"></script>
