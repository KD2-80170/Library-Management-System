// App.js

import React from 'react';
import {Link, Switch, Route} from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
import Home from "./Home" ;
import About from './About';
import NotFound from "./NotFound"; 
import { Redirect } from 'react-router-dom/cjs/react-router-dom.min';
import Adlog from './Adlog';
import Adsignup from './Adsignup';
import AdminDasbord from './component/AdminDasbord';
import BookOps from './component/BookOps';
import UserDashbord from './UserDashbord'
import LogoutUser from './LogoutUser';
import Aminlogout from './component/Aminlogout';
import ShowBook from './ShowBook';
import Transaction from "./component/Transaction"
const App = () => {
  return (
    // <Router>
    //   <div>

    //     <Switch>
    //     <Route path="/">
    //         <Home />
    //       </Route>
    //       <Route path="/login">
    //         <Login />
    //       </Route>
    //       <Route path="/signup">
    //         <Signup />
    //       </Route>
    //     </Switch>
    //   </div>
    // </Router>
    <div className='container'>
              
                {/* <hr></hr>
                    <Link to="/home">Home</Link> {" | "}
                    <Link to="/about">About Us</Link> {" | "}
                    <Link to="/login">Login</Link> {" | "}
                    <Link to="/signup">Signup</Link> {" | "}
                    <Link to="/Adsignup">ADSignup</Link> {" | "}

                   
                <hr></hr> */}
                    <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route exact path="/home" component={Home}/>
                        <Route exact path="/about" component={About}/>
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/signup" component={Signup}/>
                        <Route exact path="/Adsignup" component={Adsignup}/>
                        <Route exact path="/AdminDasbord" component={AdminDasbord}/>
                        <Route exact path="/Adlog" component={Adlog}/>
                        <Route exact path="/logoutuser" component={LogoutUser}/>
                        <Route exact path="/userdashboard" component={UserDashbord}/>
                        <Route exact path="/Book" component={BookOps}/>
                        <Route exact path="/showbook" component={ShowBook}/>
                        <Route exact path="/Adminlogout" component={Aminlogout}/>
                        <Route exact path="/transaction" component={Transaction}/>
                        <Route path="**" component={NotFound}/>
                        <Redirect from="/Signup" to="/Home"/>
                    </Switch>
             </div>
  );
};

export default App;
