<sec:authorize access="hasRole('ROLE_ADMIN')">

	<div class="Form">
	<h1>Form</h1>
	<br>

	<h5>
		FirstName <input type="text" id="firstname" />
	</h5>
	<br>
	<h5>
		LastName <input type="text" id="lastname" />
	</h5>
	<br>
	<h5>
		Username <input type="text" id="username" />
	</h5>
	<br>
	<h5>
		Password <input type="text" id="password" />
	</h5>
	
	<br>
	<p>
		<button type="submit" class="button" id="add_button" value="Submit" onclick="begin()">ADD</button>
	</p>
	<br>
	</div>

	<script>
		const firstname = document.getElementById("firstname");
		const lastname = document.getElementById("lastname");
		const username = document.getElementById("username");
		const password = document.getElementById("password");
	

		function begin() 
		{
			if (firstname.value == "" || lastname.value == "" || username.value == "" || password.value == "") 
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
			var Url = "http://localhost:8086/InsideUser/api/users/add/";
			xhr.open("POST", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({"firstName":firstname.value, "lastName":lastname.value, "username":username.value, "password":password.value, "enabled":1});
			xhr.send(myrespo);
			alert("User added!");
			
			firstname.value = '';
			lastname.value = '';
			username.value = '';
			password.value = '';
		}
	</script>

</sec:authorize>