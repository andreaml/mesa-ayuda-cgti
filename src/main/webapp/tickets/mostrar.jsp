<%-- 
    Document   : mostrar
    Created on : 13/11/2017, 09:03:46 PM
    Author     : andreaml
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
  <head>
    <title>Mesa de ayuda UdeC</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"  href="<c:url value='/css/font-awesome.css' />">
    <link rel="stylesheet"  href="<c:url value='/css/bootstrap.css' />">
    <link rel="stylesheet"  href="<c:url value='/css/style.css' />">
    <link rel="stylesheet"  href="<c:url value='/css/normalize.css' />">
  </head>
 <body>
<!-- Encabezado -->
 <header>  
    <div class="container-fluid bg-dark"> 
      <nav class="navbar navbar-dark bg-dark ml-md-5">
        <a class="navbar-brand" href="index.html">
          <img src="images/logo.png" class="image-fluid" width="320px" alt="logo-udec">
        </a>
      </nav>
    </div>
 </header>
<!-- Fin de encabezado -->

<!--Inicio encabezado 2  -->
<div class="container-fluid d-flex flex-column mt-2 col-12 align-items-center ">
        <div class="row col-12 px-0 ">
            <div class=" col-12 col-md-8 px-0"><h1 class="display-5">Mesa de ayuda UdeC</h1></div>
            <div class="col-5 col-md-4 px-0 align-self-md-center d-md-flex justify-content-md-start justify-content-md-end px-md-0 ">
                <a href="" class="btn btn-info">Iniciar sesión</a>
            </div> 
            
            <!-- Barra de menu -->
            <div class="col-7 col-md-12 px-0 mt-lg-3">
                <nav class=" container nav navbar mr-0 mx-lg-auto pt-0 px-0 navbar-expand-lg navbar-light ">
                    <button class="navbar-toggler align-self-center ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                      
                    <div class="collapse navbar-collapse " id="navbarSupportedContent">
                        <a class="nav-item nav-link text-dark p-3 px-4 px-md-5 selected mr-1" href="01-inicio.html">Inicio</a>
          
                        <div class="nav-item dropSubmenu dropdown">
                            <a class="nav-item nav-link text-dark p-3 dropdown-toggle px-4 px-md-5 boton" href="" role="button">Dependencias </a>
                            <!-- Inicio de submenu -->
                              <div class="contenido text-left ">
                                <a href="02-dependencias.html" class="">Dependencias</a>
                                <a href="03-areas.html" class="">Áreas</a>
                                <a href="04-vehiculos.html" class="">Vehículos</a>
                              </div>
                            <!-- Fin de submenu -->      
                        </div>
                      
                        <a class="nav-item nav-link text-dark p-3 selected px-4 px-md-5 mr-1" href="05-servicios.html">Servicios</a>
                        <div class="nav-item dropSubmenu dropdown">
                            <a class="nav-link text-dark p-3 dropdown-toggle px-4 px-md-5" href=""  role="button">Usuarios </a>
                            <!-- Inicio de submenu -->
                              <div class="contenido text-left ">
                                <a href="06-atencionUsuarios.html" class="">Atención a usuarios</a>
                                <a href="07-especialistas.html" class="">Especialistas</a>
                                <a href="08-usuarios.html" class="">Usuarios</a>
                              </div>
                            <!-- Fin de submenu -->  
                        </div>
                        <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5 act" href="09-tickets.html">Tickets</a>
                        <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5" href="10-evaluacion.html">Evaluación de servicio</a>          
                    </div>
                </nav>
            </div>
            <!-- Fin de barra de menu -->
        </div>
    </div>  
<!-- Fin encabezado 2 -->   

<!-- Seccion 1-->
  <section class="container mt-4">
        <h3 class="text-center p-1">Tickets</h3>
        <div class="row col-12 d-flex justify-content-center align-items-center my-4 ml-0">
            <form class="form-group col-11 col-md-6 mx-md-5 px-0 mb-lg-0 mb-2">
                <div class="input-group">
                    <input class="form-control " type="search" placeholder="Buscar" aria-label="Search">
                    <span class="input-group-btn">
                    <button class="btn btn-info " type="submit">Buscar</button>
                    </span>
                </div> 
            </form>
        <button type="button" class="btn btn-info col-md-3 col-11" data-toggle="modal" data-target="#modal-agregarTicket"><i class="fa fa-user-plus"></i> Agregar ticket</button>
    </div>
  </section>
