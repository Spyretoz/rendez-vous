<sec:authorize access="hasRole('ROLE_ADMIN')">

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
 			<table id="users_table">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
				</tr>
			</table>
		</div>
	</div>
	
	<script>
		const table = document.getElementById("users_table");
	
		var settings = {
				"url": "http://localhost:8086/InsideUser/api/users/show/",
				"method": "GET",
				"timeout": 0,
		};
	
		$.ajax(settings).done(function (response) {
			console.log(response);			
			
			for(var i = 0; i < response.length; i++)
			{
				var row = table.insertRow(1);
				
				var txt = JSON.stringify(response[i]);
				var obj = JSON.parse(txt);
				
				row.insertCell(0).innerHTML = obj.id;
				row.insertCell(1).innerHTML = obj.firstName;
				row.insertCell(2).innerHTML = obj.lastName;
				row.insertCell(3).innerHTML = obj.username;
			}
		});
	</script>
</sec:authorize>