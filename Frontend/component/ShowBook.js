import React, { useState, useEffect } from "react";
import axios from "axios";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
function ShowBook() {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = () => {
        axios.get("http://localhost:8080/books")
            .then(response => {
                setBooks(response.data);
            })
            .catch(error => {
                console.error("Error fetching books:", error);
            });
    };

    return (
        <div className="container">
            <h2 className="my-4">Books</h2>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Availability</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map(book => (
                        <tr key={book.id}>
                            <td>{book.isbn}</td>
                            <td>{book.title}</td>
                            <td>${book.price.toFixed(2)}</td>
                            <td>{book.available ? "Yes" : "No"}</td>
                            <td>{book.author.firstName} {book.author.lastName}</td>
                            <td>{book.category.catName}</td>
                            <td>{book.quantity}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default ShowBook;
