<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import  ="model.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
   <head>
   <%--<% if(session.getAttribute("client")==null){ 
        response.sendRedirect("login.jsp");} 
   	 --%>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      
      
      <!-- site metas -->
      <title>Notre Agence</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <!-- owl stylesheets --> 
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesheet" href="css/owl.theme.default.min.css">
      
      <link rel="stylesheet" href="assets/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
      <link rel="stylesheet" href="assets/vendors/iconfonts/ionicons/dist/css/ionicons.css">
      <link rel="stylesheet" href="assets/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
      <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
      <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.addons.css">
      <!-- endinject -->
      <!-- inject:css -->
      <link rel="stylesheet" href="assets/css/shared/style.css">
      <!-- endinject -->
      <!-- Layout styles -->
      <link rel="stylesheet" href="assets/css/demo_1/style.css">
      <!-- End Layout styles -->
      <link rel="shortcut icon" href="assets/images/favicon.ico" />
      
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
    <%-- <% if(session.getAttribute("client")==null){ 
        response.sendRedirect("login.jsp");} 
   	 --%>
   <body class="main-layout">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src ="images/loading.gif" alt="#" /></div>
      </div>
      <!-- end loader -->
      <!-- header -->
      <header>
		<!-- header inner -->
		<div class="header">
			<div class="header_white_section">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="header_information">
								<ul>
									<li><img src="images/1.png" alt="#" /> Bachelor
										U.MY.ISMAIL</li>
									<li><img src="images/2.png" alt="#" /> +71 5678954378</li>
									<li><img src="images/3.png" alt="#" /> Bonjour
										${client.getLogin() }, ici votre espace!</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
						<div class="menu-area">
							<div class="limit-box">
								<nav class="main-menu">
									<ul class="menu-area-main">
										<c:if test="${not empty client}">

											<li><a href="listePanier?idclient=${client.getId()}">Mon
													panier</a></li>
										</c:if>
										<c:if test="${not empty client}">

											<li><a href="reservations?id_client=${client.getId() }">Mes
													reservations</a></li>
										</c:if>
										<li><a href="#about">About us</a></li>
										<c:if test="${not empty client}">

											<li><a href="logout">log out</a></li>
										</c:if>
										<c:if test="${empty client}">
											<li><a href="register.jsp">Sign up</a></li>
											<li><a href="login.jsp">log in</a></li>
										</c:if>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end header inner -->
	</header>
      <!-- end header -->
      <section >
         <div class="banner-main">
            <img src="images/Ecommerce-customer-service-banner.png" alt="#"/>
            <div class="container">
               <div class="text-bg">
                  <h1>Commandez<br><strong class="white">quand vous voulez</strong></h1>
                 &nbsp;
                 &nbsp;
                 &nbsp;
                  
               </div>
            </div>
         </div>
      </section>
      <!-- about -->
      
      <!-- about -->
      <div id="blog" class="blog">
         <div class="container">
            
            <div class="row">
            <c:forEach items="${produits}" var="produit">
               <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                  <div class="blog-box">
                     <figure><img src="data:image/jpg;base64, ${produit.base64Image}" alt="#"/>
                     <span>${ produit.nom}</span>
                     </figure>
                     <div class="travel">
                        <span>Famille :  ${ produit.nomFamille }</span> 
                        <p><strong class="Comment"> ${ produit.getPrix() } DHS</strong>  Prix</p>
                        <h3>${ produit.getDescription() } </h3>
                        <p> Quantit??e : ${ produit.getQtte() }</p>
                              
                              <div class=" bottom text-center">
                           
                           <div class=" col-sm-7 emphasis">
                           <!-- <form action="consulterVoyage?id=${produit.getId_produit()}" method="POST"> 
                               <button  type="submit" class="btn btn-success btn-sm">
                                <i class="fa fa-user"> </i>Consulter
                              </button>
                              </form>-->
                              
							<c:if test="${not empty client}">
                              <button onclick="window.location.href ='ajoutPanier?id_client=${idclient}&idprod=${produit.getId_produit()}';" type="submit" class="btn btn-primary btn-sm">
                                <i class="fa fa-user"> </i> Ajouter au panier
                              </button>
                             </c:if>
                             <c:if test="${empty client}">
                              <button onclick="window.location.href ='login.jsp';" type="submit" class="btn btn-primary btn-sm">
                                <i class="fa fa-user"> </i> Ajouter au panier
                              </button>
                             </c:if>
                            </div>
                          </div>
                     </div>
                     
                  </div>
               </div>
               </c:forEach>
            </div>
         </div>
      </div>
      <!-- end about -->
      <!-- traveling -->
      
      <!-- end traveling -->
      <!--London -->
      
      <!-- end London -->
      <!--Tours -->
      
      <!-- end Tours -->
      <!-- Amazing -->
      
      <!-- end Amazing -->
      <!-- our blog -->
      
      <!-- end our blog -->
      <!-- footer -->
      <footer>
         <div id="contact" class="footer" style="background-color:#3555dc;">
            <div class="container">
               <div class="row pdn-top-30">
                  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                     <ul class="location_icon">
                        <li> <a href="#"><img src="icon/facebook.png"></a></li>
                        <li> <a href="#"><img src="icon/Twitter.png"></a></li>
                        <li> <a href="#"><img src="icon/linkedin.png"></a></li>
                        <li> <a href="#"><img src="icon/instagram.png"></a></li>
                     </ul>
                  </div>
                  <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                     <div class="Follow">
                        <h3>CONTACT US</h3>
                        <span>123 Second Street Fifth <br>Avenue,<br>
                        Manhattan, New York<br>
                        +987 654 3210</span>
                     </div>
                  </div>
                  <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                     <div class="Follow">
                        <h3>ADDITIONAL LINKS</h3>
                        <ul class="link">
                           <li> <a href="#">About us</a></li>
                           <li> <a href="#">Terms and conditions</a></li>
                           <li> <a href="#"> Privacy policy</a></li>
                           <li> <a href="#">News</a></li>
                           <li> <a href="#"> Contact us</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                     <div class="Follow">
                        <h3> Contact</h3>
                        <form action="sendEmail" method="post">
                        <div class="row">
                           <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                              <input class="Newsletter" name="subjet" placeholder="Sujet" type="text">
                           </div>
                           <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                              <input class="Newsletter" name="email" placeholder="Email" type="text">
                           </div>
                           <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                              <input class="Newsletter" name="password" placeholder="code de votre adresse gmail" type="password">
                           </div>
                           <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                              <textarea class="textarea" name="commentaire" placeholder="commentaire" type="text">Commentaire</textarea>
                           </div>
                        </div>
                        <button class="Subscribe">Submit</button>
                        </form>
                     </div>
                  </div>
               </div>
               <div class="copyright">
                  <div class="container">
                  
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- end footer -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <!--<script src="js/plugin.js"></script>-->
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <!-- javascript --> 
      <script src="js/owl.carousel.js"></script>
      <script>
         $(document).ready(function() {
           var owl = $('.owl-carousel');
           owl.owlCarousel({
             margin: 10,
             nav: true,
             loop: true,
             responsive: {
               0: {
                 items: 1
               },
               600: {
                 items: 2
               },
               1000: {
                 items: 3
               }
             }
           })
         })
      </script>
    
   </body>
</html>