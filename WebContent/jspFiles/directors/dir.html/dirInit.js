function hideShow(chosen) {
	$('.hidable').each(function(index) {
		if ($(this).attr("id") === chosen) {
			$(this).show();
//			$(this).attr("style", "visibility: visible");
		} else {
//			$(this).attr("style", "visibility: collapse");
			$(this).hide();
		}
	});
}
function divhide() {
	hideShow('mainDir');
	// $('.hidable').attr("style", "visibility: visible");
}


var ws = new WebSocket("ws://localhost:8080/WebBank/dir");

function newWs() {
	if (ws !== undefined && ws.readyState !== ws.CLOSED) {
		msgPost.innerHTML = "WebSocket is already opened.";
		return;
	}
	ws = new WebSocket("ws://localhost:8080/WebBank/dir");
}

ws.onmessage = function(evt) {
	onMessage(evt);
};
ws.onerror = function(evt) {
	onError(evt);
};

ws.onopen = function(evt) {
};

function doSend(msg) {
	// ws.send(msgSend.value);
	ws.send(msg);
}
function doClose() {
	ws.close();
}

function onMessage(evt) {
	// alert(evt.data);
	// console.log("received: " + evt.data);
	var jsobj = JSON.parse(evt.data);

	console.log(jsobj.head);
	var head = jsobj.head;

	switch (head) {
	case 'newEmployee':
		newEmpRes(jsobj);
		break;
	case 'empList':
		empInfoHandler(jsobj);
		break;
	case 'deleteEmployee':
		deleteEmpRes(jsobj);
		break;
	case 'alterEmployee':
		alterEmpRes(jsobj);
		break;
	case 'transaction':
		transactionHandler(jsobj);
		break;
	case 'balance':
		balanceHandler(jsobj);
		break;
	case 'error':
		errorRes(jsobj);
		break;
	}
}

function onError(evt) {
	writeResponse('<span style="color: red;">ERROR:</span> ' + evt.data);
}