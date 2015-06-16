<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "bootstrap.css" rel = "stylesheet" type ="text/css"></link>
<title>Product</title>
</head>
<body style = "font-family:georgia; margin-top:30px; margin-left:40px; margin-right:40px">
	<f:view>
		<h1>${productController.product.name}</h1>
		<h2>Dettagli</h2>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price}</div>
		<div>Descrizione: ${productController.product.description}</div>
		<div>Quantità in magazzino: ${productController.product.quantityAvailable}</div>
		<h4>Fornitori:</h4>
		<table>
			<tr>
				<th>Nome</th>
				<th>Telefono</th>
				<th>Email</th>
				<th>PartitaIVA</th>
			</tr>
			<c:forEach var="provider"
				items="#{productController.providersByProduct}">
				<tr>
					<td>${provider.name}</td>
					<td>${provider.phoneNumber}</td>
					<td>${provider.email}</td>
					<td>${provider.vatid }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="javascript:history.back()" >Torna indietro</a>
	</f:view>
</body>
</html>