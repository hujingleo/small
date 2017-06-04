<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:property name="totalPage" value="${totalPage}"></json:property>
	<json:object name="data">
		<json:property name="continueDays" value="${continueDays}"></json:property>

		<json:array name="memberTasks">
			<c:forEach items="${memberTaskList}" var="memberTask">
				<json:object>
					<json:property name="id" value="${memberTask.id}"></json:property>
					<json:property name="distributorId"
						value="${venderTaskMap[memberTask.venderTaskId].distributorId}"></json:property>
					<json:property name="distributorName"
						value="${venderTaskMap[memberTask.venderTaskId].distributorName}"></json:property>
					<json:property name="storageId" value="${memberTask.storageId}"></json:property>
					<json:property name="storageName" value="${memberTask.storageName}"></json:property>
					<json:property name="storageProvince"
						value="${memberTask.storageProvince}"></json:property>
					<json:property name="storageCity" value="${memberTask.storageCity}"></json:property>
					<json:property name="beginAt" value="${memberTask.beginAt}"></json:property>
					<json:property name="status" value="${memberTask.status}"></json:property>
					<json:property name="createAt" value="${memberTask.createAt}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>
