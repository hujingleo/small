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
	<json:property name="type" value="${type}"></json:property>
	<json:array name="data">
		<c:forEach items="${venderList}" var="vender">
			<json:object>


				<json:property name="id" value="${vender.id}"></json:property>



				<json:property name="name" value="${vender.name}"></json:property>



			</json:object>
		</c:forEach>
	</json:array>
</json:object>


