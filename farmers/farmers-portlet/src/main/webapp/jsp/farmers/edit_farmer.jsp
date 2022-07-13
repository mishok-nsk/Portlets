<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "backURL");
long farmerId = ParamUtil.getLong(request, "farmerId");
Farmer farmer = null;
Date date = new Date();
List<District> farmerFields = DistrictLocalServiceUtil.getFarmerDistricts(farmerId);
if (farmerId > 0) {
    farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
    date = farmer.getRegistrationDate();
}
SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
String dateString = df.format(date);

%>
<a href="<%=redirect %>">Назад</a><br/><br/>

<portlet:actionURL var="editFarmerActionURL" windowState="normal" name="editFarmer" />
<h2>Редактирование данных фермера</h2>
<aui:form action="<%=editFarmerActionURL %>" name="<portlet:namespace />form">
    <aui:model-context bean="<%=farmer %>" model="<%=Farmer.class %>" />
    <aui:fieldset>
        <aui:input name="name" label="Наименование фермера">
            <aui:validator name="required" errorMessage="Введите наименование фермера." />
        </aui:input>
        <aui:select name="legalForm" label="Орг./правовая форма" >
            <aui:option value="ЮР">ЮР</aui:option>
            <aui:option value="ИП">ИП</aui:option>
            <aui:option value="ФЛ">ФЛ</aui:option>
        </aui:select>
		<aui:input name="inn" label="ИНН">
		    <aui:validator name="digits" errorMessage="Поле должно содержать только цифры." />
            <aui:validator name="rangeLength" errorMessage="ИНН должно состоять из 10 цифр.">[10,10]</aui:validator>
		</aui:input>
		<aui:input name="kpp" label="КПП">
		    <aui:validator name="digits" errorMessage="Поле должно содержать только цифры." />
            <aui:validator name="rangeLength" errorMessage="КПП должно состоять из 9 цифр.">[9,9]</aui:validator>
		</aui:input>
		<aui:input name="ogrn" label="ОГРН">
		    <aui:validator name="digits" errorMessage="Поле должно содержать только цифры." />
            <aui:validator name="rangeLength" errorMessage="ОГРН должно состоять из 13 цифр.">[13,13]</aui:validator>
		</aui:input>
		<aui:select name="districtId" label="Район регистрации">
            <%
            List<District> districtList=DistrictLocalServiceUtil.getDistricts();
            for(District district:districtList){%>
            <aui:option value="<%=district.getDistrictId()%>" label="<%=district.getName()%>"></aui:option>
            <%}%>
        </aui:select>
        <aui:select name="districtField" label="Районы посевных полей" multiple="true" size="10">
            <%
            List<District> districtList=DistrictLocalServiceUtil.getDistricts();
            for(District district:districtList){%>
            <aui:option value="<%=district.getDistrictId()%>" label="<%=district.getName()%>" selected='<%=farmerFields.contains(district) %>' ></aui:option>
            <%}%>
        </aui:select>

        <label class="aui-field-label">Дата регистрации</label>
        <input name="<portlet:namespace/>registrationDate" class="form-control date" type="text" placeholder="dd-mm-yyyy" value="<%= dateString %>">

        <aui:input name="farmerId" type="hidden" />
    </aui:fieldset>
    <aui:button-row>

            <aui:button type="submit" value="Сохранить"/>

    </aui:button-row>
</aui:form>

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
