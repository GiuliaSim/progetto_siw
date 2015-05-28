<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Utente</title>
</head>
<body>
	<f:view>
		<div>
			<h1>Login Utente</h1>
		</div>
		<h:form>
			<div align="center">
				<table>
					<tr>
						<td>Email</td>
						<td><h:inputText value="#{userController.email}"
								styleClass="form-control" required="true"
								requiredMessage="  Email obbligatiorio! " id="email" />
								<h:message for="email" /></td>
								
					</tr>
					<tr>
						<td>Password</td>
						<td><h:inputSecret value="#{userController.password}"
								styleClass="form-control" required="true"
								requiredMessage="  Password obbligatoria! " id="password" />
								<h:message for="password" /></td>
					</tr>
				</table>
				<h:commandButton styleClass="btn btn-warning" value="Login"
					action="#{userController.loginUser }" />
				
				
				<p align="center">
					<b>${userController.loginError }</b>
				</p>
				
				<div align="center">
					<h3>
						Non sei ancora registrato?
						<h:outputLink style="color: Orange"
							value="faces/newUserRegistration.jsp">Clicca qui!</h:outputLink>
					</h3>
				</div>
				
				<div align="center">
						<h:outputLink style="color: Blue"
							value="faces/loginAmministratore.jsp">Login come Amministratore</h:outputLink>
				</div>
			</div>
		</h:form>
	</f:view>
</body>
</html>