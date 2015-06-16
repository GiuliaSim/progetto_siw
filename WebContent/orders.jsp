<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ordini</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>Ordini:</h1>
			<table>
				<tr>
					<th></th>
					<th>Data creazione</th>
					<th>Data chiusura</th>

				</tr>
				<c:forEach var="order" items="#{ordineController.orders}">
					<tr>
						<td><h:commandLink action="#{ordineController.listOrderLine}"
								value="Dettagli">
								<f:param name="id" value="#{order.id}"></f:param>
							</h:commandLink></td>

						<td>${order.creationDate}</td>
						<td>${order.closingDate}</td>
					</tr>
				</c:forEach>
			</table>
			<a href="faces/homeUser.jsp">Home</a>
		</h:form>
	</f:view>

</body>
</html>