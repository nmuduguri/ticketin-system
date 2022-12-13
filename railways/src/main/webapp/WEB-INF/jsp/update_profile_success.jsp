<!DOCTYPE html> 
<html> 
<head>
</head>
<body>
    <h1 style="color:green">${successMsg}/h1>
</body>

<form action="/welcome" style="text-align:center">
    <div>
    <button style="background-color:brown; color:azure">Home Page</button>
</div>
</form>
<br><br><br><br>
<form action="/comments" style="text-align:left">
    <p><label for="comments" style="color: green;">Your Suggestions for Site Improvemnt!!</label></p>
    <textarea id="comments" name="comments" rows="6" cols="80" placeholder="Add You Suggestions Here!" ></textarea>
    <br>
    <input type="submit" style="background-color:brown; color:azure" value="Submit">
  </form>
  <br><br><br><br>
</html>