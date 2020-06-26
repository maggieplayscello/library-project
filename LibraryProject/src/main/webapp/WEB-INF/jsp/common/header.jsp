<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Library Catalogue</title>
	<c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<nav>
		<c:url value='/home' var='homeURL'/>
		<c:url value='/fullCatalogue' var='fullCatalogueUrl' />
		<c:url value='/search' var='searchUrl' />
		<c:url value='/add' var='addUrl' />

		<ul>
			<li><a href='${homeURL}'> Home</a></li>
			<li><a href='${fullCatalogueUrl}'> Full Catalogue</a></li>		
			<li><a href='${addUrl}'> Add New Piece</a></li>
		</ul>
	</nav>
</body>
</html>