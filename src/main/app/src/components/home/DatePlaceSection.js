import React from 'react'
import WelcomeInfo from '../datePlace/WelcomeInfo';
import Board from '../datePlace/Board';
import DatePlaceInfo from '../datePlace/DatePlaceInfo';
import UserGo from '../datePlace/UserGo';

import {connect} from 'react-redux';
import PropTypes from 'prop-types';


import {getUpcomingConference} from '../../handling/actions/conferenceActions';
import {getUser} from '../../handling/actions/userActions';

class DatePlaceSection extends React.Component  { 

    componentDidMount() {
        this.props.getUpcomingConference().then(response => {
            const upcomingConference = response.data;
            this.props.getUser(this.props.authInfo.username, upcomingConference.id);
        });
    }

    render() {
        
        console.log("DatePlaceSection render() , ", this.props);
    
        return (
            <section className="date-place ">
                <WelcomeInfo/>

                <Board/>

                <DatePlaceInfo/>

                <UserGo/>        
            </section>
        )
    }
}

DatePlaceSection.prototypes = {
    getUpcomingConference: PropTypes.func.isRequired,
    getUser: PropTypes.func.isRequired,
};

const mapStateToProps = store => ({
    authInfo: store.user.authInfo,
  });

export default connect(mapStateToProps, { getUpcomingConference, getUser }) (DatePlaceSection);
