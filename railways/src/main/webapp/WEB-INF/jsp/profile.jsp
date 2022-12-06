<!DOCTYPE html> 
<html> 
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>  
<body style="text-align:center">  
   <h1 style="color:green" style="text-align:center"> Profile Details </h1>
   <p> </p><br>
   
    <form method="post" action="/update" style="text-align:center">
        <div class="container"> 
            <label>Frist Name : </label>${fname}<br><br>
            <label>Last Name : </label>${lname}<br><br>
            <label>Gender :</label>${gender}<br><br>
            <label>Birthday Of Birth :</label>${dob}<br><br>
            <label>Email : </label> ${email}<br><br>
            <label>City : </label> ${city}<br><br>
            <label>Mobile Number : </label> ${mobile}<br><br><br><br>
            <button style="background-color:brown; color:azure" type="submit">Update Details</button>
        </div> 
    </form>   
    <p></p>
    <form action="/backToWelcome" method="post" style="text-align:center">
        <div>
        <button style="background-color:brown; color:azure">Home Page</button>
    </div>
    </form>
    

</body> 
<br>
<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>

 
