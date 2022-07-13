<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@ include file="init.jsp" %>

<liferay-ui:success key="farmer-update-success" message="Данные фермера успешно обновлены" />
<liferay-ui:success key="farmer-delete-success" message="Запись фермера успешно удалена" />
<liferay-ui:error key="farmer-update-error" message="Ошибка обновления данных фермера" />
<liferay-ui:error key="farmer-delete-error" message="Ошибка удаления данных фермера" />


<%
String currentURL = PortalUtil.getCurrentURL(request);
String name = ParamUtil.getString(request, "name");
String district = ParamUtil.getString(request, "district");
long inn = ParamUtil.getLong(request, "inn");
int status = ParamUtil.getInteger(request, "status");
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
String startDate = ParamUtil.getString(request, "startDate");
String endDate = ParamUtil.getString(request, "endDate");

%>

<h1>Реестр фермеров</h1>

<portlet:renderURL var="homeURL"></portlet:renderURL>
<a href="<%=homeURL.toString() %>">На главную</a><br/><br/>
<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="mvcPath" value="/jsp/farmers/view_farmers.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="editFarmerURL">
    <portlet:param name="mvcPath" value="/jsp/farmers/edit_farmer.jsp"/>
    <portlet:param name="backURL" value="<%=currentURL %>"/>
</portlet:renderURL>

<a href="<%=editFarmerURL.toString()%>">Добавить фермера</a><br/>
<div class="separator"></div>

<liferay-portlet:renderURL varImpl="farmerSearchURL">
    <portlet:param name="mvcPath" value="/jsp/farmers/view_farmers.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=farmerSearchURL %>" method="get" name="farmerForm">
<liferay-portlet:renderURLParams varImpl="farmerSearchURL" />

<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="name" value="<%= name %>" />
    <portlet:param name="inn" value="<%= String.valueOf(inn) %>" />
    <portlet:param name="district" value="<%= district %>" />
    <portlet:param name="status" value="<%= String.valueOf(status) %>" />
    <portlet:param name="startDate" value="<%= startDate %>" />
    <portlet:param name="endDate" value="<%= endDate %>" />
    <portlet:param name="mvcPath" value="/jsp/farmers/view_farmers.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="there-are-no-farmers"
displayTerms="<%= new DisplayTerms(renderRequest) %>"
iteratorURL="<%=iteratorURL %>"
delta="10"
>
    <liferay-ui:search-form page="/jsp/farmers/farmers_search.jsp" servletContext="<%= application %>" />

    <liferay-ui:search-container-results>
    <%
    DisplayTerms displayTerms=searchContainer.getDisplayTerms();
    if (displayTerms.isAdvancedSearch()) {
        total = FarmerLocalServiceUtil.getSearchFarmersCount(name, inn, district, status, startDate, endDate, displayTerms.isAndOperator());
        searchContainer.setTotal(total);
        searchContainer.setResults(FarmerLocalServiceUtil.getSearchFarmers(name, inn, district, status, startDate, endDate, displayTerms.isAndOperator(),
            searchContainer.getStart(), searchContainer.getEnd(), null));
    } else {
        String searchkeywords = displayTerms.getKeywords();
        String numbesearchkeywords = Validator.isNumber(searchkeywords) ? searchkeywords : String.valueOf(0);
        total = FarmerLocalServiceUtil.getSearchFarmersCount(name, inn, district, status, startDate, endDate, displayTerms.isAndOperator());
        searchContainer.setTotal(total);
        searchContainer.setResults(FarmerLocalServiceUtil.getSearchFarmers(searchkeywords, Long.parseLong(numbesearchkeywords),
            searchkeywords, 0, "", "", false, searchContainer.getStart(), searchContainer.getEnd(), null));
    }
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row className="com.test.farmers.model.Farmer"
    keyProperty="farmerId" modelVar="currentFarmer">
        <liferay-ui:search-container-column-text name="Наименование фермера" property="name" />
        <liferay-ui:search-container-column-text name="Орг./правовая форма" property="legalForm" />
		<liferay-ui:search-container-column-text name="ИНН" property="inn" />
		<liferay-ui:search-container-column-text name="КПП" property="kpp" />
		<liferay-ui:search-container-column-text name="ОГРН" property="ogrn" />
		<liferay-ui:search-container-column-text name="Район регистрации"
		    value='<%=currentFarmer.getDistrictId()==0?"":DistrictLocalServiceUtil.getDistrict(currentFarmer.getDistrictId()).getName() %>' />
		<liferay-ui:search-container-column-text name="Дата регистрации"
		    value='<%=formatter.format(currentFarmer.getRegistrationDate()) %>' />
        <liferay-ui:search-container-column-text name="Статус"
            value='<%=currentFarmer.getIsArchive()==true?"Архивный":"Актуальный" %>' />
		<liferay-ui:search-container-column-jsp path="/jsp/farmers/farmer_actions.jsp" align="right" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>
</aui:form>
