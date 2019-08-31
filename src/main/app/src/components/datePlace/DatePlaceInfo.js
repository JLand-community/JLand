import React, {Component} from 'react'

import {connect} from 'react-redux';
import PropTypes from 'prop-types';



class DatePlaceInfo extends Component {

    render() {

        const { date, address } = this.props.upcomingConference;

        return (
            <div className="date-place__item ">
            <div className="date-place__item--grid">
                <div className="date-place__info">Next Java Community is going to be:</div>
                <div className="date-and-place__when">
                    <span>{date}</span>
                    
                </div>
                <div className="date-and-place__where">
                <span>{address}</span>
                
                    <a href="/" className="date-and-place__link" title="Map link">
                        <i className="fas fa-map-marker-alt date-and-place__map-icon--size"></i>
                    </a>
                </div>
            </div>
        </div>
        )
    }
}


DatePlaceInfo.prototypes = {
    upcomingConference: PropTypes.object.isRequired,
};

const mapStateToProps = store => ({
    upcomingConference: store.upcomingConference
});

export default connect(mapStateToProps) (DatePlaceInfo);


