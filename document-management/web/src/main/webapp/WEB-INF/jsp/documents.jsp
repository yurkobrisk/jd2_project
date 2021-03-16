<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<h1 class="pagination justify-content-center">Documents in database:</h1>
<br>
<br>

<!--        Sorting row with labels 12 columns       -->

<div class="row">
  <div class="col-md-7">
  </div>
  <div class="col-md-2">
    <h6>Documents per page:</h6>
  </div>
  <div class="col-md-1">

<!--        Sorting Dropdown Buttons       -->

    <div class="dropdown">
      <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1"
          data-bs-toggle="dropdown" aria-expanded="false">
          ${documentsList.size}
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <c:forEach var="documentsPerPage" items="${count}">
          <li class="page-item">
            <li><a class="dropdown-item" href="?size=${documentsPerPage}">${documentsPerPage}</a></li>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>
  <div class="col-md-1">
    <h6>Sort by:</h6>
  </div>
  <div class="col-md-1">

 <!--        Sorting by ...       -->

   <div class="dropdown">
      <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1"
          data-bs-toggle="dropdown" aria-expanded="false">
          Creation date
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
          <li class="page-item">
            <c:forEach var="documentsSortBy" items="${sortParam}">
                    <li class="page-item">
                      <li><a class="dropdown-item" href="?sort=${documentsSortBy}">${documentsSortBy}</a></li>
                    </li>
            </c:forEach>
          </li>
      </ul>
    </div>
  </div>
</div>

<br>

<!--        Table       -->

<table class="table table-hover table-sm">
  <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Creation date</th>
        <th scope="col">Client surname</th>
        <th scope="col">Provider surname</th>
        <th scope="col">Completion date</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="documentItem" items="${documentsList.content}">

        <c:url var="updateButton" value="/document/update/">
          <c:param name="docId" value="${documentItem.documentId}"/>
        </c:url>

        <c:url var="deleteButton" value="/document/delete/">
          <c:param name="docId" value="${documentItem.documentId}"/>
        </c:url>

        <tr>
          <th scope="row">1</th>
          <td>${documentItem.creationDate}</td>
          <td>${documentItem.clientSurname}</td>
          <td>${documentItem.providerSurname}</td>
          <td>${documentItem.completionDate}</td>
          <td>
            <input type="button" value="Update"  class="btn btn-outline-primary"
            onClick = "window.location.href = '${updateButton}'"/>
            <input type="button" value="Delete"  class="btn btn-outline-primary"
            onClick = "window.location.href = '${deleteButton}'"/>
          </td>
        </tr>
      </c:forEach>
    </tbody>
</table>

<!--        Pagination       -->

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center"
        c:if = "${documentsList.totalPages > 0}">

    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <!--        Page Numbers       -->

    <c:forEach var="pageNumber" items="${numbers}">
      <li class="page-item">
        <a class="page-link" href="?page=${pageNumber}&size=${documentsList.size}&sort=${documentsList.sort}">${pageNumber + 1}</a>
      </li>
    </c:forEach>

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

<br>
<br>

</div>

<jsp:include page="footer.jsp"/>