<%@ page import="fr.but3.ctp.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<img src="https://communitizz.studizz.fr/bm/uploads/school_116/logo_iut_A_Lille.jpg" alt="iut de lille" width="150px">

<% Authentication auth = SecurityContextHolder.getContext().getAuthentication();%>
<p>User authenticate : <%= auth.getName() %> </p>
<form method="post">
    <% List<Question> questions1 = (List<Question>) request.getAttribute("questions");
        for(Question questions2 : questions1 )
        {%>
            <div>
                <input type="radio" name="idQuestion" value=<%= questions2.getQno() %>>
                <label> <%= questions2.getLibelle() %> </label>
            </div>
        <%}%>
    <button type="submit">Envoyer</button>
</form>