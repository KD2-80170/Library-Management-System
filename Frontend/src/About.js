import React from "react";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import backgroundImage from './Image/Lib1.jpg'; // Assuming this is your background image

function About() {
    const containerStyle = {
        minHeight: '100vh', // Ensure the container covers the full viewport height
        background: `url(${backgroundImage}) no-repeat center center fixed`,
        backgroundSize: 'cover'
    };

    return (
        <div className="container-fluid mt-5 bg-image" style={containerStyle}>
            <div className="container">
                <div className="row">
                    <div className="col-md-8 offset-md-2 text-center text-white">
                        <h1 className="mb-4">About Us</h1>
                        <p className="lead animated fadeIn">
                            HI I  AM HRISHIKESH OUR CODE FOR LIBRARY  
                        </p>
                        <p className="animated fadeIn">
                            library management.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default About;
