<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:array name="storages">
			<c:forEach items="${storageList}" var="storage">
				<json:object>
					<json:property name="id" value="${storage.id}"></json:property>
					<json:property name="name" value="${storage.name}"></json:property>
					<json:property name="latitude" value="${storage.latitude}"></json:property>
					<json:property name="longitude" value="${storage.longitude}"></json:property>
					<json:property name="hasDistributed" value="${storage.hasDistributed}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>
