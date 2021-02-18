<sec:authorize access="hasRole('ROLE_EMPLOYEE')">
	<h2>Accepted appointment (accepted = 1)</h2>
	
	<br>
	
	<h5>
		Appointment's ID: <input type="text" id="appoint" placeholder="ID"/>
	</h5>
		
		<br>
 		<button type="submit" id="add_button" class="button" value="Submit" onclick="begin()">Accept</button>
 		
 	<br><br>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
 			<table id="appointments_table">
				<tr>
					<th>Id</th>
					<th>Time</th>
					<th>Date</th>
					<th>Citizen</th>
					<th>Carrier</th>
					<th>Info</th>
					<th>Accept</th>
				</tr>
			</table>
		</div>
	</div>


	<script>
	//var settings = {
	//		url: "http://localhost:8086/InsideUser/appointment/update",
	//		method: "PUT",
	//		timeout: 0,
	//		data: "{\r\n\"id\": 23,\r\n\"accepted\": 0\r\n}",
	//};

	//$.ajax(settings).done(function (response) {
	//		console.log(response);
	//});
		const rid = document.getElementById("appoint");
		
	
		const table = document.getElementById("appointments_table");
	
		var settings = {
				"url": "http://localhost:8086/InsideUser/appointment/show",
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
				row.insertCell(1).innerHTML = obj.time;
				row.insertCell(2).innerHTML = obj.date;
				row.insertCell(3).innerHTML = obj.citizen;
				row.insertCell(4).innerHTML = obj.carrier;
				row.insertCell(5).innerHTML = obj.info;
				row.insertCell(6).innerHTML = obj.accepted;
				
			}
		});
		
		function begin()
		{
			var xhr = new XMLHttpRequest();
			var Url = "http://localhost:8086/InsideUser/appointment/update";
			xhr.open("PUT", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({
			    "id": parseInt(rid.value), 
			    "accepted": 1
			});
			xhr.send(myrespo);
			
			location.reload();
			alert("Appointment has been accepted");
		}
	</script>
</sec:authorize>