<!-- Fin de seccion 1 -->

<!-- Inicio de contenido principal -->
  <div class="container-fluid d-flex flex-column mt-4 col-11 table-responsive">
   
    <!-- Tabla de registros -->
    <div class="">
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Título</th>
            <th scope="col">Tipo servicio</th>
            <th scope="col">Emisor</th>
            <th scope="col">Fecha</th>
            <th scope="col">Hora</th>
            <th scope="col">Servicio</th>           
            <th scope="col">Estado de ticket</th>
            <th scope="col">Estado de satisfacción</th>
            <th scope="col">Especialista</th> 
            <th scope="col" >Opciones </th>
          </tr>
        </thead>
        <tbody>
            <tr>
                <td>123</td>
                <td>Lorem ipsum dolor sit </td>
                <td>Lorem ipsum </td>
                <td>usuario@ucol.mx</td>
                <td>2017-10-09</td>
                <td>12:20</td>
                <td>Si</td> 
                <td>Calendarizado</td>
                <td>-</td>
                <td>usuario@ucol.mx</td>
                <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
                    <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarTicket"><i class="fa fa-pencil"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarTicket"><i class="fa fa-trash-o"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target=""><i class="fa fa-times"></i></button>
                </td>
            </tr>
            <tr>
                <td>123</td>
                <td>Lorem ipsum dolor sit </td>
                <td>Lorem ipsum </td>
                <td>usuario@ucol.mx</td>
                <td>2017-10-09</td>
                <td>12:20</td>
                <td>No</td> 
                <td>Solucionado</td>
                <td>-</td>
                <td>usuario@ucol.mx</td>
                <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
                    <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarTicket"><i class="fa fa-pencil"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarTicket"><i class="fa fa-trash-o"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target=""><i class="fa fa-times"></i></button>
                </td>
            </tr>
            <tr>
                <td>123</td>
                <td>Lorem ipsum dolor sit </td>
                <td>Lorem ipsum </td>
                <td>usuario@ucol.mx</td>
                <td>2017-10-09</td>
                <td>12:20</td>
                <td>Si</td> 
                <td>Asignado</td>
                <td>5</td>
                <td>usuario@ucol.mx</td>
                <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
                    <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarTicket"><i class="fa fa-pencil"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarTicket"><i class="fa fa-trash-o"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target=""><i class="fa fa-times"></i></button>
                 </td>
            </tr>
            <tr>
                <td>123</td>
                <td>Lorem ipsum dolor sit </td>
                <td>Lorem ipsum </td>
                <td>usuario@ucol.mx</td>
                <td>2017-10-09</td>
                <td>12:20</td>
                <td>No</td> 
                <td>Calendarizado</td>
                <td>-</td>
                <td>usuario@ucol.mx</td>
                <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
                    <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarTicket"><i class="fa fa-pencil"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarTicket"><i class="fa fa-trash-o"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target=""><i class="fa fa-times"></i></button>
                </td>
            </tr>
            <tr>
                <td>123</td>
                <td>Lorem ipsum dolor sit </td>
                <td>Lorem ipsum </td>
                <td>usuario@ucol.mx</td>
                <td>2017-10-09</td>
                <td>12:20</td>
                <td>Si</td> 
                <td>Calendarizado</td>
                <td>-</td>
                <td>usuario@ucol.mx</td>
                <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
                    <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarTicket"><i class="fa fa-pencil"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarTicket"><i class="fa fa-trash-o"></i></button>
                    <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target=""><i class="fa fa-times"></i></button>
                </td>
            </tr>
        </tbody>
      </table>
    </div>
    <!-- Fin de tabla de registros -->
  </div>
<!-- Fin de contenido principal -->

