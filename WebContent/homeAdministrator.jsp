<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Home Administrator</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>Prodotti</h1>
			<div>
				Inserisci un Prodotto:
				<h:commandButton value="Submit" action="newProduct.jsp" />
			</div>
			<div>
				Lista dei Prodotti:
				<h:commandButton value="Submit" action="#{productController.listProductAdministrator() }" />
			</div>
			<div><h:commandButton value="Logout" 
					action="#{administratorController.logoutAdministrator }" />
					 </div>
					
		</h:form>
	</f:view>
</body>
</html>