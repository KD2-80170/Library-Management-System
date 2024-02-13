import React from 'react';
import {Link, Switch, Route} from 'react-router-dom';
import NotFound from '../NotFound';
import BookOps from './BookOps'; 
const AdminDasbord = () => {
  return (
    
    <div className='container'>
              
                <hr></hr>
                    <Link to="/Book">BookData</Link> {" | "}
                    <Link to="/about">About Us</Link> {" | "}
                    <Link to="/Adminlogout">Logout</Link> {" | "}
                    <Link to="/transaction">Transactions</Link> {" | "}
                <hr></hr>
                    <Switch>
                       
                        <Route path="**" component={NotFound}/>
                    </Switch>
             </div>
  );
};

export default AdminDasbord ;