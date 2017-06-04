<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="employee" id="current_nav">
	<div id="employeeDetailApp" ng-app="employeeDetailApp">
		<div ng-controller="employeeDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="employeeForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="employeeId" ng-model="employee.id" ng-bind="employee.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">员工名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="employee.name" ng-bind="employee.name" placeholder="请输入员工名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="employee.phone" ng-bind="employee.phone" placeholder="请输入电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="email" class="col-sm-2 control-label">邮箱</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="email" ng-model="employee.email" ng-bind="employee.email" placeholder="请输入邮箱" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="school" class="col-sm-2 control-label">毕业学校</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="school" ng-model="employee.school" ng-bind="employee.school" placeholder="请输入毕业学校" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="education" class="col-sm-2 control-label">学历</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="education" ng-model="employee.education" ng-bind="employee.education" placeholder="请输入学历" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="major" class="col-sm-2 control-label">专业</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="major" ng-model="employee.major" ng-bind="employee.major" placeholder="请输入专业" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="account" class="col-sm-2 control-label">账号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="account" ng-model="employee.account" ng-bind="employee.account" placeholder="请输入账号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="address" class="col-sm-2 control-label">籍贯</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="address" ng-model="employee.address" ng-bind="employee.address" placeholder="请输入籍贯" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="age" class="col-sm-2 control-label">年龄</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="age" ng-model="employee.age" ng-bind="employee.age" placeholder="请输入年龄" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="inductionTime" class="col-sm-2 control-label">入职时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="inductionTime" ng-model="employee.inductionTime" ng-bind="employee.inductionTime" placeholder="请输入入职时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="city" class="col-sm-2 control-label">工作城市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="city" ng-model="employee.city" ng-bind="employee.city" placeholder="请输入工作城市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyId" class="col-sm-2 control-label">公司id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyId" ng-model="employee.companyId" ng-bind="employee.companyId" placeholder="请输入公司id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="company" class="col-sm-2 control-label">公司名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="company" ng-model="employee.company" ng-bind="employee.company" placeholder="请输入公司名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="departmentId" class="col-sm-2 control-label">部门id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="departmentId" ng-model="employee.departmentId" ng-bind="employee.departmentId" placeholder="请输入部门id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="department" class="col-sm-2 control-label">部门名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="department" ng-model="employee.department" ng-bind="employee.department" placeholder="请输入部门名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="position" class="col-sm-2 control-label">职位</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="position" ng-model="employee.position" ng-bind="employee.position" placeholder="请输入职位" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cardImg" class="col-sm-2 control-label">身份证</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cardImg" ng-model="employee.cardImg" ng-bind="employee.cardImg" placeholder="请输入身份证" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="photo" class="col-sm-2 control-label">照片</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="photo" ng-model="employee.photo" ng-bind="employee.photo" placeholder="请输入照片" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="diploma" class="col-sm-2 control-label">毕业证</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="diploma" ng-model="employee.diploma" ng-bind="employee.diploma" placeholder="请输入毕业证" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="skillCertificate" class="col-sm-2 control-label">技能证书</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="skillCertificate" ng-model="employee.skillCertificate" ng-bind="employee.skillCertificate" placeholder="请输入技能证书" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="otherCertificate" class="col-sm-2 control-label">其他证书</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="otherCertificate" ng-model="employee.otherCertificate" ng-bind="employee.otherCertificate" placeholder="请输入其他证书" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="signAgreement" class="col-sm-2 control-label">签订协议</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="signAgreement" ng-model="employee.signAgreement" ng-bind="employee.signAgreement" placeholder="请输入签订协议" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态 (1正常0禁用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="employee.status" ng-bind="employee.status" placeholder="请输入状态 (1正常0禁用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateEmployee(employee)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/employee">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/employee/employeeDetail.js"></script>
