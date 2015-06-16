<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "bootstrap.css" rel = "stylesheet" type ="text/css"></link>
<title>Fornitori</title>
</head>
<body style = "font-family:georgia; margin-top:30px; margin-left:40px; margin-right:40px">
	<f:view>
		<h:form>
			<h1>Fornitori</h1>
			<table class="table table-striped">
				<tr>
					<th>Nome</th>
					<th>Telefono</th>
					<th>Email</th>
				</tr>
				<c:forEach var="provider" items="#{productController.providers}">
					<tr>
						<td><h:commandLink
								action="#{providerController.getProviderById()}"
								value="#{provider.name}">
								<f:param name="id" value="#{provider.id}" />
								<f:param name="idProduct" value="#{productController.id}" />
							</h:commandLink></td>
						<td>${provider.phoneNumber}</td>
						<td>${provider.email}</td>
						<td><h:commandButton
								action="#{productController.addProvider()}" value="Seleziona">
								<f:param name="id" value="#{productController.id}" />
								<f:param name="idProvider" value="#{provider.id }" />
							</h:commandButton></td>
					</tr>
				</c:forEach>
			</table>
			<br>

			<h:commandButton action="newProvider.jsp"
				value="Nuovo Fornitore">
				<f:param name="id" value="#{productController.id}" />
			</h:commandButton>

			<a href="javascript:history.back()">Torna indietro</a>
		</h:form>
	</f:view>

</body>
</html>