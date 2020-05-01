<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Conf Usuario</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Conf-Usuario.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700|Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">

    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.jsp"
}</script>
    <meta property="og:title" content="Conf Usuario">
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
         
         <%  String reg =(String)request.getSession().getAttribute("Registrado");%>
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
          <form action="Buscador" method="POST">
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
    <section class="u-align-center u-clearfix u-section-1" id="sec-be1a">
      <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
        <div class="u-layout">
          <div class="u-layout-col">
            <div class="u-container-style u-gradient u-layout-cell u-left-cell u-right-cell u-size-30 u-layout-cell-1">
              <div class="u-container-layout u-container-layout-1"></div>
            </div>
            <div class="u-align-center-md u-container-style u-layout-cell u-left-cell u-right-cell u-size-30 u-layout-cell-2">
              <div class="u-container-layout u-container-layout-2">
                <div alt="" class="u-align-left u-image u-image-circle u-image-1" data-image-width="640" data-image-height="640"></div>
      
             <%
		String username3 =(String)request.getSession().getAttribute("Usuario");
        String name3= (String)request.getSession().getAttribute("Nombre");
        String mail3= (String)request.getSession().getAttribute("Mail");
        String password3= (String)request.getSession().getAttribute("Password");
        %>

                <h2 class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-palette-4-base u-text-1">Bienvenido/a de nuevo <%=name3 %> </h2>
                <p class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-text u-text-2">Esta es tu página de perfil, donde toda tu información está a salvo.
                  <br>No será visible para ningún otro usuario.
                  <br>Abajo encontrarás una lista de tus restaurantes favoritos, así como los últimos vistos y las últimas incidencias que has añadido.
                  <br>Además podrás configurar tu perfil.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <h1 class="u-text u-text-palette-4-base u-text-3" data-animation-name="fadeIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Tus restaurantes favoritos</h1>
    </section>
    <section class="u-align-center u-clearfix u-image u-shading u-section-2" src="" id="carousel_8722">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-expanded-width u-gutter-30 u-layout-wrap u-layout-wrap-1">
          <div class="u-gutter-0 u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-layout-cell u-left-cell u-size-20 u-size-20-md u-layout-cell-1">
                <div class="u-border-4 u-border-palette-4-base u-container-layout u-container-layout-1">
                  <span class="u-icon u-icon-circle u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 -1 511.99871 511" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-f8af"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -1 511.99871 511" id="svg-f8af" class="u-svg-content"><path d="m380.589844 204.039062 30.082031-1.90625c.050781-.003906.105469-.007812.160156-.011718 21.4375-1.808594 40.679688-13.039063 52.796875-30.820313l23.78125-34.890625c20.699219-30.375 28.71875-67.0625 22.574219-103.300781-1.207031-7.117187-4.847656-13.675781-10.246094-18.460937-5.402343-4.789063-12.347656-7.617188-19.558593-7.960938-36.726563-1.757812-72.175782 10.605469-99.847657 34.796875l-31.789062 27.792969c-16.199219 14.160156-25.042969 34.609375-24.269531 56.113281.003906.050781.003906.105469.007812.160156l1.714844 30.089844c.667968 11.730469-3.632813 23.304687-11.777344 31.734375l-248.351562 255.132812c-6.648438 6.933594-10.082032 16.445313-9.664063 26.785157.460937 11.382812 5.683594 22.5625 13.972656 29.910156 7.488281 6.636719 17.78125 10.417969 28.070313 10.417969 1.101562 0 2.203125-.042969 3.300781-.132813 10.316406-.824219 19.351563-5.371093 25.46875-12.847656l223.464844-277.085937c7.410156-9.117188 18.386719-14.773438 30.109375-15.515626zm-42.039063 5.859376-223.445312 277.0625c-3.414063 4.171874-8.664063 6.742187-14.78125 7.230468-7.277344.582032-14.738281-1.839844-19.964844-6.472656-5.226563-4.636719-8.523437-11.753906-8.816406-19.046875-.25-6.128906 1.667969-11.648437 5.363281-15.5l248.332031-255.113281c11.132813-11.519532 16.992188-27.296875 16.085938-43.289063l-1.714844-30.011719c-.582031-16.832031 6.351563-32.835937 19.035156-43.925781l31.789063-27.792969c24.671875-21.566406 56.289062-32.578124 89.015625-31.023437 3.726562.179687 7.3125 1.640625 10.105469 4.117187 2.792968 2.472657 4.671874 5.863282 5.296874 9.539063 5.476563 32.308594-1.671874 65.011719-20.125 92.089844l-23.78125 34.894531c-9.488281 13.921875-24.546874 22.722656-41.328124 24.164062l-30 1.898438c-15.984376 1.015625-30.945313 8.726562-41.066407 21.179688zm0 0"></path><path d="m497.820312 440.570312-166.519531-151.667968c-3.132812-2.855469-7.984375-2.628906-10.84375.503906-2.851562 3.132812-2.625 7.988281.507813 10.84375l166.476562 151.632812c3.960938 3.660157 6.207032 9.054688 6.328125 15.1875.144531 7.296876-2.71875 14.597657-7.660156 19.539063-4.9375 4.9375-12.226563 7.808594-19.539063 7.660156-6.132812-.121093-11.527343-2.367187-15.148437-6.285156l-148.382813-162.90625c-2.855468-3.136719-7.710937-3.359375-10.84375-.507813-3.132812 2.855469-3.359374 7.710938-.503906 10.84375l148.417969 162.945313c6.523437 7.054687 15.8125 11.054687 26.160156 11.257813.269531.003906.535157.007812.804688.007812 11.121093 0 22.242187-4.511719 29.886719-12.160156 7.835937-7.835938 12.378906-19.308594 12.152343-30.695313-.203125-10.347656-4.199219-19.636719-11.292969-26.199219zm0 0"></path><path d="m92.609375 202.585938c12.703125 11.703124 29.207031 18.375 46.472656 18.789062.054688.003906.109375.003906.160157.003906l30.140624.09375c11.75.035156 23.042969 5.023438 30.96875 13.660156l13.277344 14.574219c1.515625 1.664063 3.589844 2.507813 5.675782 2.507813 1.84375 0 3.695312-.660156 5.164062-2 3.136719-2.855469 3.363281-7.710938.507812-10.84375l-13.296874-14.59375c-10.828126-11.804688-26.226563-18.601563-42.246094-18.65625l-30.058594-.09375c-13.355469-.339844-26.125-5.453125-36.019531-14.410156l-87.347657-103.835938c-.890624-1.0625-.824218-2.601562.15625-3.582031.671876-.675781 1.460938-.773438 1.871094-.773438s1.199219.097657 1.875.773438l79.507813 79.511719c7.859375 7.859374 20.648437 7.859374 28.507812-.003907l9.34375-9.339843v-.003907l16.589844-16.589843s.003906 0 .003906-.003907c0 0 .003907-.003906.003907-.003906l9.339843-9.339844c7.859375-7.859375 7.859375-20.648437 0-28.507812l-79.507812-79.507813c-1.03125-1.03125-1.03125-2.714844 0-3.746094.980469-.980468 2.519531-1.046874 3.582031-.15625l103.835938 87.351563c8.960937 9.890625 14.074218 22.664063 14.414062 36.015625l.089844 30.0625c.054687 16.015625 6.855468 31.414062 18.675781 42.265625l14.226563 12.957031c3.136718 2.855469 7.988281 2.628906 10.84375-.503906 2.851562-3.136719 2.625-7.988281-.507813-10.84375l-14.203125-12.9375c-8.660156-7.945312-13.644531-19.242188-13.683594-30.988281l-.09375-30.140625c0-.054688 0-.109375-.003906-.164063-.414062-17.265625-7.085938-33.769531-18.789062-46.472656-.21875-.238281-.453126-.464844-.703126-.675781l-104.222656-87.671875c-7.203125-6.0625-17.65625-5.609375-24.3125 1.046875-7.019531 7.019531-7.019531 18.4375 0 25.453125l79.507813 79.511719c1.875 1.875 1.875 4.925781 0 6.800781l-3.917969 3.914062-88.613281-88.609375c-2.996094-3-7.855469-3-10.851563 0-2.996094 2.996094-2.996094 7.855469 0 10.851563l88.613282 88.613281-5.742188 5.738281-88.613281-88.609375c-2.996094-2.996094-7.855469-2.996094-10.851563 0-3 2.996094-3 7.855469 0 10.851563l88.609375 88.613281-3.914062 3.917969c-1.875 1.875-4.925781 1.875-6.800781 0l-79.511719-79.507813c-3.398438-3.398437-7.917969-5.273437-12.726563-5.273437s-9.328125 1.875-12.726562 5.273437c-6.65625 6.65625-7.105469 17.109375-1.046875 24.316406l87.675781 104.21875c.207031.25.433594.484376.671875.703126zm0 0"></path></svg>
                  </span>
                  <h3 class="u-align-center u-custom-font u-font-oswald u-text u-text-palette-4-base u-text-1">FAVORITO 1</h3>
                  <p class="u-align-center u-text u-text-font u-text-white u-text-2">Comería aquí todos los días si pudiera...</p>
                  <span class="u-icon u-icon-circle u-text-white u-icon-2" data-href="#">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 61.168 61.168" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-0f1a"></use></svg>
                    <svg version="1.1" id="svg-0f1a" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 61.168 61.168" style="enable-background:new 0 0 61.168 61.168;" xml:space="preserve" class="u-svg-content"><g><path d="M30.938,26.584c3.859,0,7-3.141,7-7s-3.141-7-7-7s-7,3.141-7,7S27.078,26.584,30.938,26.584z M30.938,14.584
		c2.757,0,5,2.243,5,5s-2.243,5-5,5s-5-2.243-5-5S28.181,14.584,30.938,14.584z"></path><path d="M50.216,37.584h-7.161l3.047-4.4c5.755-7.671,4.922-20.28-1.781-26.982c-3.621-3.622-8.437-5.617-13.56-5.617
		c-5.122,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952l3.068,4.431h-7.513L0,60.584h61.168L50.216,37.584z
		 M17.02,31.984c-5.199-6.933-4.454-18.32,1.596-24.369c3.244-3.244,7.558-5.031,12.146-5.031s8.901,1.787,12.146,5.031
		c6.05,6.049,6.795,17.437,1.573,24.399L30.761,51.827l-9.863-14.243h0L17.02,31.984z M12.216,39.584h7.634l10.911,15.757
		l10.91-15.757h7.281l9.048,19H3.168L12.216,39.584z"></path>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
              <div class="u-container-style u-layout-cell u-size-20 u-size-20-md u-layout-cell-2">
                <div class="u-border-4 u-border-palette-4-base u-container-layout u-container-layout-2">
                  <span class="u-icon u-icon-circle u-icon-3">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 -21 512 512" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-39c0"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -21 512 512" id="svg-39c0" class="u-svg-content"><path d="m490.152344 240.304688h-17.773438c-1.664062-27.023438-8.246094-53.105469-19.636718-77.625-1.738282-3.753907-6.191407-5.378907-9.945313-3.640626-3.753906 1.742188-5.382813 6.195313-3.640625 9.949219 10.464844 22.535157 16.570312 46.492188 18.210938 71.316407h-343.070313c-4.136719 0-7.488281 3.351562-7.488281 7.488281s3.351562 7.488281 7.488281 7.488281h375.855469c3.789062 0 6.867187 3.082031 6.867187 6.871094v9.140625c0 3.789062-3.078125 6.871093-6.867187 6.871093h-468.304688c-3.789062 0-6.867187-3.082031-6.867187-6.871093v-9.140625c0-3.789063 3.078125-6.871094 6.867187-6.871094h57.539063c4.136719 0 7.492187-3.351562 7.492187-7.488281s-3.355468-7.488281-7.492187-7.488281h-24.753907c3.300782-49.753907 24.636719-96.039063 60.597657-131.046876 34.65625-33.734374 79.4375-53.59375 127.296875-56.742187.027344 0 .054687.003906.082031 0 2.039063-.132813 4.054687-.234375 6.046875-.308594.398438-.011719.792969-.03125 1.191406-.042969.710938-.023437 1.417969-.039062 2.117188-.054687 1.34375-.023437 2.6875-.046875 4.035156-.046875 1.789062 0 3.578125.035156 5.363281.082031.527344.015625 1.050781.03125 1.582031.046875 1.375.046875 2.746094.117188 4.117188.191406.726562.039063 1.453125.078126 2.183594.125 61.488281 4.039063 118.058594 36.015626 153.261718 87.289063 2.339844 3.40625 7.003907 4.277344 10.414063 1.933594 3.410156-2.339844 4.277344-7.003907 1.933594-10.414063-34.640625-50.457031-88.558594-83.503906-148.152344-92.027344 3.734375-5.796874 5.832031-12.621093 5.832031-19.769531 0-4.070312-1.816406-11.574219-13.980468-16.050781-6.074219-2.234375-14.085938-3.46875-22.554688-3.46875-8.472656 0-16.484375 1.234375-22.558594 3.46875-12.164062 4.476562-13.976562 11.980469-13.976562 16.050781 0 7.128907 2.089844 13.941407 5.800781 19.726563-45.246094 6.402344-87.210937 26.886718-120.484375 59.277344-38.871094 37.839843-61.835938 87.949218-65.160156 141.777343h-17.773438c-12.046875.003907-21.847656 9.804688-21.847656 21.851563v9.140625c0 12.050781 9.800781 21.851562 21.847656 21.851562h80.683594c-4.027344 2.757813-7.886719 5.851563-11.5 9.285157l-.148438.140624c-.230468.214844-.449218.445313-.648437.691407l-35.558594 43.179687c-4.460937-2.832031-9.742187-3.863281-14.953125-2.863281-5.433594 1.039063-10.132812 4.132813-13.234375 8.710937l-13.984375 20.621094c-6.394531 9.433594-3.925781 22.320313 5.5 28.722656l95.691406 65.007813c3.46875 2.355469 7.476563 3.582031 11.582032 3.582031 1.304687 0 2.621094-.125 3.933594-.375 5.429687-1.039062 10.128906-4.132812 13.230468-8.710937l13.984375-20.621094c6.394531-9.433594 3.929688-22.320313-5.496093-28.722656l-.546876-.371094c6.660157-7.558594 15.539063-12.976563 25.199219-15.210937 20.355469-4.714844 44.308594-1.679688 60.554688 1.011718 20.097656 3.328125 41.207031 2.191406 61.046875-3.289062l27.578125-7.621094c18.371093-5.078125 35.277343-13.628906 50.253906-25.417969.113281-.089843.222656-.179687.332031-.277343l47.347656-41.933594c8.070313-6.175782 9.828126-16.871094 7.042969-25.539063h60.414063c12.046875 0 21.847656-9.800781 21.847656-21.847656v-9.144531c0-12.046875-9.800781-21.847656-21.847656-21.847656zm-234.152344-225.324219c12.613281 0 20.171875 3.121093 21.554688 4.855469-.101563 7.105468-3.695313 13.660156-9.542969 17.589843-1.472657-.078125-2.925781-.140625-4.375-.195312-.488281-.015625-.976563-.039063-1.464844-.050781-2.089844-.0625-4.152344-.09375-6.171875-.09375-1.433594 0-2.894531.019531-4.367188.050781-.710937.011719-1.425781.03125-2.140624.054687-.851563.027344-1.710938.054688-2.570313.089844-.980469.042969-1.960937.085938-2.9375.140625-5.847656-3.929687-9.4375-10.484375-9.539063-17.585937 1.382813-1.734376 8.941407-4.855469 21.554688-4.855469zm53.710938 281.777343c-.558594-1.265624-1.226563-2.46875-1.980469-3.613281h71.839843l-31.0625 20.558594-44.277343 12.808594-1.503907.035156c8.523438-7.105469 11.632813-19.238281 6.984376-29.789063zm-81.21875-3.613281-10.808594 2.253907-8.355469-2.253907zm-84.464844 138.964844-13.980469 20.621094c-.855469 1.265625-2.152344 2.117187-3.652344 2.40625-1.496093.285156-3.019531-.027344-4.28125-.886719l-95.691406-65.007812c-2.601563-1.765626-3.28125-5.320313-1.515625-7.921876l13.984375-20.625c.855469-1.261718 2.148437-2.117187 3.648437-2.402343.363282-.070313.726563-.105469 1.085938-.105469 1.132812 0 2.238281.339844 3.195312.992188l5.167969 3.507812c0 .003906.003907.003906.003907.003906l90.519531 61.492188c2.601562 1.765625 3.28125 5.324218 1.515625 7.925781zm269.476562-125.253906c-.179687.128906-.351562.269531-.519531.417969l-47.398437 41.984374c-13.363282 10.480469-28.441407 18.089844-44.8125 22.613282l-27.578126 7.621094c-17.757812 4.910156-36.640624 5.929687-54.605468 2.953124-17.507813-2.898437-43.429688-6.144531-66.386719-.828124-13.296875 3.078124-25.4375 10.71875-34.269531 21.34375l-70.792969-48.089844 34.359375-41.726563c12.996094-12.269531 29.476562-19.554687 45.257812-20h.304688c4.894531-.082031 10.074219 1.359375 15.554688 2.894531 1.101562.304688 2.199218.613282 3.300781.910157l49.59375 13.378906c1.136719.304687 2.328125.339844 3.480469.097656l64.953124-13.542969c2.945313-.609374 6.039063-.011718 8.488282 1.648438 1.582031 1.074219 2.816406 2.550781 3.570312 4.265625 2.226563 5.050781.128906 10.980469-4.847656 13.542969l-22.160156 11.734375c-3.066406 1.625-4.613282 5.140625-3.742188 8.5.875 3.363281 3.933594 5.652343 7.410156 5.605469l32.871094-.710938c.652344-.015625 1.296875-.113281 1.917969-.292969l46.316406-13.398437c.730469-.210938 1.421875-.53125 2.054688-.949219l46.726562-30.929687c3.921875-2.421876 9.140625-4.414063 11.917969-.316407 2.164062 3.1875 2.214844 8.925781-.964844 11.273438zm0 0"></path></svg>
                  </span>
                  <h3 class="u-align-center u-custom-font u-font-oswald u-text u-text-palette-4-base u-text-3">FAVORITO 2</h3>
                  <p class="u-align-center u-text u-text-font u-text-white u-text-4">Me encanta venir aquí de vez en cuando</p>
                  <span class="u-icon u-icon-circle u-text-white u-icon-4" data-href="#">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 61.168 61.168" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-d8da"></use></svg>
                    <svg version="1.1" id="svg-d8da" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 61.168 61.168" style="enable-background:new 0 0 61.168 61.168;" xml:space="preserve" class="u-svg-content"><g><path d="M30.938,26.584c3.859,0,7-3.141,7-7s-3.141-7-7-7s-7,3.141-7,7S27.078,26.584,30.938,26.584z M30.938,14.584
		c2.757,0,5,2.243,5,5s-2.243,5-5,5s-5-2.243-5-5S28.181,14.584,30.938,14.584z"></path><path d="M50.216,37.584h-7.161l3.047-4.4c5.755-7.671,4.922-20.28-1.781-26.982c-3.621-3.622-8.437-5.617-13.56-5.617
		c-5.122,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952l3.068,4.431h-7.513L0,60.584h61.168L50.216,37.584z
		 M17.02,31.984c-5.199-6.933-4.454-18.32,1.596-24.369c3.244-3.244,7.558-5.031,12.146-5.031s8.901,1.787,12.146,5.031
		c6.05,6.049,6.795,17.437,1.573,24.399L30.761,51.827l-9.863-14.243h0L17.02,31.984z M12.216,39.584h7.634l10.911,15.757
		l10.91-15.757h7.281l9.048,19H3.168L12.216,39.584z"></path>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
              <div class="u-container-style u-layout-cell u-right-cell u-size-20 u-size-20-md u-layout-cell-3">
                <div class="u-border-4 u-border-palette-4-base u-container-layout u-container-layout-3">
                  <span class="u-icon u-icon-circle u-icon-5">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 469.333 469.333" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-4343"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-4343" x="0px" y="0px" viewBox="0 0 469.333 469.333" style="enable-background:new 0 0 469.333 469.333;" xml:space="preserve" class="u-svg-content"><g><g><g><path d="M128,224c0-5.896-4.771-10.667-10.667-10.667c-5.896,0-10.667,4.771-10.667,10.667c0,28.01,30.896,66.469,34.417,70.771     c2.115,2.563,5.177,3.896,8.26,3.896c2.375,0,4.771-0.792,6.76-2.417c4.552-3.74,5.208-10.458,1.479-15.021     C146.146,267.292,128,239.437,128,224z"></path><path d="M352,213.333c-5.896,0-10.667,4.771-10.667,10.667c0,15.385-18.146,43.271-29.583,57.24     c-3.729,4.552-3.063,11.271,1.49,15.01c1.979,1.625,4.375,2.417,6.76,2.417c3.083,0,6.135-1.333,8.25-3.896     c3.521-4.302,34.417-42.76,34.417-70.771C362.667,218.104,357.896,213.333,352,213.333z"></path><path d="M234.667,213.333c-5.896,0-10.667,4.771-10.667,10.667v64c0,5.896,4.771,10.667,10.667,10.667     s10.667-4.771,10.667-10.667v-64C245.333,218.104,240.562,213.333,234.667,213.333z"></path><path d="M352,42.667c-6.464,0-13.219,0.855-20.234,2.158C308.273,17.439,273.496,0,234.667,0s-73.607,17.439-97.099,44.824     c-7.016-1.302-13.771-2.158-20.234-2.158C52.635,42.667,0,95.302,0,160c0,44.333,25,84.635,64.25,104.562L64.042,425.76     c-0.01,11.635,4.51,22.573,12.729,30.802c8.229,8.24,19.156,12.771,30.792,12.771h254.25c24,0,43.521-19.521,43.521-43.521     V264.406c39.104-19.979,64-60.219,64-104.406C469.333,95.302,416.698,42.667,352,42.667z M384,425.813     c0,12.229-9.958,22.188-22.188,22.188h-254.25c-5.927,0-11.5-2.313-15.698-6.51c-4.188-4.198-6.5-9.771-6.49-15.708L85.43,384     H384V425.813z M390.604,247.802c-0.563,0.229-1.094,0.5-1.594,0.823c-1.344,0.833-2.448,1.938-3.271,3.208     c-0.833,1.26-1.396,2.719-1.625,4.281c-0.094,0.594-0.125,1.188-0.115,1.792v104.76H85.457l0.137-104.615     c0.01-0.583-0.021-1.177-0.104-1.75c-0.229-1.615-0.823-3.115-1.688-4.417c-0.813-1.219-1.875-2.281-3.167-3.094     c-0.531-0.333-1.094-0.625-1.677-0.865C43.948,232.615,21.333,198.135,21.333,160c0-52.938,43.063-96,96-96     c2.069,0,4.253,0.25,6.396,0.419c-10.792,18.756-17.063,40.43-17.063,63.581c0,5.896,4.771,10.667,10.667,10.667     c5.896,0,10.667-4.771,10.667-10.667c0-58.813,47.854-106.667,106.667-106.667S341.333,69.187,341.333,128     c0,5.896,4.771,10.667,10.667,10.667c5.896,0,10.667-4.771,10.667-10.667c0-23.151-6.271-44.824-17.063-63.581     C347.747,64.25,349.931,64,352,64c52.938,0,96,43.063,96,96C448,198,425.479,232.437,390.604,247.802z"></path>
