<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<h1 class="pagination justify-content-center">Documents in database:</h1>

<!--        Table       -->

<table class="table table-hover table-sm">
  <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Creation date</th>
        <th scope="col">Client surname</th>
        <th scope="col">Provider surname</th>
        <th scope="col">Completion date</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${documentsList}" var="documentItem">
        <tr>
          <th scope="row">1</th>
          <td>${documentItem.creationDate}</td>
          <td>${documentItem.clientSurname}</td>
          <td>${documentItem.providerSurname}</td>
          <td>${documentItem.completionDate}</td>
        </tr>
      </c:forEach>
    </tbody>
</table>

<!--        Pagination       -->

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

<!--        Add button       -->
<sec:authorize url="/document/add/">
<div class="position-relative" >
  <div class="position-absolute bottom-0 end-0" >
  <a href="/web/document/add/" class="btn btn-outline-primary float-right" role="button">
    Add document</a>
  </div>
</div>
</sec:authorize>

</div>

<jsp:include page="footer.jsp"/>