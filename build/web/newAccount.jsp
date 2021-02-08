<%-- 
    Document   : index
    Created on : 5 févr. 2021, 20:00:00
    Author     : louis-martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creation de compte</title>
    </head>
    <body>
        <center>
        <h1>Création de compte</h1>


        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->
        <c:if test="${!empty param['message']}">
            <h2>Reçu message : ${param.message}</h2>
        </c:if>


        <h2>Menu de gestion des utilisateurs</h2>
       
            <h2>Liste des fonctionnalités à implémenter dans la Servlet (note : après chaque action cette page sera
                rappelée par la servlet avec la liste des utilisateurs raffraichie et un message de confirmation</h2>
       

            <h4>Créer d'un compte</h4>
            <form action="createAccount" method="post">
                Nom : &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="nom" size="100px"/><br><br><br>
                Prénom :  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="prenom" size="100px"/><br><br><br>
                Numéro du compte :  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="numcompte" size="100px"/><br><br><br>
                Balance :  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="balance" size="100px"/><br><br><br>
                <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->
                <input type="hidden" name="action" value="creerCompte"/>
                <input type="submit" value="Créer l'utilisateur" name="submit"/>
            </form>

            <h3><a href="listAccount.jsp">Voir la liste</a></h3>
            </center>
    </body>
</html>