import React from 'react'

export default function CoffeeAgendaEvent({event}) {
    return (
        <li className="agenda__item welcome-info--decoration">
            <p className="agenda__item-time">{event.startTime + ' - ' + event.endTime}</p>

            <img src={require(`../../img/coffee.png`)} className="agenda__item--img-coffee" alt=""/>

            <div className="agenda__item-title">
                <div className="agenda__item-title--coffe">{event.name}</div>
            </div>
         </li>
    )
}
