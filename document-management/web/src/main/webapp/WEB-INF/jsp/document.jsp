<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<br>

<h1>Document Details:</h1>
<table class="table">
    <tr>
        <td>${document.documentId}<td>
    </tr>
    <tr>
        <td>${document.creationDate}<td>
    </tr>
    <tr>
        <td>${document.completionDate}<td>
    </tr>
</table>

</div>
<jsp:include page="footer.jsp"/>