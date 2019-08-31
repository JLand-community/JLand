import React from 'react'

class GoUpButton extends React.Component {

    state = {
        isHidden: true
    }

    componentDidMount() {
        window.addEventListener('scroll', this.handleScroll);
    }
    componentWillUnmount() {
        window.removeEventListener('scroll', this.handleScroll);
    }

    handleScroll = () => {
        if(window.pageYOffset >= 100) {
            this.setState({
                isHidden: false
            });
        } else if(window.pageYOffset === 0 ) {
            this.setState({
                isHidden: true
            });
        }
    }

    onClick = () => {
        window.scrollTo(0, 0);
    }

    render() {

        const { isHidden } = this.state;
        const button = <button id="goUpButton" onClick={this.onClick} title="Back to up" className="button-go-up">
                            <i className="fas fa-angle-up button-go-up__icon"></i>
                        </button>
        return (
           
            !isHidden && button
                
        )
    }  
}

export default GoUpButton;
