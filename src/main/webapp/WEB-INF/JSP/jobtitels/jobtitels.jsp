<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Jobtitels' />
</head>
<body>
	<nav>
		<ul>
			<c:forEach items='${jobtitels}' var='jobtitel'>
				<li><spring:url var='url' value='/jobtitels/{id}'>
						<spring:param name='id' value='${jobtitel.id}' />
					</spring:url><a href='${url}'>${jobtitel.naam}</a></li>
			</c:forEach>
		</ul>
	</nav>
	<h2>${jobtitel.naam}</h2>
	<c:forEach items='${jobtitel.werknemers}' var='werknemer'>
		<spring:url var='url' value='/werknemer/{id}'>
			<spring:param name='id' value='${werknemer.id}' />
		</spring:url>
		<a href='${url}'>${werknemer.voornaam} ${werknemer.familienaam}</a>
	</c:forEach>
</body>
</html>