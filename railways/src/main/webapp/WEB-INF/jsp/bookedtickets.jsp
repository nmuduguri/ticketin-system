
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>View All Tickets</title>
<h1 style="color:green; text-align:center">${availableTickets}</h1>
<h1 style="color:green; text-align:center">${noTickets}</h1>
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
<th>Train Name</th>
<th> &nbsp;&nbsp; Date Of Journey &nbsp;&nbsp;</th>
<th> &nbsp;&nbsp; No. OF Tickets &nbsp;&nbsp;</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<c:forEach items="${tickets}" var="ticket">
<tr style="text-align: center;">
    
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.pnrNo}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.fname} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.source}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.destination} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.trainName} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.doj} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.tickets} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td style="text-align: center;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ticket.status}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
<br><br>
<form action="/comments" style="text-align:left">
    <p><label for="comments" style="color: green;">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br>
<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>