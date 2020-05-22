
<%@ include file="template/header.jspf" %>
<c:url value="/add" var="addVehicle"/>

<%@ include file="template/barra_superior.jspf" %>
	<main role="main" class="container">
		<div class="form-group">
             <h2>Cadastro de novos veiculos</h2>
             <span class="addVehicle">* campos obrigatórios</span>
        </div> 
		<form:form action="${addVehicle}" id="addVehicle" method="post" modelAttribute="vehicle">
			<input type="hidden" value="${alterVehicle.id}" name="id" id=id />			
		
			<div class="form-group">
				<label for="brand">Marca:</label>
			    <form:input path="brand" required="true" type="${paramValues.type[alterVehicle.brand]}" value="${alterVehicle.brand}"/>
			 </div>
			 <div class="form-group">
			 	<label for="modelo">Modelo:</label>
			    <form:input path="model" required="true" type="${paramValues.type[alterVehicle.model]}" value="${alterVehicle.model}"/>
			 </div>
			 <div class="form-group">
			 	<label for="modelYear">Ano do modelo:</label>
			    <form:input path="modelYear" required="true" type="${paramValues.type[alterVehicle.modelYear]}" value="${alterVehicle.modelYear}"/>
			 </div>
			 <div class="form-group">
			 	<label for="yearManufacture">Ano de fabricação:</label>
			    <form:input path="yearManufacture" required="true" type="${paramValues.type[alterVehicle.yearManufacture]}" value="${alterVehicle.yearManufacture}"/>
			 </div>
			 <div class="form-group">
			 	<label for="price">Preço:</label>
			    <form:input path="price" class="price" required="true" placeholder="0,00" type="${paramValues.type[alterVehicle.price]}" value="${alterVehicle.price}" />
			 </div>
			 <div class="form-group">
			 	<label  for="description">Descrição do veiculo:</label>
			    <form:input path="description" type="${paramValues.type[alterVehicle.description]}" value="${alterVehicle.description}" />
			 </div>			 			 
			 <input class="btn btn-primary" type="submit" value="Cadastrar"/>	         
        </form:form>			
    </main>
<%@ include file="template/footer.jspf" %>
