<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
	<div class="jumbotron text-center">
	 <h1>Examinations</h1>
  <p>Edit item!</p>
	</div>

	<div align="center" class="container">


		<form:form action="edititem" method="post" modelAttribute="examinationitem">

			<fieldset class="form-group">
				<form:label  path="examination.id">ID Examination:</form:label>
				${examinationitem.examination.id} <form:hidden path="examination.id"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label  path="id">ID item:</form:label>
				${examinationitem.id} <form:hidden path="id"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="amount">Amount of tetments:</form:label>
				<form:input path="amount"  class="form-control" />
				<form:errors path="amount" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="treatment.id">Treatment:</form:label>

				<form:select path="treatment.id" class="form-control">
					<form:options items="${allTreatments}" itemValue="id"
						itemLabel="name" />

				</form:select>

			</fieldset>
			
			<fieldset class="form-group">
				<input type="submit" class="btn btn-success" value="save" />
			</fieldset>


		</form:form>


	</div>
	<%@ include file="common/footer.jsp" %>