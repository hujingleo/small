<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>
<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:object name="data">
		<!-- report表的基本信息 -->
		<json:object name="report">
			<json:property name="id" value="${report.id}"></json:property>
			<json:property name="createAt" value="${report.createAt}"></json:property>
			<json:property name="venderTaskId" value="${report.venderTaskId}"></json:property>
			<json:property name="memberTaskIds" value="${report.memberTaskIds}"></json:property>
			<json:property name="distributorName"
				value="${report.distributorName}"></json:property>
			<json:property name="memberNames" value="${report.memberNames}"></json:property>
			<json:property name="planBeginAt" value="${report.planBeginAt}"></json:property>
		</json:object>
		<!-- 第一部分：库存审计清单 -->
		<json:array name="inventoryList">
			<c:forEach items="${inventoryList}" var="inventory">
				<json:object>
					<json:property name="id" value="${inventory.id}"></json:property>
					<json:property name="unitNo" value="${inventory.unitNo}"></json:property>
					<json:property name="vinNo" value="${inventory.vinNo}"></json:property>
					<json:property name="make" value="${inventory.make}"></json:property>
					<json:property name="assetCond" value="${inventory.assetCond}"></json:property>
					<json:property name="colorName" value="${inventory.colorName}"></json:property>
					<json:property name="auditResult" value="${inventory.auditResult}"></json:property>
					<json:property name="mileage" value="${inventory.mileage}"></json:property>
					<json:property name="updateAt" value="${inventory.updateAt}"></json:property>
					<json:property name="storageName" value="${inventory.storageName}"></json:property>
					<json:property name="auditDirection"
						value="${inventory.auditDirection}"></json:property>
					<json:property name="auditDistance"
						value="${inventory.auditDistance}"></json:property>
					<json:property name="comment" value="${inventory.comment}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
		<!-- 第一部分：停放地址 -->
		<json:object name="enrouteSaledReport">
			<json:property name="id" value="${enrouteSaledReport.id}"></json:property>
			<json:property name="head" value="${enrouteSaledReport.head}"></json:property>
			<json:property name="seconds" value="${enrouteSaledReport.seconds}"></json:property>
			<json:property name="saledNum" value="${enrouteSaledReport.saledNum}"></json:property>
			<json:property name="enrouteNum"
				value="${enrouteSaledReport.enrouteNum}"></json:property>
			<json:property name="otherNum" value="${enrouteSaledReport.otherNum}"></json:property>
			<json:property name="totalCarNum"
				value="${enrouteSaledReport.totalCarNum}"></json:property>
		</json:object>
		<!-- 第二部分：倒查审计清单 -->
		<json:array name="inspectList">
			<c:forEach items="${inspectList}" var="inspect">
				<json:object>
					<json:property name="id" value="${inspect.id}"></json:property>
					<json:property name="vinNo" value="${inspect.vinNo}"></json:property>
					<json:property name="settlementDate"
						value="${inspect.settlementDate}"></json:property>
					<json:property name="removeStorageAt"
						value="${inspect.removeStorageAt}"></json:property>
					<json:property name="auditResult" value="${inspect.auditResult}"></json:property>
					<json:property name="updateAt" value="${inspect.updateAt}"></json:property>
					<json:property name="auditDirection"
						value="${inspect.auditDirection}"></json:property>
					<json:property name="auditDistance"
						value="${inventory.auditDistance}"></json:property>
					<json:property name="comment" value="${inspect.comment}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
		<!-- 第三部分：审计任务附表 -->
		<json:object name="reportDetail">
			<json:property name="distributorName"
				value="${reportDetail.distributorName}"></json:property>
			<json:property name="planBeginAt" value="${reportDetail.planBeginAt}"></json:property>
			<json:property name="beginAt" value="${reportDetail.beginAt}"></json:property>
			<json:property name="headMemberName"
				value="${reportDetail.headMemberName}"></json:property>
			<json:property name="problemOne" value="${reportDetail.problemOne}"></json:property>
			<json:property name="problemTwo" value="${reportDetail.problemTwo}"></json:property>
			<json:property name="problemThree"
				value="${reportDetail.problemThree}"></json:property>
			<json:property name="problemFour" value="${reportDetail.problemFour}"></json:property>
			<json:property name="problemFive" value="${reportDetail.problemFive}"></json:property>
			<json:property name="inventoryEnrouteNum"
				value="${reportDetail.inventoryEnrouteNum}"></json:property>
			<json:property name="inventoryInstoreNum"
				value="${reportDetail.inventoryInstoreNum}"></json:property>
			<json:property name="inventorySaledNum"
				value="${reportDetail.inventorySaledNum}"></json:property>
			<json:property name="inventoryOtherNum"
				value="${reportDetail.inventoryOtherNum}"></json:property>
			<json:property name="inspectInstoreNum"
				value="${reportDetail.inspectInstoreNum}"></json:property>
			<json:property name="inspectSaledNum"
				value="${reportDetail.inspectSaledNum}"></json:property>
			<json:property name="centraStorageNum"
				value="${reportDetail.centraStorageNum}"></json:property>
			<json:property name="secondStorageNum"
				value="${reportDetail.secondStorageNum}"></json:property>
			<json:property name="showStorageNum"
				value="${reportDetail.showStorageNum}"></json:property>
			<json:property name="unknownSecondStorage"
				value="${reportDetail.unknownSecondStorage}"></json:property>
			<json:property name="centraStorageCarNum"
				value="${reportDetail.centraStorageCarNum}"></json:property>
			<json:property name="secondStorageCarNum"
				value="${reportDetail.secondStorageCarNum}"></json:property>
			<json:property name="showStorageCarNum"
				value="${reportDetail.showStorageCarNum}"></json:property>
			<json:property name="unknownSecondStorage"
				value="${reportDetail.unknownSecondStorage}"></json:property>
			<json:property name="memberSignImg"
				value="${reportDetail.memberSignImg}"></json:property>
			<json:property name="distributorSignImg"
				value="${reportDetail.distributorSignImg}"></json:property>
			<json:property name="distributorPosition"
				value="${reportDetail.distributorPosition}"></json:property>
			<json:property name="taskSummaryUpdateAt"
				value="${reportDetail.taskSummaryUpdateAt}"></json:property>
			<!-- 标准统计数据，用来修正任务总结的数据 -->
			<json:property name="inventoryEnrouteCount"
				value="${reportDetail.inventoryEnrouteCount}"></json:property>
			<json:property name="inventoryInstoreCount"
				value="${reportDetail.inventoryInstoreCount}"></json:property>
			<json:property name="inventorySaledCount"
				value="${reportDetail.inventorySaledCount}"></json:property>
			<json:property name="inventoryOtherCount"
				value="${reportDetail.inventoryOtherCount}"></json:property>
			<json:property name="inspectInstoreCount"
				value="${reportDetail.inspectInstoreCount}"></json:property>
			<json:property name="inspectSaledCount"
				value="${reportDetail.inspectSaledCount}"></json:property>
		</json:object>
		<!-- 第三部分：审计任务附表 ，盘库审计结果是其他的车-->
		<json:array name="inventoryOtherList">
			<c:forEach items="${inventoryOtherList}" var="inventory">
				<json:object>
					<json:property name="unitNo" value="${inventory.unitNo}"></json:property>
					<json:property name="vinNo" value="${inventory.vinNo}"></json:property>
					<json:property name="comment" value="${inventory.comment}"></json:property>
					<json:property name="auditResult" value="${inventory.auditResult}"></json:property>
				</json:object>
			</c:forEach>
		</json:array>
		<!-- 第四部分：风控监管员盘库任务结束签收 -->
		<json:object name="closeSignIn">
			<json:property name="distributorName"
				value="${closeSignIn.distributorName}"></json:property>
			<json:property name="beginYear" value="${closeSignIn.beginYear}"></json:property>
			<json:property name="beginMonth" value="${closeSignIn.beginMonth}"></json:property>
			<json:property name="beginDay" value="${closeSignIn.beginDay}"></json:property>
			<json:property name="endYear" value="${closeSignIn.endYear}"></json:property>
			<json:property name="endMonth" value="${closeSignIn.endMonth}"></json:property>
			<json:property name="endDay" value="${closeSignIn.endDay}"></json:property>
			<json:property name="hasException"
				value="${closeSignIn.hasException}"></json:property>
			<json:property name="memberSignImg"
				value="${closeSignIn.memberSignImg}"></json:property>
			<json:property name="distributorSignImg"
				value="${closeSignIn.distributorSignImg}"></json:property>
		</json:object>
	</json:object>
</json:object>
