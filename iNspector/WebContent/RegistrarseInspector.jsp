<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="iNspector">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>RegistrarseInspector</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="RegistrarseInspector.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.jsp"
}</script>
    <meta property="og:title" content="RegistrarseInspector">
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
          <% HttpSession s= request.getSession();
           String reg =(String)s.getAttribute("Registrado");%>
                      <div class="u-custom-menu u-nav-container">
           	<% if(reg=="no"){ %>
		  <ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Login.jsp" style="padding: 10px;">Login</a>
</li></ul>
		<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Login.jsp" style="padding: 10px;">Perfil</a>
		</li></ul>
		<% }%>
		
          <% if(reg=="si"){ %>
            <ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Logout.jsp" style="padding: 10px;">Logout</a>
</li></ul>
	
		<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Conf-Usuario.jsp" style="padding: 10px;">Perfil</a>
		</li></ul>
		<% } %>
		 <% if(reg=="inspector"){ %>
            <ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Logout.jsp" style="padding: 10px;">Logout</a>
</li></ul>
	
		<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Conf-Inspector.jsp" style="padding: 10px;">Perfil</a>
		</li></ul>
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
    <section class="u-clearfix u-image u-shading u-section-1" id="sec-cb27">
      <div class="u-clearfix u-sheet u-valign-top u-sheet-1">
        <div class="u-container-style u-group u-opacity u-opacity-70 u-white u-group-1">
          <div class="u-container-layout u-container-layout-1">
            <h3 class="u-align-center u-text u-text-palette-4-base u-text-1">Regístrate</h3>
            <p class="u-align-center u-text u-text-default u-text-grey-75 u-text-2"> Para ello, antes debes tener en cuenta que cualquier nuevo inspector pasa un proceso de verificación para avalar su autoridad.</p>
            <div class="u-form u-form-1">
              <form action="FormCreaInspector">
              <label for="username" class="u-align-center u-text u-text-default u-text-grey-75 u-text-2">Inspector</label>
                <div class="u-form-group u-form-name u-form-group-1">
                  <label for="name" class="u-form-control-hidden u-label">Nombre</label>
                  <input type="text" placeholder="Introduzca su nombre" id="name" name="name" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-email u-form-group">
                  <label for="email" class="u-form-control-hidden u-label u-text-palette-4-base">Email</label>
                  <input type="email" placeholder="Introduce tu correo electrónico" id="email" name="email" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-address u-form-group u-form-group-3">
                  <label for="password" class="u-form-control-hidden u-label u-text-palette-4-base">Contraseña</label>
                  <input type="password" placeholder="Introduce tu contraseña" id="password" name="password" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-agree u-form-group u-form-group-5">
                  <input type="checkbox" id="agree-66b6" name="agree" class="u-agree-checkbox">
                  <label for="agree-66b6" class="u-agree-label u-label">Acepto los 
                    <a href="#">términos del servicio</a>
                  </label>
                </div>
							<div class="u-align-center u-form-group u-form-submit">
								<button type="submit"
									class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Registrarse</button>
							</div>
               
                <input type="hidden" value="" name="recaptchaResponse">
              </form>
            </div>
            <a href="Login.jsp" class="u-active-none u-border-2 u-border-palette-1-base u-btn u-btn-rectangle u-button-style u-hover-none u-none u-btn-2">¿Ya eres miembro?
              <br>¡Haz click aquí!
            </a>
          </div>
        </div>
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
