<sec:authorize access="hasRole('ROLE_MANAGER')">	
	<div class="Form">
		<h5> Form's ID <input type="text" id="formid" required/></h5>
		<br>
		<h5> Carrier's Chief <input type="text" id="carrchief" required/></h5>
		<br>
		<h5> Carrier's Name <input type="text" id="carrname" required/></h5>
		<br>
		<h5>Amount Of Employees <input type="text" id="amntofemps" required/></h5>
		<br>
		<h5>Carrier's Location <input type="text" id="carrlocation" required/></h5>
		<br>
	
		
	</div>
	<br>
	<button type="submit" class="button" id="add_button" value="Submit" onclick="begin()">Add Carrier</button>
 	<br><br>
 	
 	<div class="res" id="res">
		<table id="form_table">
		
			<tr>
				<th><h3>Form's ID</h3></th>
				<th><h3>Chief's Name</h3></th>
				<th><h3>Carrier's Name</h3></th>
				<th><h3>Amount of Employees</h3></th>
				<th><h3>Carrier's Location</h3></th>
			</tr>
			
		</table>
	</div>
	
	
 	<script> 	
 		const table = document.getElementById("form_table");
 		
 		const formid = document.getElementById("formid");
 		const carrchief = document.getElementById("carrchief");
		const carrname = document.getElementById("carrname");
		const amntofemps = document.getElementById("amntofemps");
		const carrlocation = document.getElementById("carrlocation");
 	
		var settings = {
				"url": "http://localhost:8086/InsideUser/form/show/",
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
				row.insertCell(1).innerHTML = obj.chiefName;
				row.insertCell(2).innerHTML = obj.carrierName;
				row.insertCell(3).innerHTML = obj.a_amountOfEmps;
				row.insertCell(4).innerHTML = obj.carrierLocation;
			}
		});
		
		function begin() 
		{
			if (formid.value == "" || carrchief.value == "" || carrname.value == "" || amntofemps.value == "" || carrlocation.value == "") 
			{
				alert("Field(s) missing!");
			} 

			else 
			{
				add();
			}
		}
	
		function add() 
		{
			var xhr = new XMLHttpRequest();
			var Url = "http://localhost:8086/InsideUser/carrier/add/";
			xhr.open("POST", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({
			    "carrierChief":carrchief.value, 
			    "car_name":carrname.value, 
			    "ammountOfEmps":amntofemps.value,
			    "car_location":carrlocation.value
			});
			xhr.send(myrespo);
			alert("Carrier added!");
			
			var settings = {
					"url": "http://localhost:8086/InsideUser/form/delete/" + formid.value,
					"method": "DELETE",
					"timeout": 0,
			};

			$.ajax(settings).done(function (response) {
					console.log(response);
			});
			
			location.reload();
		}
	</script>
</sec:authorize>