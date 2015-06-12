<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>${productController.product.name}</h1>
			<h2>Dettagli</h2>
			<div>Codice: ${productController.product.code}</div>
			<div>Prezzo: ${productController.product.price}</div>
			<div>Descrizione: ${productController.product.description}</div>

		
		
		Quantità: <h:inputText value="#{ordineLineController.quantity}"
				required="true" requiredMessage="Quantity is mandatory"
				converterMessage="Price must be a number" id="quantity" />
			<h:message for="quantity" />
			<h:commandButton value="Aggiungi prodotto all'ordine"
				action="#{ordineLineController.createOrdineLine()}">
				<f:param name="idProduct" value="#{productController.product.id}" />
				<f:param name="price" value="#{productController.product.price }" />
				<f:param name="idOrdine" value="#{productController.idOrder }"/>
			</h:commandButton>
			<br>
			<a href="faces/homeUser.jsp">Torna al menu</a>
		</h:form>
	</f:view>
</body>
</html>