</g>
</g>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                  <h3 class="u-align-center u-custom-font u-font-oswald u-text u-text-palette-4-base u-text-5">FAVORITO 3</h3>
                  <p class="u-align-center u-text u-text-font u-text-white u-text-6">Sin duda, un lugar que disfruto</p>
                  <span class="u-icon u-icon-circle u-text-white u-icon-6" data-href="#">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 61.168 61.168" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-dc8e"></use></svg>
                    <svg version="1.1" id="svg-dc8e" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 61.168 61.168" style="enable-background:new 0 0 61.168 61.168;" xml:space="preserve" class="u-svg-content"><g><path d="M30.938,26.584c3.859,0,7-3.141,7-7s-3.141-7-7-7s-7,3.141-7,7S27.078,26.584,30.938,26.584z M30.938,14.584
		c2.757,0,5,2.243,5,5s-2.243,5-5,5s-5-2.243-5-5S28.181,14.584,30.938,14.584z"></path><path d="M50.216,37.584h-7.161l3.047-4.4c5.755-7.671,4.922-20.28-1.781-26.982c-3.621-3.622-8.437-5.617-13.56-5.617
		c-5.122,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952l3.068,4.431h-7.513L0,60.584h61.168L50.216,37.584z
		 M17.02,31.984c-5.199-6.933-4.454-18.32,1.596-24.369c3.244-3.244,7.558-5.031,12.146-5.031s8.901,1.787,12.146,5.031
		c6.05,6.049,6.795,17.437,1.573,24.399L30.761,51.827l-9.863-14.243h0L17.02,31.984z M12.216,39.584h7.634l10.911,15.757
		l10.91-15.757h7.281l9.048,19H3.168L12.216,39.584z"></path>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-left u-clearfix u-section-3" id="sec-a376">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="zoomIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="">Últimas incidencias</h1>
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <span class="u-icon u-icon-circle u-text-palette-4-base u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 216.278 216.278" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-0afb"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-0afb" x="0px" y="0px" viewBox="0 0 216.278 216.278" style="enable-background:new 0 0 216.278 216.278;" xml:space="preserve" class="u-svg-content"><path d="M190.627,25.646C174.089,9.108,152.1,0,128.711,0c-23.389,0-45.377,9.108-61.915,25.646  C50.257,42.185,41.148,64.174,41.148,87.563c0,17.817,5.299,34.813,15.128,49.214L4.804,188.248c-6.4,6.402-6.4,16.818,0.001,23.221  c3.101,3.102,7.225,4.81,11.61,4.81s8.51-1.708,11.61-4.81l51.471-51.471c14.401,9.829,31.397,15.128,49.213,15.128  c23.39,0,45.378-9.108,61.916-25.647c16.539-16.538,25.647-38.526,25.647-61.916C216.274,64.174,207.166,42.185,190.627,25.646z   M183.556,142.408c-14.649,14.649-34.127,22.718-54.846,22.718c-20.718,0-40.195-8.068-54.845-22.718s-22.718-34.127-22.718-54.846  c0-20.718,8.068-40.195,22.718-54.846C88.515,18.067,107.993,10,128.711,10c20.719,0,40.196,8.067,54.846,22.717  c14.649,14.65,22.718,34.128,22.718,54.846C206.274,108.281,198.206,127.759,183.556,142.408z M133.712,27.983c0,2.762-2.238,5-5,5  c-30.096,0-54.58,24.484-54.58,54.579c0,2.762-2.238,5-5,5s-5-2.238-5-5c0-35.609,28.971-64.579,64.58-64.579  C131.473,22.983,133.712,25.222,133.712,27.983z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-2">Incidencia 1</h3>
                  <a href="#" class="u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                  <p class="u-text u-text-3">Nombre del local</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-left u-clearfix u-section-4" id="sec-7321">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <span class="u-icon u-icon-circle u-text-palette-4-base u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 216.278 216.278" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-0afb"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-0afb" x="0px" y="0px" viewBox="0 0 216.278 216.278" style="enable-background:new 0 0 216.278 216.278;" xml:space="preserve" class="u-svg-content"><path d="M190.627,25.646C174.089,9.108,152.1,0,128.711,0c-23.389,0-45.377,9.108-61.915,25.646  C50.257,42.185,41.148,64.174,41.148,87.563c0,17.817,5.299,34.813,15.128,49.214L4.804,188.248c-6.4,6.402-6.4,16.818,0.001,23.221  c3.101,3.102,7.225,4.81,11.61,4.81s8.51-1.708,11.61-4.81l51.471-51.471c14.401,9.829,31.397,15.128,49.213,15.128  c23.39,0,45.378-9.108,61.916-25.647c16.539-16.538,25.647-38.526,25.647-61.916C216.274,64.174,207.166,42.185,190.627,25.646z   M183.556,142.408c-14.649,14.649-34.127,22.718-54.846,22.718c-20.718,0-40.195-8.068-54.845-22.718s-22.718-34.127-22.718-54.846  c0-20.718,8.068-40.195,22.718-54.846C88.515,18.067,107.993,10,128.711,10c20.719,0,40.196,8.067,54.846,22.717  c14.649,14.65,22.718,34.128,22.718,54.846C206.274,108.281,198.206,127.759,183.556,142.408z M133.712,27.983c0,2.762-2.238,5-5,5  c-30.096,0-54.58,24.484-54.58,54.579c0,2.762-2.238,5-5,5s-5-2.238-5-5c0-35.609,28.971-64.579,64.58-64.579  C131.473,22.983,133.712,25.222,133.712,27.983z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-1">Incidencia 2</h3>
                  <a href="#" class="u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                  <p class="u-text u-text-2">Nombre del local</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-left u-clearfix u-section-5" id="sec-9914">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-expand-resize u-layout-cell u-left-cell u-size-13 u-layout-cell-1">
                <div class="u-container-layout u-valign-middle u-container-layout-1" src="">
                  <span class="u-icon u-icon-circle u-text-palette-4-base u-icon-1">
                    <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 216.278 216.278" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-0afb"></use></svg>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-0afb" x="0px" y="0px" viewBox="0 0 216.278 216.278" style="enable-background:new 0 0 216.278 216.278;" xml:space="preserve" class="u-svg-content"><path d="M190.627,25.646C174.089,9.108,152.1,0,128.711,0c-23.389,0-45.377,9.108-61.915,25.646  C50.257,42.185,41.148,64.174,41.148,87.563c0,17.817,5.299,34.813,15.128,49.214L4.804,188.248c-6.4,6.402-6.4,16.818,0.001,23.221  c3.101,3.102,7.225,4.81,11.61,4.81s8.51-1.708,11.61-4.81l51.471-51.471c14.401,9.829,31.397,15.128,49.213,15.128  c23.39,0,45.378-9.108,61.916-25.647c16.539-16.538,25.647-38.526,25.647-61.916C216.274,64.174,207.166,42.185,190.627,25.646z   M183.556,142.408c-14.649,14.649-34.127,22.718-54.846,22.718c-20.718,0-40.195-8.068-54.845-22.718s-22.718-34.127-22.718-54.846  c0-20.718,8.068-40.195,22.718-54.846C88.515,18.067,107.993,10,128.711,10c20.719,0,40.196,8.067,54.846,22.717  c14.649,14.65,22.718,34.128,22.718,54.846C206.274,108.281,198.206,127.759,183.556,142.408z M133.712,27.983c0,2.762-2.238,5-5,5  c-30.096,0-54.58,24.484-54.58,54.579c0,2.762-2.238,5-5,5s-5-2.238-5-5c0-35.609,28.971-64.579,64.58-64.579  C131.473,22.983,133.712,25.222,133.712,27.983z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                  </span>
                </div>
              </div>
              <div class="u-align-left u-container-style u-layout-cell u-right-cell u-size-47 u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2" data-image-width="2000" data-image-height="1333">
                  <h3 class="u-text u-text-1">Incidencia 3</h3>
                  <a href="#" class="u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
                  <p class="u-text u-text-2">Nombre del local</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-border-2 u-border-white u-clearfix u-image u-shading u-section-6" id="sec-6208" data-image-width="1600" data-image-height="1067">
      <div class="u-clearfix u-sheet u-sheet-1">
       
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="slideIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="Down">Últimos locales vistos</h1>
        <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-size-60">
                <div class="u-layout-col">
                  <div class="u-container-style u-layout-cell u-right-cell u-size-20 u-layout-cell-1" data-href="#">
                    <div class="u-container-layout u-valign-bottom u-container-layout-1">
                      <%if(request.getSession().getAttribute("ult1")==null){
                    	 request.getSession().setAttribute("ult1", "");
                      }
                      if(request.getSession().getAttribute("ult2")==null){
                     	 request.getSession().setAttribute("ult2", "");
                       }
                      if(request.getSession().getAttribute("ult3")==null){
                      	 request.getSession().setAttribute("ult3", "");
                        }
                      %>
                      <h1 class="u-heading-font u-text u-title u-text-2" data-animation-name="lightSpeedIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction=""><%=request.getSession().getAttribute("ult1")%></h1>

                      
                      <%
                    	String rot= (String)request.getSession().getAttribute("ult1");
                 		request.getSession().setAttribute("rotulo",rot);
                 	%>
                 	<div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">
          <form action="Display" method="POST" >
          <div class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2 ">
             </div>
            <div class="u-align-center u-form-group u-form-submit">
                <a href="#" class="u-align-right u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
              <input type="submit" value="submit" class="u-form-control-hidden">
            </div>
            <input type="hidden" value="" name="recaptchaResponse">
          </form>
        </div>
                    </div>
                  </div>
		<div class="u-container-style u-layout-cell u-right-cell u-size-20 u-layout-cell-1" data-href="#">
                    <div class="u-container-layout u-valign-bottom u-container-layout-1">
                      <h1 class="u-heading-font u-text u-title u-text-2" data-animation-name="lightSpeedIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction=""><%=request.getSession().getAttribute("ult2")%></h1>
                      <%
                    	String rot1= (String)request.getSession().getAttribute("ult1");
                 		request.getSession().setAttribute("rotulo",rot);
                 	%>
                 	<div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">
          <form action="Display" method="POST" >
          <div class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2 ">
             </div>
            <div class="u-align-center u-form-group u-form-submit">
                <a href="#" class="u-align-right u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
              <input type="submit" value="submit" class="u-form-control-hidden">
            </div>
            <input type="hidden" value="" name="recaptchaResponse">
          </form>
        </div>
                    </div>
                  </div>
                  <div class="u-container-style u-layout-cell u-right-cell u-size-20 u-layout-cell-1" data-href="#">
                    <div class="u-container-layout u-valign-bottom u-container-layout-1">
                      <h1 class="u-heading-font u-text u-title u-text-2" data-animation-name="lightSpeedIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction=""><%=request.getSession().getAttribute("ult3")%></h1>
                      <%
                    	String rot2= (String)request.getSession().getAttribute("ult1");
                 		request.getSession().setAttribute("rotulo",rot2);
                 	%>
                 	<div class="u-expanded-width-sm u-expanded-width-xs u-form u-form-1">
          <form action="Display" method="POST" >
          <div class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2 ">
             </div>
            <div class="u-align-center u-form-group u-form-submit">
                <a href="#" class="u-align-right u-border-radius-10 u-btn u-btn-round u-button-style u-palette-4-base u-btn-1">Ver Local</a>
              <input type="submit" value="submit" class="u-form-control-hidden">
            </div>
            <input type="hidden" value="" name="recaptchaResponse">
          </form>
        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      </div>
    </section>
    <section class="u-clearfix u-section-7" id="sec-3d8a">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-palette-4-base u-text-1" data-animation-name="slideIn" data-animation-duration="1000" data-animation-delay="0" data-animation-direction="Down">Configuración</h1>
        <span class="u-icon u-icon-circle u-text-palette-4-base u-icon-1">
          <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 29.643 29.643" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-76e0"></use></svg>
          <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-76e0" x="0px" y="0px" viewBox="0 0 29.643 29.643" style="enable-background:new 0 0 29.643 29.643;" xml:space="preserve" class="u-svg-content"><g><path d="M18.621,12.397l-0.546-1.295c0,0,1.267-2.859,1.157-2.969l-1.678-1.639c-0.117-0.113-2.978,1.191-2.978,1.191l-1.32-0.533   c0,0-1.169-2.898-1.327-2.898h-2.37c-0.164,0-1.242,2.906-1.242,2.906L6.998,7.695c0,0-2.922-1.242-3.034-1.135L2.287,8.203   c-0.116,0.115,1.219,2.916,1.219,2.916l-0.544,1.295c0,0-2.962,1.139-2.962,1.295v2.322c0,0.16,2.969,1.217,2.969,1.217   l0.545,1.291c0,0-1.268,2.861-1.157,2.971l1.679,1.641c0.113,0.111,2.976-1.195,2.976-1.195l1.321,0.537   c0,0,1.166,2.896,1.326,2.896h2.37c0.163,0,1.244-2.906,1.244-2.906l1.32-0.535c0,0,2.918,1.242,3.031,1.135l1.678-1.643   c0.115-0.111-1.221-2.914-1.221-2.914l0.546-1.295c0,0,2.963-1.143,2.963-1.299v-2.32C21.591,13.453,18.621,12.397,18.621,12.397z    M10.795,18.207c-1.905,0-3.459-1.52-3.459-3.387c0-1.865,1.554-3.385,3.459-3.385c1.908,0,3.459,1.52,3.459,3.385   C14.254,16.688,12.703,18.207,10.795,18.207z"></path><path d="M28.538,9.693l0.014-0.676c0,0,1.118-1.006,1.091-1.076l-0.414-1.048c-0.031-0.072-1.544-0.062-1.544-0.062l-0.474-0.492   c0,0,0.058-1.502-0.013-1.533l-1.041-0.467c-0.074-0.033-1.117,1.035-1.117,1.035l-0.684-0.027c0,0-1.039-1.119-1.109-1.092   l-1.061,0.393c-0.071,0.025-0.036,1.518-0.036,1.518l-0.495,0.463c0,0-1.523-0.082-1.554-0.014l-0.457,1.02   c-0.032,0.072,1.065,1.119,1.065,1.119l-0.014,0.672c0,0-1.117,1.008-1.09,1.078l0.415,1.049c0.03,0.07,1.543,0.059,1.543,0.059   l0.473,0.494c0,0-0.055,1.502,0.016,1.533l1.041,0.465c0.072,0.033,1.116-1.029,1.116-1.029l0.685,0.023   c0,0,1.037,1.119,1.109,1.094l1.058-0.393c0.073-0.025,0.038-1.52,0.038-1.52l0.494-0.459c0,0,1.523,0.078,1.555,0.01l0.457-1.02   C29.634,10.74,28.538,9.693,28.538,9.693z M26.145,9.9c-0.367,0.82-1.347,1.184-2.187,0.809c-0.836-0.373-1.22-1.346-0.853-2.168   c0.365-0.818,1.348-1.18,2.184-0.807C26.126,8.111,26.51,9.082,26.145,9.9z"></path><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
        </span>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-white u-section-8" id="sec-1be9">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-heading-font u-subtitle u-text u-text-palette-4-base u-text-1"> Mis datos</h2>
        <img src="images/herramienta.png" alt="" class="u-image u-image-default u-image-1" data-image-width="225" data-image-height="225">
        <div class="u-form u-form-1">
      
         <form action="MisDatos" method="POST">
                <div class="u-form-group u-form-name">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Nombre: </p>
                  <label for="name1" class="u-form-control-hidden u-label">Nombre</label>
                  <input type="text" value=<%=name3 %> id="name1" name="name1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                 <div class="u-form-group u-form-name">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Usuario: </p>
                  <label for="username1" class="u-form-control-hidden u-label">Usuario</label>
                  <input type="text" value=<%=username3 %> id="username1" name="username1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div> 
                <div class="u-form-group u-form-name">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Mail: </p>
                  <label for="mail1" class="u-form-control-hidden u-label">Mail</label>
                  <input type="text" value=<%=mail3 %> id="mail1" name="mail1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </div>
                <div class="u-form-address u-form-group u-form-group-2">
                <p class="u-align-center u-large-text u-text u-text-font u-text-variant u-text-2">Contraseña: </p>
                  <label for="password1" class="u-form-control-hidden u-label">Password</label>
                  <input type="password" value=<%=password3%> id="password1" name="password1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" >
                </div>
                <div class="u-align-center u-form-group u-form-submit">
              <a href="BienEditado.jsp" class="u-border-radius-10 u-btn u-btn-round u-btn-submit u-button-style u-palette-4-base u-btn-1">Editar</a>
              <input type="submit" value="submit" class="u-form-control-hidden">
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

