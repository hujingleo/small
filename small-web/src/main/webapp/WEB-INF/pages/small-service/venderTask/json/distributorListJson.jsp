<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:array name="distributors">
			<c:forEach items="${distributorList}" var="distributor">
				<json:object>
					<json:property name="id" value="${distributor.id}"></json:property>
					<json:property name="companyName"
						value="${distributor.companyName}"></json:property>
					<json:property name="status" value="${distributor.status}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
	</json:object>
</json:object>
