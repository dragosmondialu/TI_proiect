<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset=UTF-8>
		<title>Project</title>
		 <link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body id="body">
	<header>
			<%@ include file= "menu.jsp" %>
	</header>
<h1>Biblioteca Internationala</h1>
<div id="motto" style="font-family: 'Monotype Corsiva';">
					"Biblioteca este templul învăţăturii, iar învăţătura a eliberat mai mulţi oameni decât toate războaiele din istorie." 
					<br/>Carl Thomas Rowan
				</div>	
<div id="sectiune">

<div class="inlinee" id="imagine">
	<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span>
  <span class="dot"></span> 
  <span class="dot"></span>
  <span class="dot"></span>
 </div>
	<div class="slideshow-container" id="continut">
	<div class="mySlides fade">
	  <img src="images/6.jpg" style="width:80%" align="right">
	</div>
	<div class="mySlides fade">
	  <img src="images/8.jpg" style="width:80%" align="right">
	</div>
	<div class="mySlides fade">
	  <img src="images/7.jpg" style="width:80%" align="right">
	</div>

	<br>
	<script>
	var slideIndex = 0;
	showSlides();
	function showSlides() {
	    var i;
	    var slides = document.getElementsByClassName("mySlides");
	    var dots = document.getElementsByClassName("dot");
	    for (i = 0; i < slides.length; i++) {
	       slides[i].style.display = "none";  
	    }
	    slideIndex++;
	    if (slideIndex> slides.length) 
		{slideIndex = 1}    
	    for (i = 0; i < dots.length; i++) {
	        dots[i].className = dots[i].className.replace(" active", "");
	    }
	    slides[slideIndex-1].style.display = "block";  
	    dots[slideIndex-1].className += " active";
	    setTimeout(showSlides, 3000); // Change image every 1 second
	}
	</script>
	</div>
	</div>

<div class="inline"> 
			Biblioteca Internationala este o bibliotecă publică structurată în conformitate cu profilul său enciclopedic şi are menirea de a fi la dispoziţia comunităţii prin serviciile şi programele oferite, venind în întâmpinarea nevoii de informare, educare şi recreere a cetăţenilor.
			<br/>
			<br/>
			În epoca informaţiei, totul se desfăşoară într-un ritm alert. Biblioteca, instituţie prin tradiţie conservatoare, este supusă unei presiuni sociale şi culturale intense, menirea sa ca instituţie de cultură şi educaţie fiind extinsă prin servicii moderne de informare şi consiliere.
			Conform celor mai avizaţi specialişti, biblioteca publică actuală trebuie să îndeplinească următoarele deziderate:
			<ul>
				<li>să pună la dispoziţia cititorilor documente culturale şi de informare actualizate, în formate cât mai variate şi organizate astfel încât accesul la ele să fie accesibil tuturor;</li>
				<li>să dispună de personal calificat;</li>
				<li>să dispună de programe informatizate care să răspundă normelor internaţionale;</li>
				<li>să fie conectată la reţele naţionale şi internaţionale de informare.</li>
			</ul>
	</div>

</div>

 <!--  -->
	</body>
</html>