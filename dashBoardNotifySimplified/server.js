
//Bihar dan konfigurazinua config.js fitxategixan dago, biharren arabera aldatu
var config = require('./config');

var pg = require('pg');


var express = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);

//Hau berez ez zan hola ingo, bakarrik probarako

app.use(express.static('public'));


var pool = new pg.Pool(config.db);

pool.connect( function(err, client) {
  if(err) {
    console.log(err);
  }
  client.on('notification', function(msg) {

  	
    console.log(msg);

  	io.sockets.emit('notification', {text: msg.payload});

  });
  var query = client.query("LISTEN delayNotify");
});


io.on('connection', function(socket) {
	console.log("batenbat konektau in da");

	socket.on('new-message', function(data){

		//Honekin konektauta daren danei esaten dotze
		console.log(data);
		io.sockets.emit('notification', data);

	});
});

server.listen(8080, function() {
	console.log("Servidor corriendo en http://localhost:8080");
});