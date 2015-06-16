<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.css" rel="stylesheet" type="text/css"></link>
<title>Registrazione Utente</title>
</head>
<body
	style="font-family: georgia; margin-top: 30px; margin-left: 40px; margin-right: 40px" >
	<f:view>
		<h:form>
			<table>

				<tr>
					<td class="col-sm-3">Nome:</td>
					<td><h:inputText value="#{userController.name}"
							styleClass="form-control" required="true"
							requiredMessage=" Name is mandatory" id="name" /> <strong><h:message
								for="name" /></strong></td>
				</tr>
				<tr>
					<td class="col-sm-3">Cognome:</td>
					<td><h:inputText value="#{userController.lastname}"
							styleClass="form-control" required="true"
							requiredMessage=" Lastname is mandatory" id="lastname" /> <h:message
							for="lastname" /></td>
				</tr>
				<tr>
					<td class="col-sm-3">Email:</td>
					<td><h:inputText value="#{userController.email}"
							styleClass="form-control" required="true"
							requiredMessage=" Email is mandatory" id="email" /> <h:message
							for="email" />${userController.signUpError}</td>
				</tr>
				<tr>
					<td class="col-sm-3">Password:</td>
					<td><h:inputText value="#{userController.password}"
							styleClass="form-control" required="true"
							requiredMessage=" Password is mandatory" id="password" /> <h:message
							for="password" /></td>
				</tr>
				<tr>
					<td class="col-sm-3">Data di nascita:</td>
					<td><h:inputText value="#{userController.dateOfBirth}"
							styleClass="form-control">
							<f:convertDateTime pattern="dd-MM-yyyy" />
						</h:inputText></td>
				</tr>

				<tr>
					<td class="col-sm-3">Città:</td>
					<td><h:inputText value="#{userController.city}"
							styleClass="form-control" required="true"
							requiredMessage="city is mandatory" id="city" /> <strong><h:message
								for="city" /></strong></td>
				</tr>

				<tr>
					<td class="col-sm-3">Via:</td>
					<td><h:inputText value="#{userController.street}"
							styleClass="form-control" required="true"
							requiredMessage="street is mandatory" id="street" /> <strong><h:message
								for="street" /></strong></td>
				</tr>

				<tr>
					<td class="col-sm-3">CAP:</td>
					<td><h:inputText value="#{userController.zipcode}"
							styleClass="form-control" required="true"
							requiredMessage="zipcode is mandatory" id="zipcode" /> <strong><h:message
								for="zipcode" /></strong></td>
				</tr>

				<tr>
					<td class="col-sm-3">Paese:</td>
					<td><h:inputText value="#{userController.country}"
							styleClass="form-control" required="true"
							requiredMessage="country is mandatory" id="country" /> <strong><h:message
								for="country" /></strong></td>
				</tr>

				<tr>
					<td class="col-sm-3">Stato:</td>
					<td><h:inputText value="#{userController.state}"
							styleClass="form-control" required="true"
							requiredMessage="state is mandatory" id="state" /> <strong><h:message
								for="state" /></strong></td>
				</tr>

			</table>
			<br>
			<div>
				<h:commandButton value="Conferma" styleClass="btn btn-warning"
					action="#{userController.createUser()}" />
				<br>

				<h:outputLink style="color: Blue" value="faces/login.jsp">Torna indietro</h:outputLink>
			</div>
		</h:form>

	</f:view>
</body>
</html>