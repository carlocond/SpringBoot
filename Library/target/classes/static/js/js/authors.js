const authorApi = "http://localhost:8080/authors";

document.getElementById("searchAuthorForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const title = document.getElementById("bookTitle").value;

  fetch(`${authorApi}/by-book/${encodeURIComponent(title)}`)
    .then(res => {
      if (!res.ok) throw new Error("Author not found");
      return res.json();
    })
    .then(author => {
      const info = document.getElementById("authorInfo");
      info.innerHTML = `
        <p>ID: ${author.id}</p>
        <p>Name: ${author.fName} ${author.lName}</p>
        <p>Birth Date: ${author.birthDate || 'N/A'}</p>
        <p>Biography: ${author.biography || 'N/A'}</p>
        <p>Books: ${author.books.map(b => b.title).join(", ")}</p>
      `;
    })
    .catch(err => alert(err));
});
