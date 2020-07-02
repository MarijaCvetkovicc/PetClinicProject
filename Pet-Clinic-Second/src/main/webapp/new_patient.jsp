<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
	<div class="jumbotron text-center">
		<h1>Patients</h1>
		<p>Add New Patient!</p>
	</div>

	<div align="center" class="container">


		<form:form action="save" method="post" modelAttribute="patient">

			<fieldset class="form-group">
				<form:label  path="petname">Pet name:</form:label>
				<form:input path="petname" class="form-control" requried="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="ownername">Owner name:</form:label>
				<form:input path="ownername" class="form-control" requried="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="number">Number:</form:label>
				<form:input path="number" class="form-control" requried="required"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="veterinarian.id">Vetenerian:</form:label>

				<form:select path="veterinarian.id" class="form-control">
					<form:options items="${allVeterinarian}" itemValue="id"
						itemLabel="name" />

				</form:select>

			</fieldset>
			<fieldset class="form-group">
				<input type="submit" class="btn btn-success" value="save" />
			</fieldset>


		</form:form>


	</div>
	<%@ include file="common/footer.jsp" %>