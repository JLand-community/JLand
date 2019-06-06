import React, {Component} from 'react'

class Header extends Component {

    render () {

        const upcomingConference = {
            id: 2
        };

        return (

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
        );
    }
}

export default Header;