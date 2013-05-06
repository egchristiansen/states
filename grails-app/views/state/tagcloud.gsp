
<%@ page import="states.State" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'state.label', default: 'State')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<style type="text/css" media="screen">
			a:link {text-decoration:none;}
			a:visited {text-decoration:none;}
			a:hover {text-decoration:underline;}
			a:active {text-decoration:underline;}

			span.button {
				background-color: #eee;
				border: .2em solid #fff; 
				padding:4px;
				margin-left:auto;
				margin-right:auto;
			}

			span.button a:hover {text-decoration:none;}
			span.button	a:active {text-decoration:none;}
			
			div.button-bar {
				margin-top: 25px;
				padding-left: 10px;

			}

			.tag-cloud {
				padding: 10px;
			}
		</style>
	</head>
	<body>
	<div class="tag-cloud">
	<g:each in="${stateInstanceList}" status="i" var="stateInstance">
		<span style="font-size:${zipCountsbyState[stateInstance.name]}px !important">
			<g:link action="show" id="${stateInstance.id}">${fieldValue(bean: stateInstance, field: "name")}</g:link>
		</span>
	</g:each>
	</div>
	<div class="button-bar">
		<span class="button"><g:link action="deleteAll">Reload Data</g:link><span>
	</div>
	</body>

</html>