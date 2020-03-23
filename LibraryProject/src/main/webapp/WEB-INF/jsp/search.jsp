<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Holdings</title>
</head>
<body>

<h1>Search Tips:</h1>
<p>- All searches will work with partial words; for example, "Tchaikovsky", "T", and "sky" will
	all bring up works by Tchaikovsky.</p>
<p>- Words in the catalogue do not contain accents or other non-English characters; for example, "Faure",
	"Baerenreiter", and "Dvorak".</p>

<c:url value='/processSearch' var='processSearchURL' />
<form method="GET" action='${processSearchURL}'>

	<div>
		<label for="catalogueId">Catalogue Id:</label> 
		<input type="text" name="catalogueId" id="catalogueId" />
	</div>

	<div>
		<label for="composer">Composer Last Name:</label> 
		<input type="text" name="composer" id="composer" />
	</div>

	<div>
		<label for="title">Title:</label> 
		<input type="text" name="title" id="title" />
	</div>

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
			<option value="Other">"Other"</option>
		</select>
	</div>

	<div>
		<label for="publisher">Publisher:</label> 
		<input type="text" name="publisher" id="publisher" />
	</div>

	<input class="formSubmitButton" type="submit" value="Search" />

</form>

</body>
</html>