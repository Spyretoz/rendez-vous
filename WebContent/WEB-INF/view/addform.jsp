<sec:authorize access="hasRole('ROLE_CHIEF')">
    <div class="FormCar">
		<h1>Form to add your carrier</h1>
	
		<input type="hidden" id="chiefName" placeholder="Your Name" value="<sec:authentication property="principal.username"/>" required/>
		
		<br>
	
		<h5>
			Carrier's Name <input type="text" id="carName" placeholder="Carrier Name" required/>
		</h5>
		
		<br>
	
		<h5>
			Amount of employees <input type="text" id="amountofEmployees" placeholder="Amount" required/>
		</h5>
		
		<br>
		
		<h5>
			Carrier Location <input type="text" id="carLoc" placeholder="Location" required/>
		</h5>
		
		
		<br>
 		<button type="submit" id="add_button" class="button" value="Submit" onclick="add()">ADD</button>
 		
 		<br><br>
 		
 		

 	</div>
 	
 	<script>
		const chiefName = document.getElementById("chiefName");
		const numberEmployees = document.getElementById("amountofEmployees");
		const carLoc = document.getElementById("carLoc");
		const carName = document.getElementById("carName");
		
	
		function add() 
		{
			var xhr = new XMLHttpRequest();
			var Url = "http://localhost:8086/InsideUser/form/add";
			xhr.open("POST", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({"chiefName":chiefName.value, "carrierName":carName.value, "a_amountOfEmps":numberEmployees.value, "carrierLocation":carLoc.value});
			xhr.send(myrespo);
			alert("Form added!");
			
			chiefName.value = '';
			numberEmployees.value = '';
			carLoc.value = '';
			carName.value = '';
		}
	</script>
</sec:authorize>