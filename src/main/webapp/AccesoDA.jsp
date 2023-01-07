<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%
boolean emptyField = false;
if (application.getAttribute("emptyFields") != null) {
	emptyField = (boolean) application.getAttribute("emptyFields");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AccesoDA</title>
</head>
<body>
<form action="ServletAccesoDA" method="post">
	<h1>TRATAMIENTO FICHEROS</h1>
	<table>
		<tr>
			<!-- Left side -->
			<td><label for="fileType">Formato de fichero:</label> <select
				name="fileType" id="fileType">
					<option value="xls">XLS</option>
					<option value="csv">CSV</option>
					<option value="json">JSON</option>
					<option value="xml">XML</option>
			</select>

				<hr>

				<p>¿Qué quiere hacer con el fichero?</p>
				<table>

					<tr>
						<td>Lectura</td>
						<td style="text-align: right"><input type="radio"
							name="action" value="read" /></td>
					</tr>

					<tr>
						<td>Escritura</td>
						<td style="text-align: right"><input type="radio"
							name="action" value="write" /></td>
					</tr>

				</table></td>

			<!-- Right side -->
			<td>
				<table>

					<tr>
						<td><label for="dato1">DATO 1:</label> <input type="text"
							name="dato1" /></td>
					</tr>

					<tr>
						<td><label for="dato2">DATO 2:</label> <input type="text"
							name="dato2" /></td>
					</tr>

					<tr>
						<td><label for="dato3">DATO 3:</label> <input type="text"
							name="dato3" /></td>
					</tr>

					<tr>
						<td><label for="dato4">DATO 4:</label> <input type="text"
							name="dato4" /></td>
					</tr>

					<tr>
						<td><label for="dato5">DATO 5:</label> <textarea name="dato5" /></textarea>
						</td>
					</tr>

					<tr>
						<td><label for="dato6">DATO 6:</label> <input type="text"
							name="dato6" /></td>
					</tr>

					<%
					if (emptyField) {
					%>
					<tr>
						<td style="color: red;">(*) Los campos no pueden estar vacíos</td>
					</tr>
					<%
					}
					%>

				</table>

			</td>

		</tr>
	</table>
	
	<input type="submit" name="Enviar" value="Enviar">
	</form>

</body>
</html>