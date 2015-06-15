<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione Utente</title>
</head>
<body>
	<f:view>
		<h:form>
			<table>

				<tr>
					<td>Nome:</td>
					<td><h:inputText value="#{userController.name}"
							required="true" requiredMessage=" Name is mandatory" id="name" />
						<strong><h:message for="name" /></strong></td>
				</tr>
				<tr>
					<td>Cognome:</td>
					<td><h:inputText value="#{userController.lastname}"
							required="true" requiredMessage=" Lastname is mandatory"
							id="lastname" /> <h:message for="lastname" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><h:inputText value="#{userController.email}"
							required="true" requiredMessage=" Email is mandatory" id="email" />
						<h:message for="email" />${userController.signUpError}</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><h:inputTextarea value="#{userController.password}"
							required="true" requiredMessage=" Password is mandatory"
							id="password" /> <h:message for="password" /></td>
				</tr>
				<tr>
					<td>Data di nascita:</td>
					<td><h:inputText value="#{userController.dateOfBirth}">
							<f:convertDateTime pattern="dd-MM-yyyy" />
						</h:inputText></td>
				</tr>

				<tr>
					<td>Città:</td>
					<td><h:inputText value="#{userController.city}"
							required="true" requiredMessage="city is mandatory" id="city" />
						<strong><h:message for="city" /></strong></td>
				</tr>

				<tr>
					<td>Via:</td>
					<td><h:inputText value="#{userController.street}"
							required="true" requiredMessage="street is mandatory" id="street" />
						<strong><h:message for="street" /></strong></td>
				</tr>

				<tr>
					<td>CAP:</td>
					<td><h:inputText value="#{userController.zipcode}"
							required="true" requiredMessage="zipcode is mandatory"
							id="zipcode" /> <strong><h:message for="zipcode" /></strong></td>
				</tr>

				<tr>
					<td>Paese:</td>
					<td><h:inputText value="#{userController.country}"
							required="true" requiredMessage="country is mandatory"
							id="country" /> <strong><h:message for="country" /></strong></td>
				</tr>

				<tr>
					<td>Stato:</td>
					<td><h:inputText value="#{userController.state}"
							required="true" requiredMessage="state is mandatory" id="state" />
						<strong><h:message for="state" /></strong></td>
				</tr>

			</table>
			<br>
			<div>
				<h:commandButton value="Conferma"
					action="#{userController.createUser()}" /><br>

				<h:outputLink style="color: Blue" value="faces/login.jsp">Torna indietro</h:outputLink>
			</div>
		</h:form>

	</f:view>
</body>
</html>