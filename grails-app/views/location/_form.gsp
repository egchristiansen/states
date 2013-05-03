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

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="location.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitude" value="${fieldValue(bean: locationInstance, field: 'latitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="location.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitude" value="${fieldValue(bean: locationInstance, field: 'longitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'zipCode', 'error')} ">
	<label for="zipCode">
		<g:message code="location.zipCode.label" default="Zip Code" />
		
	</label>
	<g:textField name="zipCode" value="${locationInstance?.zipCode}"/>
</div>

