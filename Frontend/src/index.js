import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(<BrowserRouter><App/></BrowserRouter>)

// debugger;
// root.render(<Combined/>)

// root.render(<Home />);
// root.render(<About />);

