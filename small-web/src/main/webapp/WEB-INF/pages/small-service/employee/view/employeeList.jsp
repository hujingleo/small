<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="employee" id="current_nav">
<div id="employeeApp" ng-app="employeeApp">
	<div ng-controller="employeeController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Employee管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addEmployee(employee)">新增</span>
		    </span>
	
			<paging url="/web/a/employee">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>员工名称</td>
			        				                    <td>电话</td>
			        				                    <td>邮箱</td>
			        				                    <td>毕业学校</td>
			        				                    <td>学历</td>
			        				                    <td>专业</td>
			        				                    <td>账号</td>
			        				                    <td>籍贯</td>
			        				                    <td>年龄</td>
			        				                    <td>入职时间</td>
			        				                    <td>工作城市</td>
			        				                    <td>公司id</td>
			        				                    <td>公司名称</td>
			        				                    <td>部门id</td>
			        				                    <td>部门名称</td>
			        				                    <td>职位</td>
			        				                    <td>身份证</td>
			        				                    <td>照片</td>
			        				                    <td>毕业证</td>
			        				                    <td>技能证书</td>
			        				                    <td>其他证书</td>
			        				                    <td>签订协议</td>
			        				                    <td>状态 (1正常0禁用)</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="employee in data">				
									                    <td ng-bind="employee.id" ></td>
			        				                    <td ng-bind="employee.name" ></td>
			        				                    <td ng-bind="employee.phone" ></td>
			        				                    <td ng-bind="employee.email" ></td>
			        				                    <td ng-bind="employee.school" ></td>
			        				                    <td ng-bind="employee.education" ></td>
			        				                    <td ng-bind="employee.major" ></td>
			        				                    <td ng-bind="employee.account" ></td>
			        				                    <td ng-bind="employee.address" ></td>
			        				                    <td ng-bind="employee.age" ></td>
			        				                    <td ng-bind="employee.inductionTime" ></td>
			        				                    <td ng-bind="employee.city" ></td>
			        				                    <td ng-bind="employee.companyId" ></td>
			        				                    <td ng-bind="employee.company" ></td>
			        				                    <td ng-bind="employee.departmentId" ></td>
			        				                    <td ng-bind="employee.department" ></td>
			        				                    <td ng-bind="employee.position" ></td>
			        				                    <td ng-bind="employee.cardImg" ></td>
			        				                    <td ng-bind="employee.photo" ></td>
			        				                    <td ng-bind="employee.diploma" ></td>
			        				                    <td ng-bind="employee.skillCertificate" ></td>
			        				                    <td ng-bind="employee.otherCertificate" ></td>
			        				                    <td ng-bind="employee.signAgreement" ></td>
			        				                    <td ng-bind="employee.status" ></td>
			        				                    <td ng-bind="employee.updateAt" ></td>
			        				                    <td ng-bind="employee.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateEmployee(employee.id)" /> 
							<input type="button" value="删除" ng-click="deleteEmployee(employee.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/employee/employeeList.js"></script>
