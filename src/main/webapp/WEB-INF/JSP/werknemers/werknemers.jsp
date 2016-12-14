<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Werknemers' />
</head>
<body>
	<v:menu />
	<table>
		<thead>
			<tr>
				<th>Voornaam</th>
				<th>Familienaam</th>
				<th>Chef</th>
				<th>Werknemers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${werknemers}' var='werknemer'>
				<tr>
					<td>${werknemer.voornaam}</td>
					<td>${werknemer.familienaam}</td>
					<td>${werknemer.chef.voornaam}</td>
					<c:forEach items='${werknemer.chef.werknemers}' var='werknemer'>
						<td>${werknemer.voornaam}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>