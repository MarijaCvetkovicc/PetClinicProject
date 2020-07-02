<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
	<div class="jumbotron text-center">
	 <h1>Examinations</h1>
  <p>Creating new examination!</p>
	</div>

	<div align="center" class="container">


		<form:form action="save" method="post" modelAttribute="examination">

			<fieldset class="form-group">
				<form:label  path="date" for="datepicker">Date:</form:label>
				<form:input path="date" class="form-control" id="datepicker" requried="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="totalcost">Total cost:</form:label>
				<form:input path="totalcost"  class="form-control" readonly />
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
						itemLabel="name" />

				</form:select>

			</fieldset>
			<fieldset class="form-group">
				<input type="submit" class="btn btn-success" value="save" />
			</fieldset>


		</form:form>


	</div>
	<%@ include file="common/footer.jsp" %>