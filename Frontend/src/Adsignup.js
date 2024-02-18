import React, { useState } from 'react';
import axios from 'axios';
import { Link, Redirect, useHistory } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
const Adsignup = () => {
    const history = useHistory();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [error, setError] = useState('');
    const [redirectToLogin, setRedirectToLogin] = useState(false);

    const handleSignup= async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/admin/register', { username, password});
            console.log('Signed up successfully!', response.data);
            setRedirectToLogin(true);
        } catch (error) {
            setError('Registration failed');
            console.error('Signup error:', error);
        }
    };

    if (redirectToLogin) {
        return <Redirect to="/Adlog" />;
    }

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-header"> Admin Sign Up</div>
                        <div className="card-body">
                            <form>
                                <div className="mb-3">
                                    <input type="text" className="form-control" placeholder="Username" value={username} onChange={e => setUsername(e.target.value)} />
                                </div>
                                <div className="mb-3">
                                    <input type="password" className="form-control" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} />
                                </div>
                    
                                <div className="mb-3">
                                    <button type="button" className="btn btn-primary" onClick={handleSignup}>Sign Up</button>
                                </div>
                                {error && <div className="alert alert-danger">{error}</div>}
                                <Link to="/Adlog">Already have an account? Login</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Adsignup;
