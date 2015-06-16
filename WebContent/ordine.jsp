<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.css" rel="stylesheet" type="text/css"></link>
<title>Insert title here</title>
</head>
<body
	style="font-family: georgia; margin-top: 30px; margin-left: 40px; margin-right: 40px">
	<f:view>
		<h:form>
			<h1>Creazione Ordine</h1>
			<table>
				<tr>
					<td>Aggiungi un prodotto:</td>
					<td><h:commandButton value="Submit"
							styleClass="btn btn-warning"
							action="#{productController.listProductForOrder()}">

						</h:commandButton></td>
				</tr>

				<tr>
					<td>Chiudi l'ordine:</td>
					<td><h:commandButton value="Submit"
							styleClass="btn btn-warning"
							action="#{ordineController.closeOrder()}" /></td>
				</tr>
			</table>
		</h:form>
	</f:view>

</body>
</html>