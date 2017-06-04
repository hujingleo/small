<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

	<json:object name="data">


		<json:object name="enrouteSaledReport">
			<json:property name="id" value="${enrouteSaledReport.id}"></json:property>
			<json:property name="status" value="${enrouteSaledReport.status}"></json:property>
			<json:property name="createAt" value="${enrouteSaledReport.createAt}"></json:property>
			<json:property name="updateAt" value="${enrouteSaledReport.updateAt}"></json:property>
			<json:property name="createBy" value="${enrouteSaledReport.createBy}"></json:property>
			<json:property name="updateBy" value="${enrouteSaledReport.updateBy}"></json:property>
			<json:property name="blankBillImg" value="${enrouteSaledReport.blankBillImg}"></json:property>
			<json:property name="blankOutStorageImg"
				value="${enrouteSaledReport.blankOutStorageImg}"></json:property>
			<json:property name="distributorSignImg"
				value="${enrouteSaledReport.distributorSignImg}"></json:property>
			<json:property name="enrouteNum" value="${enrouteSaledReport.enrouteNum}"></json:property>
			<json:property name="saledNum" value="${enrouteSaledReport.saledNum}"></json:property>
			<json:property name="otherNum" value="${enrouteSaledReport.otherNum}"></json:property>
		</json:object>
		<json:property name="enrouteSaledInventorys" value="${enrouteSaledInventorys}"></json:property>
		<json:property name="carNumInfo" value="${carNumInfo}"></json:property>
	</json:object>

</json:object>