<!-- Inicio de descripción de los tickets -->
    <div class="container-fluid d-flex flex-column mt-5 col-12 col-md-11 ">
        <div class="row">
            <div class="col-12 col-md-8">
                <div class="row">
                    <h3 class="col-lg-3">Titulo de ticket </h3>
                    <span class="col-lg-3 align-self-center"> Estado del ticket</span>
                </div>
                <p>Por: usuario@ucol.mx el 27-10-2017 a las 18:26 hrs </p>
                <p class="text-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa voluptatem vitae dolorem quisquam provident eligendi dicta ratione veniam cum fuga? 
                    Incidunt repellendus neque debitis non iste corporis consectetur nam porro, optio veniam maxime est hic sed minus et recusandae illum distinctio quia eius autem. Omnis.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque aliquam ratione possimus asperiores? Quibusdam minus nemo doloribus eius quaerat consequuntur ad sunt id doloremque.
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Porro earum, adipisci perferendis ipsa libero unde nemo facere saepe recusandae aperiam? Error, a pariatur.
                </p>
                <p>Ticket número: 1234</p>
            </div>
            <div class="col-lg-3 col-md-4 col-12 ml-auto">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <th>Tipo de servicio: Tipo 1</th>                        
                        </tr>
                        <tr>
                            <td>Especialista: usuario@ucol.mx</td>
                        </tr>
                        <tr>
                            <td>Servicio: asignado</td>
                        </tr>
                        <tr>
                            <td>Fecha de servicio: 26-09-2017 </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <h3>Comentarios</h3>
        <div class="row mt-3">
            <div class="col-md-1 col-2 ">
                <img src="images/user.png" alt="foto-usuario" class="rounded-circle img-fluid" width="50px">
            </div>
            <div class="col-md-11 col-10">
                <h4>Nombre Especialista 1 - Especialista</h4> 
                <p class="text-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis animi expedita eaque molestias repellendus sequi voluptatum, 
                    Lorem ipsum dolor sit amet consectetur, adipisicing elit. Obcaecati, unde. sit dignissimos.</p>
                <div class="row ">
                <p class="col-lg-2 col-12">2017/09/29 a las 18:30</p> 
                <a href="" class="col-lg-2 col-md-4 col-12">Editar comentario</a>  
                <a href="" class="col-lg-2 col-md-4 col-12">Eliminar comentario</a>  
                </div>
                
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-1 col-2">
                <img src="images/user.png" alt="foto-usuario" class="rounded-circle img-fluid" width="50px">
            </div>
            <div class="col-md-11 col-10">
                <form action="" class="d-flex flex-column">
                    <div class="form-group">                    
                        <textarea class="form-control" id="" rows="1" placeholder="Escribe tu comentario"></textarea>
                    </div>
                    <div class="ml-auto">
                        <button type="submit" class="btn btn-info">Enviar </button>
                    </div>
                </form>

            </div>

        </div>
    </div>

<!-- Fin de descripción de tickets -->

  
 
  <!-- Inicio de pie de pagina -->
  <footer class="mt-5 container-fluid bg-dark text-center ">
    <div class="container navbar navbar-dark bg-dark ">
      <p class="text-white mr-auto ml-auto"><i class="fa fa-registered"></i> Derechos reservados Universidad de Colima | Página desarrollada por la Facultad de Telemática - 2017</p>
    </div>
  </footer>
  <!-- Fin de pie de pagina -->
  


  <!-- Modales -->

