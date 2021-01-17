<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>FPIS INFORMATION SYSTEM</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		
		<ul class="nav navbar-nav">
			<li><a href="javascript:addContentFromUrl('cenovnik-div', 'cenovnik')">Cenovnik</a></li>
			<li><a href="javascript:addContentFromUrl('spediter-div', 'spediter')">Spediter</a></li>
			
		</ul>
	</div>
	
</nav>
<div id="cenovnik-div"></div>
<div id="spediter-div"></div>


<script type="text/javascript">
function addContentFromUrl(divId, ajaxUrl) {
	

	$.ajax({
		url : ajaxUrl,
		success : function(data) {
			$('#' + divId).html(data);
		}
	});
	
	toggleDivs(divId);

}

function toggleDivs(activeDivId) {
	var allDivs = ['cenovnik-div', 'spediter-div'];
	
    for (var i = 0; i < allDivs.length; i++) {
    	toggleDiv(allDivs[i], activeDivId);
       
    }
	
}

function toggleDiv(divId, activeDivId) {
	if (divId == activeDivId) {
	
		$('#' + divId).show();
	} else {
		if (divId != 'cenovnik-div' || activeDivId != 'spediter-div') {
			
			$('#' + divId).empty();
		}
		$('#' + divId).hide();
	}
	
}

</script>
</html>