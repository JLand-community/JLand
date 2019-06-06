import React from 'react';
import {Route, Redirect} from 'react-router-dom';

const PrivateRoute = ({component: Component, authInfo, role, ...rest}) => (

    <Route
        {...rest}
        render={   props => {
            console.log(" PrivateRoute authInfo", authInfo);    
            if (!authInfo.isLoggedIn) {
                console.log(" Redirect to /login", authInfo);   
                return <Redirect to={{pathname: "/login", state: {from: props.location}}}/>
            }

            if (role && role.indexOf(authInfo.role) === -1) {
                 props.history.goBack();
             }
            return <Component {...props} />
        }
        }
    />
);

export default PrivateRoute;