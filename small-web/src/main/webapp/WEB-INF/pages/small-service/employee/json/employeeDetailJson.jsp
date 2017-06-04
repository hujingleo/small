<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${employee.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${employee.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${employee.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="email" value="${employee.email}"></json:property>
           
           
	   
                    			
               
                    <json:property name="school" value="${employee.school}"></json:property>
           
           
	   
                    			
               
                    <json:property name="education" value="${employee.education}"></json:property>
           
           
	   
                    			
               
                    <json:property name="major" value="${employee.major}"></json:property>
           
           
	   
                    			
               
                    <json:property name="account" value="${employee.account}"></json:property>
           
           
	   
                    			
               
                    <json:property name="address" value="${employee.address}"></json:property>
           
           
	   
                    			
               
                    <json:property name="age" value="${employee.age}"></json:property>
           
           
	   
                    			
               
                    <json:property name="inductionTime" value="${employee.inductionTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="city" value="${employee.city}"></json:property>
           
           
	   
                    			
               
                    <json:property name="companyId" value="${employee.companyId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="company" value="${employee.company}"></json:property>
           
           
	   
                    			
               
                    <json:property name="departmentId" value="${employee.departmentId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="department" value="${employee.department}"></json:property>
           
           
	   
                    			
               
                    <json:property name="position" value="${employee.position}"></json:property>
           
           
	   
                    			
               
                    <json:property name="cardImg" value="${employee.cardImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="photo" value="${employee.photo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="diploma" value="${employee.diploma}"></json:property>
           
           
	   
                    			
               
                    <json:property name="skillCertificate" value="${employee.skillCertificate}"></json:property>
           
           
	   
                    			
               
                    <json:property name="otherCertificate" value="${employee.otherCertificate}"></json:property>
           
           
	   
                    			
               
                    <json:property name="signAgreement" value="${employee.signAgreement}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${employee.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${employee.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${employee.createAt}"></json:property>
           
           <json:property name="birthday" value="${employee.birthday}"></json:property>
	   
                    				
	 
			</json:object>
		
</json:object>


