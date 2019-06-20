
import React, {Component} from 'react';
import headerStyles from '../../css/header.module.css';
import LogoFragment from './LogoFragment';

import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import {Role} from '../../util/roles';

import {NavLink} from 'react-router-dom'


class Header extends Component {

    render () {

        const isAdmin =  this.props.currentUserRole === Role.Admin;
        const allRequestsMenuLink = <li className={headerStyles["menu__item"]} >
                                        <NavLink to="/allRequests" 
                                                className={headerStyles["menu__link"]}
                                                activeClassName={headerStyles["menu__link--active"]}>All Requests
                                        </NavLink>
                                    </li>;

        return (
          
            <header className={headerStyles["header"]}>
            <input type="checkbox" id="nav-toggle-input" className={headerStyles["nav-toggle__input"]}/>
            <nav className={headerStyles["nav-bar"]}>
                <ul className={headerStyles["menu"]}>
                    <li className={headerStyles["menu__item"]}>
                         <NavLink to="/conferences/upcomingConference" 
                         className={headerStyles["menu__link"]}
                         activeClassName={headerStyles["menu__link--active"]}>Home</NavLink>
                    </li>
                    <li className={headerStyles["menu__item"]}>
                    
                        {/* <NavLink to="{`/user/${user.id}/applyForPresentation`}" 
                         className={headerStyles["menu__link"]}
                         activeClassName={headerStyles["menu__link--active"]}>Apply for presentation</NavLink> */}

                        <NavLink to="" 
                         className={headerStyles["menu__link"]}
                         >Apply for presentation</NavLink>

                    </li>
                    <li className={headerStyles["menu__item"]}>
                        <NavLink to={`/conferences/upcomingConference/participants`}
                            className={headerStyles["menu__link"]}
                            activeClassName={headerStyles["menu__link--active"]}>Participants</NavLink>
                    </li>

                    { isAdmin && allRequestsMenuLink }    
                    
                </ul>
                <form className={headerStyles["logout"]} onSubmit={this.onSubmitLogout}>
                    <button type="submit" className={headerStyles["logout__button"]} title="Logout">
                        <i className={["fas fa-sign-out-alt",  headerStyles["logout__icon"]].join(' ')}></i>
                    </button>
                </form>
            </nav>

            <div className={headerStyles.logo}>
                <LogoFragment/>
            </div>
        
            <label htmlFor="nav-toggle-input" className={headerStyles["nav-toggle__label"]}>
                <i className={["fas fa-bars", headerStyles["nav-toggle-label__icon"]].join(" ")}></i>
            </label>
        </header>

            
        );
    }
}

Header.prototypes = {
    currentUserRole: PropTypes.string.isRequired,
    user: PropTypes.object.isRequired,
};

const mapStateToProps = store => ({
    currentUserRole: store.user.authInfo.role,
    user: store.user.info, 
})

export default connect(mapStateToProps) (Header);