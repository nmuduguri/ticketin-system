<!DOCTYPE html> 
<html> 
<head>
    <style>
        span.small {
          font-size: smaller;
        }
        div {
        margin-bottom: 10px;
        text-align: center;
      }
      label {
        display: inline-block;
        width: 150px;
        text-align: center;
        
      }
      .gender {
        display: inline-block;
        width: 150px;
        text-align: center;
    }
        </style>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>  
<body style="text-align:center">  
   <h1 style="color:green" style="text-align:center"> Please Enter All The Fields to Register</h1>
   <p> </p><br>
    
    <form method="post" action="/updateUserDetails">
        <div class="container"> 
            <label>Enter Frist Name : </label> 
            <input type="text" placeholder="Enter Name" name="fname" ><br></br>
            <p style="color:red">${fnameErrorMsg}</p>
            <label>Enter Last Name : </label> 
            <input type="text" placeholder="Enter Name" name="lname"><br></br>
            <p style="color:red">${lnameErrorMsg}</p>
            <label for="cars">Gender :</label>
            <select class="gender" name="gender" id="gender">
                <option value="" selected="selected"> Select </option>
                <option>Male</option>
                <option>Female</option>
                <option>Others</option>
            </select><br></br>
            <label>Birthday Of Birth :</label>
            <input type="date" id="dob" name="dob">
            <p style="color:red">${ageErrorMsg}</p>
            <label>Enter Email : </label> 
            <input type="text" placeholder="Enter Email" name="email"><br></br>
            <p style="color:red">${emailErrorMsg}</p>
            <label>Enter City : </label> 
            <input type="text" placeholder="Enter City" name="city"><br></br>
            <p style="color:red">${cityErrorMsg}</p>
            <label>Enter Mobile : </label> 
            <input type="text" placeholder="Enter Mobile Number" name="mobile"><br></br>
            <p style="color:red">${mobileErrorMsg}</p>
            <button style="background-color:brown; color:azure" type="submit">Update Profile</button>
            
            
        </div> 
    </form>   
    <p></p>
    <form action="/backToWelcome" style="text-align:center">
        <div>
        <button style="background-color:brown; color:azure">Home Page</button>
    </div>
    </form>
    <h1 style="color:green">${message}</h1>
    

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

 