<!--Inicio de modal editar ticket -->
    <div class="modal" id="modal-editarTicket" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content ">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">Editar Ticket</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body p-5 col-11 ">
                    <form action="">
                        <div class="form-group row">
                            <label for="" class="col-form-label col-4">Titulo:</label>
                            <input type="text" class="form-control col-8" id="">
                        </div>
                        <div class="form-group row">         
                            <label for="" class="col-form-label col-4">Descripción:</label>           
                            <textarea class="form-control col-8" id="" rows="3" ></textarea>
                        </div>
                        <div class="form-group row ">
                            <label for="" class="col-4">Tipo de servicio: </label>
                            <select class="form-control col-8" id="selectTipoServicio">
                                <option></option>
                            </select> 
                        </div>
                        <div class="form-group row ">
                            <label for="" class="col-4">Emisor: </label>
                            <select class="form-control col-8" id="selectEmisor">
                                <option></option>
                            </select> 
                        </div>
                        <div class="form-group row ">
                            <label for="" class="col-4">Especialista: </label>
                            <select class="form-control col-8" id="selectEspecialista">
                            </select> 
                        </div>
                        <div class="form-group row ">
                            <label for="" class="col-4">Servicio: </label>
                            <select class="form-control col-8" id="selectServicio">
                            </select> 
                        </div>
                        <div class="form-group row ">
                        <label for="" class="col-4">Estado de ticket: </label>
                            <select class="form-control col-8" id="">
                                <option value="Atendiendo">Atendiendo</option>
                                <option value="Solucionado">Solucionado</option>
                            </select> 
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal">Editar</button>
                </div>
            </div>
        </div>
    </div>

<!-- Fin de modal editar ticket--> 


<!--Inicio de modal eliminar ticket-->
    <div class="modal" id="modal-eliminarTicket" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">Eliminar Ticket</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body p-5">
                ¿Realmente desea eliminar ticket array[i]?   
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Eliminar</button>
                </div>
            </div>
        </div>
    </div>
<!-- Fin de modal -->


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="<c:url value='/js/bootstrap.js' />"></script>
    <script>
        $(function(){
           function cargarEmisoresEnSelect() {
               $.ajax({
                    type: 'GET',
                    url: './usuario?action=mostrar',
                    dataType: 'json',
                    success: function(usuarios, textStatus, jqXHR){
                        // access response data
                        $("#selectEmisor").empty();
                        $.each(usuarios, function(id, usuario) {
                            $('#selectEmisor').append(new Option(usuario.correo,usuario.correo)); 
                        });
                    }
               });
           }
           function cargarEspecialistasEnSelect() {
               console.log('entraespecialista')
               /*$.ajax({
                    type: 'GET',
                    url: './especialista?action=mostrar',
                    dataType: 'json',
                    success: function(especialistas, textStatus, jqXHR){
                        // access response data
                        $("#selectEspecialista").empty();
                        $.each(especialistas, function(id, especialista) {
                            $('#selectEspecialista').append(new Option(especialista.correo,especialista.correo)); 
                        });
                    }
               });*/
               $("#selectEspecialista").change(function(){
                   console.log('clickselect')
                    cargarServiciosEnSelect($("#selectEspecialista option:selected").val());
               });
           }
           function cargarServiciosEnSelect(id_especialista) {
               console.log(id_especialista)
               /*$.ajax({
                    type: 'GET',
                    url: './servicios?action=mostrarPorEspecialista?id_especialista=' + id_especialista,
                    dataType: 'json',
                    success: function(servicios, textStatus, jqXHR){
                        // access response data
                        $("#selectServicios").empty();
                        $.each(servicios, function(id, servicio) {
                            $('#selectServicios').append(new Option(servicio.nombreServicio,servicio.id_servicio)); 
                        });
                    }
               });*/
           } 
           function cargarTipoServicioEnSelect() {
               $.ajax({
                    type: 'GET',
                    url: './tipo-servicio?action=mostrar',
                    dataType: 'json',
                    success: function(tiposServicio, textStatus, jqXHR){
                        // access response data
                        $("#selectTipoServicio").empty();
                        $.each(tiposServicio, function(id, tipoServicio) {
                            $('#selectTipoServicio').append(new Option(tipoServicio.nombreTipoServicio,tipoServicio.id_tipo_servicio)); 
                        });
                    }
               });
               $("#selectTipoServicio").change(function(){
                    cargarEspecialistasEnSelect($("#selectTipoServicio option:selected").val());
               });
           } 
           cargarEmisoresEnSelect();
           cargarTipoServicioEnSelect();
           //cargarEspecialistasEnSelect();
        });
    </script>
  </body>
</html>