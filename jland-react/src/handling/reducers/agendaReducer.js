import {GET_AGENDA_EVENTS, CLEAR_AGENDA_EVENTS, GET_PRESENTATION_PLAN} from '../actions/type';


const initialState = [];

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_AGENDA_EVENTS:
            return action.payload;
        case CLEAR_AGENDA_EVENTS:
            return [];
        case GET_PRESENTATION_PLAN:
            return state.map(event => {
                   if(event.type === "Presentation" && event.presentationId === action.payload.presentationId) {
                       return {...event, presentationPlan: action.payload.presentationPlan, isPresentationPlanOpened: true}
                   } else {
                       return event
                   }
            })
        
        default:
            return state;

    }
}