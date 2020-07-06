<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="jumbotron text-center">
  <h1>Examinations</h1>
  <p>Add or Edit  examination!<br/> SEARCH examination using pet name or owner name!</p>
</div>
	<div class="container" align="center">
	<form method="get" action="search">
		<input class="form-control" type="text" name="keyword" placeholder="Search" aria-label="Search">
		<br/>
		<div>
		<input type="submit" class="btn btn-success" value="Search"/>
		</div>
	</form>
	<br/>
	
	 <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>
        
	<table border="1" class="table table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>PET NAME</th>
			<th>OWNER NAME</th>
			<th>DATE</th>
			<th>TOTAL COST</th>
			<th>DIAGNOSIS</th>
			<th>ACTION</th>
		</tr>
		<thead>
		<tbody>
		<c:forEach items="${listExamination}" var="examination">
			<tr>
				<td>${examination.id}</td>
				<td>${examination.patient.petname}</td>
				<td>${examination.patient.ownername}</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${examination.date}"/></td>
				<td>${examination.totalcost}</td>
				<td>${examination.diagnosis.name}</td>
				<td>
				 <a class="btn btn-info" href="edit-examination?id=${examination.id} ">	Edit </a>
			 <a class="btn btn-info" href="view-items-examination?id=${examination.id} "> View Items </a> 
				
				 </td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
		<div><a class="btn btn-success" href="/new-examination">Add New Examination</a></div>
	
	</div>
	<%@ include file="common/footer.jsp" %>
