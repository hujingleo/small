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
		<c:forEach items="${reportList}" var="report">
			<json:object>
					
               
                    <json:property name="id" value="${report.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="venderTaskId" value="${report.venderTaskId}"></json:property>
           
           
	   
        			
               
                    <json:property name="distributorId" value="${report.distributorId}"></json:property>
           
           
	   
        			
               
                    <json:property name="distributorShortName" value="${report.distributorShortName}"></json:property>
           
           
	   
        			
               
                    <json:property name="planBeginAt" value="${report.planBeginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="beginAt" value="${report.beginAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="endAt" value="${report.endAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="carType" value="${report.carType}"></json:property>
           
           
	   
        			
               
                    <json:property name="eachTeamId" value="${report.eachTeamId}"></json:property>
           
           
	   
        			
               
                    <json:property name="eachTeamName" value="${report.eachTeamName}"></json:property>
           
           
	   
        			
               
                    <json:property name="storageNum" value="${report.storageNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="photoNum" value="${report.photoNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="auditFinishTimes" value="${report.auditFinishTimes}"></json:property>
           
           
	   
        			
               
                    <json:property name="inventoryEnrouteNum" value="${report.inventoryEnrouteNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inventoryInstoreNum" value="${report.inventoryInstoreNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inventorySaledNum" value="${report.inventorySaledNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inventoryOtherNum" value="${report.inventoryOtherNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inspectEnrouteNum" value="${report.inspectEnrouteNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inspectInstoreNum" value="${report.inspectInstoreNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inspectSaledNum" value="${report.inspectSaledNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="inspectOtherNum" value="${report.inspectOtherNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="centraStorageNum" value="${report.centraStorageNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="secondStorageNum" value="${report.secondStorageNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="showStorageNum" value="${report.showStorageNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="unknownSecondStorage" value="${report.unknownSecondStorage}"></json:property>
           
           
	   
        			
               
                    <json:property name="centraStorageCarNum" value="${report.centraStorageCarNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="secondStorageCarNum" value="${report.secondStorageCarNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="showStorageCarNum" value="${report.showStorageCarNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="distributorSignImg" value="${report.distributorSignImg}"></json:property>
           
           
	   
        			
               
                    <json:property name="firstJudgeAt" value="${report.firstJudgeAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="finalJudgeAt" value="${report.finalJudgeAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="judgeResult" value="${report.judgeResult}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${report.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${report.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${report.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${report.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


