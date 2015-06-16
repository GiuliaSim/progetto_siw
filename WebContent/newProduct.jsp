<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<link href="bootstrap.css" rel="stylesheet" type="text/css"></link>
<title>New Product</title>
</head>
<body style = "font-family:georgia; margin-top:30px; margin-left:40px; margin-right:40px">
	<f:view>
		<h:form>
			<table >
				<tr>
					<td class="col-sm-3">Nome:</td>
					<td ><h:inputText value="#{productController.name}"
							styleClass="form-control" required="true"
							requiredMessage="Name is mandatory" id="name" /> <strong><h:message
								for="name" /></strong></td>
				</tr>
				<tr>
					<td class="col-sm-3">Codice:</td>
					<td><h:inputText value="#{productController.code}"
							styleClass="form-control" required="true"
							requiredMessage="Code is mandatory" id="code" /> <h:message
							for="code" /></td>
				</tr>
				<tr>
					<td class="col-sm-3">Prezzo:</td>
					<td><h:inputText value="#{productController.price}"
							styleClass="form-control" required="true"
							requiredMessage="Price is mandatory"
							converterMessage="Price must be a number" id="price" /> <h:message
							for="price" /></td>
				</tr>

				<tr>
					<td class="col-sm-3">Descrizione:</td>
					<td><h:inputTextarea value="#{productController.description}"
							styleClass="form-control" required="false" cols="20" rows="5" /></td>
				</tr>

				<tr>
					<td class="col-sm-3">Quantita' disp:</td>
					<td><h:inputText
							value="#{productController.quantityAvailable}"
							styleClass="form-control" required="true"
							requiredMessage="Quantity is mandatory"
							converterMessage="Quantity must be a number"
							id="quantityAvailable" /> <h:message for="quantityAvailable" /></td>
				</tr>

			</table>
			<div>
				<h:commandButton value="Conferma" styleClass="btn btn-warning"
					action="#{productController.createProduct()}" />
			</div>
			<br>
			<div>
				<a href="javascript:history.back()" >Annulla operazione</a>
			</div>
		</h:form>

	</f:view>
</body>
</html>
