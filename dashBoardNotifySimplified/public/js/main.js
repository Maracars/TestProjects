var socket = io.connect('http://localhost:8080', {'forceNew': true});

socket.on('notification', function(data){
	console.log(data);
	render(data);
});

function render (data) {

	//for batekin ein leike baina honekin garbixaua geratzen da
	var notify = $.notify(`<strong>${data.text}</strong> ek zerbait aldatu dau`, {
	type: 'success',
	offset: {
		x: 50,
		y: 50
	},
	animate: {
		enter: 'animated bounceInDown',
		exit: 'animated lightSpeedOut'
	}
});

/*setTimeout(function() {
	notify.update('message', `<strong>${data.text}</strong> Page Data.`);
}, 1000);*/



}

function addMessage(e){
	var payload = {
		text: document.getElementById("text").value
	};
	socket.emit('new-message', payload);
	return false;
}