<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>
<style>
ul#menu {
	padding: 0;
}

ul#menu li {
	display: inline;
}

ul#menu li a {
	background-color: black;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 4px 4px 0 0;
}

ul#menu li a:hover {
	background-color: orange;
}
</style>
</head>

	<h2>Horizontal List</h2>

	<ul id="menu">
		<li><a href="lista">Lista</a></li>
		<li><a href="deletar">deletar</a></li>
		<li><a href="javascript">JavaScript</a></li>
		<li><a href="php">PHP</a></li>
	</ul>
