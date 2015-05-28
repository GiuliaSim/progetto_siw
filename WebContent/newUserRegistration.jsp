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
					requiredMessage="Name is mandatory" id="name" />
				<strong><h:message for="name" /></strong>
			</div>
			<div>
				Cognome:
				<h:inputText value="#{userController.lastname}" required="true"
					requiredMessage="Lastname is mandatory" id="lastname" />
				<h:message for="lastname" />
			</div>
			<div>
				Email:
				<h:inputText value="#{userController.email}" required="true"
					requiredMessage="Email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputTextarea value="#{userController.password}" required="true"
					requiredMessage="Password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				Data di nascita:
				<h:inputText value="#{userController.dateOfBirth}">
					<f:convertDateTime pattern="dd-MM-yyyy" />
				</h:inputText>
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{userController.createUser()}" />
				<h:outputLink style="color: Blue"
					value="faces/loginAmministratore.jsp">Torna indietro</h:outputLink>
			</div>
		</h:form>

	</f:view>
</body>
</html>