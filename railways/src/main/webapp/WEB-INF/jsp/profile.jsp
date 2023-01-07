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
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>
  <body style="text-align: center">
    <h1 style="color: green" style="text-align: center">Profile Details</h1>
    <p></p>
    <br />

    <form method="post" action="/update">
      <div class="container">
        <label>Frist Name :</label>${fname}<br /><br />
        <label>Last Name :</label>${lname}<br /><br />
        <label>Gender :</label>${gender}<br /><br />
        <label>Birthday Of Birth :</label>${dob}<br /><br />
        <label>Email :</label>${email}<br /><br />
        <label>City :</label>${city}<br /><br />
        <label>Mobile Number :</label> ${mobile}<br /><br /><br /><br />
        <button style="background-color: brown; color: azure" type="submit">
          Update Details
        </button>
      </div>
    </form>
    <p></p>
    <form action="/backToWelcome" method="post" style="text-align: center">
      <div>
        <button style="background-color: brown; color: azure">Home Page</button>
      </div>
    </form>
  </body>
  <br /><br /><br /><br />
  <form action="/comments" style="text-align: left">
    <p>
      <label for="comments" style="color: green; width: 850px; text-align: left"
        >Your Suggestions for Site Improvemnt!!</label
      >
    </p>
    <textarea
      id="comments"
      name="comments"
      rows="6"
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
  <br /><br /><br /><br />
  <marquee
    style="background-color: green; color: azure"
    behavior="scroll"
    direction="left"
    >Reservation System Site Still in Development Stage!!
  </marquee>
</html>
