<%@ page import="states.Location" %>



<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="location.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${locationInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'county', 'error')} ">
	<label for="county">
		<g:message code="location.county.label" default="County" />
		
	</label>
	<g:textField name="county" value="${locationInstance?.county}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'zipCode', 'error')} ">
	<label for="zipCode">
		<g:message code="location.zipCode.label" default="Zip Code" />
		
	</label>
	<g:textField name="zipCode" value="${locationInstance?.zipCode}"/>
</div>

