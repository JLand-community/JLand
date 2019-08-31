import axios from 'axios';
import {
    AUTHENTICATED,
    LOGOUT,
    UPDATE_USER,
} from './type';

export const login = (user, history) => async dispatch => {
    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.post('/login',
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
           
            history.push("/conferences/upcomingConference");
            
        }

    } catch (error) {
        console.log("login errors---", error);
    }

};

export const logout = (history) => async dispatch => {

    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.post('/logout');

        console.log("/logout response---", response);

       if (response.status === 200) {
            console.log("Logout successfull");
            dispatch({
                type: LOGOUT
            });
        }

        history.push("/login");


    } catch (error) {
        console.log("Logout errors---", error);
    }
};

export const getUser = (username, conferenceId) => async dispatch => {

    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.get(`/conferences/${conferenceId}/user/${username}`);
        console.log("getUser---", response.data);
            dispatch({
                type: UPDATE_USER,
                payload: response.data
            });

                    
    } catch (error) {
        console.log("getUser errors---", error);
    }

}

export const register = (userId, conferenceId) => async dispatch => {
    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.post(`/conferences/${conferenceId}/user/${userId}/participate`);
        console.log("register---", response.data);
            dispatch({
                type: UPDATE_USER,
                payload: response.data
            });

                    
    } catch (error) {
        console.log("register errors---", error);
    }

}

export const unregister = (userId, conferenceId) => async dispatch => {
    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.post(`/conferences/${conferenceId}/user/${userId}/notParticipate`);
        console.log("unregister---", response.data);
            dispatch({
                type: UPDATE_USER,
                payload: response.data
            });

                    
    } catch (error) {
        console.log("unregister errors---", error);
    }
}



const getFormData = (user) => {
    let form = new FormData();
    form.set("username", user.username);
    form.set("password", user.password);
    return form;
};

