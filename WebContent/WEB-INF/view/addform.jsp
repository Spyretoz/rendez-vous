<sec:authorize access="hasRole('ROLE_CHIEF')">
    <div class="Form">
		<h1>Form to add your carrier</h1>
		<br>
	
		<h5>
			<label>Chief's Name </label><input type="text" id="chiefName" placeholder="Name"/>
		</h5>
		
		<br><br>
	
		<h5>
			<label>Amount of employees </label><input type="text" id="amountofEmployees" placeholder="Amount"/>
		</h5>
		
		<br><br>
 		<button type="submit" id="add_button" class="button" value="Submit" onclick="begin()">ADD</button>
 		
 		<br><br>

 	</div>
 	
 	<script>
		const chiefName = document.getElementById("chiefName");
		const numberEmployees = document.getElementById("amountofEmployees");
		

		function begin() 
		{
			if (chiefName.value == "" || numberEmployees.value == "") 
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
			var Url = "http://localhost:8086/InsideUser/form/add";
			xhr.open("POST", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({"chiefName":chiefName.value, "carrierId":numberEmployees.value});
			xhr.send(myrespo);
			alert("Form added!");
			
			chiefName.value = '';
			numberEmployees.value = '';
		}
	</script>
</sec:authorize>