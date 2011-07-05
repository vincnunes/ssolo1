
function chang(Event) {
	
	if(!isENTER(Event)){
		return;
	}
	
	var input = null;
	if (Event.target) input = Event.target;
	else if (Event.srcElement) input = Event.srcElement;
	
	var form = null;
	var quoi = input;
	
	while(quoi != null){
		quoi = quoi.parentNode;
		if(quoi && quoi.tagName == "FORM"){
			form = quoi;
			break;
		}
	}
	
	if (form != null) {
		for (var i = 0; i < form.elements.length; i++){
			var e = form.elements[i];
			if(e != input) {
				continue;
			}
			
			var count = 0;;
			for(var j = i+1; j < form.elements.length; j++){
				var f = form.elements[j];
				var type = f.type;
				if((f.tagName.toUpperCase() == "INPUT" && type == "text")
							|| f.tagName.toUpperCase() == "TEXTAREA"){
					
					f.focus();
					if(f.setSelectionRange) {
						f.focus();
						f.setSelectionRange(0,f.value.length);
					} else if (f.createTextRange) {
						var range = f.createTextRange();
						range.collapse(true);
						range.moveEnd('character', 0);
						range.moveStart('character', f.value.length);
						range.select();
					}
					break;
				} else if (f.tagName.toUpperCase() == "INPUT" && (type == "radio" || type == "checkbox")){
					f.focus();
					break;
				} else if (f.tagName.toUpperCase() == "SELECT") {
					f.focus();
					break;
				} else if (j == form.elements.length-1 && count == 0) {
					j = 0;
					count++;
				}
			}
			
			break;
		}
	}
}
 
function isENTER(Event) {

	// Event appears to be passed by Mozilla
	// IE does not appear to pass it, so lets use global var
	if(Event==null) {
		Event=event;
	}
	var key = Event.keyCode;

	if(key == '13') return true;
	else return false;
}

function addLoadEvent(load) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = load;
	} else {
		window.onload = function() {
			if (oldonload) { oldonload(); }
			load();
		};
	}
}

function carregar() {
	
	var inputs = document.getElementsByTagName('input');
	for(var i = 0; i < inputs.length; i++) {
		var type = inputs[i].type;
		if (type == "text" || type == "radio" || type == "checkbox") {
			inputs[i].onkeypress = chang;
		}
	}
	
	inputs = document.getElementsByTagName('select');
	for(var i = 0; i < inputs.length; i++) {
		inputs[i].onkeypress = chang;
	}
}

addLoadEvent(carregar);
