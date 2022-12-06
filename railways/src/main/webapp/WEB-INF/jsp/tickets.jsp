
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>View All Tickets</title>
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
<tr>
    
    <td>${ticket.pnrNo}</td>
    <td>${ticket.fname}</td>
    <td>${ticket.source}</td>
    <td>${ticket.destination}</td>
    <td>${ticket.doj}</td>
    <td>${ticket.tickets}</td>
    <td>${ticket.status}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>