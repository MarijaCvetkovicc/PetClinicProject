<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
	<div class="jumbotron text-center">
	 <h1>Examinations</h1>
  <p>Edit examination!</p>
	</div>

	<div align="center" class="container">


		<form:form action="editexamination" method="post" modelAttribute="examination">

	<fieldset class="form-group">
				<form:label  path="id">ID Examination:</form:label>
				${examination.id} <form:hidden path="id"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label  path="date" >Date:</form:label>
				<form:input path="date" type="text" class="form-control" requried="required" />
				<form:errors path="date" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="totalcost">Total cost:</form:label>
				<form:input path="totalcost"  class="form-control" readonly="true" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="diagnosis.id">Diagnosis:</form:label>

				<form:select path="diagnosis.id" class="form-control">
					<form:options items="${allDiagnosis}" itemValue="id"
						itemLabel="name" />

				</form:select>

			</fieldset>
			<fieldset class="form-group">
				<form:label path="patient.id">Patient:</form:label>

				<form:select path="patient.id" class="form-control">
					<form:options items="${allPatients}" itemValue="id"
						itemLabel="petname" />

				</form:select>

			</fieldset>
			<fieldset class="form-group">
				<input type="submit" class="btn btn-success" value="save" />
			</fieldset>


		</form:form>


	</div>
	<%@ include file="common/footer.jsp" %>