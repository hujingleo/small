<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
				<json:object name="userArticle">
								
               
                    <json:property name="id" value="${userArticle.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="articleId" value="${userArticle.articleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="openId" value="${userArticle.openId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${userArticle.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${userArticle.createAt}"></json:property>
           
           
	   
                    				
				</json:object>
			</json:object>
		
</json:object>


