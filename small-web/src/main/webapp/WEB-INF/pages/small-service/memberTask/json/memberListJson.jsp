<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:array name="members">
			<c:forEach items="${memberList}" var="member">
				<json:object>
					<json:property name="id" value="${member.id}"></json:property>
					<json:property name="name" value="${member.name}"></json:property>
					<json:property name="account" value="${member.account}"></json:property>
					<json:property name="status" value="${member.status}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>
