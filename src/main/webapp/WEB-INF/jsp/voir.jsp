<%@ page import="fr.but3.ctp.Choix" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.but3.ctp.Question" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<img src="https://communitizz.studizz.fr/bm/uploads/school_116/logo_iut_A_Lille.jpg" alt="iut de lille" width="150px">

<% Authentication auth = SecurityContextHolder.getContext().getAuthentication();%>
<p>User authenticate : <%= auth.getName() %> </p>

<% Question question = (Question) request.getAttribute("question"); %>

<h1><%= question.getLibelle() %></h1>

<% List<Choix> listChoix = (List<Choix>) request.getAttribute("choix"); %>
<%for(Choix choix : listChoix) {%>
    <ul>
        <li><%= choix.getLibChoix() %> : <%= choix.getNbChoix() %></li>
    </ul>
<%}%>

<p>Pourcentage de vote correct : <%= question.percentageAnswer() %>%</p>

