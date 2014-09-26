<%@ include file="../include.jsp"%>

<html>
<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <h1>Show Form</h1>
        </div>
    </div>

        <c:if test="${!empty user}">
            <h3>Users</h3>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:forEach items="${user}" var="user">--%>
                    <tr>
                        <td>${user.lastName}, ${user.firstName}</td>
                        <td>${user.email}</td>
                        <td>
                            <form action="delete/${user.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
                        </td>
                    </tr>
                <%--</c:forEach>--%>
                </tbody>
            </table>
        </c:if>
</div>
</body>
</html>