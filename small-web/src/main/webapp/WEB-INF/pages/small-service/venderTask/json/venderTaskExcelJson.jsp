<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>

	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

	<json:object name="data">
		<json:property name="type" value="${type}"></json:property>
		
		<json:object name="distributor">
			<json:property name="id" value="${distributor.id}"></json:property>
			<json:property name="name" value="${distributor.companyName}"></json:property>
		</json:object>
		
		<json:array name="inventorys">
			<c:forEach items="${inventoryList}" var="inventory">
				<json:object>
					<json:property name="vinNo" value="${inventory.vinNo}"></json:property>
					<json:property name="unitNo" value="${inventory.unitNo}"></json:property>
					<json:property name="make" value="${inventory.make}"></json:property>
					<json:property name="assetCond" value="${inventory.assetCond}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>

		<json:array name="inspects">
			<c:forEach items="${inspectList}" var="inspect">
				<json:object>
					<json:property name="vinNo" value="${inspect.vinNo}"></json:property>
					<json:property name="settlementDate" value="${inspect.settlementDate}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>

	</json:object>

</json:object>


