const bookApi = "http://localhost:8080/books";

function fetchBooks() {
  fetch(bookApi)
    .then(res => res.json())
    .then(books => {
      const list = document.getElementById("bookList");
      list.innerHTML = "";
      books.forEach(book => {
        const li = document.createElement("li");
        li.textContent = `${book.title} by ${book.author?.fName || 'N/A'} ${book.author?.lName || ''} - ${book.genre} - ${book.status}`;
        list.appendChild(li);
      });
    });
}

document.getElementById("createBookForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const title = document.getElementById("title").value;
  const authorId = document.getElementById("authorId").value;
  const genre = document.getElementById("genre").value;
  const status = document.getElementById("status").value;

  fetch(bookApi, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, author: { id: parseInt(authorId) }, genre, status })
  })
    .then(res => res.json())
    .then(() => {
      fetchBooks();
      this.reset();
    })
    .catch(err => alert(err));
});

fetchBooks();
