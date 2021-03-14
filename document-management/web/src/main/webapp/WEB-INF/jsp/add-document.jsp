<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<br>

<h2 class="text-center">Please add new document:</h2>

<br>

<form:form action="/web/document/add/" method="post" modelAttribute="documentDto">

<form:hidden path="documentId"/>

<div class="container">
  <div class="row">
    <div class="col">

<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="basic-addon1">Creation date:</span>
  <form:input type="text" class="form-control" placeholder="YYYY-MM-DD"
    aria-label="creation date" aria-describedby="basic-addon1" path="creationDate"/>
</div>
    </div>
    <div class="col">
<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="basic-addon2">Complition date:</span>
  <form:input type="text" class="form-control" placeholder="YYYY-MM-DD"
    aria-label="complition date" aria-describedby="basic-addon2" path="completionDate"/>
</div>

    </div>
  </div>
</div>

<br>

<div class="container">
  <div class="row">
    <div class="col">
      <h3>Client:</h3>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon3">Name:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s name"
          aria-label="client name" aria-describedby="basic-addon3" path="clientName"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon4">Surname:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s surname"
          aria-label="client surname" aria-describedby="basic-addon4" path="clientSurname"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon5">Passport Number:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s passport number"
          aria-label="client passport number" aria-describedby="basic-addon5" path="clientPassportNumber"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon6">Country:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s country"
          aria-label="client country" aria-describedby="basic-addon6" path="clientCountry"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon7">City:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s city"
          aria-label="client city" aria-describedby="basic-addon7" path="clientCity"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon8">Street:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s street"
          aria-label="client street" aria-describedby="basic-addon8" path="clientStreet"/>
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon9">Index:</span>
        <form:input type="text" class="form-control" placeholder="Write client`s index"
          aria-label="client index" aria-describedby="basic-addon9" path="clientIndex"/>
      </div>
    </div>

    <div class="col">
    <h3>Provider:</h3>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon10">Name:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s name"
        aria-label="provider name" aria-describedby="basic-addon10" path="providerName"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon11">Surname:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s surname"
        aria-label="provider surname" aria-describedby="basic-addon11" path="providerSurname"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon12">Passport Number:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s passport number"
        aria-label="provider passport number" aria-describedby="basic-addon12" path="providerPassportNumber"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon13">Country:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s country"
        aria-label="provider country" aria-describedby="basic-addon13" path="providerCountry"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon14">City:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s city"
        aria-label="provider city" aria-describedby="basic-addon14" path="providerCity"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon15">Street:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s street"
        aria-label="provider street" aria-describedby="basic-addon15" path="providerStreet"/>
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon16">Index:</span>
      <form:input type="text" class="form-control" placeholder="Write provider`s index"
        aria-label="provider index" aria-describedby="basic-addon16" path="providerIndex"/>
    </div>

    </div>
  </div>
  <div class="row">
</div>

<br>
<br>

<div class="btn-group" role="group" aria-label="Basic example">
  <a href="/web/document/all/" class="btn btn-outline-primary" role="button">Back</a>
  <input type="submit" value="Add" class="btn btn-outline-primary">
</div>

</form:form>
</div>
<br>

<jsp:include page="footer.jsp"/>