<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Provider</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{providerController.name}" required="true"
					requiredMessage=" Name is mandatory" id="name" />
				<strong><h:message for="name" /></strong>
			</div>
			<div>
				Telefono:
				<h:inputText value="#{providerController.phoneNumber}"
					required="true" requiredMessage=" PhoneNumber is mandatory"
					id="phoneNumber" />
				<h:message for="phoneNumber" />
			</div>
			<div>
				Email:
				<h:inputText value="#{providerController.email}" required="true"
					requiredMessage=" Email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Partita IVA:
				<h:inputTextarea value="#{ providerController.vatid}"
					required="true" requiredMessage=" VatID is mandatory" id="vatid" />
				<h:message for="vatid" />
			</div>
			<div>
				Città:
				<h:inputText value="#{providerController.city}" required="true"
					requiredMessage="city is mandatory" id="city" />
				<strong><h:message for="city" /></strong>
			</div>

			<div>
				Via:
				<h:inputText value="#{providerController.street}" required="true"
					requiredMessage="street is mandatory" id="street" />
				<strong><h:message for="street" /></strong>
			</div>

			<div>
				CAP:
				<h:inputText value="#{providerController.zipcode}" required="true"
					requiredMessage="zipcode is mandatory" id="zipcode" />
				<strong><h:message for="zipcode" /></strong>
			</div>

			<div>
				Paese:
				<h:inputText value="#{providerController.country}" required="true"
					requiredMessage="country is mandatory" id="country" />
				<strong><h:message for="country" /></strong>
			</div>

			<div>
				Stato:
				<h:inputText value="#{providerController.state}" required="true"
					requiredMessage="state is mandatory" id="state" />
				<strong><h:message for="state" /></strong>
			</div>
			<br>
			<div>
				<h:commandButton value="Conferma"
					action="#{providerController.createProvider()}">
					<f:param name="idProduct" value="#{productController.id}" />
				</h:commandButton>
				<a href="javascript:history.back()">Annulla operazione</a>
			</div>
		</h:form>

	</f:view>
</body>
</html>