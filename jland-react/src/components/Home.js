import React, {Component } from 'react'

import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import {getUpcomingConference} from '../handling/actions/conferenceActions';
import {getUser} from '../handling/actions/userActions';


class Home extends Component {

    componentDidMount() {
        this.props.getUpcomingConference()
        const {user, upcomingConference} = this.props;
        this.props.getUser(user.authInfo.username, upcomingConference.id)
    }
    
    render() {
        const {upcomingConference, user} = this.props;

        const NotGoButton = <button type="submit" className="register__button register__button--active">
                                <div className="register__icon--not">
                                    <i className="fas fa-door-open register__icon--active"></i>
                                    <i className="fas fa-walking  register__icon--mirror register__icon--active"></i>
                                </div>
                                <div className="register__button--text">Not go</div>
                            </button>

        const GoButton = <button type="submit" className="register__button register__button--active">
                            <div className="register__button--text">Go</div>
                            <div className="register__icon--go">
                                <i className="fas fa-walking register__icon--active"></i>
                                <i className="fas fa-door-open register__icon--mirror register__icon--active"></i>
                            </div>
                        </button>                     

        return (
            <div className="main-grid">
                <header className="header">
                    <input type="checkbox" id="nav-toggle-input" className="nav-toggle__input"/>
                    <nav className="nav-bar">
                        <ul className="menu">
                            <li className="menu__item"><a href="/home" className="menu__link menu__link--active ">Home</a></li>
                            <li className="menu__item"><a href="/applyForPresentation" className="menu__link">Apply for presentation</a></li>
                            <li className="menu__item"><a href={`/conferences/${upcomingConference.id}/participants`}            
                                                    className="menu__link">Participants</a></li>
                            <li className="menu__item" ><a href="/allRequests" className="menu__link">All Requests</a></li>
                        </ul>
                        <form className="logout" onSubmit={this.onSubmitLogout}>
                            <button type="submit" className="logout__button" title="Logout">
                                <i className="fas fa-sign-out-alt logout__icon"></i>
                            </button>
                        </form>
                    </nav>

                    <div className="logo ">
                        <p className="logo__letter logo__letter--j logo__letter--plaster">j</p>
                        <p className="logo__letter logo__letter--l logo__letter--plaster">l</p>
                        <p className="logo__letter logo__letter--amp logo--decoration">&</p>
                    </div>

                    <label htmlFor="nav-toggle-input" className="nav-toggle__label">
                        <i className="fas fa-bars nav-toggle-label__icon"></i>
                    </label>
                </header>

                <section className="date-place ">
                    <div className="welcome-info welcome-info--decoration">
                        <h1>You can, you should, and if you are brave enough to start, you will</h1>
                    </div>

                    <div className="date-place__board">
                        <img src="../src/img/whiteboard2fhd.png" alt="" className="date-place__board--size"/>
                    </div>

                    <div className="date-place__item ">
                        <div className="date-place__item--grid">
                            <div className="date-place__info">Next Java Community is going to be:</div>
                            <div className="date-and-place__when">
                                <span>{upcomingConference.date}</span>
                                
                            </div>
                            <div className="date-and-place__where">
                            <span>{upcomingConference.address}</span>
                               
                                <a href="/" className="date-and-place__link" title="Map link">
                                    <i className="fas fa-map-marker-alt date-and-place__map-icon--size"></i>
                                </a>
                            </div>
                        </div>

                    </div>

                    <div className="user ">
                        <div className="user__grid user--decoration">
                            <img src={`../src/img/users/${user.info.photo}`} alt="User avatar" className="user__avatar user__avatar--resize"/>
                            
                            <div className="user__name" text={user.info.firstName + ' ' + user.info.lastName}>UserName UserLastName</div>
                            
                            <form  className="register">
                            {user.info.isParticipant && NotGoButton}
                            {!user.info.isParticipant && GoButton}
                            </form>
                        </div>
                    </div>
                </section>

                <section className="agenda">Agenda</section>

                <footer className="footer">
                    <p className="footer__item"><i className="far fa-copyright footer__icon"></i>2019 JLand. Copyright notice</p>

                </footer>


          
            </div>
        )
    }
}

Home.prototypes = {
    getUpcomingConference: PropTypes.func.isRequired,
    getUser: PropTypes.func.isRequired,
    upcomingConference: PropTypes.object.isRequired,
    user: PropTypes.object.isRequired,
};

const mapStateToProps = store => ({
    upcomingConference: store.upcomingConference,
    user: store.user
});

export default connect(mapStateToProps, {getUpcomingConference, getUser})(Home);
