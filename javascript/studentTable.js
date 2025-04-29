let studentsData = []; // Store all students for filtering

// Fetch students from backend and populate the table
function fetchStudents() {
  fetch("http://localhost:8080/student", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to fetch students");
      }
      return response.json();
    })
    .then((students) => {
      studentsData = students; // Store all students for filtering
      displayStudents(students);
    })
    .catch((error) => {
      console.error("Error fetching students:", error);
      alert("Failed to load student data");
    });
}

// Display students in the table
function displayStudents(students) {
  const tableBody = document.getElementById("studentTableBody");
  tableBody.innerHTML = ""; // Clear previous data

  students.forEach((student, index) => {
    const row = `
            <tr>
                <td>${index + 1}</td>
                <td>${student.rollNumber}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${
                  student.dateOfBirth
                    ? new Date(student.dateOfBirth).toLocaleDateString()
                    : "N/A"
                }</td>
                <td>${student.address || "N/A"}</td>
                <td>${student.branch || "N/A"}</td>
            </tr>
        `;
    tableBody.innerHTML += row;
  });
}

// Search and filter students
function filterStudents() {
  const searchValue = document
    .getElementById("searchInput")
    .value.toLowerCase();
  const filteredStudents = studentsData.filter(
    (student) =>
      student.name.toLowerCase().includes(searchValue) ||
      student.rollNumber.toLowerCase().includes(searchValue)
  );
  displayStudents(filteredStudents);
}

// Call fetchStudents when the page loads
window.onload = fetchStudents;
