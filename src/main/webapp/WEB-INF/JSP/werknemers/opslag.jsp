<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Opslag Werknemer' />
</head>
<body>
	<h2>Huidig Salaris</h2>
	<h3>
		<fmt:formatNumber value='${salaris}' />
	</h3>
	<c:url value='/werknemer/opslag' var='url' />
	<form:form action='${url}' commandName='opslagWerknemer'>
		<form:label path='bedrag'>Bedrag<form:errors
				path='bedrag' />
		</form:label>
		<%-- 		<form:input path='bedrag' autofocus='autofocus' type='number' --%>
		<%-- 			required='required' min='1' /> --%>
		<form:input path='bedrag' autofocus='autofocus' />
		<input type='submit' value='Wijzigen'>
	</form:form>
</body>
</html>