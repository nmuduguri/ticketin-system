<!DOCTYPE html>
<html>
<head>
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
  var trains = document.getElementById("train");
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

    <h1 style="text-align: center;">Book Train</h1>

<form style="text-align: center" method="post" action="/bookTicket">

<div class="container">

<label> Enter First Name :</label>
<input type="text" placeholder="Enter First Name" name="fname"></p>

<label> Enter Last Name :</label>
<input type="text"placeholder="Enter Last Name" name="lname"></p>

<label for="gender">Gender* :</label>
            <select name="gender" id="gender">
                <option value="" selected="selected"> Select Gender </option>
                <option>Male</option>
                <option>Female</option>
                <option>Others</option>
            </select><br></br>
   <p style="color:red">${genderErrorMsg}</p>

   <label for="birthday">Date Of Journey* :</label>
            <input type="date" id="doj" name="doj">
            <p style="color:red">${dojErrorMsg}</p>

<label> From :</label>
<select name="source" id="source" style="width: 150px;">
    <option value="" selected="selected">Select From Station </option>
  </select></p>
<label> To :</label>
<select name="destination" id="destination" style="width: 150px;">
    <option value="" selected="selected">Select Dest Station </option>
  </select></p>
<label> Train :</label>
<select name="train" id="train" style="width: 150px;">
    <option value="" selected="selected">Choose Train </option>
  </select></p>

<label> Amount :</label>
<input type="text" name="amount"></p>

<label> Enter Mobile Number :</label>
<input type="text" name="mobile"></p>

<label> Enter Email :</label>
<input type="text" name="email"></p>
<br><br>
<button type ="submit" style="background-color: burlywood ;">BookTicket</button>

</div>
</form>
</body>
<br><br><br><br>
<br><br><br><br>
<br><br><br><br>
<marquee style="background-color:green; color:azure;" behavior="scroll" direction="left">Reservation System Site Still in Development Stage!! </marquee>
</html>
