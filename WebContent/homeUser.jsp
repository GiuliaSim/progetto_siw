<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<link href="bootstrap.css" rel="stylesheet" type="text/css"></link>
<title>Home User</title>
</head>
<body
	style="font-family: georgia; margin-top: 30px; margin-left: 40px; margin-right: 40px">
	<f:view>
		<h:form>
			<h1>Benvenuto</h1>
			<table>
				<tr>
					<td>Effettua Ordine:</td>
					<td><h:commandButton value="Submit"
							styleClass="btn btn-warning"
							action="#{ordineController.createOrdine()}" /></td>
				</tr>
				<tr>
					<td>Consulta catalogo:</td>
					<td><h:commandButton value="Submit"
							styleClass="btn btn-warning"
							action="#{productController.listProduct() }" /></td>
				</tr>
				<tr>
					<td>Propri ordini:</td>
					<td><h:commandButton value="Submit"
							styleClass="btn btn-warning"
							action="#{ordineController.listOrder() }" /></td>
				</tr>
				<tr>
					<td><h:commandButton value="Logout"
							styleClass="btn btn-primary"
							action="#{userController.logoutUser }" /></td>
				</tr>
			</table>


		</h:form>
	</f:view>
</body>
</html>