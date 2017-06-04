<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="totalPage" value="${totalPage}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${teamList}" var="team">
			<json:object>
					
               
                    <json:property name="id" value="${team.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${team.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${team.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="count" value="${team.count}"></json:property>
           
           
	   
        			
               
                    <json:property name="belongToId" value="${team.belongToId}"></json:property>
           
           
	   
        			
               
                    <json:property name="belongToName" value="${team.belongToName}"></json:property>
           
           
	   
        			
               
                    <json:property name="isForbidden" value="${team.isForbidden}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${team.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${team.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${team.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${team.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


