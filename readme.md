Le projet est en JPA 
Les end points en sont pas fonctionnnels 
j'ai commencé a implémenter security mais en commentaire puisque non fonctionnnel

Correction :
j'ai corrigé du one to many dans le choix et rajouté un manytoone dans la classe question 

j'ai ajouté la dépendance jsp dans le pom.xml sans celle ci certains endpoints n'était pas accessible

j'ai ajouté spring security , j'avais confondu hasAuthority et hasRole donc tous les end points étaient en erreur 403

j'ai corrigé les jsp avec la complétion automatique que je n'avais pas sur la version community intellij à l'université

j'ai rajouté des valeurs dans le import sql pour qu'une question sois activer au démarrage

Les post étaient bloqué avec security j'ai du rajouté csrf desactivate

j'ai rajouter une méthode find active dans le question repository qui me retourne la question active

Proposition : 
En étant alternants j'ai trouvé que le CTP n'était pas facile car nous n'avons pas eu 
de projet qui regroupé tous ce que l'on avais fais depuis des mois. certains point était donc très anciens 
pour s'en souvenir clairement un tp qui regroupe l'intégralité des connaissances avant le ctp aurait pu être utile.
Cependant les cours étaient très interessant et claire =)  
