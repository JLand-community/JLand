import axios from 'axios';
import {
    AUTHENTICATED,
    LOGOUT,
    GET_USER
} from './type';
import {apiUrl} from '../../util/network';

export const login = (user, history) => async dispatch => {
    axios.defaults.withCredentials = true;
    try {
        const response = await axios.post(apiUrl('/login'),
            getFormData(user),
            {headers: {'Content-Type': 'multipart/form-data'}}
        );

        if (response.status === 200) {
            console.log("Login successfull");
            const authInfo = {
                username: user.username,
                role: response.data,
                isLoggedIn: true}
            dispatch({
                type: AUTHENTICATED,
                payload: authInfo
            });
            console.log("user actions login ---1")
            history.push("/conferences/upcomingConference");
            console.log("user actions login ---2 after history.push(/conferences/upcomingConference);")
        }


    } catch (error) {
        console.log("login errors---", error);
    }

};

export const getUser = (username, confetenceId) => dispatch => {

        const currentUser = {
            id: "1",
            lastName: "lastName",
            firstName: "firstName",
            photo: "default.png",
            isParticipated: false,
        }
            dispatch({
                type: GET_USER,
                payload: currentUser
            });

}

export const logout = () => async dispatch => {

    axios.defaults.withCredentials = true;
    try {
        const response = await axios.post(apiUrl('/logout'));
        console.log(response);
        if (response.status === 200) {
            console.log("Logout successfull");
            dispatch({
                type: LOGOUT,
                payload: {username: "", role: "", loggedIn: false}
            });
        }


    } catch (error) {
        console.log(error);
    }
};

const getFormData = (user) => {
    let form = new FormData();
    form.set("username", user.username);
    form.set("password", user.password);
    return form;
};

