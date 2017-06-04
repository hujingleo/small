<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:array name="enrouteSaledReport">
			<c:forEach items="${esrStorageList}" var="storage">
				<json:object>
					<json:property name="enrouteSaledReportStorageName" value="${storage.name}"></json:property>
					<json:property name="enrouteSaledReportStorageAttribute" value="${storage.attribute}"></json:property>
					<json:property name="enrouteSaledReportStorageCarNum" value="${storage.carNum}"></json:property>
					<json:property name="enrouteSaledReportStorageAttributeName" value="${storage.attributeName}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
		<json:array name="memberTaskList">
			<c:forEach items="${memberTaskList}" var="memberTask">
				<json:object>
					<json:property name="memberTaskStorageName" value="${memberTask.storageName}"></json:property>
					<json:property name="memberTaskStorageAttribute" value="${memberTask.storageAttribute}"></json:property>
					<json:property name="memberTaskStorageId" value="${memberTask.id}"></json:property>
					<json:property name="memberTaskStatus" value="${memberTask.status}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
		<json:object name="carsWithNoPhotos">
		    <json:property name="carsWithNoPhotos" value="${carsWithNoPhotos}"></json:property>
		    <json:property name="carsWithNoPhotosJson" value="${carsWithNoPhotosJson}"></json:property>
		</json:object>
	</json:object>

</json:object>
