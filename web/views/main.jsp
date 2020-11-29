<%@ page import="com.shpakovskiy.trippy.utils.Consts" %>
<%@ page import="com.shpakovskiy.trippy.app.entity.Tour" %>
<%@ page import="com.shpakovskiy.trippy.app.service.tour.DefaultTourService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shpakovskiy.trippy.app.entity.User" %>
<%@ page import="com.shpakovskiy.trippy.app.entity.UserRole" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Happy Trip</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<style>
    body, h1, h2, h3, h4, h5, h6 {
        font-family: "Raleway", Arial, Helvetica, sans-serif;
    }
    .myLink {display: none}
</style>

<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-border-bottom w3-xlarge">
    <a href="#" class="w3-bar-item w3-button w3-text-red w3-hover-red"><b><i class="fa fa-map-marker w3-maruser_role_idgin-right"></i>Happy Trip</b></a>
</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-hide-small" style="max-width:1500px"></header>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px;">

    <!-- Good offers -->
    <div class="w3-container w3-margin-top">
        <h3>Good Offers Right Now</h3>
    </div>

    <%
        User currentUser = (User) request.getAttribute(Consts.CURRENT_USER);
        List<Tour> allTours = (new DefaultTourService()).getAllTours();

        for (int i = 0; i < allTours.size(); i++) {
            Tour tour = allTours.get(i);

            out.print((i % 2 == 0) ?
                    "<div class=\"w3-half w3-margin-bottom\" style=\"float: left; width: 49.5%; margin-right: 0.5%;\">" :
                    "<div class=\"w3-half w3-margin-bottom\" style=\"float: right; width: 49.5%; margin-left: 0.5%;\">");

            out.print("<img src=\"" + tour.getPictureLink() + "\" alt=\"Norway\" style=\"width:100%\">");
            out.print("<div class=\"w3-container w3-white\">");
            out.print("<h3>" + tour.getCaption() +"</h3>");
            out.print("<p class=\"w3-opacity\"> Price: $" + tour.getPriceDollars() + "</p>");
            out.print("<p>" + tour.getSummary() + "</p>");

            if (currentUser.getRoleId() == UserRole.ADMIN.ordinal() + 1) {
                out.print("<label>");
                out.print("<form method=\"GET\" action=\"/edit/" + i + "\">");
                out.print("<input class=\"w3-button w3-margin-bottom\" type=\"submit\" value=\"Edit\"/>");
                out.print("</form>");
                out.print("</label>");
            } else {
                out.print("<button class=\"w3-button w3-margin-bottom\">Buy Tickets</button>");
            }
            out.print("</div></div>");
        }
    %>

    <!-- Newsletter -->
    <div class="w3-container">
        <div class="w3-panel w3-padding-16 w3-black w3-opacity w3-card w3-hover-opacity-off">
            <h2>Have any questions?</h2>
            <p>Leave it here!</p>
            <label>E-mail</label>
            <label>
                <input class="w3-input w3-border" type="text" placeholder="Your Email address">
            </label>
            <br>
            <label>Question</label>
            <label>
                <input class="w3-input w3-border" type="text" placeholder="Enter your question here">
            </label>
            <button type="button" class="w3-button w3-red w3-margin-top">Send</button>
        </div>
    </div>

    <!-- End page content -->
</div>

<!-- Footer -->
<footer class="w3-container w3-center w3-opacity w3-margin-bottom">
    <h5>Find Us On</h5>
    <div class="w3-xlarge w3-padding-16">
        <a class="fa fa-facebook-official w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
        <a class="fa fa-instagram w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
        <a class="fa fa-snapchat w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
        <a class="fa fa-pinterest-p w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
        <a class="fa fa-twitter w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
        <a class="fa fa-linkedin w3-hover-opacity" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"></a>
    </div>
</footer>
</body>
</html>
