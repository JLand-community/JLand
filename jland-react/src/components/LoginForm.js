import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {login} from '../handling/actions/userActions';

import '../css/mainpage.css';
import '../css/login.css';

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
                    <header className="header">
                        <div className="logo">
                            <p className="logo__letter logo__letter--j logo__letter--plaster">j</p>
                            <p className="logo__letter logo__letter--l logo__letter--plaster">l</p>
                            <p className="logo__letter logo__letter--amp logo--decoration">&</p>
                        </div>
                    </header>

                    <div className="login">
                        <div className="login__title">
                            <h3 className="title">Login Form</h3>
                            <h3 className="sign-up">
                                <a href="/">Sing Up</a>
                            </h3>
                        </div>

                        <form onSubmit={this.onSubmit}>

                            <div className="usernameBox inputBox">
                                <input type="text" 
                                    id="username" 
                                    name="username" 
                                    required
                                    value={this.state.username}
                                    onChange={this.onChange}/>
                                <label htmlFor="username">Username</label>
                            </div>

                            <div className="passwordBox inputBox">
                                <input type="password" 
                                    id="passwordField" 
                                    name="password" 
                                    required
                                    value={this.state.password}
                                    onChange={this.onChange}/>
                                <label htmlFor="passwordField">Password</label>
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

export default connect(null, {login})(LoginForm);

