<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

long districtId = ((District)row.getObject()).getDistrictId();
%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editURL">
        <portlet:param name="districtId" value="<%= String.valueOf(districtId) %>" />
        <portlet:param name="mvcPath" value="/jsp/districts/edit_district.jsp" />
        <portlet:param name="backURL" value="<%= currentURL %>" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Редактировать" url="<%=editURL.toString() %>" />

    <portlet:actionURL name="archiveDistrict" var="archiveURL">
        <portlet:param name="districtId" value="<%= String.valueOf(districtId) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="attributes" message="В архив" url="<%=archiveURL.toString() %>" />

    <portlet:actionURL name="deleteDistrict" var="deleteURL">
        <portlet:param name="districtId" value="<%= String.valueOf(districtId) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" message="Удалить" />
</liferay-ui:icon-menu>