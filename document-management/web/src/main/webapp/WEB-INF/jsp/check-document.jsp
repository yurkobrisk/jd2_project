<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<body>
<div class="container-sm" >

<br>

<h2 class="text-center">Please check information and submit:</h2>

<br>

<form action="/web/document/all/" method="post" modelAttribute="documentDto">

<div class="container">
  <div class="row">
    <div class="col">

<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="basic-addon1">Creation date:</span>
  <input type="text" class="form-control" placeholder="${documentDto.creationDate}" disabled
    aria-label="creation date" aria-describedby="basic-addon1" name="creationDate">
</div>
    </div>
    <div class="col">
<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="basic-addon2">Complition date:</span>
  <input type="text" class="form-control" placeholder="${documentDto.completionDate}" disabled
    aria-label="complition date" aria-describedby="basic-addon2" name="completionDate">
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
        <input type="text" class="form-control" placeholder="${documentDto.clientName}" disabled
          aria-label="client name" aria-describedby="basic-addon3" name="clientName">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon4">Surname:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientSurname}" disabled
          aria-label="client surname" aria-describedby="basic-addon4" name="clientSurname">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon5">Passport Number:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientPassportNumber}" disabled
          aria-label="client passport number" aria-describedby="basic-addon5" name="clientPassportNumber">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon6">Country:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientCountry}" disabled
          aria-label="client country" aria-describedby="basic-addon6" name="clientCountry">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon7">City:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientCity}" disabled
          aria-label="client city" aria-describedby="basic-addon7" name="clientCity">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon8">Street:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientStreet}" disabled
          aria-label="client street" aria-describedby="basic-addon8" name="clientStreet">
      </div>

      <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="basic-addon9">Index:</span>
        <input type="text" class="form-control" placeholder="${documentDto.clientIndex}" disabled
          aria-label="client index" aria-describedby="basic-addon9" name="clientIndex">
      </div>
    </div>

    <div class="col">
    <h3>Provider:</h3>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon10">Name:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerName}" disabled
        aria-label="provider name" aria-describedby="basic-addon10" name="providerName">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon11">Surname:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerSurname}" disabled
        aria-label="provider surname" aria-describedby="basic-addon11" name="providerSurname">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon12">Passport Number:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerPassportNumber}" disabled
        aria-label="provider passport number" aria-describedby="basic-addon12" name="providerPassportNumber">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon13">Country:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerCountry}" disabled
        aria-label="provider country" aria-describedby="basic-addon13" name="providerCountry">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon14">City:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerCity}" disabled
        aria-label="provider city" aria-describedby="basic-addon14" name="providerCity">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon15">Street:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerStreet}" disabled
        aria-label="provider street" aria-describedby="basic-addon15" name="providerStreet">
    </div>

    <div class="input-group input-group-sm mb-3">
      <span class="input-group-text" id="basic-addon16">Index:</span>
      <input type="text" class="form-control" placeholder="${documentDto.providerIndex}" disabled
        aria-label="provider index" aria-describedby="basic-addon16" name="providerIndex">
    </div>

    </div>
  </div>
  <div class="row">
</div>

<br>
<br>

<div class="btn-group" role="group" aria-label="Basic example">
  <a href="/web/document/add/" class="btn btn-outline-primary" role="button">Go Back</a>
  <a href="/web/document/all/" class="btn btn-outline-primary" role="button">Cancel</a>
  <input type="submit" value="Ok" class="btn btn-outline-primary">
</div>

</form>
</div>
<br>

<jsp:include page="footer.jsp"/>