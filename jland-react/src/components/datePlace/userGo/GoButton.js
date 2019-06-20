import React from 'react'

export default function GoButton() {
    return (
        <button className="register__button register__button--active">
            <div className="register__button--text">Go</div>
            <div className="register__icon--go">
                <i className="fas fa-walking register__icon--active"></i>
                <i className="fas fa-door-open register__icon--mirror register__icon--active"></i>
            </div>
        </button>
    )
}
