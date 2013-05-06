<%@ page import="states.State" %>



<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="state.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${stateInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="state.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${stateInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'zipCount', 'error')} required">
	<label for="zipCount">
		<g:message code="state.zipCount.label" default="Zip Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="zipCount" type="number" value="${stateInstance.zipCount}" required=""/>
</div>

