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
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${commentList}" var="comment">
			<json:object>
					
               
                    <json:property name="id" value="${comment.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="openId" value="${comment.openId}"></json:property>


				<json:property name="articleId" value="${comment.articleId}"></json:property>
        			
               
                    <json:property name="content" value="${comment.content}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${comment.updateAt}"></json:property>
           
           
	   <json:property name="createTime" value="${comment.createTime}"></json:property>
        			
               
                    <json:property name="createAt" value="${comment.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


