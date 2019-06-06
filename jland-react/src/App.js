import React, {Component} from "react";
import {Router, Route} from "react-router-dom";


import Home from "./components/Home";

import LoginForm from "./components/LoginForm";


import PrivateRoute from "./components/PrivateRoute";
import {connect} from 'react-redux';
import {history} from "./util/history";

class App extends Component {

    render() {



        console.log("App authInfo", this.props.authInfo);

        return (

            <Router history={history}>
                    <PrivateRoute exact path="/conferences/upcomingConference" component={Home} 
                                  authInfo={this.props.authInfo}/>
                    <Route exact path="/login" component={LoginForm}/>
                  
            </Router>

        );
    }
}

const mapStateToProps = store => ({
  authInfo: store.user.authInfo
});
export default connect(mapStateToProps)(App);

