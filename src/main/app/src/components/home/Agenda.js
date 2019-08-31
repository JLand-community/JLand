import React, { Component } from 'react'

import {getAgendaEvents, clearAgendaEvents} from '../../handling/actions/agendaActions';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';

import CoffeeAgendaEvent from '../agenda/CoffeeAgendaEvent';
import PresentationAgendaEvent from '../agenda/PresentationAgendaEvent';

class Agenda extends Component {

    state = {
        isAgendaListOpened: false
    }

    onClick = () => {

        if(this.state.isAgendaListOpened) {

            this.props.clearAgendaEvents();

            this.setState({
                isAgendaListOpened: false
            })
        } else {

            this.props.getAgendaEvents(this.props.conferenceId);

            this.setState({
                isAgendaListOpened: true
            })
        }
        
    }
    
    
    render() {

        const { isAgendaListOpened } = this.state; 

        const events = this.props.events;

        const agendaList = <ul className="agenda__list active" id="agendaList">
                        {events.map(event => {
                            if(event.type === "Coffee") {
                                return <CoffeeAgendaEvent event={event} key={event.id} />
                            } else {
                                return <PresentationAgendaEvent event={event} key={event.id} />
                            }
                        })}
                        </ul>

        return (
            <section className="agenda">

                <div className="agenda__header agenda__header--decoration">
                    <h1 className="agenda__header--title ">Agenda</h1>
                    
                    <div className="agenda__dropdown" id="dropdownForAgenda" onClick={() => this.onClick()}>
                        <i className="fas fa-scroll agenda__icon" title="Agenda details"></i>
                    </div>
                </div>

                { isAgendaListOpened && agendaList }

            </section>

        )
    }
}

Agenda.prototypes = {
    getAgendaEvents: PropTypes.func.isRequired,
    clearAgendaEvents: PropTypes.func.isRequired,
    events: PropTypes.array.isRequired,
    conferenceId: PropTypes.number.isRequired,
};

const mapStateToProps = store => ({
    events: store.events,
    conferenceId: store.upcomingConference.id,
});

export default connect(mapStateToProps, {getAgendaEvents, clearAgendaEvents})(Agenda);

