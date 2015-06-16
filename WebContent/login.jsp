<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link href="bootstrap.css" rel="stylesheet" type="text/css"></link>
<title>Login Utente</title>
</head>
<body style = "font-family:georgia; margin-top:60px">

	<f:view>
		<div class="container">
			<div align="center">
				<p align="right">
					<h:outputLink style="color: Blue"
						value="faces/loginAdministrator.jsp">Login come Amministratore</h:outputLink>
				</p>


			</div>
			<h:form>
				<div class="jumbotron" align="center">
					<h1>Login Utente</h1>
					<table>
						<tr>
							<td class="col-sm-3">Email</td>
							<td><h:inputText value="#{userController.email}"
									styleClass="form-control" required="true"
									requiredMessage="Email obbligatioria! " id="email" /></td>
							<td><h:message style="color: Red" for="email" /></td>

						</tr>
						<tr>
							<td class="col-sm-3">Password</td>
							<td><h:inputSecret value="  #{userController.password}"
									styleClass="form-control" required="true"
									requiredMessage="Password obbligatoria! " id="password" /></td>
							<td><h:message  style="color: Red"  for="password" /></td>
						</tr>
					</table>
					<br>
					<h:commandButton styleClass="btn btn-warning" value="Login"
						action="#{userController.loginUser}" />


					<p align="center">
						<b>${userController.loginError}</b>
					</p>
					<div align="center">
						<h:commandLink value="Consulta catalogo"
							action="#{productController.listProduct()}" immediate="true" />
					</div>
					<br>
					<div align="center">
						<h3>
							Non sei ancora registrato?
							<h:outputLink style="color: Orange"
								value="faces/newUserRegistration.jsp">Clicca qui!</h:outputLink>
						</h3>
					</div>


				</div>

			</h:form>
		</div>
	</f:view>
</body>
</html>