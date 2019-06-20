import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from "react-redux";
import store from './handling/store';
import App from './App';
import './css/index.css';
import '@fortawesome/fontawesome-free/css/all.css';

ReactDOM.render(<Provider store={store}>
    <App />
</Provider>, document.getElementById('app'));

