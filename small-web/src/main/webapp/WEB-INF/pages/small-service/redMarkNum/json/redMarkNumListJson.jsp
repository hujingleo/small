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
	<json:array name="data">
		<c:forEach items="${redMarkNumList}" var="redMarkNum">
			<json:object>
					
               
                    <json:property name="id" value="${redMarkNum.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="venderTaskId" value="${redMarkNum.venderTaskId}"></json:property>
           
           
	   
        			
               
                    <json:property name="memberNum" value="${redMarkNum.memberNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="photoNum" value="${redMarkNum.photoNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${redMarkNum.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${redMarkNum.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${redMarkNum.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${redMarkNum.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


