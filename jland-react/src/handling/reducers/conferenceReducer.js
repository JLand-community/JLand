import {GET_UPCOMING_CONFERENCE} from '../actions/type';


const initialState = {};

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_UPCOMING_CONFERENCE:
            return action.payload;
        default:
            return state;

    }
}