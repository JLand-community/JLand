import {GET_ALL_PARTICIPANTS, LOGOUT} from '../actions/type';

const initialState = [];

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_ALL_PARTICIPANTS:
            return action.payload;
        case LOGOUT:
                return [];
        default:
            return state;

    }
}