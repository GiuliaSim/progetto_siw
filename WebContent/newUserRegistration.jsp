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
			<div>
				Name:
				<h:inputText value="#{userController.name}" required="true"
					requiredMessage=" Name is mandatory" id="name" />
				<strong><h:message for="name" /></strong>
			</div>
			<div>
				Cognome:
				<h:inputText value="#{userController.lastname}" required="true"
					requiredMessage=" Lastname is mandatory" id="lastname" />
				<h:message for="lastname" />
			</div>
			<div>
				Email:
				<h:inputText value="#{userController.email}" required="true"
					requiredMessage=" Email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputTextarea value="#{userController.password}" required="true"
					requiredMessage=" Password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				Data di nascita:
				<h:inputText value="#{userController.dateOfBirth}">
					<f:convertDateTime pattern="dd-MM-yyyy" />
				</h:inputText>
			</div>

			<div>
				Città:
				<h:inputText value="#{userController.city}" required="true"
					requiredMessage="city is mandatory" id="city" />
				<strong><h:message for="city" /></strong>
			</div>

			<div>
				Via:
				<h:inputText value="#{userController.street}" required="true"
					requiredMessage="street is mandatory" id="street" />
				<strong><h:message for="street" /></strong>
			</div>

			<div>
				CAP:
				<h:inputText value="#{userController.zipcode}" required="true"
					requiredMessage="zipcode is mandatory" id="zipcode" />
				<strong><h:message for="zipcode" /></strong>
			</div>

			<div>
				Paese:
				<h:inputText value="#{userController.country}" required="true"
					requiredMessage="country is mandatory" id="country" />
				<strong><h:message for="country" /></strong>
			</div>

			<div>
				Stato:
				<h:inputText value="#{userController.state}" required="true"
					requiredMessage="state is mandatory" id="state" />
				<strong><h:message for="state" /></strong>
			</div>

			<div>
				<h:commandButton value="Submit"
					action="#{userController.createUser()}" />
				<h:outputLink style="color: Blue" value="faces/login.jsp">Torna indietro</h:outputLink>
			</div>
		</h:form>

	</f:view>
</body>
</html>