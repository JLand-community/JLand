import axios from 'axios';
import {
    GET_AGENDA_EVENTS,
    CLEAR_AGENDA_EVENTS,
    GET_PRESENTATION_PLAN
} from './type';

export const getAgendaEvents = (conferenceId) => async dispatch => {
    axios.defaults.withCredentials = true;
    try {
        const response = await axios.get(`/conferences/${conferenceId}/agendaEvents`);
        console.log("getAgendaEvents---", response.data);
            dispatch({
                type: GET_AGENDA_EVENTS,
                payload: response.data
            });
    } catch (error) {
        console.log("getAgendaEvents errors---", error);
    }
};

export const clearAgendaEvents = () => dispatch => {
    dispatch({
        type: CLEAR_AGENDA_EVENTS
    });
};

export const getPresentationPlan = (presentationId) => async dispatch => {
    axios.defaults.withCredentials = true;
    try {
        const response = await axios.get(`/presentations/${presentationId}/presentationPlan`);
        console.log("getPresentationPlan---", response.data);

            dispatch({
                type: GET_PRESENTATION_PLAN,
                payload: { presentationId: presentationId, presentationPlan: response.data }

            });
    } catch (error) {
        console.log("getPresentationPlan errors---", error);
    }

}

