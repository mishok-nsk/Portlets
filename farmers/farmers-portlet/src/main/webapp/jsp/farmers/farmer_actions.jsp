<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

long farmerId = ((Farmer)row.getObject()).getFarmerId();

String currentURL = PortalUtil.getCurrentURL(request);
%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editURL">
        <portlet:param name="farmerId" value="<%= String.valueOf(farmerId) %>" />
        <portlet:param name="mvcPath" value="/jsp/farmers/edit_farmer.jsp" />
        <portlet:param name="backURL" value="<%= currentURL %>" />
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Редактировать" url="<%=editURL.toString() %>" />

    <portlet:actionURL name="changeArchiveStatus" var="archiveURL">
        <portlet:param name="farmerId" value="<%= String.valueOf(farmerId) %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="attributes" message="Изменить статус" url="<%=archiveURL.toString() %>" />

    <portlet:actionURL name="deleteFarmer" var="deleteURL">
        <portlet:param name="farmerId" value="<%= String.valueOf(farmerId) %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" message="Удалить"/>
</liferay-ui:icon-menu>