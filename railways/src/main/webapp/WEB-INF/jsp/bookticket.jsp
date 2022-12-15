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
<script>
    var stations = {
      "Hyderabad": {
        "Chennai": ["Charminar Exp", "Delhi Exp"],
        "Vijayawada": ["Charminar Exp", "Delhi Exp","Godawari Exp", "Gouthami Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]  
      },
      "Vijayawada": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"] 
      }
      ,
      "Vizag": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]
      },
      "Chennai": {
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]
      },
      "Pune": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]
      },
      "Mumbai": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]
      },
      "Bangalore": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Eluru": ["Godawari Exp", "Gowthami Exp", "Special Train Super Fast"]
      },
      "Eluru": {
        "Chennai": ["Charminar Exp", "Delhi Exp", "Chennai Exp"],
        "Vijayawada": ["Godawari Exp", "Gouthami Exp", "Special Train Super Fast", "LTT Exp"],
        "Vizag": ["Godawari Exp", "Special Train Super Fast", "Non-Stop"],
        "Pune": ["BBS Exp", "HYB Exp", "Pune Shatabdi Exp", "Pune Exp"],
        "Mumbai": ["RJT Exp", "BBS Exp", "Hussin Sagar Super Fast", "Mumbai Exp"],
        "Bangalore": ["Bnglr Exp", "KCG Exp", "YPR Super Fast", "NZM Exp"]
      }
    }
    window.onload = function() {
  var sourcesStations = document.getElementById("source");
  var destinationStation = document.getElementById("destination");
  var trains = document.getElementById("trainName");
  for (var x in stations) {
    sourcesStations.options[sourcesStations.options.length] = new Option(x, x);
  }
  sourcesStations.onchange = function() {
    trains.length = 1;
    destinationStation.length = 1;
    for (var y in stations[this.value]) {
      destinationStation.options[destinationStation.options.length] = new Option(y, y);
    }
  }
  destinationStation.onchange = function() {
    trains.length = 1;
    var z = stations[sourcesStations.value][this.value];
    for (var i = 0; i < z.length; i++) {
      trains.options[trains.options.length] = new Option(z[i], z[i]);
    }
  }
}
</script>
</head>


<body>
  
    <h1 style="text-align: center;">Book Train Ticket</h1>

    <h5 style="color:green; text-align: center;">${available}</h5>
    <h5 style="color:red; text-align: center;">${noAvailable}</h5> 

<form style="text-align: center" method="post" action="/bookTicket">

<div class="container">

<label>    First Name* :</label>
<input type="text" placeholder="Enter First Name" name="fname" required><br/><br/>

<label>     Last Name* :</label>
<input type="text"placeholder="Enter Last Name" name="lname" required><br/><br/>

<label>           Age* :</label>
<input type="text"placeholder="Enter Age " name="age" required><br/><br/>

<label class="gender">Gender* :</label>
            <select class="gender" name="gender" id="gender" required>
                <option value="" selected="selected"> Select Gender </option>
                <option>Male</option>
                <option>Female</option>
                <option>Others</option>
            </select><br>
   <p style="color:red">${genderErrorMsg}</p>

   <label for="birthday">Date Of Journey* :</label>
            <input type="date" id="doj" name="doj" required>
            <p style="color:red">${dojErrorMsg}</p>

<label>From* :</label>
<select name="source" id="source" style="width: 150px;" required>
    <option value="" selected="selected">Select From Station </option>
  </select>
  <br><br>
<label>To* :</label>
<select name="destination" id="destination" style="width: 150px;" required>
    <option value="" selected="selected">Select Dest Station </option>
  </select>
  <br><br>
<label>Train* :</label>
<select name="trainName" id="trainName" style="width: 150px;" required>
    <option value="" selected="selected">Choose Train </option>
  </select>
  <br><br>

  <label>No.Of Tickets* :</label>
<input type="text" name="tickets"><br/>
<p style="color:red">${ticketsErrorMsg}</p>

<label>Amount :</label>
<input type="text" name="amount" value="1000"><br/><br/>

<label>Mobile No* :</label>
<input type="text" name="mobile" required><br/>
<p style="color:red">${mobileErrorMsg}</p>

<label>Email* :</label>
<input type="text" name="email" required><br/><br/>
<p style="color:red">${emailErrorMsg}</p>

<button type ="submit" style="background-color: burlywood ;">BookTicket</button>

</div>
</form>
<br><br>
<form action="/backToWelcome" method="post" style="text-align:center">
  <div>
  <button style="background-color:brown; color:azure">Home Page</button>
</div>
</form>
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

