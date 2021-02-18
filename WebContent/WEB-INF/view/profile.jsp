<sec:authorize access="isAuthenticated()">
	<br><br>
	Username:  <sec:authentication property="principal.username"/>
	<br><br>
	Role:  <sec:authentication property="principal.authorities"/>
	<!-- <button type="submit" value="Submit" onclick="begin()">Update</button> -->
	
	
</sec:authorize>