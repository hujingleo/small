<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<json:array name="inventoryList">
			<c:forEach items="${inventoryList}" var="inventory">
				<json:object>
					<json:property name="inventoryId" value="${inventory.id}"></json:property>
					<%-- <json:property name="venderTaskId"
						value="${inventory.venderTaskId}"></json:property>
					<json:property name="memberTaskId"
						value="${inventory.memberTaskId}"></json:property>
					<json:property name="distributorName"
						value="${inventory.distributorName}"></json:property> --%>
					<json:property name="vinNo" value="${inventory.vinNo}"></json:property>
					<json:property name="unitNo" value="${inventory.unitNo}"></json:property>
					<json:property name="make" value="${inventory.make}"></json:property>
					<json:property name="assetCond" value="${inventory.assetCond}"></json:property>
					<json:property name="auditResult" value="${inventory.auditResult}"></json:property>
					<json:property name="mileage" value="${inventory.mileage}"></json:property>
					<json:property name="color" value="${inventory.color}"></json:property>
					<json:property name="comment" value="${inventory.comment}"></json:property>
					<json:property name="vinNoImg" value="${inventory.vinNoImg}"></json:property>
					<json:property name="mileageImg" value="${inventory.mileageImg}"></json:property>
					<json:property name="nameplateImg"
						value="${inventory.nameplateImg}"></json:property>
					<json:property name="carImg" value="${inventory.carImg}"></json:property>
					<json:property name="otherImg" value="${inventory.otherImg}"></json:property>
					<json:property name="removeStorageImg" value="${inventory.removeStorageImg}"></json:property>
					<json:property name="repayCertificateImg" value="${inventory.repayCertificateImg}"></json:property>
					<json:property name="explainImg" value="${inventory.explainImg}"></json:property>
					<json:property name="status" value="${inventory.status}"></json:property>
					<json:property name="createAt" value="${inventory.createAt}"></json:property>
					<json:property name="updateAt" value="${inventory.updateAt}"></json:property>
					<json:property name="createBy" value="${inventory.createBy}"></json:property>
					<json:property name="updateBy" value="${inventory.updateBy}"></json:property>
					<json:property name="type" value="1"></json:property>
				</json:object>
			</c:forEach>
		</json:array>

		<json:array name="inspectList">
			<c:forEach items="${inspectList}" var="inspect">
				<json:object>
					<json:property name="inspectListId" value="${inspect.id}"></json:property>
					<%-- <json:property name="venderTaskId" value="${inspect.venderTaskId}"></json:property>
					<json:property name="memberTaskId" value="${inspect.memberTaskId}"></json:property>
					<json:property name="distributorName"
						value="${inspect.distributorName}"></json:property> --%>
					<json:property name="vinNo" value="${inspect.vinNo}"></json:property>
					<json:property name="settlementDate"
						value="${inspect.settlementDate}"></json:property>
					<json:property name="auditResult" value="${inspect.auditResult}"></json:property>
					<json:property name="removeStorageAt"
						value="${inspect.removeStorageAt}"></json:property>
					<json:property name="comment" value="${inspect.comment}"></json:property>
					<json:property name="removeStorageImg"
						value="${inspect.removeStorageImg}"></json:property>
					<json:property name="vinNoImg" value="${inspect.vinNoImg}"></json:property>
					<json:property name="otherImg" value="${inspect.otherImg}"></json:property>
					<json:property name="status" value="${inspect.status}"></json:property>
					<json:property name="createAt" value="${inspect.createAt}"></json:property>
					<json:property name="updateAt" value="${inspect.updateAt}"></json:property>
					<json:property name="createBy" value="${inspect.createBy}"></json:property>
					<json:property name="updateBy" value="${inspect.updateBy}"></json:property>
					<json:property name="type" value="2"></json:property>
				</json:object>
			</c:forEach>
		</json:array>

		<json:object name="memberStorage">
			<json:property name="memberStorageId" value="${memberStorage.id}"></json:property>
			<%-- <json:property name="memberTaskId"
				value="${memberStorage.memberTaskId}"></json:property> --%>
			<json:property name="memberStorageImg"
				value="${memberStorage.memberStorageImg}"></json:property>
			<json:property name="memberStoragekeyImg" value="${memberStorage.keyImg}"></json:property>
			<json:property name="memberStorageName"
				value="${memberStorage.storageName}"></json:property>
			<json:property name="otherImg" value="${memberStorage.otherImg}"></json:property>
			<json:property name="status" value="${memberStorage.status}"></json:property>
			<json:property name="createAt" value="${memberStorage.createAt}"></json:property>
			<json:property name="updateAt" value="${memberStorage.updateAt}"></json:property>
			<json:property name="createBy" value="${memberStorage.createBy}"></json:property>
			<json:property name="updateBy" value="${memberStorage.updateBy}"></json:property>
		</json:object>
		
		<json:object name="enrouteSaledReport">
		    <json:property name="enrouteSaledReportStatus" value="${enrouteSaledReport.status}"></json:property>
		</json:object>

	</json:object>
</json:object>
