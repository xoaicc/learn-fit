import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const KOREAN = {
  '여자': 'woman',
  '남자': 'man',
  '사람': 'person',
  '나무': 'tree',
  '호수': 'lake',
  '구름': 'cloud',
  '땅': 'ground'
};

ReactDOM.render(
  <React.StrictMode>
    <App words={KOREAN} numOfWords={Object.keys(KOREAN).length} />
  </React.StrictMode>,
  document.getElementById('main')
);

reportWebVitals();