import {GET_UPCOMING_CONFERENCE, LOGOUT} from '../actions/type';


const initialState = {};

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_UPCOMING_CONFERENCE:
            return action.payload;
        case LOGOUT:
                return {};    
        default:
            return state;

    }
}