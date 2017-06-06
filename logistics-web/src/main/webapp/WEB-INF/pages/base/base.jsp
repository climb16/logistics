<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- 启用 el --%>
<%@ page isELIgnored="false"%>
<c:set value="${pageContext.request.contextPath}" var="ctx" scope="application"/>
<c:set value="专注你的托付--无锡远翔官方网站" var="key_title" scope="application"/>
<c:set value="远翔物流，专注于国内高速陆路运输，快捷、安全、方便" var="key_description" scope="application"/>
<c:set value="远翔、物流、货运" var="key_word" scope="application"/>
<script src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script src="${ctx}/js/modernizr-2.8.3.min.js"></script>
<link href="${ctx}/css/normalize.css"/>
<link rel="icon" href="${ctx}/img/apple-touch-icon.png" type="image/x-icon">