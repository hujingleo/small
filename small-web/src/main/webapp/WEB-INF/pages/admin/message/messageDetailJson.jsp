<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:object name="message">
        <json:property name="id" value="${message.id}"></json:property>


        <json:property name="openId" value="${message.openId}"></json:property>


        <json:property name="content" value="${message.content}"></json:property>


        <json:property name="updateAt" value="${message.updateAt}"></json:property>


        <json:property name="createAt" value="${message.createAt}"></json:property>
	   <json:property name="createTime" value="${message.createTime}"></json:property>
        </json:object>
    </json:object>

</json:object>


