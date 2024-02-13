import React from "react";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {Link, Switch, Route} from 'react-router-dom';
import backgroundImage from './Image/Lib1.jpg';
import adminimage from  './Image/Admin.png';
import userimage from  './Image/Usernn.png';
import './style.css';
import { useHistory } from "react-router-dom";

function Home() {
   const history = useHistory();
   const handleUser = () => {
      history.push("/signup");
  };
  const handleAdmin = () => {
   history.push("/Adsignup");
};

    const containerStyle = {
        minHeight: '100vh',
        background: `url(${backgroundImage}) no-repeat center center fixed`,
        backgroundSize: 'cover'
    };

    return (

      

      <div className="container-fluid mt-5 bg-image" style={containerStyle}>

<hr></hr>
                    <Link to="/home">Home</Link> {" | "}
                    <Link to="/about">About Us</Link> {" | "}
                    <Link to="/login">Login</Link> {" | "}
                    <Link to="/signup">Signup</Link> {" | "}
                    <Link to="/Adsignup">ADSignup</Link> {" | "}

                   
                <hr></hr>
          <h1 className="glowing-running-text text-center">Library Management</h1>
      
        <div className="container mt-5">
          <div className="row justify-content-center">
            <div className="col-md-6 text-center">
              <a href="/signup" onClick={(e) => { e.preventDefault(); handleUser(); }}>
                <img src={userimage} alt="User Signup" className="img-fluid mb-2" style={{ cursor: "pointer", maxWidth: "200px" }} />
              </a>
              <p className="text-white font-weight-bold">Sign Up as User</p>
            </div>
            <div className="col-md-6 text-center">
              <a href="/Adsignup" onClick={(e) => { e.preventDefault(); handleAdmin(); }}>
                <img src={adminimage} alt="Admin Signup" className="img-fluid mb-2" style={{ cursor: "pointer", maxWidth: "200px" }} />
              </a>
              <p className="text-white font-weight-bold">Sign Up as Admin</p>
            </div>
          </div>
        </div>
      </div>
    );
}

export default Home;
