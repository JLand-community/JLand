import {combineReducers} from 'redux';

import userReducer from './userReducer';
import conferenceReducer from './conferenceReducer';
import agendaReducer from './agendaReducer';
import participantsReducer from './participantsReducer';

export default combineReducers({
    user: userReducer,
    upcomingConference: conferenceReducer,
    events: agendaReducer,
    participants: participantsReducer,
}); 