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
    <title>Inspector</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Conf-Inspector.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.jsp"
}</script>
    <meta property="og:title" content="Conf Inspector">
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
          String reg =(String)s.getAttribute("Registrado");
          String autorizado = (String) request.getSession().getAttribute("Autorizado");
          System.out.println(autorizado);
           %>
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
          <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-menu-close"></div>
              <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Login.jsp" style="padding: 10px;">Login</a>
</li></ul>
			<ul class="u-nav u-spacing-0 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base u-text-palette-1-base" href="Conf-Usuario.jsp" style="padding: 10px;">Perfil</a>
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
    <section class="u-align-center u-clearfix u-valign-middle u-section-1" id="sec-90d5">
      <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
        <div class="u-layout">
          <div class="u-layout-col">
            <div class="u-container-style u-gradient u-layout-cell u-left-cell u-right-cell u-size-30 u-layout-cell-1">
              <div class="u-container-layout u-container-layout-1"></div>
            </div>
            <div class="u-align-center-md u-container-style u-layout-cell u-left-cell u-right-cell u-size-30 u-layout-cell-2">
              <div class="u-container-layout u-container-layout-2">
                <div alt="" class="u-align-left u-image u-image-circle u-image-1"></div>
							<%
								String name2 = (String) request.getSession().getAttribute("Name");
								String mail2 = (String) request.getSession().getAttribute("Email");
								String password2 = (String) request.getSession().getAttribute("Password");
								
								String incidencia1 = request.getSession().getAttribute("Incidencia1").toString();
								String nameInc1 = request.getSession().getAttribute("IncidenciaLocal1").toString();
								String incidencia2 = request.getSession().getAttribute("Incidencia2").toString();
								String nameInc2 = request.getSession().getAttribute("IncidenciaLocal2").toString();
								String incidencia3 = request.getSession().getAttribute("Incidencia3").toString();
								String nameInc3 = request.getSession().getAttribute("IncidenciaLocal3").toString();
								
								String incidenciaRevisada1 = request.getSession().getAttribute("IncidenciaRevisada1").toString();
								String nameIncRevisada1 = request.getSession().getAttribute("IncidenciaLocalRevisada1").toString();
								String incidenciaRevisada2 = request.getSession().getAttribute("IncidenciaRevisada2").toString();
								String nameIncRevisada2 = request.getSession().getAttribute("IncidenciaLocalRevisada2").toString();
								String incidenciaRevisada3 = request.getSession().getAttribute("IncidenciaRevisada3").toString();
								String nameIncRevisada3 = request.getSession().getAttribute("IncidenciaLocalRevisada3").toString();
								
								
								String inspeccionProgramada1 = request.getSession().getAttribute("InspeccionProgramada1").toString();
								String nameinspeccionProgramada1 = request.getSession().getAttribute("InspeccionProgramadaLocal1").toString();
								String inspeccionProgramada2 = request.getSession().getAttribute("InspeccionProgramada2").toString();
								String nameinspeccionProgramada2 = request.getSession().getAttribute("InspeccionProgramadaLocal2").toString();
								String inspeccionProgramada3 = request.getSession().getAttribute("InspeccionProgramada3").toString();
								String nameinspeccionProgramada3 = request.getSession().getAttribute("InspeccionProgramadaLocal3").toString();
								
								String fecha1 = request.getSession().getAttribute("Fecha1").toString();
								String fecha2 = request.getSession().getAttribute("Fecha2").toString();
								String fecha3 = request.getSession().getAttribute("Fecha3").toString();
								
								
								String fechaHecha1 = request.getSession().getAttribute("FechaHecha1").toString();
								String fechaHecha2 = request.getSession().getAttribute("FechaHecha2").toString();
								String fechaHecha3 = request.getSession().getAttribute("FechaHecha3").toString();
								
							
								String inspeccionHecha1 = request.getSession().getAttribute("InspeccionHecha1").toString();
								String nameinspeccionHecha1 = request.getSession().getAttribute("InspeccionLocalHecha1").toString();
								String inspeccionHecha2 = request.getSession().getAttribute("InspeccionHecha2").toString();
								String nameinspeccionHecha2 = request.getSession().getAttribute("InspeccionLocalHecha2").toString();
								String inspeccionHecha3 = request.getSession().getAttribute("InspeccionHecha3").toString();
								String nameinspeccionHecha3 = request.getSession().getAttribute("InspeccionLocalHecha3").toString();
								
								%>

							<%
								if (autorizado.equals("no")) {
							%>
                        <h2 class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-palette-4-base u-text-1">Bienvenido/a de nuevo <%=name2 %></h2>
                <p class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-2">Para poder ejercer sus labores de inspector debe esperar a ser autorizado
                </p>
                 <%} else { %>
                <h2 class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-palette-4-base u-text-1">Bienvenido/a de nuevo <%=name2 %></h2>
                <p class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-2">Aquí aparecerán las notificaciones de incidencias de los usuarios y
                  <br>las últimas inspecciones realizadas.
                  <br>Además, podrás manejar las incidencias pendientes
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-left u-clearfix u-section-2" id="sec-41bf">
      <div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xs u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Panel de notificaciones</h1>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <div alt="" class="u-align-left u-image u-image-circle u-image-1" data-image-width="640" data-image-height="640"></div>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                 <% if (incidencia1.equals("0")){
     		%><p class="u-text u-text-3">Aquí aparecerán las incidencias que tienes pendientes por revisar</p>
     
     			<%} %>
     			 <% if (!incidencia1.equals("0")){
     %>
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-2"> Incidencia <%=incidencia1 %> </h3>
                  <a href="#" class="u-border-radius-10 u-btn u-form-control-hidden u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                  <p class="u-text u-text-3 u-align-right">
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </p>
                  <p class="u-text u-text-3 u-align-right">
                  
                  <%=nameInc1 %></p>
                </div>
                 <% } %>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
         			 <% if (!incidencia2.equals("0")){
     %>
    <section class="u-align-left u-clearfix u-palette-4-light-3 u-section-3" id="sec-9924">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <div alt="" class="u-align-left u-image u-image-circle u-image-1" data-image-width="640" data-image-height="640"></div>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-1">Incidencia <%=incidencia2 %></h3>
                  <a href="#" class="u-border-radius-10 u-btn u-form-control-hidden u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                   <p class="u-text u-text-3 u-align-right">
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </p>
                  <p class="u-text u-text-2"><%=nameInc2 %></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <% } %>
         			 <% if (!incidencia3.equals("0")){
     %>
    <section class="u-align-left u-clearfix u-section-4" id="sec-364c">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <div alt="" class="u-align-left u-image u-image-circle u-image-1" data-image-width="640" data-image-height="640"></div>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-1">Incidencia <%=incidencia3 %> </h3>
                  <a href="#" class="u-border-radius-10 u-btn  u-form-control-hiddenu-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                   <p class="u-text u-text-3 u-align-right">
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </br>
                  </p>
                  <p class="u-text u-text-2"><%=nameInc3 %></p>
                </div>
              </div>
            </div>
          </div>
          <% } %>
          <form action="FormVerTodasIncidenciasPendientes">
            <div class="u-align-center u-form-group u-form-submit">
                  <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Ver todas</button>
            
            </div>
			</form>
        </div>
      </div>
    </section>
    <section class="u-align-left u-clearfix u-image u-shading u-section-5" id="sec-bfea" data-image-width="150" data-image-height="99">
         <% if (inspeccionProgramada1.equals("0")){
     		%><p class="u-text u-text-3">Inspecciones Pendientes</p>
     
     			<%} %>
     			
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Inspecciones Programadas</h1>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <% if (!inspeccionProgramada1.equals("0")){
     %>
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-1">
                <div class="u-container-layout u-container-layout-1" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-bd85"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-bd85" x="0px" y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" class="u-svg-content"><path style="fill:#3B4145;" d="M322.939,62.642l178.737,309.583C508.231,383.578,512,396.74,512,410.791  c0,42.67-34.592,77.264-77.264,77.264H256L194.189,256L256,23.946C284.62,23.946,309.587,39.519,322.939,62.642z"></path><path style="fill:#525A61;" d="M189.061,62.642L10.323,372.225C3.769,383.578,0,396.74,0,410.791  c0,42.67,34.592,77.264,77.264,77.264H256V23.946C227.38,23.946,202.413,39.519,189.061,62.642z"></path><path style="fill:#FFB751;" d="M474.913,387.678L296.177,78.098c-8.056-13.959-22.849-22.767-38.848-23.22l152.869,402.275h24.539  c25.559,0,46.358-20.798,46.358-46.358C481.095,402.677,478.952,394.683,474.913,387.678z"></path><path style="fill:#FFD764;" d="M444.853,387.678c3.492,7.005,5.336,14.999,5.336,23.117c0,25.559-17.935,46.358-39.992,46.358  H77.264c-25.559,0-46.358-20.799-46.358-46.358c0-8.118,2.143-16.112,6.181-23.117l178.736-309.58  c8.283-14.34,23.674-23.251,40.177-23.251c0.443,0,0.886,0.01,1.329,0.031c13.732,0.536,26.414,9.323,33.326,23.22L444.853,387.678z  "></path><path style="fill:#3B4145;" d="M256,354.131v51.509c14.227,0,25.755-11.528,25.755-25.755  C281.755,365.659,270.227,354.131,256,354.131z"></path><path style="fill:#525A61;" d="M256,354.131c2.843,0,5.151,11.528,5.151,25.755c0,14.227-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.528-25.755-25.755C230.245,365.659,241.773,354.131,256,354.131z"></path><path style="fill:#3B4145;" d="M256,132.646V323.23c14.227,0,25.755-11.538,25.755-25.755V158.401  C281.755,144.174,270.227,132.646,256,132.646z"></path><path style="fill:#525A61;" d="M256,132.646c2.843,0,5.151,11.528,5.151,25.755v139.074c0,14.216-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.538-25.755-25.755V158.401C230.245,144.174,241.773,132.646,256,132.646z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-2">Inspección <%=inspeccionProgramada1 %></h3>
                  <p class="u-text u-text-default u-text-palette-3-base u-text-3">Pendiente</p>
                  <p class="u-text u-text-body-alt-color u-text-4"> <%=nameinspeccionProgramada1 %></p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2">
                  <div class="u-expand-resize u-image u-image-circle u-image-1"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%} %>
        <% if (!inspeccionProgramada2.equals("0")){
     %>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-shape-rectangle u-layout-wrap-2">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-3">
                <div class="u-container-layout u-container-layout-3" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-2">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-03c7"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-03c7" x="0px" y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" class="u-svg-content"><path style="fill:#3B4145;" d="M322.939,62.642l178.737,309.583C508.231,383.578,512,396.74,512,410.791  c0,42.67-34.592,77.264-77.264,77.264H256L194.189,256L256,23.946C284.62,23.946,309.587,39.519,322.939,62.642z"></path><path style="fill:#525A61;" d="M189.061,62.642L10.323,372.225C3.769,383.578,0,396.74,0,410.791  c0,42.67,34.592,77.264,77.264,77.264H256V23.946C227.38,23.946,202.413,39.519,189.061,62.642z"></path><path style="fill:#FFB751;" d="M474.913,387.678L296.177,78.098c-8.056-13.959-22.849-22.767-38.848-23.22l152.869,402.275h24.539  c25.559,0,46.358-20.798,46.358-46.358C481.095,402.677,478.952,394.683,474.913,387.678z"></path><path style="fill:#FFD764;" d="M444.853,387.678c3.492,7.005,5.336,14.999,5.336,23.117c0,25.559-17.935,46.358-39.992,46.358  H77.264c-25.559,0-46.358-20.799-46.358-46.358c0-8.118,2.143-16.112,6.181-23.117l178.736-309.58  c8.283-14.34,23.674-23.251,40.177-23.251c0.443,0,0.886,0.01,1.329,0.031c13.732,0.536,26.414,9.323,33.326,23.22L444.853,387.678z  "></path><path style="fill:#3B4145;" d="M256,354.131v51.509c14.227,0,25.755-11.528,25.755-25.755  C281.755,365.659,270.227,354.131,256,354.131z"></path><path style="fill:#525A61;" d="M256,354.131c2.843,0,5.151,11.528,5.151,25.755c0,14.227-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.528-25.755-25.755C230.245,365.659,241.773,354.131,256,354.131z"></path><path style="fill:#3B4145;" d="M256,132.646V323.23c14.227,0,25.755-11.538,25.755-25.755V158.401  C281.755,144.174,270.227,132.646,256,132.646z"></path><path style="fill:#525A61;" d="M256,132.646c2.843,0,5.151,11.528,5.151,25.755v139.074c0,14.216-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.538-25.755-25.755V158.401C230.245,144.174,241.773,132.646,256,132.646z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-5">Inspección <%=inspeccionProgramada2 %></h3>
                  <p class="u-text u-text-default u-text-palette-3-base u-text-6">Pendiente</p>
                  <p class="u-text u-text-body-alt-color u-text-7"><%=nameinspeccionProgramada2 %></p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-4">
                <div class="u-container-layout u-valign-middle u-container-layout-4">
                  <div class="u-expand-resize u-image u-image-circle u-image-2"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%} %>
              <% if (!inspeccionProgramada3.equals("0")){
     %>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-3">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-5">
                <div class="u-container-layout u-container-layout-5" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-3">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-d7b0"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-d7b0" x="0px" y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" class="u-svg-content"><path style="fill:#3B4145;" d="M322.939,62.642l178.737,309.583C508.231,383.578,512,396.74,512,410.791  c0,42.67-34.592,77.264-77.264,77.264H256L194.189,256L256,23.946C284.62,23.946,309.587,39.519,322.939,62.642z"></path><path style="fill:#525A61;" d="M189.061,62.642L10.323,372.225C3.769,383.578,0,396.74,0,410.791  c0,42.67,34.592,77.264,77.264,77.264H256V23.946C227.38,23.946,202.413,39.519,189.061,62.642z"></path><path style="fill:#FFB751;" d="M474.913,387.678L296.177,78.098c-8.056-13.959-22.849-22.767-38.848-23.22l152.869,402.275h24.539  c25.559,0,46.358-20.798,46.358-46.358C481.095,402.677,478.952,394.683,474.913,387.678z"></path><path style="fill:#FFD764;" d="M444.853,387.678c3.492,7.005,5.336,14.999,5.336,23.117c0,25.559-17.935,46.358-39.992,46.358  H77.264c-25.559,0-46.358-20.799-46.358-46.358c0-8.118,2.143-16.112,6.181-23.117l178.736-309.58  c8.283-14.34,23.674-23.251,40.177-23.251c0.443,0,0.886,0.01,1.329,0.031c13.732,0.536,26.414,9.323,33.326,23.22L444.853,387.678z  "></path><path style="fill:#3B4145;" d="M256,354.131v51.509c14.227,0,25.755-11.528,25.755-25.755  C281.755,365.659,270.227,354.131,256,354.131z"></path><path style="fill:#525A61;" d="M256,354.131c2.843,0,5.151,11.528,5.151,25.755c0,14.227-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.528-25.755-25.755C230.245,365.659,241.773,354.131,256,354.131z"></path><path style="fill:#3B4145;" d="M256,132.646V323.23c14.227,0,25.755-11.538,25.755-25.755V158.401  C281.755,144.174,270.227,132.646,256,132.646z"></path><path style="fill:#525A61;" d="M256,132.646c2.843,0,5.151,11.528,5.151,25.755v139.074c0,14.216-2.308,25.755-5.151,25.755  c-14.227,0-25.755-11.538-25.755-25.755V158.401C230.245,144.174,241.773,132.646,256,132.646z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-8">Inspección <%=inspeccionProgramada3 %></h3>
                  <p class="u-text u-text-default u-text-palette-3-base u-text-9">Pendiente</p>
                  <p class="u-text u-text-body-alt-color u-text-10"><%=nameinspeccionProgramada3 %>l</p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-6">
                <div class="u-container-layout u-valign-middle u-container-layout-6">
                  <div class="u-expand-resize u-image u-image-circle u-image-3"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%} %>
               <form action="FormVerTodasInspeccionesProgramadas">
            <div class="u-align-center u-form-group u-form-submit">
                  <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Ver todas</button>
            
            </div>
			</form>
        <h1 class="u-text u-text-palette-4-base u-text-11">Añadir Inspección</h1>
        <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-4">
          <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-3d93"></use></svg>
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 512 512" id="svg-3d93" class="u-svg-content"><linearGradient id="a" gradientUnits="userSpaceOnUse" x1="256" x2="256" y1="0" y2="512"><stop offset="0" stop-color="#2af598"></stop><stop offset="1" stop-color="#009efd"></stop>
</linearGradient><path d="m437.019531 74.980469c-48.351562-48.351563-112.640625-74.980469-181.019531-74.980469s-132.667969 26.628906-181.019531 74.980469c-48.351563 48.351562-74.980469 112.640625-74.980469 181.019531s26.628906 132.667969 74.980469 181.019531c48.351562 48.351563 112.640625 74.980469 181.019531 74.980469s132.667969-26.628906 181.019531-74.980469c48.351563-48.351562 74.980469-112.640625 74.980469-181.019531s-26.628906-132.667969-74.980469-181.019531zm-181.019531 397.019531c-119.101562 0-216-96.898438-216-216s96.898438-216 216-216 216 96.898438 216 216-96.898438 216-216 216zm20-236.019531h90v40h-90v90h-40v-90h-90v-40h90v-90h40zm0 0" fill="url(#a)"></path></svg>
        </span>
  
    </section>
       <% if (inspeccionHecha1.equals("0")){
     		%><p class="u-text u-text-3">Inspecciones Pendientes</p>
     
     			<%} %>
    <section class="u-align-left u-clearfix u-image u-shading u-section-6" id="sec-fe09" data-image-width="1280" data-image-height="1280">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Últimas inspecciones realizadas</h1>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
                      <% if (!inspeccionHecha1.equals("0")){
     %>
        
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-1">
                <div class="u-container-layout u-container-layout-1" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 367.805 367.805" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-703d"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-703d" x="0px" y="0px" viewBox="0 0 367.805 367.805" style="enable-background:new 0 0 367.805 367.805;" xml:space="preserve" class="u-svg-content"><g><path style="fill:#3BB54A;" d="M183.903,0.001c101.566,0,183.902,82.336,183.902,183.902s-82.336,183.902-183.902,183.902   S0.001,285.469,0.001,183.903l0,0C-0.288,82.625,81.579,0.29,182.856,0.001C183.205,0,183.554,0,183.903,0.001z"></path><polygon style="fill:#D4E1F4;" points="285.78,133.225 155.168,263.837 82.025,191.217 111.805,161.96 155.168,204.801    256.001,103.968  "></polygon>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-2">Inspección <%=inspeccionHecha1 %></h3>
                  <p class="u-text u-text-default u-text-palette-4-base u-text-3">Hecha</p>
                  <p class="u-text u-text-body-alt-color u-text-4"><%=nameinspeccionHecha1 %></p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2">
                  <div class="u-expand-resize u-image u-image-circle u-image-1"></div>
                </div>
              </div>
            </div>
          </div>
          <%} %>
        </div>
        <% if (!inspeccionHecha2.equals("0")){
     %>
        
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-2">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-3">
                <div class="u-container-layout u-container-layout-3" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-2">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 367.805 367.805" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-f0c1"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-f0c1" x="0px" y="0px" viewBox="0 0 367.805 367.805" style="enable-background:new 0 0 367.805 367.805;" xml:space="preserve" class="u-svg-content"><g><path style="fill:#3BB54A;" d="M183.903,0.001c101.566,0,183.902,82.336,183.902,183.902s-82.336,183.902-183.902,183.902   S0.001,285.469,0.001,183.903l0,0C-0.288,82.625,81.579,0.29,182.856,0.001C183.205,0,183.554,0,183.903,0.001z"></path><polygon style="fill:#D4E1F4;" points="285.78,133.225 155.168,263.837 82.025,191.217 111.805,161.96 155.168,204.801    256.001,103.968  "></polygon>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-5">Inspección <%=inspeccionHecha2 %></h3>
                  <p class="u-text u-text-default u-text-palette-4-base u-text-6">Hecha</p>
                  <p class="u-text u-text-body-alt-color u-text-7"><%=nameinspeccionHecha2 %></p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-4">
                <div class="u-container-layout u-valign-middle u-container-layout-4">
                  <div class="u-expand-resize u-image u-image-circle u-image-2"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%} %>
        <% if (!inspeccionHecha3.equals("0")){
     %>
        
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-3">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-right-cell u-size-45 u-layout-cell-5">
                <div class="u-container-layout u-container-layout-5" data-image-width="2000" data-image-height="1333">
                  <span class="u-icon u-icon-circle u-text-palette-1-base u-icon-3">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 367.805 367.805" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-b137"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-b137" x="0px" y="0px" viewBox="0 0 367.805 367.805" style="enable-background:new 0 0 367.805 367.805;" xml:space="preserve" class="u-svg-content"><g><path style="fill:#3BB54A;" d="M183.903,0.001c101.566,0,183.902,82.336,183.902,183.902s-82.336,183.902-183.902,183.902   S0.001,285.469,0.001,183.903l0,0C-0.288,82.625,81.579,0.29,182.856,0.001C183.205,0,183.554,0,183.903,0.001z"></path><polygon style="fill:#D4E1F4;" points="285.78,133.225 155.168,263.837 82.025,191.217 111.805,161.96 155.168,204.801    256.001,103.968  "></polygon>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-text u-text-body-alt-color u-text-8">Inspección <%=inspeccionHecha3 %></h3>
                  <p class="u-text u-text-default u-text-palette-4-base u-text-9">Hecha</p>
                  <p class="u-text u-text-body-alt-color u-text-10"><%=nameinspeccionHecha3 %></p>
                </div>
              </div>
              <div class="u-container-style u-grey-5 u-layout-cell u-opacity u-opacity-30 u-size-15 u-layout-cell-6">
                <div class="u-container-layout u-valign-middle u-container-layout-6">
                  <div class="u-expand-resize u-image u-image-circle u-image-3"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <%} %>
      </div>
    </section>
    <section class="u-clearfix u-section-7" id="sec-13a8">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="slideIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="Down">Configuración</h1>
        <span class="u-icon u-icon-circle u-text-palette-4-base u-icon-1">
          <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 29.643 29.643" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-76e0"></use></svg>
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-76e0" x="0px" y="0px" viewBox="0 0 29.643 29.643" style="enable-background:new 0 0 29.643 29.643;" xml:space="preserve" class="u-svg-content"><g><path d="M18.621,12.397l-0.546-1.295c0,0,1.267-2.859,1.157-2.969l-1.678-1.639c-0.117-0.113-2.978,1.191-2.978,1.191l-1.32-0.533   c0,0-1.169-2.898-1.327-2.898h-2.37c-0.164,0-1.242,2.906-1.242,2.906L6.998,7.695c0,0-2.922-1.242-3.034-1.135L2.287,8.203   c-0.116,0.115,1.219,2.916,1.219,2.916l-0.544,1.295c0,0-2.962,1.139-2.962,1.295v2.322c0,0.16,2.969,1.217,2.969,1.217   l0.545,1.291c0,0-1.268,2.861-1.157,2.971l1.679,1.641c0.113,0.111,2.976-1.195,2.976-1.195l1.321,0.537   c0,0,1.166,2.896,1.326,2.896h2.37c0.163,0,1.244-2.906,1.244-2.906l1.32-0.535c0,0,2.918,1.242,3.031,1.135l1.678-1.643   c0.115-0.111-1.221-2.914-1.221-2.914l0.546-1.295c0,0,2.963-1.143,2.963-1.299v-2.32C21.591,13.453,18.621,12.397,18.621,12.397z    M10.795,18.207c-1.905,0-3.459-1.52-3.459-3.387c0-1.865,1.554-3.385,3.459-3.385c1.908,0,3.459,1.52,3.459,3.385   C14.254,16.688,12.703,18.207,10.795,18.207z"></path><path d="M28.538,9.693l0.014-0.676c0,0,1.118-1.006,1.091-1.076l-0.414-1.048c-0.031-0.072-1.544-0.062-1.544-0.062l-0.474-0.492   c0,0,0.058-1.502-0.013-1.533l-1.041-0.467c-0.074-0.033-1.117,1.035-1.117,1.035l-0.684-0.027c0,0-1.039-1.119-1.109-1.092   l-1.061,0.393c-0.071,0.025-0.036,1.518-0.036,1.518l-0.495,0.463c0,0-1.523-0.082-1.554-0.014l-0.457,1.02   c-0.032,0.072,1.065,1.119,1.065,1.119l-0.014,0.672c0,0-1.117,1.008-1.09,1.078l0.415,1.049c0.03,0.07,1.543,0.059,1.543,0.059   l0.473,0.494c0,0-0.055,1.502,0.016,1.533l1.041,0.465c0.072,0.033,1.116-1.029,1.116-1.029l0.685,0.023   c0,0,1.037,1.119,1.109,1.094l1.058-0.393c0.073-0.025,0.038-1.52,0.038-1.52l0.494-0.459c0,0,1.523,0.078,1.555,0.01l0.457-1.02   C29.634,10.74,28.538,9.693,28.538,9.693z M26.145,9.9c-0.367,0.82-1.347,1.184-2.187,0.809c-0.836-0.373-1.22-1.346-0.853-2.168   c0.365-0.818,1.348-1.18,2.184-0.807C26.126,8.111,26.51,9.082,26.145,9.9z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
        </span>
      </div>
             <form action="FormVerTodasInspeccionesHechas">
            <div class="u-align-center u-form-group u-form-submit">
                  <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Ver todas</button>
            
            </div>
			</form>
    </section>
<%} %>

     <section class="u-align-center u-clearfix u-white u-section-8" id="sec-1be9">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-heading-font u-subtitle u-text u-text-palette-4-base u-text-1"> Mis datos</h2>
        <img src="images/herramienta.png" alt="" class="u-image u-image-default u-image-1" data-image-width="225" data-image-height="225">
        <div class="u-form u-form-1">
      
         <form action="FormEditaInspector">
                <div class="u-form-group u-form-name">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Nombre: </p>
                  <label for="name" class="u-form-control-hidden u-label">Nombre</label>
                  <input type="text" value=<%=name2 %> id="name" name="name" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-group u-form-name">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Mail: </p>
                  <label for="email" class="u-form-control-hidden u-label">Mail</label>
                  <input type="text" value=<%=mail2 %> id="email" name="email" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-address u-form-group u-form-group-2">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Contraseña: </p>
                  <label for="password" class="u-form-control-hidden u-label">Password</label>
                  <input type="password" value=<%=password2%> id="password" name="password" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="" >
                </div>
                <div class="u-align-center u-form-group u-form-submit">
                  <button type="submit" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style">Editar</button>
            </div>
                
                <input type="hidden" value="" name="recaptchaResponse">
              </form>
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

