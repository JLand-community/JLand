import axios from 'axios';
import {
    GET_ALL_PARTICIPANTS
} from './type';


export const getAllParticipants = (conferenceId) => async dispatch => {
    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "/api";
    try {
        const response = await axios.get(`/conferences/${conferenceId}/participants`);
        console.log("getAllParticipants---", response.data);
            dispatch({
                type: GET_ALL_PARTICIPANTS,
                payload: response.data
            });
    } catch (error) {
        console.log("getAllParticipants errors---", error);
    }
};