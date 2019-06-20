import axios from 'axios';
import {
    GET_UPCOMING_CONFERENCE
} from './type';

export const getUpcomingConference = () => async dispatch => {
    axios.defaults.withCredentials = true;
    try {
        const response = await axios.get('/conferences/upcomingConference');
        
        console.log("getUpcomingConference---", response.data.id);
            dispatch({
                type: GET_UPCOMING_CONFERENCE,
                payload: response.data
            });

        return response;
    } catch (error) {
        console.log("getUpcomingConference errors---", error);
    }

};

