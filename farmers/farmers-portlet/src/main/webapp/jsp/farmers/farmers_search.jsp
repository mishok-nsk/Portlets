<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ include file="init.jsp" %>
<%
String name = ParamUtil.getString(request, "name");
String district = ParamUtil.getString(request, "district");
long inn = ParamUtil.getLong(request, "inn");
int status = ParamUtil.getInteger(request, "status");
String startDate = ParamUtil.getString(request, "startDate");
String endDate = ParamUtil.getString(request, "endDate");

SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Поиск" displayTerms="<%= displayTerms %>" id="toggle_id_farmer_search">
    <aui:input label="Наименование фермера" name="name" value="<%=name %>" />
    <aui:input label="ИНН" name="inn" value="<%=inn %>" />
    <aui:input label="Район регистрации" name="district" value="<%=district %>" />
    <label class="aui-field-label">Дата регистрации:</label>
    <label class="aui-field-label">с</label>
    <input name="<portlet:namespace/>startDate" class="form-control date" type="text" placeholder="dd-mm-yyyy" value="<%= startDate %>">
    <label class="aui-field-label">по</label>
    <input name="<portlet:namespace/>endDate" class="form-control date" type="text" placeholder="dd-mm-yyyy" value="<%= endDate %>">
    <aui:select label="Статус" name="status">
        <aui:option label="Все" value="0"></aui:option>
        <aui:option label="Актуальный" value="1"></aui:option>
        <aui:option label="Архивный" value="2"></aui:option>
    </aui:select>
</liferay-ui:search-toggle>

<aui:script>
    AUI().use('aui-datepicker', function(A) {
        new A.DatePicker({
            trigger: '.date',
            mask: '%d-%m-%Y',
            popover: {
                zIndex: 1000
            }
        });
    });
</aui:script>