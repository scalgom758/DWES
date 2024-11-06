package com.app.Ejercicio3.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controlador")
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "home";
        }

        switch (action) {
            case "mostrarEmpleados":
                mostrarEmpleados(request, response);
                break;
            case "buscarSalario":
                mostrarEmpleados(request, response);
                break;
            case "buscarEmpleado":
                mostrarEmpleados(request, response);
                break;
        }
    }

    private void mostrarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/mostrarEmpleadosServlet").forward(request, response);
    }

    private void buscarSalario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/buscarSalarioServlet").forward(request, response);
    }
    
    private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buscarEmpleadoServlet").forward(request, response);
    }
}
