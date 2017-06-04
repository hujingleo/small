<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${venderTask.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderId" value="${venderTask.venderId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderName" value="${venderTask.venderName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorId" value="${venderTask.distributorId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorProvince" value="${venderTask.distributorProvince}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorCity" value="${venderTask.distributorCity}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorShortName" value="${venderTask.distributorShortName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorName" value="${venderTask.distributorName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="eachTeamId" value="${venderTask.eachTeamId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="eachTeamName" value="${venderTask.eachTeamName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="planBeginAt" value="${venderTask.planBeginAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="beginAt" value="${venderTask.beginAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="endAt" value="${venderTask.endAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="inventoryNum" value="${venderTask.inventoryNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="inspectNum" value="${venderTask.inspectNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="inventoryTotalNum" value="${venderTask.inventoryTotalNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="inspectTotalNum" value="${venderTask.inspectTotalNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributeNum" value="${venderTask.distributeNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="completeNum" value="${venderTask.completeNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${venderTask.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${venderTask.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${venderTask.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributeAt" value="${venderTask.distributeAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributeBy" value="${venderTask.distributeBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="closeAt" value="${venderTask.closeAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="closeBy" value="${venderTask.closeBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${venderTask.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${venderTask.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


