<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${memberTask.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderTaskId" value="${memberTask.venderTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="storageId" value="${memberTask.storageId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="storageName" value="${memberTask.storageName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="storageProvince" value="${memberTask.storageProvince}"></json:property>
           
           
	   
                    			
               
                    <json:property name="storageCity" value="${memberTask.storageCity}"></json:property>
           
           
	   
                    			
               
                    <json:property name="storageAddress" value="${memberTask.storageAddress}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberId" value="${memberTask.memberId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberName" value="${memberTask.memberName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="beginAt" value="${memberTask.beginAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="planBeginAt" value="${memberTask.planBeginAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${memberTask.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="isWithdraw" value="${memberTask.isWithdraw}"></json:property>
           
           
	   
                    			
               
                    <json:property name="withdrawAt" value="${memberTask.withdrawAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="withdrawTime" value="${memberTask.withdrawTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="withdrawCause" value="${memberTask.withdrawCause}"></json:property>
           
           
	   
                    			
               
                    <json:property name="nextMemberTaskId" value="${memberTask.nextMemberTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${memberTask.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${memberTask.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${memberTask.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${memberTask.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


