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
		<c:forEach items="${commentDataList}" var="commentDataMap">
			<json:object>
				<json:property name="userAvatarUrl" value="${commentDataMap.userAvatarUrl}"></json:property>
				<json:property name="nickName" value="${commentDataMap.nickName}"></json:property>
				<json:property name="commentOpenId" value="${commentDataMap.commentOpenId}"></json:property>
				<json:property name="commentContent" value="${commentDataMap.commentContent}"></json:property>
				<json:property name="commentCreateAt" value="${commentDataMap.commentCreateAt}"></json:property>
				<json:property name="createTime" value="${commentDataMap.createTime}"></json:property>
			</json:object>
		</c:forEach>
	</json:array>
</json:object>


