var socket = io.connect('http://localhost:8080', {'forceNew': true});

socket.on('notification', function(data){
	console.log(data);
	render(data);
});

function render (data) {

	//for batekin ein leike baina honekin garbixaua geratzen da
	var notify = $.notify(`<strong>${data.text}</strong> Do not close this page...`, {
	type: 'success',
	allow_dismiss: false,
	showProgressbar: true
});

setTimeout(function() {
	notify.update('message', `<strong>${data.text}</strong> Page Data.`);
}, 1000);

setTimeout(function() {
	notify.update('message', `<strong>${data.text}</strong> User Data.`);
}, 2000);

setTimeout(function() {
	notify.update('message', `<strong>${data.text}</strong> Profile Data.`);
}, 3000);

setTimeout(function() {
	notify.update('message', `<strong>${data.text}</strong> for errors.`);
}, 4000);
setTimeout(function() {
	notify.update('message', `<strong>Txanpi</strong> mongolo.`);
}, 5000);

}

function addMessage(e){
	var payload = {
		text: document.getElementById("text").value
	};
	socket.emit('new-message', payload);
	return false;
}