<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP i18n Example</title>
</head>
<body>

<%-- Lấy ngôn ngữ từ yêu cầu --%>
<c:set var="mangongngu" value="${param.radio_mangongngu}" />
<%-- Nếu ngôn ngữ không rỗng, đặt nó vào session --%>
<c:if test="${not empty mangongngu}">
    <f:setLocale value="${mangongngu}" scope="session" />
</c:if>

<%-- Nạp tệp properties với các chuỗi ngôn ngữ --%>
<f:setBundle basename="messages" scope="session" />

<form action="index.jsp" method="post">
    <label><f:message key="languageMessage" /></label>
    <br>
    
    <%-- Radio button cho ngôn ngữ tiếng Việt --%>
    <input type="radio" name="radio_mangongngu" value="vi-VN"
        <c:if test="${mangongngu == 'vi-VN'}">checked</c:if> />
    <f:message key="vn" />
    
    <%-- Radio button cho ngôn ngữ tiếng Anh --%>
    <input type="radio" name="radio_mangongngu" value="en-US"
        <c:if test="${mangongngu == 'en-US'}">checked</c:if> />
    <f:message key="en" />
    
    <br>
    
    <%-- Nút để chọn ngôn ngữ --%>
    <input type="submit" name="submit" value="<f:message key='chooseButton' />">
    
    <hr>
    
    <%-- Form nhập username và password --%>
    <table border="0">
        <tr>
            <td><f:message key="username" /></td>
            <td><input type="text" name="txtusername" value="" /></td>
        </tr>
        <tr>
            <td><f:message key="pass" /></td>
            <td><input type="password" name="txtpassword" value="" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="<f:message key='login' />">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
