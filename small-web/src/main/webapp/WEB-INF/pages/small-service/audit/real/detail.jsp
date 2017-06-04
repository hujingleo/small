<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

	<json:object name="data">

			<json:property name="inventoryEnrouteNum"
				value="${inventoryEnrouteNum}"></json:property>





			<json:property name="inventoryInstoreNum"
				value="${inventoryInstoreNum}"></json:property>





			<json:property name="inventorySaledNum"
				value="${inventorySaledNum}"></json:property>





			<json:property name="inventoryOtherNum"
				value="${inventoryOtherNum}"></json:property>





			<json:property name="inspectEnrouteNum"
				value="${inspectEnrouteNum}"></json:property>





			<json:property name="inspectInstoreNum"
				value="${inspectInstoreNum}"></json:property>





			<json:property name="inspectSaledNum"
				value="${inspectSaledNum}"></json:property>



			<json:property name="inspectOtherNum"
				value="${inspectOtherNum}"></json:property>


	</json:object>

</json:object>


