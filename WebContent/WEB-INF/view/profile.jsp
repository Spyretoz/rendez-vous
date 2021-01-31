<sec:authorize access="isAuthenticated()">
	<br><br>
	Username:  <sec:authentication property="principal.username"/>
	<br><br>
	Role:  <sec:authentication property="principal.authorities"/>
	<!-- <button type="submit" value="Submit" onclick="begin()">Update</button> -->
	
	<script>
		const firstname = document.getElementById("firstname");
		const lastname = document.getElementById("lastname");
		const username = document.getElementById("username");
		const password = document.getElementById("password");
		
		const x = document.getElementById("username").placeholder;
		
		

		function begin() 
		{
			var xhr = new XMLHttpRequest();
			var Url = "http://localhost:8086/InsideUser/api/users/update/";
			xhr.open("PUT", Url);
			xhr.setRequestHeader("Content-Type", "application/json");
			var myrespo = JSON.stringify({"firstName":firstname.value, "lastName":lastname.value, "username":username.value, "password":password.value, "enabled":1});
			xhr.send(myrespo);
			alert("User added!");
			
			firstname.value = '';
			lastname.value = '';
			username.value = '';
			password.value = '';
		}
	
		function add() 
		{
			
		}
	</script>
</sec:authorize>