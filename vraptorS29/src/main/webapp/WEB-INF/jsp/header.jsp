<%-- 
    Document   : header
    Created on : 13/03/2017, 14:36:40
    Author     : Ricardo Fonseca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Revenda de carros</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {font-family: "Roboto", sans-serif}
        .w3-sidebar a {padding:16px;font-weight:bold}
    </style>
    <body>

        <%@include file="menu.jsp" %>

        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>
        <div class="w3-main" style="margin-left:200px;">


            <div id="myTop" class="w3-top w3-container w3-padding-16 w3-theme w3-large">
                <i class="fa fa-bars w3-opennav w3-hide-large w3-xlarge w3-margin-left w3-margin-right" onclick="w3_open()"></i>
                <span id="myIntro" class="w3-hide">Revenda de carros</span>
                <a href="usuario/login.jsp" style="padding-left: 75%;">Login - Admin</a>
            </div>

            <header class="w3-container w3-theme w3-padding-64" style="padding-left:32px">
                <h1 class="w3-xxxlarge w3-padding-16">Revenda de carros</h1>
            </header>

            <div class="w3-container w3-padding-32" style="padding-left:32px">