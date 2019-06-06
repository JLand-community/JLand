import axios from 'axios';
import {
    GET_UPCOMING_CONFERENCE
} from './type';
import {apiUrl} from '../../util/network';

export const getUpcomingConference = () => async dispatch => {
    axios.defaults.withCredentials = true;
    try {
        const response = await axios.get(apiUrl('/conferences/upcomingConference'));
        console.log("getUpcomingConference---", response.data);
            dispatch({
                type: GET_UPCOMING_CONFERENCE,
                payload: response.data
            });
    } catch (error) {
        console.log("login errors---", error);
    }

};

