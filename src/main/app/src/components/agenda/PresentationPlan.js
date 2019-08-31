import React from 'react'

export default function PresentationPlan({items}) {
    return (
        <div className="presentation__plan active">
            <ul className="presentation__list">
                { 
                    items.map(item => 
                                <li className="presentation__item" key={item.id}>   
                                    <p>{item.itemName}</p>
                                </li>)
                }
            </ul>
        </div>
    )
}
