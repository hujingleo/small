<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

	<json:object name="data">
		<json:object name="distributor">
			<json:property name="id" value="${distributor.id}"></json:property>
			<json:property name="companyName" value="${distributor.companyName}"></json:property>
			<json:property name="companyShortName"
				value="${distributor.companyShortName}"></json:property>
			<json:property name="province" value="${distributor.province}"></json:property>
			<json:property name="city" value="${distributor.city}"></json:property>
			<json:property name="cityName" value="${distributor.cityName}"></json:property>
			<json:property name="provinceName"
				value="${distributor.provinceName}"></json:property>
			<json:property name="contactsName"
				value="${distributor.contactsName}"></json:property>
			<json:property name="contactsPost"
				value="${distributor.contactsPost}"></json:property>
			<json:property name="contactsPhone"
				value="${distributor.contactsPhone}"></json:property>
			<json:property name="internalRemark"
				value="${distributor.internalRemark}"></json:property>
			<json:property name="suditorRemark"
				value="${distributor.suditorRemark}"></json:property>
			<json:property name="status" value="${distributor.status}"></json:property>
			<json:property name="createBy" value="${distributor.createBy}"></json:property>
			<json:property name="updateBy" value="${distributor.updateBy}"></json:property>
			<json:property name="updateAt" value="${distributor.updateAt}"></json:property>
			<json:property name="createAt" value="${distributor.createAt}"></json:property>
			<json:property name="selfStorageNum"
				value="${distributor.selfStorageNum}"></json:property>
			<json:property name="secondStorageNum"
				value="${distributor.secondStorageNum}"></json:property>
			<json:property name="tempStorageNum"
				value="${distributor.tempStorageNum}"></json:property>
		</json:object>
		<json:object name="headStorage">
			<json:property name="headStorageId" value="${headStorage.id}"></json:property>
			<json:property name="detailAddress" value="${headStorage.address}"></json:property>
			<json:property name="latitude" value="${headStorage.latitude}"></json:property>
			<json:property name="longtitude" value="${headStorage.longitude}"></json:property>
		</json:object>
	</json:object>

</json:object>


