<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Werknemers' />
</head>
<body>
	<%-- 	<v:menu /> --%>
	<h1>Werknemer ${werknemer.voornaam} ${werknemer.familienaam}</h1>
	<c:if test="${param.optimisticlockingexception}">
		<div class="fout">Opslag werknemer werd door andere gebruiker
			als volgt gewijzigd:</div>
	</c:if>
	<ul class='zonderbolletjes'>
		<h2>Voornaam</h2>
		<li>${werknemer.voornaam}</li>
		<h2>Familienaam</h2>
		<li>${werknemer.familienaam}</li>
		<h2>Email</h2>
		<li>${werknemer.email}</li>
		<h2>Salaris</h2>
		<li><fmt:formatNumber value='${werknemer.salaris}' /></li>
		<h2>Jobtitel</h2>
		<li>${werknemer.jobtitel.naam}</li>
		<c:if test='${not empty werknemer.chef}'>
			<h2>Chef</h2>
			<spring:url var='url' value='/werknemer/{id}'>
				<spring:param name='id' value='${werknemer.chef.id}' />
			</spring:url>
			<li><a href='${url}'>${werknemer.chef.voornaam}
					${werknemer.chef.familienaam}</a></li>
		</c:if>
		<c:if test='${not empty werknemer.werknemers}'>
			<h2>Ondergeschikten</h2>
			<li><c:forEach items='${werknemer.werknemers}'
					var='ondergeschikte'>
					<spring:url var='url' value='/werknemer/{id}'>
						<spring:param name='id' value='${ondergeschikte.id}' />
					</spring:url>
					<a href='${url}'>${ondergeschikte.voornaam}
						${ondergeschikte.familienaam}</a>
					<br>
				</c:forEach></li>
		</c:if>
		<h2>Foto</h2>
		<li><img alt='${werknemer.voornaam}'
			src='<c:url value="/images/${werknemer.id}.jpg"/>'></li>
		<li><spring:url var='url'
				value='/werknemer/opslag/{id}/{salaris}'>
				<spring:param name='id' value='${werknemer.id}' />
				<spring:param name='salaris' value='${werknemer.salaris}' />
			</spring:url> <a href='${url}'>Opslag</a></li>
	</ul>
</body>
</html>