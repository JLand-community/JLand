import React, {Component} from "react";
import {Router, Route, Redirect, Switch} from "react-router-dom";


import Home from "./components/Home";

import LoginForm from "./components/app/login/LoginForm";
import Header from "./components/app/Header";
import Participants from "./components/Participants";
import Footer from './components/app/Footer';

import GoUpButton from './components/app/GoUpButton';

import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import {history} from "./util/history";

class App extends Component {
    
    render() {
 
       const { isLoggedIn } = this.props.authInfo;     
        return (

            <Router history={history}>
                {
                    !isLoggedIn ? (
                        <Switch>
                            <Route exact path="/login" component={LoginForm}/>
                            <Redirect to="/login" />
                      </Switch>
                    ) : (
                        <div className="main-grid">
                            <Header history={history}/>

                            <Switch>
                                <Route exact path="/conferences/upcomingConference" component={Home} />
                            
                                <Route exact path={`/conferences/upcomingConference/participants`} 
                                                component={Participants}/>
                                <Route exact path="/" render={() => <Redirect to="/conferences/upcomingConference" />} />
                            </Switch>
                            
                            <Footer/>
                            <GoUpButton/> 
                        </div>
                    )
                }                     
            </Router>

        );
    }
}

App.prototypes = {
    authInfo: PropTypes.object.isRequired,
};

const mapStateToProps = store => ({
  authInfo: store.user.authInfo,
});
export default connect(mapStateToProps)(App);




