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
<title style="color:green"> Verify OTP Page Details</title>
</head>  
<body> 
    <h1 style="color:green; text-align: center;">Please Verify With Valid OTP</h1>
    <p> </p><br>
    <form method="post" action="/changePwdOTP">
        <div class="container"> 
          <label>Enter Password* : </label> 
          <input type="password" placeholder="Enter Password" name="password" required><br>
          <p style="color:red">${passwordErrorMsg}</p>
          <label>Confirm Password* : </label> 
          <input type="password" placeholder="Enter Password" name="rpassword" required><br>
          <p style="color:red">${rpasswordErrorMsg}</p>
            <input type="hidden" value="${email}" name="email">
            <input type="hidden" value="${userName}" name="fname">
            
            <button type="submit" name="verifyOTP" value="changePwd" style="text-align:center; background-color:brown; color:azure">Change Password</button>
        </div>
    </form>

    <p></p>
    <form action="/index?login=registe" style="text-align:center">
        <div>
        <button style="background-color:brown; color:azure">Back</button>
    </div>
    </form>
    
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

 
