import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useHistory } from 'react-router-dom';

const UserDashboard = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const history = useHistory();

  useEffect(() => {
    const username = sessionStorage.getItem('username');
    if (username) {
      fetchUser(username);
    }
  }, []); // Ensure the useEffect runs only once upon component mount

  const fetchUser = (username) => {
    setLoading(true); // Set loading state to true when fetching user data
    axios.get(`http://localhost:8080/api/users/username/${username}`)
      .then(response => {
        setUser(response.data);
        sessionStorage.setItem('userId', response.data.id); // Set user ID in session storage
        setLoading(false); // Set loading state to false when user data is fetched
      })
      .catch(error => {
        setError('Error fetching user data');
        setLoading(false); // Set loading state to false if there's an error
        console.error('Error fetching user:', error);
      });
  };

  const handleLogout = () => {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('userId'); // Remove user ID from session storage upon logout
    history.push('/home');
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-8">
          <div className="card">
            <div className="card-header">
              <h2>User Dashboard</h2>
            </div>
            <div className="card-body">
              <div className="mb-3">
                <Link to="/showbook" className="btn btn-primary me-3">Books</Link>
                <Link to="/transaction" className="btn btn-primary me-3">Transaction</Link>
                <button onClick={handleLogout} className="btn btn-danger">Logout</button>
              </div>
              {loading ? (
                <p>Loading...</p>
              ) : error ? (
                <p>{error}</p>
              ) : (
                <div>
                  <h3>Welcome {user.firstName} {user.lastName}</h3>
                  <p>Email: {user.email}</p>
                  <p>Mobile No: {user.mobileNo}</p>
                  {/* Additional user data can be displayed here */}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserDashboard;
