<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="comment" id="current_nav">
<div id="commentApp" ng-app="commentApp">
	<div ng-controller="commentController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Comment管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addComment(comment)">新增</span>
		    </span>
	
			<paging url="/web/a/comment">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id主键自增</td>
			        				                    <td>用户id</td>
			        				                    <td>内容</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="comment in data">				
									                    <td ng-bind="comment.id" ></td>
			        				                    <td ng-bind="comment.openId" ></td>
			        				                    <td ng-bind="comment.content" ></td>
			        				                    <td ng-bind="comment.updatAt" ></td>
			        				                    <td ng-bind="comment.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateComment(comment.id)" /> 
							<input type="button" value="删除" ng-click="deleteComment(comment.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/small-pub-service/comment/commentList.js"></script>
