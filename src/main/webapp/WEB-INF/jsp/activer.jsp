<form>
    <% questions1 = req.getAttribute("questions")
        for(Question questions2 : questions1 )
        {%>
            <input type="radio" value=<%= questions2 %>>
        <%}%>
    <button type="submit">Envoyer</button>
</form>