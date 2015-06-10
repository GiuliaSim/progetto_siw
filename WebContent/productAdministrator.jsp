<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
	<f:view>
		<h1>${productController.product.name}</h1>
		<h2>Dettagli</h2>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price}</div>
		<div>Descrizione: ${productController.product.description}</div>
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

		<h:form>
			<h:commandButton value="Aggiungi fornitore al prodotto"
				action="#{productController.listProvider}">
				<f:param name="id" value="#{productController.product.id}" />
			</h:commandButton>
			<br>
			<h:commandButton action="faces/newProduct.jsp"
				value="Aggiungi un nuovo prodotto"></h:commandButton>
			<a href="faces/homeAdministrator.jsp">Torna al menu</a>
		</h:form>
	</f:view>
</body>
</html>