<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Contact Form | Gentelella Alela! by Colorlib</title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="assets/css/demo_1/style.css">
  </head>
<% if(session.getAttribute("client1")==null){ 
        response.sendRedirect("login.jsp");} 
   	 %>
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="afficherVoyages?id_client=${client1.getId() }" class="site_title"><i class="fa fa-money"></i> <span>Nos offres</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                  <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                
            </div>
          </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Mes Produits</h3>
              </div>

            </div>

            <div class="clearfix"></div>

            <div class="row">
                <div class="x_panel">
                  <div class="x_content">
                      
                      <div class="clearfix"></div>

                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th> </th>
                          <th> Produit </th>
                          <th> prixT </th>
                          <th> Quantite </th>
                          <th>  Description</th>
                        </tr>
                      </thead>
                      
                      <tbody id="myMenu">
                      <c:forEach items="${paniers}" var="p">
                        <tr >
                          <td>
                          <img src="data:image/jpg;base64, ${p.photo}" width="30" height="35" style="border-radius: 50%;"/>
                          </td>
                          <td> ${ p.produit} </td>
                          <td>${ p.prixT }
                          </td>
                          <td>${ p.qtte }
                          </td>
                          <td> ${ p.description } MAD </td>
                          
                          <td><a href="supprimerPanier?id_panier=${p.idpanier}" ><i
								class="fa fa-trash-o" aria-hidden="true"></i>Supprimer</a></td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
   <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
  </body>
</html>