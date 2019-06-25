import React from 'react'

export default function NotGoButton() {
    return (
        <button className="register__button register__button--active">
            <div className="register__icon--not">
                <i className="fas fa-door-open register__icon--active"></i>
                <i className="fas fa-walking  register__icon--mirror register__icon--active"></i>
            </div>
            <div className="register__button--text">Not go</div>
        </button>
    )
}
