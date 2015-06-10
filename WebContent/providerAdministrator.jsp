<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Provider</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>${providerController.provider.name}</h1>
			<h2>Dettagli</h2>
			<div>Telefono: ${providerController.provider.phoneNumber}</div>
			<div>Email: ${providerController.provider.email}</div>
			<div>PartitaIVA: ${providerController.provider.vatid}</div>
			<br>
			<h:commandButton action="#{productController.addProvider()}"
				value="Aggiungi fornitore al prodotto">
				<f:param name="idProvider" value="#{providerController.provider.id}" />
				<f:param name="id" value="#{providerController.idProduct}" />
			</h:commandButton>
			<a href = "javascript:history.back()">Torna Indietro</a>
		</h:form>
	</f:view>
</body>
</html>