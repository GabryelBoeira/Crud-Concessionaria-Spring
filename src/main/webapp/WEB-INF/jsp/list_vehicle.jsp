<%@ include file="template/header.jspf" %>
<%@ include file="template/barra_superior.jspf" %>	
    <main role="main" class="container">
		<table class="table" id="table">
	       <thead>
				<tr>
			    	<th scope="col">Id</th>
			      	<th scope="col">Marca</th>
			      	<th scope="col">Modelo</th>
			      	<th scope="col">Ano do modelo</th>
			      	<th scope="col">Preço</th>
			      	<th scope="col">Descrição</th>
			      	<th scope="col">Remover</th>
			      	<th scope="col">Alterar</th>
			    </tr>
			</thead>
			<tbody>
	        	<c:forEach var="vehicle" items="${listVehicles}"> 		
					<tr>
					    <th>${vehicle.id}</th>
					    <td>${vehicle.brand}</td>
					    <td>${vehicle.modelYear}</td>
					    <td>${vehicle.model}</td>
					    <td>${vehicle.price}</td>
					    <td>${vehicle.description}</td>
					    <td><button onclick="window.location.href='/remove_vehicle?idVehicle=${vehicle.id}'" class="btn btn-danger"> Remove</button></td>
					    <td><button onclick="window.location.href='/alter_vehicle?idVehicle=${vehicle.id}'" class="btn btn-info"> Alterar</button></td>
				  	</tr>			
	    		</c:forEach>
	    	</tbody>
		</table>
    </main>
<%@ include file="template/footer.jspf" %>