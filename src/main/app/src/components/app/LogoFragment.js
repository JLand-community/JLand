import React, {Fragment} from 'react'
import '../../css/logo.css';

export default function LogoFragment() {
    return (
        <Fragment>
            <p className="logo__letter logo__letter--j logo__letter--plaster">j</p>
            <p className="logo__letter logo__letter--l logo__letter--plaster">l</p>
            <p className="logo__letter logo__letter--amp logo--decoration">&</p>
        </Fragment>
    )
}