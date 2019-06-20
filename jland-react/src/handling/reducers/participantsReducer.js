import {GET_ALL_PARTICIPANTS} from '../actions/type';

const initialState = [];

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_ALL_PARTICIPANTS:
            return action.payload;
        default:
            return state;

    }
}