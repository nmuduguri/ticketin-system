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
    <form method="post" action="/otp">
        <div class="container"> 
            <label style="text-align:center">Enter OTP : </label> 
            <input type="text" placeholder="Enter OTP" name="otp" style="text-align:center"><br>
            <p style="color:red">${otpErrorMsg}</p>
            <input type="hidden" value="${email}" name="email">
            <input type="hidden" value="${userName}" name="fname">
            
            <button type="submit" name="verifyOTP" value="login" style="text-align:center; background-color:brown; color:azure">Verify OTP</button>
            <button type="submit" name="verifyOTP" value="newOTP" style="text-align:center; background-color:brown; color:azure">New OTP</button>
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

 
