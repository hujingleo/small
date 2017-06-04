<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" /></json:property>
		<json:property name="size" value="${size}"></json:property>
        <json:property name="total" value="${total}"></json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:array name="data">
		<c:forEach items="${adviceDataList}" var="adviceDataMap">
			<json:object>
			<json:property name="id" value="${adviceDataMap.id}"></json:property>
				<json:property name="userAvatarUrl" value="${adviceDataMap.userAvatarUrl}"></json:property>
				<json:property name="nickName" value="${adviceDataMap.nickName}"></json:property>
				<json:property name="adviceCreateBy" value="${adviceDataMap.adviceCreateBy}"></json:property>
				<json:property name="adviceDescription" value="${adviceDataMap.adviceDescription}"></json:property>
				<json:property name="adviceCreateAt" value="${adviceDataMap.adviceCreateAt}"></json:property>
				<json:property name="adviceContactInformation" value="${adviceDataMap.adviceContactInformation}"></json:property>
			</json:object>
		</c:forEach>
	</json:array>
</json:object>


