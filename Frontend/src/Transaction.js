import React, { useEffect, useState } from "react";
import axios from "axios";

function Transaction() {
    const [transactions, setTransactions] = useState([]);   
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const userId = sessionStorage.getItem('userId'); // Retrieve user ID from session
    const url = `http://localhost:8080/transactions/user/${userId}`; // Assuming transactions are fetched from this URL

    const fetchTransactions = () => {
        axios.get(url)
            .then((response) => {
                setTransactions(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError("Error fetching transaction data");
                setLoading(false);
                console.error("Error fetching data:", error);
            });
    }

    useEffect(() => {
        fetchTransactions();
    }, []);

    return (
        <div className="container">
            <hr />
            <div className="alert alert-success">
                <h1 className="fw-bold text-primary" style={{ fontSize: '2.5rem' }}>Transactions</h1>
                {loading && <p>Loading...</p>}
                {error && <p>{error}</p>}
            </div>
            <hr />
            <div className="table-responsive">
                <table className="table table-bordered">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Book Title</th>
                            <th>Author</th>
                            <th>Checkout Date</th>
                            <th>Return Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {transactions.map((transaction, index) => (
                            <tr key={index}>
                                <td>{transaction.user.firstName}</td>
                                <td>{transaction.book.title}</td>
                                <td>{transaction.book.author.firstName} {transaction.book.author.lastName}</td>
                                <td>{transaction.checkoutDate}</td>
                                <td>{transaction.returnDate}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Transaction;
 