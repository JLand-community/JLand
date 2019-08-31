import React, { Component } from 'react';

import "../css/participants.css";

import { getAllParticipants } from "../handling/actions/particapantsActions";
import {connect} from 'react-redux';
import PropTypes from 'prop-types';

class Participants extends Component {

    componentDidMount() {
        
        this.props.getAllParticipants(this.props.conferenceId);
    }

    render() {

        const { participants } = this.props;

        return (
            <section className="participants">
                <div className="participants__grid">
                    <div className="participants__count participants--background">
                        <i className="fas fa-users participants__icon"></i>
                        <p className="participants__counter">{participants.length}</p>
                    </div>

                    <ul className="participants__list">
                        { participants.map(participant => {
                           
                            const photo = "default" === participant.photo ? "default.png" :
                                            participant.lastName + participant.firstName + ".png";
                                           
                            return <li className="participants__item participants--background" key={participant.id}>
                                    <img src={require(`../img/users/${photo}`)}
                                        alt="User avatar" className="participants__photo"/>
                                    <p className="participants__name">
                                    { participant.firstName + ' ' + participant.lastName }
                                    </p>
                                    </li>
                    
                        })}              
                    </ul>
                </div>
            </section>
        )
    }
}

Participants.prototypes = {
    getAllParticipants: PropTypes.func.isRequired,
    participants: PropTypes.array.isRequired,
    conferenceId: PropTypes.number.isRequired
};

const mapStateToProps = store => ({
    participants: store.participants,
    conferenceId: store.upcomingConference.id
});

export default connect(mapStateToProps, {getAllParticipants})(Participants);

