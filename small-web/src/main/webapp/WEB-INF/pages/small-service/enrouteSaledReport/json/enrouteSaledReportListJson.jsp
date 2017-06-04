<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:object name="data">
		<json:property name="total" value="${total}"></json:property>
		<json:property name="page" value="${page}"></json:property>
		<json:property name="size" value="${size}"></json:property>
		<json:property name="totalPage" value="${totalPage}"></json:property>
		<json:array name="enrouteSaledReportList">
			<c:forEach items="${enrouteSaledReportList}" var="enrouteSaledReport">
				<json:object>


					<json:property name="id" value="${enrouteSaledReport.id}"></json:property>





					<json:property name="memberTaskId"
						value="${enrouteSaledReport.memberTaskId}"></json:property>





					<json:property name="distributorId"
						value="${enrouteSaledReport.distributorId}"></json:property>





					<json:property name="distributorShortName"
						value="${enrouteSaledReport.distributorShortName}"></json:property>





					<json:property name="headStorageId"
						value="${enrouteSaledReport.headStorageId}"></json:property>





					<json:property name="headStorageName"
						value="${enrouteSaledReport.headStorageName}"></json:property>





					<json:property name="headStorageAddress"
						value="${enrouteSaledReport.headStorageAddress}"></json:property>





					<json:property name="headStorageContactName"
						value="${enrouteSaledReport.headStorageContactName}"></json:property>





					<json:property name="headStorageContactPhone"
						value="${enrouteSaledReport.headStorageContactPhone}"></json:property>





					<json:property name="beginAt" value="${enrouteSaledReport.beginAt}"></json:property>





					<json:property name="planBeginAt"
						value="${enrouteSaledReport.planBeginAt}"></json:property>





					<json:property name="auditDirection"
						value="${enrouteSaledReport.auditDirection}"></json:property>





					<json:property name="auditDistance"
						value="${enrouteSaledReport.auditDistance}"></json:property>





					<json:property name="enrouteNum"
						value="${enrouteSaledReport.enrouteNum}"></json:property>





					<json:property name="saledNum"
						value="${enrouteSaledReport.saledNum}"></json:property>





					<json:property name="eachStorageId"
						value="${enrouteSaledReport.eachStorageId}"></json:property>





					<json:property name="eachStorageNum"
						value="${enrouteSaledReport.eachStorageNum}"></json:property>





					<json:property name="otherNum"
						value="${enrouteSaledReport.otherNum}"></json:property>





					<json:property name="status" value="${enrouteSaledReport.status}"></json:property>





					<json:property name="createAt"
						value="${enrouteSaledReport.createAt}"></json:property>





					<json:property name="updateAt"
						value="${enrouteSaledReport.updateAt}"></json:property>





					<json:property name="createBy"
						value="${enrouteSaledReport.createBy}"></json:property>





					<json:property name="updateBy"
						value="${enrouteSaledReport.updateBy}"></json:property>
					<json:property name="createAt" value="${storage.createAt}"></json:property>

					<json:property name="headStorageNum"
						value="${enrouteSaledReport.headStorageNum}"></json:property>
					<json:property name="blankBillImg" value="${enrouteSaledReport.blankBillImg}"></json:property>
					<json:property name="blankOutStorageImg"
						value="${enrouteSaledReport.blankOutStorageImg}"></json:property>
					<json:property name="distributorSignImg"
						value="${enrouteSaledReport.distributorSignImg}"></json:property>


				</json:object>
			</c:forEach>
		</json:array>

	</json:object>
</json:object>


