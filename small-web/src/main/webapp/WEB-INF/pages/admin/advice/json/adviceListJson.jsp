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
    <json:property name="page" value="${page}"></json:property>
    <json:array name="data">
        <c:forEach items="${adviceList}" var="advice">
            <json:object>


                <json:property name="id" value="${advice.id}"></json:property>


                <json:property name="description" value="${advice.description}"></json:property>


                <json:property name="contactInformation" value="${advice.contactInformation}"></json:property>


                <json:property name="createBy" value="${advice.createBy}"></json:property>


                <json:property name="createAt" value="${advice.createAt}"></json:property>



            </json:object>
        </c:forEach>
    </json:array>
</json:object>

