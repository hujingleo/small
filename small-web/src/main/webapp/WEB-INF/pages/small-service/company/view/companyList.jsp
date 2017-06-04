<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="company" id="current_nav">
<div id="companyApp" ng-app="companyApp">
	<div ng-controller="companyController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Company管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCompany(company)">新增</span>
		    </span>
	
			<paging url="/web/a/company">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>公司名称</td>
			        				                    <td>状态 (1正常0禁用)</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="company in data">				
									                    <td ng-bind="company.id" ></td>
			        				                    <td ng-bind="company.name" ></td>
			        				                    <td ng-bind="company.status" ></td>
			        				                    <td ng-bind="company.updateAt" ></td>
			        				                    <td ng-bind="company.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCompany(company.id)" /> 
							<input type="button" value="删除" ng-click="deleteCompany(company.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/company/companyList.js"></script>
