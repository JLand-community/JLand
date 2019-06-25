import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {login} from '../../../handling/actions/userActions';

import HeaderLoginPage from './HeaderLoginPage';

import "../../../css/login.css";

class LoginForm extends Component {

    state = {
        username: "",
        password: "",
    };

    onChange = (e) => {
        this.setState({[e.target.name]: e.target.value})
    };

    onSubmit = (e) => {
        e.preventDefault();
        this.props.login(this.state, this.props.history);    
    };

    render() {

        return (
            <div className="login-grid">
                    
                    <HeaderLoginPage/>

                    <div className="login">
                        <div className="login__title">
                            <h3 className="title">Login Form</h3>
                            <h3 className="sign-up">
                                <a href="/">Sing Up</a>
                            </h3>
                        </div>

                        <form onSubmit={this.onSubmit} className="login__form">

                            <div className="usernameBox inputBox">
                                <input type="text" className="login__input"
                                    id="username" 
                                    name="username" 
                                    required
                                    value={this.state.username}
                                    onChange={this.onChange}/>
                                <label htmlFor="username" className="login__label">Username</label>
                            </div>

                            <div className="passwordBox inputBox">
                                <input type="password" className="login__input"
                                    id="passwordField" 
                                    name="password" 
                                    required
                                    value={this.state.password}
                                    onChange={this.onChange}/>
                                <label htmlFor="passwordField" className="login__label">Password</label>
                            </div>

                            <button type="submit" className="login__button">Login</button>
                        </form>
                    </div>
            </div>
        )
    }

}

LoginForm.prototypes = {
    login: PropTypes.func.isRequired,
};

const mapStateToProps = store => ({
    user: store.user
});

export default connect(mapStateToProps, {login})(LoginForm);

