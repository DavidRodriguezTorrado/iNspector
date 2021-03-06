<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Hacer Inspeccion</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Buscador-Autoridad.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.jsp"
}</script>
    <meta property="og:title" content="Buscador Autoridad">
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
    <section class="u-clearfix u-image u-shading u-section-1" id="sec-227a" data-image-width="150" data-image-height="99">
            <form action="FormHacerInspeccion">
    
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-heading-font u-text u-text-body-alt-color u-text-default u-title u-text-1">${inspeccion.getRotulo()}</h1>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-2">Direcci�n</h5> 
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2">
                  <h5 class="u-text u-text-body-alt-color u-text-3">${inspeccion.getDireccion()}</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-2">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-3">
                <div class="u-container-layout u-valign-middle u-container-layout-3">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-4">Actividad</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-4">
                <div class="u-container-layout u-valign-middle u-container-layout-4">
                  <h5 class="u-text u-text-body-alt-color u-text-5">${inspeccion.getActividad()}</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-3">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-5">
                <div class="u-container-layout u-valign-bottom u-container-layout-5">
                  <h5 class="u-align-center u-text u-text-body-alt-color u-text-default u-text-6">Fecha �ltima inspecci�n</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-6">
                <div class="u-container-layout u-valign-middle u-container-layout-6">
                  <h5 class="u-text u-text-body-alt-color u-text-7">${inspeccion.getFecha()}</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-4">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-7">
                <div class="u-container-layout u-valign-middle u-container-layout-7">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-8">Tipo de actuaci�n</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-8">
                <div class="u-container-layout u-valign-middle u-container-layout-8">
                  <h5 class="u-text u-text-body-alt-color u-text-9">${inspeccion.getTipo_actuacion()}</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-5">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-9">
                <div class="u-container-layout u-valign-middle u-container-layout-9">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-10">Perfil de actividad</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-10">
                <div class="u-container-layout u-valign-middle u-container-layout-10">
                  <input name="perfilActividad" id="perfilActividad" placeholder="Escriba la frecuencia de inspeccion" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="" >
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-6">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-11">
                <div class="u-container-layout u-valign-middle u-container-layout-11">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-12">Estado higi�nico sanitario</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-12">
                <div class="u-container-layout u-valign-middle u-container-layout-12">
                    <input name="estado" id="estado" placeholder="Escriba el estado higienico sanitario" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="" >
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-7">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-left-cell u-opacity u-opacity-50 u-size-16 u-layout-cell-13">
                <div class="u-container-layout u-valign-middle u-container-layout-13">
                  <h5 class="u-text u-text-body-alt-color u-text-default u-text-14">Frecuencia de la inspecci�n</h5>
                </div>
              </div>
              <div class="u-align-center u-container-style u-grey-75 u-layout-cell u-opacity u-opacity-50 u-right-cell u-size-44 u-layout-cell-14">
                <div class="u-container-layout u-valign-middle u-container-layout-14">
               <input name="F_inspeccion" id="F_inspeccion" placeholder="Escriba la frecuencia de inspeccion" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="" >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
       <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Enviar </button>
          <br>
          </form>
    </section>
        
    <section>


        
     
        
    
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
