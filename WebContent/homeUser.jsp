<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Home User</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>Benvenuto</h1>
			<div>
				Effettua Ordine:
				<h:commandButton value="Submit" action="#{productController.listProduct()}" />
			</div>
			<div>
				Consulta catalogo:
				<h:commandButton value="Submit"
					action="#{productController.listProduct() }" />
			</div>
			<div>
				<h:commandButton value="Logout"
					action="#{userController.logoutUser }" />
			</div>
			
		</h:form>
	</f:view>
</body>
</html>