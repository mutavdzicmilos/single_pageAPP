

function prepareDrzava() {
	$.ajax({
		url : "api/drzave/all",
		type : "GET",
		dataType : "json",
		success : function(data) {
			jQuery.each(data, function() {

				var row = createRow(this);

				$('#drzava').append(row);
			});
		}
	});
}
function createRow(data) {

	let row;
	
		row = '<option value="' + data.sifraDrzave + '">'
						+ data.naziv
						+ '</option>';

	
	return row;
}
