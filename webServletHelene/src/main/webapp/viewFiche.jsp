<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.formation.inti.entities.Fiche"%>
<%@ page import="fr.formation.inti.service.FicheService"%>
<%@ page import="fr.formation.inti.entities.Patient"%>
<%@ page import="fr.formation.inti.service.PatientService"%>
<%@ page import="fr.formation.inti.servlets.HelloServlet"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Style.css">
<meta charset="ISO-8859-1">
<title>Fiches</title>
</head>
<body>
	<header></header>
	<input type="text" id="myInput" onkeyup="myFunction()"
		placeholder="Recherche par Nom" title="Type in a name">
		<form action='Formulaire.html'>
		<button type='submit'>Ajouter un patient</button>
	</form>
	<div class="contener">
		<table width=300px id="myTable"class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nom</th>
					<th scope="col">Prenom</th>
				</tr>
			</thead>
			<c:forEach begin="0" end="${patient.nom}" varStatus="loop">
  				  ${patient.headings[loop.index]}
				<%-- <tbody>
					<tr>
						<td>${p.pId }</td>
						<td>${p.nom }</td>
						<td>${p.prenom }</td>
						<td><form action="delete" method="post">
								<input type="hidden" name="deleteId" value="${p.pId}"> <input
									type="submit" value="X" title="delete" id="delete"
									onclick="return confirm('Voulez-vous supprimer Mr/Mme ${p.nom } ${p.prenom }')">
							</form>
							
							<form action="view" method="post">
								<input type="hidden" name="viewFiche" value="${p.pId}"> <input
									type="submit" value="F" title="viewFiche" id="viewFiche">
							</form>
							
							<form action="add" method="post">
								<input type="hidden" name="addFiche" value="${p.pId}"> <input
									type="submit" value="+" title="addFiche" id="addFiche">
							</form>
						</td>  
					</tr>
				</tbody> --%>
			</c:forEach>
		</table>
	</div>
	<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}

		function sortTable() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("myTable");
			switching = true;
			/*Make a loop that will continue until
			no switching has been done:*/
			while (switching) {
				//start by saying: no switching is done:
				switching = false;
				rows = table.rows;
				/*Loop through all table rows (except the
				first, which contains table headers):*/
				for (i = 1; i < (rows.length - 1); i++) {
					//start by saying there should be no switching:
					shouldSwitch = false;
					/*Get the two elements you want to compare,
					one from current row and one from the next:*/
					x = rows[i].getElementsByTagName("TD")[0];
					y = rows[i + 1].getElementsByTagName("TD")[0];
					//check if the two rows should switch place:
					if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
						//if so, mark as a switch and break the loop:
						shouldSwitch = true;
						break;
					}
				}
				if (shouldSwitch) {
					/*If a switch has been marked, make the switch
					and mark that a switch has been done:*/
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
				}
			}
		}
	</script>
</body>
</html>