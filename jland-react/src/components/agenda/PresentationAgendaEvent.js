import React, { Component } from 'react'

import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import {getPresentationPlan} from '../../handling/actions/agendaActions';

import PresentationPlan from './PresentationPlan';

class PresentationAgendaEvent extends Component {

    state = {
        isPresentationPlanOpened: false,
        presentationPlan: []
    }

componentWillReceiveProps(nextProps) {

    const {isPresentationPlanOpened, presentationPlan} = nextProps.event;

    this.setState({
        isPresentationPlanOpened,
        presentationPlan
    })
}

    openPresentationPlan = (presentationId) => {

        const {isPresentationPlanOpened} = this.state;

        if(isPresentationPlanOpened){
            this.setState({
                isPresentationPlanOpened: false,
                presentationPlan: []
            })
        } else {
            this.props.getPresentationPlan(presentationId);
        }

    }

    render() {
    
        const { isPresentationPlanOpened, presentationPlan } = this.state;
        const {event} = this.props;
        return (
            <li className="agenda__item welcome-info--decoration agenda__item--presentation-hover">

                <p className="agenda__item-time">{event.startTime + ' - ' + event.endTime}</p>

                <div className="agenda__item-title">
                    <p className="presentation__name">{event.presentationName}</p>
                    <p className="presentation__presenter">{"@ " + event.userFirstName + " " + event.userLastName}</p>
                </div>


                <div className="presentation__dropdown" onClick={() => this.openPresentationPlan(event.presentationId)}>
                    <i className="fas fa-scroll presentation__icon"></i>
                </div>

                {isPresentationPlanOpened && <PresentationPlan items={presentationPlan}/>}

            </li>
        )
    }
}

PresentationAgendaEvent.prototypes = {
    getPresentationPlan: PropTypes.func.isRequired,
};


export default connect(null, {getPresentationPlan})(PresentationAgendaEvent);

