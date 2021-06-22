<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<h1 class="pagination justify-content-center">Documents in database:</h1>
<br>
<br>

<!--        Ordering row with labels 12 columns       -->

<div class="row">
  <div class="col-md-6" align="left">
    <h6>Total documents: ${documentsList.totalElements} - Page ${documentsList.number + 1} of ${documentsList.totalPages}</h6>
  </div>

<!--        Ordering Dropdown Button - Documents Per Page       -->

  <div class="col-md-2" align="right">
    <h6>Documents per page</h6>
  </div>

  <div class="col-md-1" align="left">

    <c:set var="pageNumber" value="${documentsList.number}"/>
    <c:if test="${currentPage + 1 >= documentsList.totalPages}">
      <c:set var="pageNumber" value="0"/>
    </c:if>

    <div class="dropdown">
      <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1"
          data-bs-toggle="dropdown" aria-expanded="false">
          ${documentsList.size}
      </button>

      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <c:forEach var="documentsPerPage" items="${count}">
          <li class="page-item">
            <li><a class="dropdown-item"
                   href="?page=${pageNumber}&size=${documentsPerPage}&orderBy=${currentOrderBy}">${documentsPerPage}</a></li>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>

 <!--        Ordering by ...       -->

  <div class="col-md-1" align="right">
    <h6>Order by</h6>
  </div>

  <div class="col-md-1" align="left">
   <div class="dropdown">
      <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton2"
        data-bs-toggle="dropdown" aria-expanded="false">
        ${currentOrderBy}
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
        <li class="page-item">
          <c:forEach var="documentsOrderBy" items="${orderByParam}">
            <li class="page-item">
              <li>
                <a class="dropdown-item"
                  href="?page=${documentsList.number}&size=${documentsList.size}&orderBy=${documentsOrderBy}">
                  ${documentsOrderBy}
                </a>
              </li>
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
        <th scope="col">Creation Date</th>
        <th scope="col">Client Surname</th>
        <th scope="col">Provider Surname</th>
        <th scope="col">Completion Date</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
      <c:set var="counter" value="${(currentPage * currentSize)}"/>
      <c:forEach var="documentItem" items="${documentsList.content}">

        <c:url var="viewButton" value="/document/view/">
          <c:param name="docId" value="${documentItem.documentId}"/>
        </c:url>

        <c:url var="updateButton" value="/document/update/">
          <c:param name="docId" value="${documentItem.documentId}"/>
        </c:url>

        <c:url var="deleteButton" value="/document/delete/">
          <c:param name="docId" value="${documentItem.documentId}"/>
        </c:url>

        <tr>
          <th scope="row">${counter = counter + 1}</th>
          <td>${documentItem.creationDate}</td>
          <td>${documentItem.clientSurname}</td>
          <td>${documentItem.providerSurname}</td>
          <td>${documentItem.completionDate}</td>
          <td>
            <input type="button" value="View"  class="btn btn-outline-primary"
            onClick = "window.location.href = '${viewButton}'"/>
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

    <!--      Previous page       -->
    <c:if test = "${currentPage > 0}">
      <a class="page-link"
        href="?page=${currentPage - 1}&size=${documentsList.size}&orderBy=${currentOrderBy}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </c:if>
    <li class="page-item">
    </li>

    <!--        Page Numbers       -->
    <c:forEach var="pageNumber" items="${numbers}">
      <li class="page-item">
        <c:if test="${pageNumber == currentPage}">
          <li class="page-item active" aria-current="page">
            <a class="page-link">${pageNumber + 1}</a>
          </li>
        </c:if>

        <c:if test="${pageNumber != currentPage}">
          <a class="page-link"
             href="?page=${pageNumber}&size=${documentsList.size}&orderBy=${currentOrderBy}">${pageNumber + 1}</a>
        </c:if>
      </li>
    </c:forEach>

    <!--      Next page       -->
    <li class="page-item">
      <c:if test = "${currentPage < documentsList.totalPages - 1}">
      <a class="page-link"
        href="?page=${currentPage + 1}&size=${documentsList.size}&orderBy=${currentOrderBy}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
      </c:if>
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