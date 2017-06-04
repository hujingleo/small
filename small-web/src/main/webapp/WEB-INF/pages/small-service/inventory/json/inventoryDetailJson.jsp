<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${inventory.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="venderTaskId" value="${inventory.venderTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberTaskId" value="${inventory.memberTaskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="distributorName" value="${inventory.distributorName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="vinNo" value="${inventory.vinNo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="unitNo" value="${inventory.unitNo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="make" value="${inventory.make}"></json:property>
           
           
	   
                    			
               
                    <json:property name="assetCond" value="${inventory.assetCond}"></json:property>
           
           
	   <json:property name="beginAt" value="${enrouteSaledReport.beginAt}"></json:property>





			<json:property name="planBeginAt"
				value="${enrouteSaledReport.planBeginAt}"></json:property>





			<json:property name="auditDirection"
				value="${enrouteSaledReport.auditDirection}"></json:property>





			<json:property name="auditDistance"
				value="${enrouteSaledReport.auditDistance}"></json:property>
                    			
               
                    <json:property name="auditResult" value="${inventory.auditResult}"></json:property>
           
           
	   
                    			
               
                    <json:property name="mileage" value="${inventory.mileage}"></json:property>
           
           
	   
                    			
               
                    <json:property name="color" value="${inventory.color}"></json:property>
           
           
	   
                    			
               
                    <json:property name="comment" value="${inventory.comment}"></json:property>
           
           
	   
                    			
               
                    <json:property name="vinNoImg" value="${inventory.vinNoImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="mileageImg" value="${inventory.mileageImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="nameplateImg" value="${inventory.nameplateImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="carImg" value="${inventory.carImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="otherImg" value="${inventory.otherImg}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${inventory.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${inventory.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${inventory.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${inventory.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${inventory.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


