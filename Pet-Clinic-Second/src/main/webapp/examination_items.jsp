<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="jumbotron text-center">
  <h1>Examinations items</h1>
  <p>Add Edit or Delete items!Patient is  ${examination.patient.petname}</p>
  <!----> 
  
</div>
	<div class="container" align="center">
	
	<br/>
	 <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>
	<table border="1" class="table table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>AMOUNT</th>
			<th>TREATMENT</th>
			<th>TREATMENT PRICE</th>
			<th> ACTION </th>
		</tr>
		<thead>
		<tbody>
		<c:forEach items="${listExaminationItems}" var="examinationitem">
			<tr>
				<td>${examinationitem.id}</td>
				<td>${examinationitem.amount}</td>
				<td>${examinationitem.treatment.name}</td>
				<td>${examinationitem.treatment.price}</td>
				<td>
				  <a class="btn btn-info" href="edit-examinationitem?id=${examinationitem.id} ">	Edit </a>
			 <a class="btn btn-danger" href="delete-examinationitem?id=${examinationitem.id} ">Remove </a> 
				
				 </td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
		 <div><a class="btn btn-success" href="/new-examinationitem?idExamination=${examination.id}">Add New Item</a></div> 
	
	</div>
	<%@ include file="common/footer.jsp" %>
