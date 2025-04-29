const signinButton = document.getElementById("signinButton");

signinButton.addEventListener("click", function () {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  console.log(username, password);

  if (!username || !password) {
    alert("Please fill in all fields");
    return;
  }

  const requestData = {
    userName: username,
    password: password,
  };

  fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestData),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Login failed"); // Throw an error for non-200 responses
      }
      //return response.json(); // Only parse JSON for successful responses
      window.location.href = "http://127.0.0.1:5500/html/studentTable.html";
    })
    .then((data) => {
      alert("Login successful!");
      window.location.href = "http://127.0.0.1:5500/html/studentTable.html";
    })
    .catch((error) => {
      alert("Login failed"); // Show login failed message
    });
});
