<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="jumbotron text-center">
  <h1>Patients</h1>
  <p>Add Edit or Delete patient!</p>
</div>
	<div class="container" align="center">
	
	<table border="1" class="table table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>PET NAME</th>
			<th>OWNER NAME</th>
			<th>NUMBER</th>
			<th>VETENERIAN</th>
			<th>ACTION</th>
		</tr>
		<thead>
		<tbody>
		<c:forEach items="${listPatient}" var="patient">
			<tr>
				<td>${patient.id}</td>
				<td>${patient.petname}</td>
				<td>${patient.ownername}</td>
				<td>${patient.number}</td>
				<td>${patient.veterinarian.name}</td>
				<td>
				<a class="btn btn-info" href="edit-patient?id=${patient.id} ">	Edit </a>
				<a class="btn btn-danger" href="delete-patient?id=${patient.id} ">	Delete </a>
				
				 </td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
		<div><a class="btn btn-success" href="/new">Add New Patient</a></div>
	
	</div>
	<%@ include file="common/footer.jsp" %>
