<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="jumbotron text-center">
  <h1>Examinations</h1>
  <p>Add Edit or Delete examination!</br> SEARCH examination using pet name or owner name</p>
</div>
	<div class="container" align="center">
	<form method="get" action="search">
		<input class="form-control" type="text" name="keyword" placeholder="Search" aria-label="Search">
		<input type="submit" value="Search"/>
	</form>
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
				<td>${examination.date}</td>
				<td>${examination.totalcost}</td>
				<td>${examination.diagnosis.name}</td>
				<td>
				<!-- <a class="btn btn-info" href="edit-patient?id=${patient.id} ">	Edit </a> -->
			<!--	<a class="btn btn-danger" href="delete-patient?id=${patient.id} ">	Delete </a> -->
				
				 </td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
		<!--<div><a class="btn btn-success" href="/new">Add New Patient</a></div>-->
	
	</div>
	<%@ include file="common/footer.jsp" %>
