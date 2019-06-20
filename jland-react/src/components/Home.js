import React, { Fragment } from 'react'

import "../css/mainpage.css";

import Agenda from './home/Agenda';
import DatePlaceSection from './home/DatePlaceSection';

export default function Home() {
    return (
        <Fragment>

            <DatePlaceSection/>

            <Agenda />
                
        </Fragment>
    )
}


