<!DOCTYPE html>
<html>
  <head> </head>
  <body>
    <h1 style="color: red">${commonErrorMsg}</h1>
  </body>
  <br /><br /><br /><br />
  <form action="/comments" style="text-align: left">
    <p>
      <label for="comments" style="color: green"
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
