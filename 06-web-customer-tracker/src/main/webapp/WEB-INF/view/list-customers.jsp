<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

    <link type="text/css"
    		  rel="stylesheet"
    		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>


    <div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

        <p>
    		User: <security:authentication property="principal.username" />,
    		Role(s): <security:authentication property="principal.authorities" />
    	</p>

			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer"
					   onclick="window.location.href='add-customer'; return false;"
					   class="add-button"/>

			</security:authorize>

            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />

                <input type="submit" value="Search" class="add-button" />
            </form:form>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>

                    <%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

						<th>Action</th>

					</security:authorize>

				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

                    <c:url var="updateLink" value="/customer/update-customer">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete-customer">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>

                        <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
							<td>
								<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>

								<security:authorize access="hasRole('ADMIN')">
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</security:authorize>
							</td>
						</security:authorize>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

    <p></p>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

		<input type="submit" value="Logout" class="add-button" />

	</form:form>

</body>

</html>
