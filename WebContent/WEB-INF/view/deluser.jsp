<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="Form">
	<br><br>
	<h1>Delete user</h1>
	<br><br>
	<h2>Choose the id of the user and press DELETE</h2>
	<br><br>

	<h5>ID: <input type="text" id="idtext" autocomplete="off" placeholder="Write any id..." required></h5>
	
	<br><br>
	<button type="submit" class="button" id="del_button" value="Submit" onclick="begin()">DELETE</button>
</div>

<script>
const id_text = document.getElementById("idtext");

function begin()
{
	if(isNaN(id_text.value) || id_text.value <= 0)
	{
		alert("Id must be postive number");
	}
	else
	{
		del();
	}	
}

function del()
{
	var form = new FormData();
	var settings = {
	  "url": "http://localhost:8086/InsideUser/api/users/delete/" + id_text.value,
	  "method": "DELETE",
	  "timeout": 0,
	  "processData": false,
	  "mimeType": "multipart/form-data",
	  "contentType": false,
	  "data": form
	};

	$.ajax(settings).done(function (response) {
	  console.log(response);
	  alert("User with id:"+id_text.value+" has been removed");
	  location.reload();
	});
}
</script>
</sec:authorize>