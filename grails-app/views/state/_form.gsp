<%@ page import="states.State" %>



<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="state.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${stateInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'locations', 'error')} ">
	<label for="locations">
		<g:message code="state.locations.label" default="Locations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${stateInstance?.locations?}" var="l">
    <li><g:link controller="location" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="location" action="create" params="['state.id': stateInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'location.label', default: 'Location')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="state.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${stateInstance?.name}"/>
</div>

