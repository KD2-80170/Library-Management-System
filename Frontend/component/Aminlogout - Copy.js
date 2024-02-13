import React, { useEffect } from 'react';
import { Link, Redirect, useHistory } from 'react-router-dom';
function Adminlogout() {
  const history = useHistory();
 
  useEffect(() => {
    // Clear session storage upon component mount
    sessionStorage.removeItem('username');
    history.push('/home');
  }, []);

  return (
    <div>
      <h1>Logout Page</h1>
      <p>You have been successfully logged out.</p>
    </div>
  );
}

export default Adminlogout;
