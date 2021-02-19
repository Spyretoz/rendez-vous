<sec:authorize access="hasRole('ROLE_ADMIN')">

	<div class="Form">
	<h1>Form</h1>
	<br>

	<h5>
		FirstName <input type="text" id="firstname" required/>
	</h5>
	<br>
	<h5>
		LastName <input type="text" id="lastname" required/>
	</h5>
	<br>
	<h5>
		Username <input type="text" id="username" required/>
	</h5>
	<br>
	<h5>
		Password <input type="password" id="password" required/>
	</h5>
	
	<br>
	<p>
		<button type="submit" class="button" id="add_button" value="Submit" onclick="add()">ADD</button>
	</p>
	<br>
	</div>

	<script>
		const firstname = document.getElementById("firstname");
		const lastname = document.getElementById("lastname");
		const username = document.getElementById("username");
		const password = document.getElementById("password");
	

	
		function add() 
		{
			var xhr = new XMLHttpRequest();
			var Url = "http://localhost:8086/InsideUser/api/users/add/";
			xhr.open("POST", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({"firstName":firstname.value, "lastName":lastname.value, "username":username.value, "password":password.value, "enabled":1});
			xhr.send(myrespo);
			alert("User added!");
			
			location.reload();
		}
	</script>

</sec:authorize>