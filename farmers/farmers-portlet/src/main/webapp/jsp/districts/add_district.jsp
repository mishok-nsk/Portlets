<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:actionURL var="addDistrictActionURL" windowState="normal" 
name="addDistrict">
</portlet:actionURL>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"district-add-success")){%>
<liferay-ui:success key="district-add-success" message="District information have been added successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),
"district-add-error")){%>
<liferay-ui:error key="district-add-error" message="There is an Error occured while adding district please try again" />
<%} %>
<h2>Add District</h2>
<a href="<%=homeURL.toString() %>">Home</a><br/><br/>
<form action="<%=addDistrictActionURL%>" name="districtForm"  method="POST">
<b>District Name</b><br/>
<input  type="text" name="<portlet:namespace/>name" id="<portlet:namespace/>name"/><br/>
<b>Code</b><br/>
<input type="text" name="<portlet:namespace/>code" id="<portlet:namespace/>code"/><br/>
<b>Archive</b><br/>
<input type="checkbox" name="<portlet:namespace/>isArchive" value="true">archive<br>
<input type="submit" name="addDistrict" id="addDistrict" value="Add District"/>
</form>