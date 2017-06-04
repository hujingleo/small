<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:object name="data">
	
		<json:property name="total" value="${total}"></json:property>
		<json:property name="page" value="${page}"></json:property>
		<json:property name="size" value="${size}"></json:property>
		<json:property name="totalPage" value="${totalPage}"></json:property>
		<json:array name="companyList">
		<c:forEach items="${companyList}" var="company">
			<json:object>
					
               
                    <json:property name="id" value="${company.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${company.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${company.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${company.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${company.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
	</json:object>
</json:object>


