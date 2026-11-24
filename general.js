const express = require('express');
const axios = require('axios'); // Dodanie Axios
let books = require("./booksdb.js");
let isValid = require("./auth_users.js").isValid;
let users = require("./auth_users.js").users;
const public_users = express.Router();

// Rejestracja (zostawiamy bez zmian, to nie jest wymagane w tym pytaniu)
public_users.post("/register", (req, res) => {
  const username = req.body.username;
  const password = req.body.password;
  if (username && password) {
    if (!isValid(username)) {
      users.push({"username": username, "password": password});
      return res.status(200).json({message: "Customer successfully registred. Now you can login"});
    } else {
      return res.status(404).json({message: "User already exists!"});
    }
  }
  return res.status(404).json({message: "Unable to register user."});
});

// 1. Pobierz listę wszystkich książek (używając Axios + async/await)
public_users.get('/', async function (req, res) {
    try {
        // Wywołanie własnego API
        const response = await axios.get('http://localhost:5000/');
        res.send(response.data);
    } catch (error) {
        res.status(500).send(error.message);
    }
});

// 2. Pobierz książkę po ISBN (używając Axios + async/await)
public_users.get('/isbn/:isbn', async function (req, res) {
    const isbn = req.params.isbn;
    try {
        const response = await axios.get(`http://localhost:5000/isbn/${isbn}`);
        res.send(response.data);
    } catch (error) {
        // Jeśli książka nie zostanie znaleziona
        res.status(404).send({ message: "Book not found" });
    }
});

// 3. Pobierz książki po autorze (używając Axios + async/await)
public_users.get('/author/:author', async function (req, res) {
    const author = req.params.author;
    try {
        const response = await axios.get(`http://localhost:5000/author/${author}`);
        res.send(response.data);
    } catch (error) {
        res.status(404).send({ message: "Books by author not found" });
    }
});

// 4. Pobierz książki po tytule (używając Axios + async/await)
public_users.get('/title/:title', async function (req, res) {
    const title = req.params.title;
    try {
        const response = await axios.get(`http://localhost:5000/title/${title}`);
        res.send(response.data);
    } catch (error) {
        res.status(404).send({ message: "Books by title not found" });
    }
});

// Pobierz recenzje (zostawiamy bez zmian)
public_users.get('/review/:isbn', function (req, res) {
  const isbn = req.params.isbn;
  res.send(books[isbn].reviews);
});

module.exports.general = public_users;
