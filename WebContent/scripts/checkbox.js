function selecionarLinha(checkbox) {
    var tr = getParentNode(checkbox, "tr");

    markCheckBoxes(tr, checkbox.checked);
}

function selecionarColuna(acionador) {
    var table = getParentNode(acionador, "table");
    var td = getParentNode(acionador, "th");
    
    var coluna = td.cellIndex;

    if (!td.checked && td.checked != false) {
        td.checked = false;
    }

    var checked = !td.checked;
    td.checked = checked;

    for (var i = 0; i < table.rows.length; i++) {
        markCheckBoxes(table.rows[i].cells[coluna], checked);
    }
}

function markCheckBoxes(element, checked) {
	var inputs = element.getElementsByTagName("input");
	for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox") {
            inputs[i].checked = checked;
        }
    }
}

function getParentNode(child, nodeName) {
    var parent = child.parentNode;

    if (parent == null) {
        return null;
    }

    if (parent.nodeName.toLowerCase() == nodeName.toLowerCase()) {
        return parent;
    } else {
        return getParentNode(parent, nodeName);
    }
}