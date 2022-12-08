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
          padding:20px 42px;
          text-align: center;
          display: inline-block;
          font-size: 16px;
        }
        .container {
        display: flex;
        align-items: center;
        justify-content: center
      }
      img {
        max-width: 40%
      }
      .image {
        flex-basis: 30%
      }
      .text {
        font-size: 20px;
        padding-left: 30px;
      }
        </style>
</head>  
<body>

      <div style="content: center" class="container">
        
        <div class="text">
            <h1>Welcome to Ticket Regiservation System    </h1>
        </div>
        <div class="image">
            <p></p>
            <img src="/images/train.png" alt="Trulli" width="250" height="150">
          </div>
      </div>

    <form style="text-align:center" method="get" action="/index" class="container">
       
        <div> 
            <p></p>
            <p style="color:blue">Please Login/Register To Book The Ticket</p>
            <button class="button"  style="background-color:brown; color:azure" type="submit" name="login" value="login">Login</button> 
            <button class="button"  style="background-color:brown; color:azure" type="submit" name="login"value="register">Registration</button> 
        </div> 
    </form>   
</body>  
<br><br><br><br>
<form action="/comments">
    <p><label for="comments" style="color: green;">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br><br><br>

<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee> 
</html>

 
