const resApi = "http://localhost:8080/reservations";

// Create reservation
document.getElementById("createResForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const userId = document.getElementById("resUserId").value;
  const bookId = document.getElementById("resBookId").value;

  fetch(resApi, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userId, bookId })
  })
    .then(res => res.json())
    .then(() => alert("Reservation created"))
    .catch(err => alert(err));
});

// Fetch reservations by user
document.getElementById("resByUserForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const userId = document.getElementById("userIdQuery").value;

  fetch(`${resApi}/com/library/Library/user/${userId}`)
    .then(res => res.json())
    .then(reservations => {
      const list = document.getElementById("resList");
      list.innerHTML = "";
      reservations.forEach(r => {
        const li = document.createElement("li");
        li.textContent = `Reservation ${r.id}: Book ${r.book.title} - Status ${r.status} - Expiration ${r.expirationDate}`;
        list.appendChild(li);
      });
    })
    .catch(err => alert(err));
});
