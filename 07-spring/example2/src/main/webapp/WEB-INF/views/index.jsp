<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Geolocation Example</title>
</head>
<body>
  <h1>Get User Location</h1>
  <button onclick="getLocation()">Get Location</button>

  <script>
    function getLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(sendPositionToServer, showError);
      } else {
        alert("Geolocation is not supported by this browser.");
      }
    }

    function sendPositionToServer(position) {
      const latitude = position.coords.latitude;
      const longitude = position.coords.longitude;

      // 서버로 위치 정보 전송
      fetch('/location', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          latitude: latitude,
          longitude: longitude
        })
      }).then(response => {
        if (response.ok) {
          return response.json();
        }
      }).then(data => {
        console.log('Server Response:', data);
      }).catch(error => {
        console.error('Error:', error);
      });
    }

    function showError(error) {
      switch (error.code) {
        case error.PERMISSION_DENIED:
          alert("User denied the request for Geolocation.");
          break;
        case error.POSITION_UNAVAILABLE:
          alert("Location information is unavailable.");
          break;
        case error.TIMEOUT:
          alert("The request to get user location timed out.");
          break;
        case error.UNKNOWN_ERROR:
          alert("An unknown error occurred.");
          break;
      }
    }
  </script>
</body>
</html>
