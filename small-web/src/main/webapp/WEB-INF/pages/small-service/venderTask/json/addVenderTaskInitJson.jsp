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
    
    <json:array name="venders">
      <c:forEach items="${venderList}" var="vender">
        <json:object>
          <json:property name="venderId" value="${vender.id}"></json:property>
          <json:property name="venderName" value="${vender.name}"></json:property>
        </json:object>
      </c:forEach>
    </json:array>
    
    <json:array name="thirdPartyTeams">
      <c:forEach items="${thirdPartyTeamList}" var="team">
        <json:object>
          <json:property name="teamId" value="${team.id}"></json:property>
          <json:property name="teamName" value="${team.name}"></json:property>
        </json:object>
      </c:forEach>
    </json:array>
    
    <json:array name="venderTeams">
      <c:forEach items="${venderTeamList}" var="team">
        <json:object>
          <json:property name="teamId" value="${team.id}"></json:property>
          <json:property name="teamName" value="${team.name}"></json:property>
        </json:object>
      </c:forEach>
    </json:array>
  </json:object>

</json:object>


