import React, {Component} from 'react'

import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import { register, unregister } from '../../handling/actions/userActions';
import NotGoButton from './userGo/NotGoButton';
import GoButton from './userGo/GoButton';


class UserGo extends Component {

    onSubmit = (event) => {
        event.preventDefault();
        const {user, upcomingConference} = this.props;
        const isParticipant = !(user.participantId === 0);
        if(isParticipant) {
            this.props.unregister(user.id, upcomingConference.id);
           
        } else {
            this.props.register(user.id, upcomingConference.id);
           
        }
    }

   render () {

        const { user } = this.props;

        const  isParticipant = !(user.participantId === 0);

        let photo = "default.png";
        if (JSON.stringify(user) !== "{}") {
            photo = "default" === user.photo ? photo :
            user.lastName + user.firstName + ".png";
        }
                      
    return (
            <div className="user">
                <div className="user__grid user--decoration">
                    
                     <img src={require(`../../img/users/${photo}`)} 
                        alt="User avatar" 
                        className="user__avatar user__avatar--resize"/> 
                   
        
                    <div className="user__name">{user.firstName + ' ' + user.lastName}</div>

                        <form className="register" onSubmit={this.onSubmit}>
                                {isParticipant && <NotGoButton/>}
                                {!isParticipant && <GoButton/>}
                        </form>  
                                                                     
                </div>
            </div>
    )
}
}
UserGo.prototypes = {
    register: PropTypes.func.isRequired,
    unregister: PropTypes.func.isRequired, 
    user: PropTypes.object.isRequired,
    upcomingConference: PropTypes.object.isRequired,
};


const mapStateToProps = store => ({
    user: store.user.info,
    upcomingConference: store.upcomingConference
});


export default connect(mapStateToProps, { register, unregister })(UserGo);




