<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Favoritos</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Conf-Administrador.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    
    
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.jsp"
}</script>
    <meta property="og:title" content="Conf&nbsp; Administrador">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.jsp">
    <meta property="og:url" content="index.jsp">
  </head>
  <body class="u-body"><header class="u-clearfix u-header u-palette-4-base u-sticky u-header" id="sec-2a1f"><div class="u-clearfix u-sheet u-sheet-1">
        <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse" style="font-size: 1.25rem; letter-spacing: 0; font-weight: 700;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="#" style="padding: 4px 22px; font-size: calc(1em + 8px);">
              <svg><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
              <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
            </a>
          </div>
<%
					HttpSession s = request.getSession();
					String reg = (String) s.getAttribute("Registrado");
				%>
				<div class="u-custom-menu u-nav-container">
					<%
						if (reg == "no") {
					%>
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Login.jsp" style="padding: 10px;">Login</a></li>
					</ul>
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Login.jsp" style="padding: 10px;">Perfil</a></li>
					</ul>
					<%
						}
					%>

					<%
						if (reg == "si") {
					%>
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Logout.jsp" style="padding: 10px;">Logout</a></li>
					</ul>

					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Conf-Usuario.jsp" style="padding: 10px;">Perfil</a></li>
					</ul>
					<%
						}
					%>
					<%
						if (reg == "inspector" || reg == "inspector_noautorizado") {
					%>
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Logout.jsp" style="padding: 10px;">Logout</a></li>
					</ul>

					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Conf-Inspector.jsp" style="padding: 10px;">Perfil</a></li>
					</ul>
					<%
						}
					%>
					<%
						if (reg == "admin") {
					%>
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Logout.jsp" style="padding: 10px;">Logout</a></li>
					</ul>

					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base"
							href="Conf-Administrador.jsp" style="padding: 10px;">Perfil</a></li>
					</ul>
					<% } %>
					</div>
          <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-menu-close"></div>
              <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Login.jsp" style="padding: 10px;">Login</a>
</li></ul>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
        <h1 class="u-heading-font u-text u-title u-text-1">
          <a href="Principal.jsp">iNspector</a>
        </h1>
        <div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">
          <form action="BuscadorLocalesServlet">
            <div class="u-form-group u-form-name">
              <label for="rotulo" class="u-form-control-hidden u-label">Restaurante</label>
              <input type="text" placeholder="Busca un restaurante..." id="rotulo" name="rotulo" class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-gradient u-input u-input-round u-input-1" required="">
            </div>
            <div class="u-form-group u-form-submit">
              <a href="#" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style u-palette-4-dark-2 u-btn-1">Buscar</a>
              <input type="submit" value="submit" class="u-form-control-hidden">
            </div>
          </form>
        </div>
      </div></header>




    <section class="u-clearfix u-image u-shading u-section-5" id="sec-462c" data-image-width="1280" data-image-height="720">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Incidencias Pendientes</h1>
        <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-1" data-animation-name="rubberBand" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 512 512" id="svg-0f91" class="u-svg-content"><linearGradient id="a" gradientUnits="userSpaceOnUse" x1="256" x2="256" y1="0" y2="512"><stop offset="0" stop-color="#2af598"></stop><stop offset="1" stop-color="#009efd"></stop>
</linearGradient>
<path d="m437.019531 74.980469c-48.351562-48.351563-112.640625-74.980469-181.019531-74.980469s-132.667969 26.628906-181.019531 74.980469c-48.351563 48.351562-74.980469 112.640625-74.980469 181.019531s26.628906 132.667969 74.980469 181.019531c48.351562 48.351563 112.640625 74.980469 181.019531 74.980469s132.667969-26.628906 181.019531-74.980469c48.351563-48.351562 74.980469-112.640625 74.980469-181.019531s-26.628906-132.667969-74.980469-181.019531zm-181.019531 397.019531c-119.101562 0-216-96.898438-216-216s96.898438-216 216-216 216 96.898438 216 216-96.898438 216-216 216zm20-236.019531h90v40h-90v90h-40v-90h-90v-40h90v-90h40zm0 0" fill="url(#a)"></path></svg>
        </span>
        <table class="u-align-center">
			<tr>
				
				<th>ID</th>
				<th>LOCAL</th>
				<td>USUARIO</td>
				<td>FECHA</td>
			</tr>
			<c:forEach items="${inspector.getIncidenciasarevisar()}" var="item">
				<tr>
					
					<td>${item.id}</td>
					<td>${item.local.getRotulo()}</td>
					<td>${item.customer.getEmail()}</td>
					<td>${item.fecha}</td>
				
					<td>
				<form action="UltimaInspeccionDelLocalServlet" >
					<input type="hidden" name="rotulo" value="${item.local.getRotulo()}" />
        			<button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style" >Ver Local</button>
        		</form>
        		</td>
        		
        	<td>
				<form action="VerIncidencia1" >
					<input type="hidden" name="incidencia" value="${item.id}" />
					<input type="hidden" name="LOCAL" value="${item.local.getId()}" />
        			<button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style" >Ver Incidencia</button>
        		</form>
        		</td>
 
				</tr>
			</c:forEach>
		</table>

      </div>
                     <div class="u-align-center u-form-group u-form-submit">
                  <a href="Conf-Usuario.jsp" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Volver</a>
                  
                  <input type="submit" value="submit" class="u-form-control-hidden">
                </div>
    </section>
    
    
    <footer class="u-align-left u-clearfix u-footer u-grey-80 u-footer" id="sec-24d6"><div class="u-clearfix u-sheet u-valign-middle-xs u-sheet-1">
        <span class="u-icon u-icon-circle u-text-black u-icon-1">
           </span>
        <p class="u-text u-text-default u-text-1"></p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">

    
    </section>
  </body>
</html>
