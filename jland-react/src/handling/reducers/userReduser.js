import {AUTHENTICATED, LOGOUT, GET_USER} from '../actions/type';

const initialState = {
    authInfo:{},
    info: {}
};

export default function (state = initialState, action) {
    switch (action.type) {
        case AUTHENTICATED:
            return {...state, authInfo: action.payload };
        case LOGOUT:
            return {authInfo: action.payload, info: {}};
        case GET_USER:
                return {...state, info: action.payload};
        default:
            return state;

    }
}