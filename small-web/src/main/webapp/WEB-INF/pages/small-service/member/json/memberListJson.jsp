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
	<json:property name="totalPage" value="${totalPage}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${memberList}" var="member">
			<json:object>
					
               
                    <json:property name="id" value="${member.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${member.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="phone" value="${member.phone}"></json:property>
           
           
	   
        			
               
                    <json:property name="account" value="${member.account}"></json:property>
           
           
	   
        			
               
                    <json:property name="pwd" value="${member.pwd}"></json:property>
           
           
	   
        			
               
                    <json:property name="teamId" value="${member.teamId}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${member.status}"></json:property>
           
           
                    <json:property name="isForbidden" value="${member.isForbidden}"></json:property>
	   
        			
               
                    <json:property name="createBy" value="${member.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${member.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${member.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${member.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


