<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Amministratore</title>
</head>
<body>
	<f:view>
		<div>
			<h1>Login Amministratore</h1>
		</div>
		<h:form>
			<div align="center">
				<table>
					<tr>
						<td>Email</td>
						<td><h:inputText value="#{administratorController.email}"
								styleClass="form-control" required="true"
								requiredMessage="Email obbligatiorio! " id="email" />
							<h:message for="email" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><h:inputSecret
								value="#{administratorController.password}"
								styleClass="form-control" required="true"
								requiredMessage="Password obbligatoria! " id="password" />
							<h:message for="password" /></td>
					</tr>
				</table>
				<h:commandButton styleClass="btn btn-warning" value="Login"
					action="#{administratorController.loginAdministrator }" />

				<p align="center">
					<b>${administratorController.loginError }</b>
				</p>

			</div>
			<div align="center">
				<h:outputLink style="color: Blue" value="faces/login.jsp">Torna indietro</h:outputLink>
			</div>
		</h:form>
	</f:view>
</body>
</html>