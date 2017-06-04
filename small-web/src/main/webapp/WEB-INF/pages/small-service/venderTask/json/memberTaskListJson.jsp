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
	<json:property name="totalPage" value="${totalPage}"></json:property>

		<json:array name="data">
			<c:forEach items="${memberTaskList}" var="memberTask">
				<json:object>
					<json:property name="id" value="${memberTask.id}"></json:property>
					<json:property name="storageName" value="${memberTask.storageName}"></json:property>
					<json:property name="storageProvince"
						value="${memberTask.storageProvince}"></json:property>
					<json:property name="storageCity" value="${memberTask.storageCity}"></json:property>
					<json:property name="storageAddress" value="${memberTask.storageAddress}"></json:property>
					<json:property name="updateByName" value="${memberTask.updateByName}"></json:property>
					<json:property name="updateBy" value="${memberTask.updateBy}"></json:property>
					<json:property name="updateAt" value="${memberTask.updateAt}"></json:property>
					<json:property name="planBeginAt" value="${memberTask.planBeginAt}"></json:property>
					<json:property name="memberId" value="${memberTask.memberId}"></json:property>
					<json:property name="memberName" value="${memberTask.memberName}"></json:property>
					<json:property name="beginAt" value="${memberTask.beginAt}"></json:property>
					<json:property name="status" value="${memberTask.status}"></json:property>
					<json:property name="isWithdraw" value="${memberTask.isWithdraw}"></json:property>
					<json:property name="withdrawCause" value="${memberTask.withdrawCause}"></json:property>
					<json:property name="memberStatus" value="${memberTask.memberStatus}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
</json:object>
