var express = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);

//Hau berez ez zan hola ingo, bakarrik probarako



app.use(express.static('public'))

app.get('/hello', function(req, res){
	res.status(200).send("Hello world!");
});

io.on('connection', function(socket) {
	console.log("batenbat konektau in da");

	socket.on('new-message', function(data){

		//Honekin konektauta daren danei esaten dotze
		io.sockets.emit('notification', data);

	});
});

server.listen(8080, function() {
	console.log("Servidor corriendo en http://localhost:8080");
});