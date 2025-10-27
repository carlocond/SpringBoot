const apiUrl = "http://localhost:8080/users";

function fetchUsers() {
  fetch(apiUrl)
    .then(res => res.json())
    .then(users => {
      const list = document.getElementById("userList");
      list.innerHTML = "";
      users.forEach(user => {
        const li = document.createElement("li");
        li.textContent = `${user.fName} ${user.lName} - ${user.email} - ${user.status}`;
        list.appendChild(li);
      });
    });
}

// Handle form submit
document.getElementById("createUserForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const fName = document.getElementById("fName").value;
  const lName = document.getElementById("lName").value;
  const email = document.getElementById("email").value;

  fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ fName, lName, email })
  })
    .then(res => res.json())
    .then(() => {
      fetchUsers();
      this.reset();
    })
    .catch(err => alert(err));
});

fetchUsers();
