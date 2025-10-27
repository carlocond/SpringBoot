const loanApi = "http://localhost:8080/loans";

// Create loan
document.getElementById("createLoanForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const userId = document.getElementById("userId").value;
  const bookId = document.getElementById("bookId").value;
  const dueDate = document.getElementById("dueDate").value;

  fetch(`${loanApi}?userId=${userId}&bookId=${bookId}&dueDate=${dueDate}`, {
    method: "POST"
  })
    .then(res => res.json())
    .then(() => alert("Loan created"))
    .catch(err => alert(err));
});

// Fetch active loans
document.getElementById("activeLoansForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const userId = document.getElementById("loanUserId").value;

  fetch(`${loanApi}/com/library/Library/user/${userId}/active`)
    .then(res => res.json())
    .then(loans => {
      const list = document.getElementById("loanList");
      list.innerHTML = "";
      loans.forEach(loan => {
        const li = document.createElement("li");
        li.textContent = `Loan ${loan.id}: Book ${loan.book.title} - Due ${loan.dueDate} - Status ${loan.status}`;
        list.appendChild(li);
      });
    })
    .catch(err => alert(err));
});
