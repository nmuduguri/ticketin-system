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
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>
  <body style="text-align: center">
    <h1 style="color: green" style="text-align: center">
      Please Enter All The Fields to Register
    </h1>
    <p></p>
    <h5 style="color: red; text-align: center; vertical-align: top">
      Note : * Mark Fields Are Mandatory
    </h5>
    <form method="post" action="/registration">
      <div class="container">
        <label>Enter Frist Name* : </label>
        <input
          type="text"
          placeholder="Enter Name"
          name="fname"
          required
        /><br />
        <p style="color: red">${fnameErrorMsg}</p>
        <label>Enter Last Name* : </label>
        <input
          type="text"
          placeholder="Enter Name"
          name="lname"
          required
        /><br />
        <p style="color: red">${lnameErrorMsg}</p>
        <label class="gender">Gender* :</label>
        <select class="gender" name="gender" id="gender" required>
          <option value="" selected="selected">Select Gender</option>
          <option>Male</option>
          <option>Female</option>
          <option>Others</option></select
        ><br />
        <p style="color: red">${genderErrorMsg}</p>
        <label for="birthday">Birthday Of Birth* :</label>
        <input type="date" id="dob" name="dob" />
        <p style="color: red">${dobErrorMsg}</p>
        <p style="color: red">${ageErrorMsg}</p>
        <label>Enter Email* : </label>
        <input type="text" placeholder="Enter Email" name="email" required />
        <p>
          <span
            class="small"
            style="color: green; text-align: center; width: 200px"
            >&emsp;&emsp;&emsp;Note: OTP will send to this given email.</span
          ><br />
        </p>
        <p style="color: red">${emailErrorMsg}</p>
        <label>Enter Password* : </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="password"
          required
        /><br />
        <p style="color: red">${passwordErrorMsg}</p>
        <label>Confirm Password* : </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="rpassword"
          required
        /><br />
        <p style="color: red">${rpasswordErrorMsg}</p>
        <label>Enter City* : </label>
        <input
          type="text"
          placeholder="Enter City"
          name="city"
          required
        /><br />
        <p style="color: red">${cityErrorMsg}</p>
        <label>Enter Mobile* : </label>
        <input
          type="text"
          placeholder="Enter Mobile Number"
          name="mobile"
          required
        /><br />
        <p style="color: red">${mobileErrorMsg}</p>
        <button style="background-color: brown; color: azure" type="submit">
          Registration
        </button>
      </div>
    </form>
    <p></p>
    <form action="/backToHome" method="post" style="text-align: center">
      <div>
        <button style="background-color: brown; color: azure">Home Page</button>
      </div>
    </form>
  </body>
  <form action="/comments" style="text-align: left">
    <p>
      <label for="comments" style="color: green; width: 850px; text-align: left"
        >Your Suggestions for Site Improvemnt!!</label
      >
    </p>
    <textarea
      id="comments"
      name="comments"
      rows="4"
      cols="80"
      placeholder="Add You Suggestions Here!"
    ></textarea>
    <br />
    <input
      type="submit"
      style="background-color: brown; color: azure"
      value="Submit"
    />
  </form>
  <br />
  <marquee
    style="background-color: green; color: azure"
    behavior="scroll"
    direction="left"
    >Reservation System Site Still in Development Stage!!
  </marquee>
</html>
