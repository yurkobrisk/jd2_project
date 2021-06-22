<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<br>

<h2 class="text-center">View document:</h2>

<br>

    <form:form>

        ${documentDto.creationDate}
        <br>
        ${documentDto.clientSurname}
        <br>
        ${documentDto.providerSurname}
        <br>
        ${documentDto.completionDate}

        <input type="submit" value="Edit">

    </form:form>

</div>

<jsp:include page="footer.jsp"/>