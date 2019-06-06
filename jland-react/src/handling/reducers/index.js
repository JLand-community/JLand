import {combineReducers} from 'redux';

import userReduser from './userReduser';
import conferenceReducer from './conferenceReducer';

export default combineReducers({
    user: userReduser,
    upcomingConference: conferenceReducer

}); 