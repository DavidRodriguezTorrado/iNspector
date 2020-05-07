<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="ISO-8859-1">
    <meta name="keywords" content="iNspector">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Login</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Login.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <meta property="og:title" content="Login">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.jsp">
    <meta property="og:url" content="index.jsp">
  </head>
  <body class="u-body u-overlap"><header class="u-clearfix u-header u-palette-4-base u-sticky u-header" id="sec-2a1f"><div class="u-clearfix u-sheet u-sheet-1">
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
           String reg =(String)request.getSession().getAttribute("Registrado");%>
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
		 <% if(reg=="inspector" || reg=="inspector_noautorizado"){ %>
            <ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Logout.jsp" style="padding: 10px;">Logout</a>
</li></ul>
	
		<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Conf-Inspector.jsp" style="padding: 10px;">Perfil</a>
		</li></ul>
		<% } %>
          </div>
          		 <% if(reg=="admin"){ %>
            <ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Logout.jsp" style="padding: 10px;">Logout</a>
</li></ul>
	
		<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Conf-Administrador.jsp" style="padding: 10px;">Perfil</a>
		</li></ul>
		<% } %>
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
    <section class="u-clearfix u-image u-shading u-section-1" src="" id="sec-87d6">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-container-style u-align-left u-group u-opacity u-opacity-70 u-white u-group-1">
          <div class="u-container-layout u-container-layout-1">
            <h3 class="u-align-center u-text u-text-palette-4-base u-text-1"> <br>Bienvenido</h3>
            <p class="u-align-center u-text u-text-default u-text-grey-75 u-text-2">Navegar identificado te permite disfrutar de ventajas únicas para nuestros usuarios.</p>
            <div class="u-form u-form-1">
              <form action="ServletLogin">
                <div class="u-form-group u-form-name">
                  <label for="username" class="u-form-control-hidden u-label">Nombre</label>
                  <input type="text" placeholder="Introduce tu correo" name="email" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-address u-form-group u-form-group-2">
                  <label for="password" class="u-form-control-hidden u-label">Contraseña</label>
                  <input type="password" placeholder="Introduce tu contraseña" id="password" name="password" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                     
                <div class="u-align-center u-form-group u-form-submit">
                  <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Acceder</button>
                </div>
                
                <input type="hidden" value="" name="recaptchaResponse">
              </form>
            </div>
            <a href="Registrarse.jsp" class="u-active-none u-border-2 u-border-palette-1-base u-btn u-btn-rectangle u-button-style u-hover-none u-none u-btn-2">¿Aún no eres miembro?
              <br>¡Haz click aquí para registrarte!
            </a>
             <a href="RegistrarseInspector.jsp" class="u-active-none u-border-2 u-border-palette-1-base u-btn u-btn-rectangle u-button-style u-hover-none u-none u-btn-2">¿Eres un nuevo inspector?
              <br>¡Haz click aquí para registrarte!
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

