<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="memberTaskStatus" value="${memberTask.status}"></json:property>
	<json:property name="memberTaskId" value="${memberTask.id}"></json:property>
	<json:property name="enrouteSaledReportStatus" value="${enrouteSaledReport.status}"></json:property>
	<json:property name="enrouteSaledReportId" value="${enrouteSaledReport.id}"></json:property>
	<json:property name="memberStorageStatus" value="${memberStorage.status}"></json:property>
	<json:property name="memberStorageId" value="${memberStorage.id}"></json:property>
	<json:property name="inventoryStatus" value="${inventory.status}"></json:property>
	<json:property name="inventoryId" value="${inventory.id}"></json:property>
	<json:property name="inspectStatus" value="${inspect.status}"></json:property>
	<json:property name="inspectId" value="${inspect.id}"></json:property>
</json:object>