<h1><%= req.getAttribute("intitule") %></h1>

<% for(Choix choix : req.getAttribute("choix")) {%>
    <input type="radio" value=<%= choix %>
<%}%>