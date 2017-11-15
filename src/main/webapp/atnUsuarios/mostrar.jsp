<%-- 
    Document   : mostrar
    Created on : 13/11/2017, 03:53:30 PM
    Author     : andreaml
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
  <head>
    <title>Mesa de ayuda UdeC</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"  href="css/font-awesome.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">
   
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
                    <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5" href="09-tickets.html">Tickets</a>
                    <a class="nav-item nav-link text-dark p-3 selected mr-1 px-4 px-md-5" href="10-evaluacion.html">Evaluación de servicio</a>          
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
            <form class="form-group col-11 col-md-6 mx-md-5 px-0 mb-lg-0 mb-2">
            <div class="input-group">
                <input class="form-control " type="search" placeholder="Buscar" aria-label="Search">
                <span class="input-group-btn">
                <button class="btn btn-info " type="submit">Buscar</button>
                </span>
            </div> 
            </form>
            <button type="button" class="btn btn-info col-md-3 col-11" data-toggle="modal" data-target="#modal-agregarUsuario"><i class="fa fa-plus-circle"></i> Agregar usuario</button>
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
          <tr class="text-truncate"> 
            <td>usuario@ucol.mx</td>
            <td>1234</td>
            <td>Lorem ipsum, dolor sit amet consectetur elit</td>
            <td>Dependencia 1</td>
            <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
              <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarUsuario"><i class="fa fa-pencil"></i></button>              
              <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarUsuario"><i class="fa fa-trash-o"></i></button>
            </td>
          </tr>
          <tr>
              <td>usuario@ucol.mx</td>
              <td>1234</td>
              <td>Lorem ipsum, dolor sit amet consectetur elit</td>
              <td>Dependencia 2</td>
            <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
              <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarUsuario"><i class="fa fa-pencil"></i></button>
              <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarUsuario"><i class="fa fa-trash-o"></i></button>
            </td>
          </tr>
          <tr>
              <td>usuario@ucol.mx</td>
              <td>1234</td>
              <td>Lorem ipsum, dolor sit amet consectetur elit</td>
              <td>Dependencia 3</td>
            <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
              <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarUsuario"><i class="fa fa-pencil"></i></button>
              <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarUsuario"><i class="fa fa-trash-o"></i></button>
            </td>
          </tr>
          <tr>
              <td>usuario@ucol.mx</td>
              <td>1234</td>
              <td>Lorem ipsum, dolor sit amet consectetur elit</td>
              <td>Dependencia 4</td>
            <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
              <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarUsuario"><i class="fa fa-pencil"></i></button>
              <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarUsuario"><i class="fa fa-trash-o"></i></button>
            </td>
          </tr>
          <tr>
              <td>usuario@ucol.mx</td>
              <td>1234</td>
              <td>Lorem ipsum, dolor sit amet consectetur elit</td>
              <td>Dependencia 5</td>
            <td class="text-center d-flex flex-column flex-lg-row justify-content-around">
              <button type="button" class="btn btn-info my-1" data-toggle="modal" data-target="#modal-editarUsuario"><i class="fa fa-pencil"></i></button>
              <button type="button" class="btn btn-danger my-1" data-toggle="modal" data-target="#modal-eliminarUsuario"><i class="fa fa-trash-o"></i></button>
            </td>
          </tr> 
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
<div class="modal" id="modal-agregarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content ">
            <div class="modal-header">
                <h3 class="modal-title" id="exampleModalLabel">Agregar Usuario tipo Atención a Usuario</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body p-5 col-11 ">
                <form action="">
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Correo universitario:</label>
                        <input type="text" class="form-control col-8" id="">
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Número de trabajador:</label>
                        <input type="text" class="form-control col-4" id="">
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Primer nombre:</label>
                        <input type="text" class="form-control col-8" id="">
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Segundo nombre:</label>
                        <input type="text" class="form-control col-8" id="">
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Apellido paterno:</label>
                        <input type="text" class="form-control col-8" id="">
                    </div>
                    <div class="form-group row">
                        <label for="" class="col-form-label col-4">Apellido materno:</label>
                        <input type="text" class="form-control col-8" id="">
                    </div>
                     
                    <div class="form-group row ">
                            <label for="" class="col-4">Dependencia: </label>
                            <select class="form-control col-8" id="">
                                <option>Dependencia 1</option>
                                <option>Dependencia 2</option>
                                <option>Dependencia 3</option>
                                <option>Dependencia 4</option>
                                <option>Dependencia 5</option>
                              </select> 
                    </div>
                    
                </form>
            </div>
            
            <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-success" data-dismiss="modal">Agregar</button>
            </div>
        </div>
        </div>
    </div>
  <!-- Fin de modal agregar -->

<!--Inicio de modal editar usurio tipo atención a usuario -->
<div class="modal" id="modal-editarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content ">
        <div class="modal-header">
            <h3 class="modal-title" id="exampleModalLabel">Editar Usuario tipo Atención a Usuario</h3>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>

        <div class="modal-body p-5 col-11 ">
            <form action="">
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Correo universitario:</label>
                    <input type="text" class="form-control col-8" id="">
                </div>
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Número de trabajador:</label>
                    <input type="text" class="form-control col-4" id="">
                </div>
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Primer nombre:</label>
                    <input type="text" class="form-control col-8" id="">
                </div>
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Segundo nombre:</label>
                    <input type="text" class="form-control col-8" id="">
                </div>
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Apellido paterno:</label>
                    <input type="text" class="form-control col-8" id="">
                </div>
                <div class="form-group row">
                    <label for="" class="col-form-label col-4">Apellido materno:</label>
                    <input type="text" class="form-control col-8" id="">
                </div>
                 
                <div class="form-group row ">
                        <label for="" class="col-4">Dependencia: </label>
                        <select class="form-control col-8" id="">
                            <option>Dependencia 1</option>
                            <option>Dependencia 2</option>
                            <option>Dependencia 3</option>
                            <option>Dependencia 4</option>
                            <option>Dependencia 5</option>
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
<!-- Fin de modal editar --> 


<!--Inicio de modal eliminar -->
<div class="modal" id="modal-eliminarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="exampleModalLabel">Eliminar Usuario</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body p-5">
            ¿Realmente desea eliminar usuario array[i] ?   
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="js/bootstrap.js"></script>
  </body>
</html>