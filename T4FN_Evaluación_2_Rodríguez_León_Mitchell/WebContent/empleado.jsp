<!-- agregar el taglib para que la página pueda trabajar con jstl-->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
	<h2 style="text-align:center">Registro de Empleado</h2>
	
<c:if test="${requestScope.MENSAJE!=null}">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>${requestScope.MENSAJE}</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>

	<div class="container">
 		 <form method="post" action="ServletEmpleado?accion=registrar" id="form_registrar">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Nombres</label>
			    <input type="text" class="form-control"  name="nombre" placeholder="Ingresar nombres">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Apellidos</label>
			    <input type="text" class="form-control" name="apellido" placeholder="Ingresar apellidos">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">DNI</label>
			    <input type="text" class="form-control" name="dni" placeholder="Ingresar número de DNI">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Hijos</label>
			    <input type="text" class="form-control" name="hijos" placeholder="Ingresar número de hijos">
			  </div>
			  <button type="submit" class="btn btn-primary">Registrar</button>
			  <button type="button" class="btn btn-success">Listar</button>
		 </form>
	</div>
	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

	<!-- jQuery validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>
	
	<script>
		$(".btn-success").click(function() {
			window.location.href='ServletEmpleado?accion=listar';
		})
	</script>
	
	
	<script>    
	  $('#form_registrar').validate({
	    rules: {
	    	nombre: {
	    		required:true,
	    		pattern:'[a-zA-Z\\s]{3,30}'
	    	},
	    	apellido: {
	    		required:true,
	    		pattern:'[a-zA-Z\\s]{3,30}'
	    	},
	    	dni: {
	    		required:true,
	    		pattern:'^\\d{8}'
	    	},
	    	hijos: {
	    		required:true,
	    		pattern:'^\\d{1}'
	    	}
	    },
	    messages:{
	    	nombre: {
	    		required:'Campo nombre es obligatorio',
	    		pattern:'Campo nombre acepta letras entre 3 a 30 dígitos'
	    	},
	    	apellido: {
	    		required:'Campo apellido es obligatorio',
	    		pattern:'Campo apellido acepta letras entre 3 a 30 dígitos'
	    	},
	    	dni: {
	    		required:'Campo dni es obligatorio',
	    		pattern:'Campo dni acepta 8 dígitos'
	    	},
	    	hijos: {
	    		required:'Campo hijos es obligatorio',
	    		pattern:'Campo hijos acepta números de una cifra'
	    	}
	    
	    },
	    
	    
	    errorElement: 'span',
	    errorPlacement: function (error, element) {
	        error.addClass('invalid-feedback');
	        element.closest('.form-group').append(error);
	    },
	    highlight: function (element, errorClass, validClass) {
	        $(element).addClass('is-invalid');
	    },
	    unhighlight: function (element, errorClass, validClass) {
	        $(element).removeClass('is-invalid');
	    },
	    
	
	})
	</script>
	
	
</body>
</html>