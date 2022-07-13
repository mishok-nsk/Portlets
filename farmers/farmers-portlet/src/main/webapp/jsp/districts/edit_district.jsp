<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "backURL");
long districtId = ParamUtil.getLong(request, "districtId");
District selecteDistrict = null;
String title = "Добавление района";
if (districtId > 0) {
    selecteDistrict = DistrictLocalServiceUtil.getDistrict(districtId);
    title = "Редактирование района";
}
%>
<a href="<%=redirect %>">Back</a><br/><br/>

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="<%=redirect %>"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="editDistrictActionURL" windowState="normal" name="editDistrict">
    <portlet:param name="districtId" value="<%=String.valueOf(districtId) %>" />
</portlet:actionURL>
<h2><%=title %></h2>
<aui:form action="<%=editDistrictActionURL %>" name="<portlet:namespace />form">
    <aui:model-context bean="<%=selecteDistrict %>" model="<%= District.class %>" />
    <aui:fieldset>
        <aui:input name="name" label="Название района">
            <aui:validator name="required" errorMessage="Введите наименование района." />
        </aui:input>
        <aui:input name="code" label="Код района">
            <aui:validator name="digits" />
            <aui:validator name="rangeLength" errorMessage="Код должен состоять из 5 цифр.">[5,5]</aui:validator>
        </aui:input>
        <aui:input name="districtId" type="hidden" />
    </aui:fieldset>
    <aui:button-row>

            <aui:button type="submit" label="Сохранить"></aui:button>

    </aui:button-row>
</aui:form>