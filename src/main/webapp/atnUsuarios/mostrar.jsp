<%-- 
    Document   : mostrar
    Created on : 13/11/2017, 03:53:30 PM
    Author     : andreaml
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                      <img src="<c:url value='/images/logo.png' />" class="image-fluid" width="320px" alt="logo-udec">
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
                            <a class="nav-item nav-link text-dark p-3 px-4 px-md-5 selected mr-1" href="<c:url value='/atnUsuarios/index.jsp' />">Inicio</a>
                            
                            <div class="nav-item dropSubmenu dropdown">
                                <a class="nav-item nav-link text-dark p-3 dropdown-toggle px-4 px-md-5 boton" href="" role="button">Dependencias </a>
                                <!-- Inicio de submenu -->
                                  <div class="contenido text-left ">
                                    <a href="<c:url value='/dependencias' />" class="">Dependencias</a>
                                    <a href="<c:url value='/AreaServlet' />" class="">Áreas</a>
                                    <a href="<c:url value='/vehiculo' />" class="">Vehículos</a>
                                  </div>
                                <!-- Fin de submenu -->      
                            </div>
                  
                            <a class="nav-item nav-link text-dark p-3 selected px-4 px-md-5 mr-1" href="05-servicios.html">Servicios</a>
                            <div class="nav-item dropSubmenu dropdown">
                                <a class="nav-link text-dark p-3 dropdown-toggle px-4 px-md-5" href=""  role="button">Usuarios </a>
                                <!-- Inicio de submenu -->
                                <div class="contenido text-left ">
                                    <a href="<c:url value='/atencion-usuarios' />" class="">Atención a usuarios</a>
                                    <a href="<c:url value='/especialista' />" class="">Especialistas</a>
                                    <a href="<c:url value='/usuario' />" class="">Usuarios</a>
                                </div>
                                <!-- Fin de submenu -->  
                            </div>
                            <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5" href="<c:url value='/tickets' />">Tickets</a>
                            <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5" href="<c:url value='/evaluacionServicio' />">Evaluación de servicio</a>          
                        </div>
                    </nav>
                </div>
                <!-- Fin de barra de menu -->
            </div>
        </div>  
        <!-- Fin encabezado 2 -->
    
        <!-- Seccion 1-->
        <section class="container mt-5">
            <h3 class="text-center p-1">Usuarios tipo Atención a usuarios</h3>
            <div class="row col-12 d-flex justify-content-center align-items-center my-4 ml-0">
                <div id="alertAgregado" class="alert alert-success alert-dismissible fade show col-12 oculto-inicio" role="alert">
                    Atención a usuarios <strong id="correoAtnUsuarioNuevo"></strong> agregado con éxito.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="alertEditado" class="alert alert-success alert-dismissible fade show col-12 oculto-inicio" role="alert">
                    Atención a usuarios <strong id="correoAtnUsuarioNuevo"></strong> editado con éxito.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="alertEliminado" class="alert alert-success alert-dismissible fade show col-12 oculto-inicio" role="alert">
                    Atención a usuarios <strong id="correoAtnUsuarioNuevo"></strong> eliminado con éxito.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>          
                <form class="form-group col-11 col-md-6 mx-md-5 px-0 mb-lg-0 mb-2">
                    <div class="input-group">
                        <input class="form-control " type="search" placeholder="Buscar" aria-label="Search">
                        <span class="input-group-btn">
                            <button class="btn btn-info " type="submit">Buscar</button>
                        </span>
                    </div> 
                </form>
                <button type="button" class="btn btn-info col-md-3 col-11" data-toggle="modal" data-target="#modal-agregarAtnUsuario"><i class="fa fa-plus-circle"></i> Agregar usuario</button>
            </div>
        </section>
        <!-- Fin de seccion 1 -->

        <!-- Contenido principal -->
        <div class="container mt-5 table-responsive ">
      
            <!-- Tabla de registros -->
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Correo</th>
                        <th scope="col">Número de trabajador</th>
                        <th scope="col" >Nombre completo</th>
                        <th scope="col" >Dependencia</th>
                        <th scope="col" class="text-center">Opciones </th>
                    </tr>
                </thead>
                <tbody>
                    
                </tbody>
            </table>
            
            <!-- Fin de tabla de registros -->
        </div>
        <!-- Fin contenido principal -->
        
        <!-- Pie de pagina -->
        <footer class="mt-5 container-fluid bg-dark text-center">
            <div class="container navbar navbar-dark bg-dark ">
                <p class="text-white mr-auto ml-auto"><i class="fa fa-registered"></i> Derechos reservados Universidad de Colima | Página desarrollada por la Facultad de Telemática - 2017</p>
            </div>
        </footer>
        <!-- Fin de pie de pagina -->
        
        <!-- Modales -->
        
        <!--Inicio de modal agregar usurio tipo atención a usuario -->
        <div class="modal" id="modal-agregarAtnUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content ">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Agregar Usuario tipo Atención a Usuario</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    
                    <div class="modal-body p-5 col-11 ">
                        <form id="formAgregarAtnUsuario" action="">
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Correo universitario:</label>
                                <input name="correo" type="text" class="form-control col-8" id="">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Número de trabajador:</label>
                                <input name="num_trabajador" type="text" class="form-control col-4" id="">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Primer nombre:</label>
                                <input name="primer_nombre" type="text" class="form-control col-8" id="">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Segundo nombre:</label>
                                <input name="segundo_nombre" type="text" class="form-control col-8" id="">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Apellido paterno:</label>
                                <input name="apellido_paterno" type="text" class="form-control col-8" id="">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Apellido materno:</label>
                                <input name="apellido_materno" type="text" class="form-control col-8" id="">
                            </div>
                            
                            <div class="form-group row ">
                                <label for="" class="col-4">Dependencia: </label>
                                <select class="form-control col-8" id="selectDependencia">
                                    
                                </select> 
                            </div>               
                        </form>
                    </div>
                    
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button id="btnAgregarAtnUsuario" type="button" class="btn btn-success" data-dismiss="modal">Agregar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin de modal agregar -->

        <!--Inicio de modal editar usurio tipo atención a usuario -->
        <div class="modal" id="modal-editarAtnUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content ">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Editar Usuario tipo Atención a Usuario</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    
                    <div class="modal-body p-5 col-11 ">
                        <form id="formEditarAtnUsuario" action="">
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Correo universitario:</label>
                                <input type="text" class="form-control col-8" id="correo" name="correo">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Número de trabajador:</label>
                                <input type="text" class="form-control col-4" id="num_trabajador" name="num_trabajador">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Primer nombre:</label>
                                <input type="text" class="form-control col-8" id="primer_nombre" name="primer_nombre">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Segundo nombre:</label>
                                <input type="text" class="form-control col-8" id="segundo_nombre" name="segundo_nombre">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Apellido paterno:</label>
                                <input type="text" class="form-control col-8" id="apellido_paterno" name="apellido_paterno">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-form-label col-4">Apellido materno:</label>
                                <input type="text" class="form-control col-8" id="apellido_materno" name="apellido_materno">
                            </div>
                            
                            <div class="form-group row ">
                                <label for="" class="col-4">Dependencia: </label>
                                <select class="form-control col-8" id="selectDependencia">
                                    
                                </select> 
                            </div>   
                        </form>
                    </div>
                    
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button id="btnEditarAtnUsuario" type="button" class="btn btn-success" data-dismiss="modal">Editar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin de modal editar --> 


        <!--Inicio de modal eliminar -->
        <div class="modal" id="modal-eliminarAtnUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Eliminar Usuario</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body p-5">
                        ¿Realmente desea eliminar usuario <strong id="correo"></strong>?   
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <form id="formEliminarAtnUsuario" action="">
                            <button id="btnEliminarAtnUsuario" type="button" class="btn btn-danger" data-dismiss="modal">Eliminar</button>
                        </form>
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
                var listaAtnUsuarios;
                cargarTablaAtnUsuarios();
                $("#btnAgregarAtnUsuario").unbind('click').on('click', function(){
                   console.log($("#formAgregarAtnUsuario").serialize());
                   let dependencia="&dependencia="+$("#formAgregarAtnUsuario #selectDependencia").val();
                   $.ajax({
                        type: 'POST',
                        url: './atencion-usuarios?action=registrar',
                        dataType: 'json',
                        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                        data: $("#formAgregarAtnUsuario").serialize() + dependencia ,
                        success: function(data, textStatus, jqXHR){
                            // access response data
                            console.log(data, textStatus, jqXHR);
                            $("#alertAgregado #correoAtnUsuarioNuevo").text(data.correo);
                            $("#alertAgregado").toggle();
                            setTimeout(function(){
                                $("#alertAgregado").toggle();
                            }, 5000);
                            cargarTablaAtnUsuarios();
                        }
                    });
                });
                
                $("#btnEditarAtnUsuario").unbind('click').on('click', function(){
                   console.log($("#formEditarAtnUsuario").serialize()); 
                   $.ajax({
                        type: 'POST',
                        url: './atencion-usuarios?action=editar&correo=' + $("#formEditarAtnUsuario #correo").val(),
                        dataType: 'json',
                        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                        data: $("#formEditarAtnUsuario").serialize(),
                        success: function(data, textStatus, jqXHR){
                            // access response data
                            console.log(data, textStatus, jqXHR);
                            $("#alertEditado #correoAtnUsuariosNuevo").text(data.correo);
                            $("#alertEditado").toggle();
                            setTimeout(function(){
                                $("#alertEditado").toggle();
                            }, 5000);
                            cargaTablaAtnUsaurios();
                        }
                    });
                });
                
                $("#btnEliminarAtnUsuario").unbind('click').on('click', function(){
                   $.ajax({
                        type: 'POST',
                        url: './atencion-usuarios?action=eliminar&correo=' + $("#formEliminarAtnUsuario #correo").val(),
                        dataType: 'json',
                        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                        success: function(data, textStatus, jqXHR){
                            // access response data
                            console.log(data, textStatus, jqXHR);
                            $("#alertEliminado #correoAtnUsuariosNuevo").text(data.correo);
                            $("#alertEliminado").toggle();
                            setTimeout(function(){
                                $("#alertEliminado").toggle();
                            }, 5000);
                            cargarTablaAtnUsuarios();
                        }
                    });
                });
            
                function mostrarEditarAtnUsuario() {
                    $(".editar").unbind('click').on('click', function(){
                        let idObjAtnUsuario = $(this).attr('data-idObjAtnUsuario');
                        $("#modal-editarAtnUsuario #correo").val(listaAtnUsuarios[idObjAtnUsuario].correo);
                        $("#modal-editarAtnUsuario #num_trabajador").val(listaAtnUsuarios[idObjAtnUsuario].num_trabajador);
                        $("#modal-editarAtnUsuario #primer_nombre").val(listaAtnUsuarios[idObjAtnUsuario].primer_nombre);
                        $("#modal-editarAtnUsuario #segundo_nombre").val(listaAtnUsuarios[idObjAtnUsuario].segundo_nombre);
                        $("#modal-editarAtnUsuario #apellido_paterno").val(listaAtnUsuarios[idObjAtnUsuario].apellido_paterno);
                        $("#modal-editarAtnUsuario #apellido_materno").val(listaAtnUsuarios[idObjAtnUsuario].apellido_materno);
                        $("#modal-editarAtnUsuario #dependencia").val(listaAtnUsuarios[idObjAtnUsuario].dependencia);
                    });
                }
                
                function mostrarEliminarAtnUsuario() {
                    $(".eliminar").unbind('click').on('click', function(){
                        let idObjAtnUsuario = $(this).attr('data-idObjAtnUsuario');
                        $("#modal-eliminarAtnUsuario #num_trabajador").text(listaAtnUsuarios[idObjAtnUsuario].num_trabajador);
                        $("#modal-eliminarAtnUsuario #correo").val(listaAtnUsuarios[idObjAtnUsuario].correo);
                    });
                }
                function cargarTablaAtnUsuarios() {
                    $.ajax({
                        type: 'GET',
                        url: './atencion-usuarios?action=mostrar',
                        dataType: 'json',
                        //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                        //data: $("#formAgregarDependencia").serialize() + direccion,
                        success: function(atnUsuarios, textStatus, jqXHR){
                            // access response data
                            console.log(atnUsuarios, textStatus, jqXHR);
                            listaAtnUsuarios = atnUsuarios;
                            $("tbody").empty();
                            $.each(atnUsuarios, function(id, atnUsuario) {
                                let btnEditar = '<button type="button" class="editar btn btn-info my-1" data-toggle="modal" data-target="#modal-editarAtnUsuario" data-idObjAtnUsuario="'+ id +'"><i class="fa fa-pencil"></i></button>';
                                let btnEliminar = '<button type="button " class="eliminar btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarAtnUsuario" data-idObjAtnUsuario="'+ id +'"><i class="fa fa-trash-o"></i></button>';
                                let nombreCompleto = atnUsuario.primer_nombre+ " ";
                                    nombreCompleto+= atnUsuario.segundo_nombre+ " ";
                                    nombreCompleto+= atnUsuario.apellido_paterno+ " ";
                                    nombreCompleto+= atnUsuario.apellido_materno;
                                let tr = $('<tr class="text-truncate">').append(
                                    $('<td>').text(atnUsuario.correo),                              
                                    $('<td>').text(atnUsuario.num_trabajador),
                                    $('<td>').text(nombreCompleto),
                                    $('<td>').text(atnUsuario.dependencia),                               
                                    $('<td class="text-center d-flex flex-column flex-lg-row justify-content-around">').html(btnEditar + btnEliminar)
                                ); //.appendTo('#records_table');
                                $("table").append(tr);
                                //console.log(tr.wrap('<tr>').html());
                            });
                            mostrarEditarAtnUsuario();
                            mostrarEliminarAtnUsuario();
                        }
                    });
                }  
                
                cargarDependenciasEnSelect();
                function cargarDependenciasEnSelect() {
                   $.ajax({
                        type: 'GET',
                        url: './dependencias?action=mostrar',
                        dataType: 'json',
                        success: function(dependencias, textStatus, jqXHR){
                            // access response data
                            $("#selectDependencia").empty();
                            $.each(dependencias, function(id, dependencia) {
                                $('#selectDependencia').append(new Option(dependencia.nombreDependencia,dependencia.id_dependencia)); 
                            });
                        }
                   });
               }          
            });
        </script>
    </body>
</html>