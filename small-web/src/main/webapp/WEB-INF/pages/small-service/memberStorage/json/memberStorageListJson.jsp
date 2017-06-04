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
		<c:forEach items="${memberStorageList}" var="memberStorage">
			<json:object>
					
               
                    <json:property name="id" value="${memberStorage.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="memberTaskId" value="${memberStorage.memberTaskId}"></json:property>
           
           
	   
        			
               
                    <json:property name="memberStorageImg" value="${memberStorage.memberStorageImg}"></json:property>
           
           
	   
        			
               
                    <json:property name="keyImg" value="${memberStorage.keyImg}"></json:property>
           
           
	   
        			
               
                    <json:property name="keyImg" value="${memberStorage.keyImg}"></json:property>
           
           
	   
        			
               
                    <json:property name="storageId" value="${memberStorage.storageId}"></json:property>
           
           
	   
        			
               
                    <json:property name="storageName" value="${memberStorage.storageName}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${memberStorage.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${memberStorage.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${memberStorage.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${memberStorage.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${memberStorage.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


