<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="init.jsp" %>

<liferay-ui:success key="district-add-success" message="Район был успешно добавлен" />
<liferay-ui:success key="district-update-success" message="Район был успешно обновлен" />
<liferay-ui:success key="district-delete-success" message="Район был успешно удален" />
<liferay-ui:success key="district-archive-success" message="Район был переведен в архив" />
<liferay-ui:error key="district-add-error" message="Ошибка добавления района" />
<liferay-ui:error key="district-update-error" message="Ошибка обновления района" />
<liferay-ui:error key="district-delete-error" message="Ошибка удаления района" />
<liferay-ui:error key="district-archive-error" message="Ошибка изменения данных района" />

<h1>Реестр районов</h1>
<portlet:renderURL var="homeURL"></portlet:renderURL>
<a href="<%=homeURL.toString() %>">На главную</a><br/><br/>
<liferay-portlet:renderURL varImpl="iteratorURL">
<portlet:param name="mvcPath" value="/jsp/districts/view_districts.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="editDistrictURL">
    <portlet:param name="mvcPath" value="/jsp/districts/edit_district.jsp"/>
    <portlet:param name="backURL" value="<%=currentURL %>"/>
</portlet:renderURL>

<a href="<%=editDistrictURL.toString()%>">Добавить район</a><br/>
<div class="separator"></div>

<liferay-ui:search-container emptyResultsMessage="there-are-no-districts"
total="<%=DistrictLocalServiceUtil.getDistrictsCount()%>"
iteratorURL="<%=iteratorURL %>"
delta="10"
deltaConfigurable="true"
>
    <liferay-ui:search-container-results
    results="<%=DistrictLocalServiceUtil.getDistricts(searchContainer.getStart(), searchContainer.getEnd())%>"
    />

    <liferay-ui:search-container-row className="com.test.farmers.model.District"
    keyProperty="districtId" modelVar="currentDistrict">
    <liferay-portlet:renderURL varImpl="rowURL">
    <portlet:param name="backURL" value="<%= currentURL %>" />
    <portlet:param name="mvcPath" value="/jsp/districts/edit_district.jsp" />
    <portlet:param name="districtId"
    value="<%= String.valueOf(currentDistrict.getDistrictId()) %>" />
    </liferay-portlet:renderURL>
    <liferay-ui:search-container-row-parameter name="rowURL" value="<%= rowURL.toString() %>"/>
        <liferay-ui:search-container-column-text href="<%= rowURL %>" name="Наименование района" property="name" />
        <liferay-ui:search-container-column-text name="Код района" property="code" />
        <liferay-ui:search-container-column-jsp path="/jsp/districts/district_actions.jsp" align="right" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

