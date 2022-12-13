<!DOCTYPE html> 
<html> 
<head>
<meta name="viewport" text-align="center" content="width=device-width, initial-scale=1">
<title style="color:green"> Login Page Details</title>
</head>  
<body> 
    <h1 style="color:green; text-align: center;">Please Login</h1>
    <p> </p><br>
    <h4 style="color:red; text-align: center;">${loginErrorMsg}</h4> 
    <form method="post" action="/login" style="text-align:center">
        <div class="container"> 
            <label style="text-align:center">Email : </label> 
            <input type="text" placeholder="Enter Email" name="email" style="text-align:center" required><br></br>
            <label>Password : </label> 
            <input type="password" placeholder="Enter Password" name="password" style="text-align:center" required><br></br>
            <button type="submit" name="login" value="login" style="text-align:center; background-color:brown; color:azure">Login</button>
        </div>
    </form>

    <p></p>
    <form action="/" style="text-align:center">
        <div>
        <button style="background-color:brown; color:azure">Back</button>
    </div>
    </form>
      
    <h1>${errorMessage}</h1>
    
</body>
<br><br><br><br>
<form action="/comments" style="text-align:left">
    <p><label for="comments" style="color: green;">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br><br><br>
<marquee style="text-align: grid-row-end;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>

 
