import React, { useState } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
const Adlog = () => {
    const history = useHistory();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/admin/login', { username, password });
            console.log('Logged in successfully!', response.data);
            sessionStorage.setItem('username',username)
            history.push('/AdminDasbord');
        } catch (error) {
            setError('Invalid username or password');
            history.push('/Adsignup');
            console.error('Login error:', error);
        }
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-header">Admin Login</div>
                        <div className="card-body">
                            <form>
                                <div className="mb-3">
                                    <input type="text" className="form-control" placeholder="Username" value={username} onChange={e => setUsername(e.target.value)} />
                                </div>
                                <div className="mb-3">
                                    <input type="password" className="form-control" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} />
                                </div>
                                <div className="mb-3">
                                    <button type="button" className="btn btn-primary" onClick={handleLogin}>Login</button>
                                </div>
                                {error && <div className="alert alert-danger">{error}</div>}
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Adlog;
