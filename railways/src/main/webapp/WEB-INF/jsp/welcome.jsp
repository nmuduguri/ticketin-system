<!DOCTYPE html> 
<html> 
<head>
    <style>
        .button {
          background-color: #4CAF50;
          border: none;
          color: white;
          text-decoration: none;
          font-size: 16px;
          margin: 4px 2px;
          cursor: pointer;
          padding: 15px 32px;
          text-align: center;
          display: inline-block;
          font-size: 16px;
        }
        </style>
</head>  
<body>
    <form style="text-align:center" method="post" action="/welcome" class="container">
        <div>
            <h1>Hello ${userName}, Welcome to Ticket Reservation System </h1>
            </div>
        </div>
        <div> 
            <p></p><br></br>
            <button class="button" style="background-color:brown; color:azure;" type="submit" name="welcome" value="profile">Profile</button> 
            <button class="button" style="background-color:brown; color:azure" type="submit" name="welcome"value="canceltickets">Cancel Ticket</button><br><br><br><br>
            <button class="button" style="background-color:brown; color:azure;" type="submit" name="welcome" value="bookedtickets">Booked Tickets</button> 
            <button class="button" style="background-color:brown; color:azure" type="submit" name="welcome"value="bookticket">Book Ticket</button> 
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

 
