import React, { useState, useEffect } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';

function TransactionManager() {
    const [transactions, setTransactions] = useState([]);
    const [newTransaction, setNewTransaction] = useState({
        userId: 0,
        bookId: 0,
        issueDate: "",
        subscriptionType:0 // Added plan property to the state
    });

    const [editTransaction, setEditTransaction] = useState(null);
    const [users, setUsers] = useState([]);
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetchTransactions();
        fetchUsers();
        fetchBooks();
    }, []);

    const fetchTransactions = () => {
        axios.get("http://localhost:8080/transactions")
            .then(response => {
                setTransactions(response.data);
            })
            .catch(error => {
                console.error("Error fetching transactions:", error);
            });
    };

    const fetchUsers = () => {
        axios.get("http://localhost:8080/api/users")
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error("Error fetching users:", error);
            });
    };

    const fetchBooks = () => {
        axios.get("http://localhost:8080/books")
            .then(response => {
                setBooks(response.data);
            })
            .catch(error => {
                console.error("Error fetching books:", error);
            });
    };

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setNewTransaction({
            ...newTransaction,
            [name]: value
        });
    };

    const addTransaction = () => {
        axios.post("http://localhost:8080/transactions", newTransaction)
            .then(response => {
                fetchTransactions();
                resetNewTransaction();
            })
            .catch(error => {
                console.error("Error adding transaction:", error);
            });
    };

    const updateTransaction = () => {
        axios.put(`http://localhost:8080/transactions/${editTransaction.id}`, editTransaction)
            .then(response => {
                fetchTransactions();
                setEditTransaction(null);
            })
            .catch(error => {
                console.error("Error updating transaction:", error);
            });
    };

    const deleteTransaction = (id) => {
        axios.delete(`http://localhost:8080/transactions/${id}`)
            .then(response => {
                fetchTransactions();
            })
            .catch(error => {
                console.error("Error deleting transaction:", error);
            });
    };

    const resetNewTransaction = () => {
        setNewTransaction({
            userId: 0,
            bookId: 0,
            issueDate: "",
            subscriptionType:0  // Reset plan property
        });
    };

    const editTransactionData = (transaction) => {
        setEditTransaction(transaction);
    };

    return (
        <div className="container">
            {/* Add New Transaction Section */}
            <h2>Add New Transaction</h2>
            <div className="row">
                <div className="col">
                    <label>User ID:</label>
                    <select className="form-control" name="userId" value={newTransaction.userId} onChange={handleInputChange}>
                        <option value="">Select User</option>
                        {users.map(user => (
                            <option key={user.id} value={user.id}>{user.id} - {user.firstName}-{user.lastName}</option>
                        ))}
                    </select>
                </div>
                <div className="col">
                    <label>Book ID:</label>
                    <select className="form-control" name="bookId" value={newTransaction.bookId} onChange={handleInputChange}>
                        <option value="">Select Book</option>
                        {books.map(book => (
                            <option key={book.id} value={book.id}>{book.id} - {book.title} by {book.author.firstName} {book.author.lastName}</option>
                        ))}
                    </select>
                </div>
                <div className="col">
                    <label>Issue Date:</label>
                    <input className="form-control" type="date" name="issueDate" value={newTransaction.issueDate} onChange={handleInputChange} />
                </div>
                <div className="col">
                    <label>SubscriptionPlan:</label>
                    <select className="form-control" name="subscriptionType" value={newTransaction.subscriptionType} onChange={handleInputChange}>
                        <option value="">Select Plan</option>
                        <option value="BASIC">BASIC</option>
                        <option value="PREMIUM">PREMIUM</option>
                        <option value="GOLD">GOLD</option>
                    </select>
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={addTransaction}>Add Transaction</button>
                </div>
            </div>

            {/* Transactions Table */}
            <h2>Transactions</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>UserID</th>
                        <th>User</th>
                        <th>Mobile Number</th>
                        <th>Book</th>
                        <th>ISBN</th>
                        <th>Quantity</th>
                        <th>IssueDate</th>
                        <th>Plan</th>
                        <th>Fine</th>
                    </tr>
                </thead>
                <tbody>
                    {transactions.map(transaction => (
                        <tr key={transaction.id}>
                            <td>{transaction.id}</td>
                            <td>{transaction.user.id} </td>
                            <td> {transaction.user.firstName} {transaction.user.lastName}</td>
                            <td>{transaction.user.mobileNo}</td>
                            <td> {transaction.book.title} by {transaction.book.author.firstName} {transaction.book.author.lastName}</td>
                            <td>{transaction.book.isbn}</td>
                            <td>{transaction.book.quantity}</td>
                            <td>{transaction.issueDate}</td>
                            <td>{transaction.subscriptionType}</td>
                            <td>{transaction.fine}</td>
                            <td>
                                <button className="btn btn-danger" onClick={() => deleteTransaction(transaction.id)}>Delete</button>
                                <button className="btn btn-warning" onClick={() => editTransactionData(transaction)}>Edit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {/* Edit Transaction Section */}
            {editTransaction && (
                <div>
                    <h2>Edit Transaction</h2>
                    <div className="row">
                        <div className="col">
                            <label>User ID:</label>
                            <select className="form-control" name="userId" value={editTransaction.userId} onChange={(event) => setEditTransaction({ ...editTransaction, userId: event.target.value })}>
                                <option value="">Select User</option>
                                {users.map(user => (
                                    <option key={user.id} value={user.id}>{user.id} - {user.username}</option>
                                ))}
                            </select>
                        </div>
                        <div className="col">
                            <label>Book ID:</label>
                            <select className="form-control" name="bookId" value={editTransaction.bookId} onChange={(event) => setEditTransaction({ ...editTransaction, bookId: event.target.value })}>
                                <option value="">Select Book</option>
                                {books.map(book => (
                                    <option key={book.id} value={book.id}>{book.id} - {book.title} by {book.author.firstName} {book.author.lastName}</option>
                                ))}
                            </select>
                        </div>
                        <div className="col">
                            <label>Checkout Date:</label>
                            <input className="form-control" type="date" name="issueDate" value={editTransaction.issueDate} onChange={(event) => setEditTransaction({ ...editTransaction, issueDate: event.target.value })} />
                        </div>
                        <div className="col">
                            <label>Plan:</label>
                            <select className="form-control" name="subscriptionType" value={editTransaction.subscriptionType} onChange={(event) => setEditTransaction({ ...editTransaction, subscriptionType: event.target.value })}>
                                <option value="">Select Plan</option>
                                <option value="basic">Basic</option>
                                <option value="premium">Premium</option>
                                <option value="gold">Gold</option>
                            </select>
                        </div>
                        <div className="col">
                            <button className="btn btn-primary" onClick={updateTransaction}>Update Transaction</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default TransactionManager;
