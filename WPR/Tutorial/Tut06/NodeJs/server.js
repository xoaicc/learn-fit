const http = require('http');
const server = http.createServer();

const url = require("url");

server.on('request', function (req, res) {
  const q = url.parse(req.url, true);
  const path = q.pathname;

  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');

  // we want to match a path --> do this
  if (path === "/") {
    res.end('Hello World!');
  }
  if (path === "/hello") {
    const name = q.query.name;
    if (name === undefined) {
      res.end("Hello no one!");
    }
    res.end(`Hello, ${name}!`);
  }
  if (path === "/cards") {
    if (req.method === "GET") {
      // ... get all cards
    } else if (req.method === "POST") {
      // ... create a card
    }
    // ... PUT & DELETE
  }

  // --> Vanilla NodeJS is too VERBOSE
});

server.on('listening', function(){
  console.log('Server running!');
});

server.listen(3000);
