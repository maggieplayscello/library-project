<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse Ensembles</title>
</head>
<body>

		<c:url value='/browse' var='browseUrl' />
		<a href='${browseUrl}'> Browse by Ensemble Type</a>
		

<h1>Browse by Ensemble Type:</h1>
ensembleType

		<c:url value='/browseSelection' var='browseSelectionURL'/>
		<a href='${browseSelectionURL}'>Details</a>
		
		<c:url value='/browseSelection' var='browseSelectionURL'/>
		<a href='${browseSelectionURL}'>Concerto</a>

	<div>
		<label for="ensembleType">Ensemble Type:</label> 
		<select name="ensembleType" id="ensembleType">
			<option value="Chamber Symphony">Chamber Symphony</option>
			<option value="Concerto">Concerto</option>
			<option value="Holiday">Holiday</option>
			<option value="Concerto">Concerto</option>
			<option value="Opera">Opera</option>
			<option value="Orchestra">Orchestra</option>
			<option value="Orchestra and Choir">Orchestra and Choir</option>
			<option value="Overture">Overture</option>
			<option value="Patriotic">Patriotic</option>
			<option value="Pops">Pops</option>
			<option value="Small Ensemble">Small Ensemble</option>
			<option value="String Orchestra">String Orchestra</option>
		</select>
	</div>


</body>
</html>