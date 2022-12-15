<!DOCTYPE html> 
<html> 
<head>
    <style>
        span.small {
          font-size: smaller;
        }
        div {
        margin-bottom: 10px;
        text-align:center;
      }
      label {
        display: inline-block;
        width: 80px;
        text-align: center;
        
      }
        </style>
<meta name="viewport" text-align="center" content="width=device-width, initial-scale=1">
<title style="color:green"> Login Page Details</title>
</head>  
<body> 
    <h1 style="color:green; text-align: center;">Please Enter Registered Email</h1>
    <p> </p><br>
    <form method="post" action="/forgotPassword">
        <div class="container"> 
            <label style="text-align:center">Email : </label> 
            <input type="text" placeholder="Enter Regitered Email" name="email" style="text-align:center" required><br>
            <p><span class="small" style="color:green; text-align: center; width: 200px;">&emsp;&emsp;&emsp;Note: OTP will send to this given email.</span><br></p>
            <h4 style="color:red; text-align: center;">${forgotPasswordErrorMsg}</h4> 
            <button type="submit" name="login" value="passwordOTP" style="text-align:center; background-color:brown; color:azure">Submit</button>
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
    <p><label for="comments" style="color: green; width: 850px; text-align: left">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br><br><br>
<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>

 
