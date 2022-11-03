import React from 'react';

import Card from './Card';
import StatusBar from './StatusBar';

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      // card list
      cards: [
        {
          word: '여자',
          definition: 'women'
        }, 
        {
          word: '남자',
          definition: 'men'
        },
        // more words here
      ],
      // the index of showing card in <card list>
      index: 0 
    };
  }

  next = () => {
    this.setState({
      ...this.state,
      index: this.state.index+1
    });
  }

  prev = () => {
    this.setState({
      ...this.state,
      index: this.state.index-1
    });
  }

  render() {
    const card = this.state.cards[this.state.index];
    
    return <div id="main">
          <Card word={card.word} definition={card.definition} />

          <StatusBar 
            currentIndex={this.state.index} 
            maxIndex={this.state.cards.length} 
            prevCallback={this.prev} 
            nextCallback={this.next} 
          />
      </div>;
  }
}

export default App;