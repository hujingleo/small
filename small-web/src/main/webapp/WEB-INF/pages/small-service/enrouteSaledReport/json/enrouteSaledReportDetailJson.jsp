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





			<json:property name="saledNum" value="${enrouteSaledReport.saledNum}"></json:property>





			<json:property name="eachStorageId"
				value="${enrouteSaledReport.eachStorageId}"></json:property>





			<json:property name="eachStorageNum"
				value="${enrouteSaledReport.eachStorageNum}"></json:property>





			<json:property name="otherNum" value="${enrouteSaledReport.otherNum}"></json:property>





			<json:property name="status" value="${enrouteSaledReport.status}"></json:property>





			<json:property name="createAt" value="${enrouteSaledReport.createAt}"></json:property>





			<json:property name="updateAt" value="${enrouteSaledReport.updateAt}"></json:property>





			<json:property name="createBy" value="${enrouteSaledReport.createBy}"></json:property>





			<json:property name="updateBy" value="${enrouteSaledReport.updateBy}"></json:property>

			<json:property name="headStorageNum"
				value="${enrouteSaledReport.headStorageNum}"></json:property>
			<json:property name="blankBillImg" value="${enrouteSaledReport.blankBillImg}"></json:property>
			<json:property name="blankOutStorageImg"
				value="${enrouteSaledReport.blankOutStorageImg}"></json:property>
			<json:property name="distributorSignImg"
				value="${enrouteSaledReport.distributorSignImg}"></json:property>



		</json:object>
		<json:array name="inventoryList">
			<c:forEach items="${inventoryList}" var="inventory">
				<json:object>
					<json:property name="id" value="${inventory.id}"></json:property>





					<json:property name="venderTaskId"
						value="${inventory.venderTaskId}"></json:property>





					<json:property name="memberTaskId"
						value="${inventory.memberTaskId}"></json:property>





					<json:property name="distributorName"
						value="${inventory.distributorName}"></json:property>





					<json:property name="vinNo" value="${inventory.vinNo}"></json:property>





					<json:property name="unitNo" value="${inventory.unitNo}"></json:property>





					<json:property name="make" value="${inventory.make}"></json:property>





					<json:property name="assetCond" value="${inventory.assetCond}"></json:property>





					<json:property name="auditResult" value="${inventory.auditResult}"></json:property>





					<json:property name="mileage" value="${inventory.mileage}"></json:property>





					<json:property name="color" value="${inventory.color}"></json:property>
					
					
					
					
					
					<json:property name="colorName" value="${inventory.colorName}"></json:property>





					<json:property name="comment" value="${inventory.comment}"></json:property>





					<json:property name="vinNoImg" value="${inventory.vinNoImg}"></json:property>





					<json:property name="mileageImg" value="${inventory.mileageImg}"></json:property>





					<json:property name="nameplateImg"
						value="${inventory.nameplateImg}"></json:property>





					<json:property name="carImg" value="${inventory.carImg}"></json:property>





					<json:property name="otherImg" value="${inventory.otherImg}"></json:property>





					<json:property name="status" value="${inventory.status}"></json:property>





					<json:property name="createAt" value="${inventory.createAt}"></json:property>





					<json:property name="updateAt" value="${inventory.updateAt}"></json:property>



					<json:property name="beginAt" value="${enrouteSaledReport.beginAt}"></json:property>





					<json:property name="planBeginAt"
						value="${enrouteSaledReport.planBeginAt}"></json:property>





					<json:property name="auditDirection"
						value="${enrouteSaledReport.auditDirection}"></json:property>





					<json:property name="auditDistance"
						value="${enrouteSaledReport.auditDistance}"></json:property>

					<json:property name="createBy" value="${inventory.createBy}"></json:property>





					<json:property name="updateBy" value="${inventory.updateBy}"></json:property>





				</json:object>
			</c:forEach>
		</json:array>
		<json:array name="storageList">
			<c:forEach items="${storageList}" var="storage">
				<json:object>


					<json:property name="id" value="${storage.id}"></json:property>





					<json:property name="name" value="${storage.name}"></json:property>





					<json:property name="attribute" value="${storage.attribute}"></json:property>





					<json:property name="latitude" value="${storage.latitude}"></json:property>





					<json:property name="longitude" value="${storage.longitude}"></json:property>





					<json:property name="province" value="${storage.province}"></json:property>





					<json:property name="city" value="${storage.city}"></json:property>

					<json:property name="cityName" value="${distributor.cityName}"></json:property>
					<json:property name="provinceName"
						value="${distributor.provinceName}"></json:property>



					<json:property name="address" value="${storage.address}"></json:property>





					<json:property name="contactsName" value="${storage.contactsName}"></json:property>





					<json:property name="contactsPost" value="${storage.contactsPost}"></json:property>





					<json:property name="contactsPhone"
						value="${storage.contactsPhone}"></json:property>





					<json:property name="internalRemark"
						value="${storage.internalRemark}"></json:property>





					<json:property name="suditorRemark"
						value="${storage.suditorRemark}"></json:property>





					<json:property name="activityStartTime"
						value="${storage.activityStartTime}"></json:property>





					<json:property name="activityEndTime"
						value="${storage.activityEndTime}"></json:property>





					<json:property name="status" value="${storage.status}"></json:property>


					<json:property name="distributorId"
						value="${storage.distributorId}"></json:property>


					<json:property name="createBy" value="${storage.createBy}"></json:property>





					<json:property name="updateBy" value="${storage.updateBy}"></json:property>





					<json:property name="updateAt" value="${storage.updateAt}"></json:property>





					<json:property name="createAt" value="${storage.createAt}"></json:property>


					<json:property name="carNum" value="${storage.carNum}"></json:property>
					
					
					<json:property name="attributeName" value="${storage.attributeName}"></json:property>

				</json:object>
			</c:forEach>
		</json:array>

	</json:object>

</json:object>


