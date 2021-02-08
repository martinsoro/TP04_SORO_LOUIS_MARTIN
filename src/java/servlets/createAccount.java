/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import comptebancaires.gestionnaires.GestionCompteBancaire;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comptebancaire.modeles.CompteBancaire;
import java.io.PrintWriter;
//import static comptebancaire.modeles.CompteBancaire_.balance;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author louis-martin
 */
public class createAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pratique pour décider de l'action à faire
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        out.println("action : "+action);
        String forwardTo = "";
        String message = "";
         if (action.equals("creerCompte")) {
             
             String nom = request.getParameter("firstName");
             out.println("nom : "+nom);
             String lastName = request.getParameter("lastName");
             String accountNumber = request.getParameter("accountNumber");
             double balance = Double.valueOf(request.getParameter("balance")) ;
             
              //CompteBancaire liste = GestionCompteBancaire.creeCompte(nom, lastName, accountNumber , balance);
             
              //liste = GestionCompteBancaire.creeCompte(nom, lastName, accountNumber , balance);
              GestionCompteBancaire gestionCompteBancaire = new GestionCompteBancaire();
              CompteBancaire liste = gestionCompteBancaire.creeCompte(nom, lastName, accountNumber, balance);

                request.setAttribute("listeDesComptes", liste);
                forwardTo = "index.jsp?action=listerCompte";
                message = "Liste des comptes";
            
         }
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);

                
        // Après un forward, plus rien ne peut être exécuté après !
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

             /*   PrintWriter out = response.getWriter();
                String action = request.getParameter("action");
                out.println("action : "+action);
                String forwardTo = "";
                String message = "";
         if (action.equals("creerCompte")) {
             
             String nom = request.getParameter("nom");
             String lastName = request.getParameter("prenom");
             String accountNumber = request.getParameter("numcompte");
             double balance = Double.valueOf(request.getParameter("balance")) ;
             
              //CompteBancaire liste = GestionCompteBancaire.creeCompte(nom, lastName, accountNumber , balance);
             
             out.println("nom : "+nom);
             out.println("lastName : "+lastName);
             out.println("accountNumber : "+accountNumber);
             out.println("balance : "+balance);

              //liste = GestionCompteBancaire.creeCompte(nom, lastName, accountNumber , balance);
              GestionCompteBancaire gestionCompteBancaire = new GestionCompteBancaire();
              CompteBancaire liste = gestionCompteBancaire.creeCompte(nom, lastName, accountNumber, balance);
                request.setAttribute("listeDesComptes", liste);
                forwardTo = "index.jsp?action=listerCompte";
                message = "Liste des comptes";*/
             processRequest(request, response);
         }
       // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static class gestionCompteBancaire {

        private static Collection<CompteBancaire> creeCompte(HttpServletRequest request) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public gestionCompteBancaire() {
        }
    }
*/

