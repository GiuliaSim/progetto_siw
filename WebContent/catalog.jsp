<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>Catalogo</h1>
			<table>
				<tr>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Codice</th>
				</tr>
				<c:forEach var="product" items="#{productController.products}">
					<tr>
						<td><h:commandLink
								action="#{productController.getProductByIdForOrder()}"
								value="#{product.name}">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.price}</td>
						<td>${product.code}</td>

					</tr>
				</c:forEach>
			</table>
			<br>
			<h:outputLink style="color: Blue" value="faces/homeUser.jsp">Torna al menu principale</h:outputLink>
		</h:form>
	</f:view>
</body>
</html>