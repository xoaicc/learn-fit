import React from "react";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      index: 1,
      showingWord: true
    };
  }

  getCardContent(index) {
    const word = Object.keys(this.props.words)[index - 1];
    return [word, this.props.words[word]];
  }

  next = () => {
    if (this.state.index <= 6) {
      this.setState({
        index: this.state.index + 1,
        showingWord: true
      });
    }
  }

  prev = () => {
    if (this.state.index > 1) {
      this.setState({
        index: this.state.index - 1,
        showingWord: true
      });
    }
  }

  flip = () => this.setState({ showingWord: !this.state.showingWord })

  render() {
    const [word, definition] = this.getCardContent(this.state.index);
    return (
      <>
        <div id="flashcard-container">
          <div class="flashcard-box" onClick={this.flip}>
            {this.state.showingWord && <div class="flashcard word">{word}</div> || <div class="flashcard definition">{definition}</div>}
          </div>
        </div>

        <div id="status-bar">
          <button onClick={this.prev}
            disabled={this.state.index === 1}
            id="prev">&larr;</button>
          <strong>{this.state.index}</strong>/<span>{this.props.numOfWords}</span>
          <button onClick={this.next}
            disabled={this.state.index === this.props.numOfWords}
            id="next">&rarr;</button>
        </div>
      </>
    )
  }
}
export default App;