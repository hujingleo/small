<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${inspect.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderTaskId" value="${inspect.venderTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberTaskId" value="${inspect.memberTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorName" value="${inspect.distributorName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="vinNo" value="${inspect.vinNo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="settlementDate" value="${inspect.settlementDate}"></json:property>
           
           
	   
                    			
               
                    <json:property name="auditResult" value="${inspect.auditResult}"></json:property>
           
           
	   
                    			
               
                    <json:property name="removeStorageAt" value="${inspect.removeStorageAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="comment" value="${inspect.comment}"></json:property>
           
           
	   
                    			
               
                    <json:property name="removeStorageImg" value="${inspect.removeStorageImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="qualifiedImg" value="${inspect.qualifiedImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="otherImg" value="${inspect.otherImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${inspect.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${inspect.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${inspect.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${inspect.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${inspect.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


