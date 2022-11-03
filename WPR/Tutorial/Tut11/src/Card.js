import React from 'react';

export default class Card extends React.Component {
    constructor(props) {
        super(props);

        this.state={
            showingWord: true
        };
    }

    flip = () => {
        this.setState({
            showingWord: !this.state.showingWord
        });
    }

    render() {
        return <div id="flashcard-container">
            <div className="flashcard-box" onClick={this.flip}>
            {
                this.state.showingWord ? 
                <div className="flashcard word">{this.props.word}</div> :
                <div className="flashcard definition">{this.props.definition}</div>
            }
            </div>
        </div>;
    }
}