import React from 'react'

import styles from '../../../css/headerLoginPage.module.css';
import LogoFragment from '../LogoFragment';

export default function HeaderLoginPage() {
    return (
        <header className={styles.header}>
            <div className={styles.logo}>
                <LogoFragment/>
            </div>
        </header>
    )
}