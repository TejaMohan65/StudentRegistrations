document.addEventListener("DOMContentLoaded", function () {
  const signupButton = document.getElementById("signupButton");

  signupButton.addEventListener("click", function () {
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const rollNumber = document.getElementById("rollNumber").value;
    

    if (!username || !email || !password) {
      alert("Please fill in all fields");
      return;
    }

    const requestData = {
      rollNumber: rollNumber,
      name: username,
      email: email,
      password: password,
    };

    fetch("http://localhost:8080/student", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestData),
    })
      .then((response) => response.json())
      .then((data) => {
        alert("Registration successful!");
      })
      .catch((error) => {
        // console.error("Error:", error);
        alert("Registration failed");
      });
  });
});
