<%-- 
    Document   : listAccount
    Created on : 5 févr. 2021, 20:07:36
    Author     : louis-martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
          <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->
        <c:if test="${param['action'] == 'listerCompte'}" >
            <h2>Liste des utilisateurs</h2>

            <table border="10">
                <!-- La ligne de titre du tableau des comptes -->
                <tr>
                    <td><b>Nom</b></td>
                    <td><b>Prénom</b></td>
                    <td><b>Numéro de compte</b></td>
                    <td><b>Balance</b></td>
                </tr>

                <!-- Ici on affiche les lignes, une par utilisateur -->
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->
                <c:set var="total" value="0"/>

                <c:forEach var="u" items="${requestScope['listeDesComptes']}">
                    <tr>
                        
                        <td>${u.firstname}</td>
                        <td>${u.lastname}</td>
                        <td>${u.accountNumber}</td>
                        <td>${u.balance}</td>
                        
                        <!-- On compte le nombre de users -->
                        <c:set var="total" value="${total+1}"/>
                    </tr>
                </c:forEach>

                <!-- Affichage du solde total dans la dernière ligne du tableau -->
                <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>
            </table>

        </c:if>
            </center>
    </body>
</html>
