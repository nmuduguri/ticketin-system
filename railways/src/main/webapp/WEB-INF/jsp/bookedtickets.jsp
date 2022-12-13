
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>View All Tickets</title>
<h1 style="color:green; text-align:center">{availableTickets}</h1>
<h1 style="color:green; text-align:center">{noTickets}</h1>
<style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
    
    table.center {
      margin-left: auto; 
      margin-right: auto;
    }
    </style>
</head>
<body>
<table class="center">
<thead>
<tr>
<th>Ticket No</th>
<th>Name</th>
<th>From</th>
<th>To</th>
<th>Date Of Journey</th>
<th>No. OF Tickets</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<c:forEach items="${tickets}" var="ticket">
<trstyle="text-align: center;">
    
    <td style="text-align: center;">${ticket.pnrNo}</td>
    <td style="text-align: center;">${ticket.fname}</td>
    <td style="text-align: center;">${ticket.source}</td>
    <td style="text-align: center;">${ticket.destination}</td>
    <td style="text-align: center;">${ticket.doj}</td>
    <td style="text-align: center;">${ticket.tickets}</td>
    <td style="text-align: center;">${ticket.status}</td>
</tr>
</c:forEach>
</tbody>
</table>
<br><br>
<br><br>
<form action="/backToWelcome" method="post" style="text-align:center">
    <div>
    <button style="background-color:brown; color:azure">Home Page</button>
</div>
</form>
</body>
<br><br><br><br>
<form action="/comments" style="text-align:left">
    <p><label for="comments" style="color: green;">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br><br><br>
<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>