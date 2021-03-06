<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>


<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

	<json:object name="data">

		<json:object name="articleType">


			<json:property name="id" value="${articleType.id}"></json:property>




			<json:property name="sort" value="${articleType.sort}"></json:property>




			<json:property name="name" value="${articleType.name}"></json:property>





			<json:property name="createBy" value="${articleType.createBy}"></json:property>





			<json:property name="updateBy" value="${articleType.updateBy}"></json:property>






			<json:property name="updateAt" value="${articleType.updateAt}"></json:property>





			<json:property name="createAt" value="${articleType.createAt}"></json:property>


			<json:property name="status" value="${articleType.status}"></json:property>


		</json:object>


	</json:object>

</json:object>


