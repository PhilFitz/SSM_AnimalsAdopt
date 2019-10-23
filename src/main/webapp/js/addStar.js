window.onload = function() {
	onTest();
}

var name = false,
	address = false,
	phone = false,
	type = false;

function onTest() {
	nameTest();
	addressTest();
	phoneTest();
	typeTest();
}

function nameTest() {
	var nameInput = document.getElementById("name"); //名称
	var tipSpan = document.getElementById("name_tip"); // 提示
	var nameStr = null; //  输入的内容
	nameInput.onfocus = function() {
		change(tipSpan, nameInput, "#ccc", nametips.begin);
	}
	nameInput.onblur = function() {
		nameStr = nameInput.value;
		if (nameStr == "") {
			change(tipSpan, nameInput, "red", nametips.air);
			name = false;
		} else if (nameStr.length <= 2 || nameStr.length >= 16) {
			change(tipSpan, nameInput, "red", nametips.wrong);
			name = false;
		} else {
			change(tipSpan, nameInput, "green", nametips.ok);
			name = true;
		}
	}
}

function addressTest() {
	var addressInput = document.getElementById("address");
	var tipSpan = document.getElementById("address_tip");
	var addressStr = null; //  输入的内容
	addressInput.onfocus = function() {
		change(tipSpan, addressInput, "#ccc", addresstips.begin);
	}
	addressInput.onblur = function() {
		addressStr = addressInput.value;
		if (addressStr == "") {
			change(tipSpan, addressInput, "red", addresstips.air);
			address = false;
		} else if (addressStr.length < 6 || addressStr.length > 12) {
			change(tipSpan, addressInput, "red", addresstips.wrong);
			address = false;
		} else {
			change(tipSpan, addressInput, "green", addresstips.ok);
			address = true;
		}
	}
}


function phoneTest() {
	var phoneInput = document.getElementById("phone");
	var tipSpan = document.getElementById("phone_tip");
	var phoneStr = null; //  输入的内容
	phoneInput.onfocus = function() {
		change(tipSpan, phoneInput, "#ccc", phonetips.begin);
	}
	phoneInput.onblur = function() {
		phoneStr = phoneInput.value;
		if (phoneStr == "") {
			change(tipSpan, phoneInput, "red", phonetips.air);
			phone = false;
		} else if (phoneStr.length != 11 || isNaN(phoneStr)) {
			change(tipSpan, phoneInput, "red", phonetips.wrong);
			phone = false;
		} else {
			change(tipSpan, phoneInput, "green", phonetips.ok);
			phone = true;
		}
	}
}

function typeTest() {
	var typeInput = document.getElementById("type");
	var tipSpan = document.getElementById("type_tip");
	var typeStr = null; //  输入的内容
	typeInput.onfocus = function() {
		change(tipSpan, typeInput, "#ccc", typetips.begin);
	}
	typeInput.onblur = function() {
		typeStr = typeInput.value;
		if (typeStr == "") {
			change(tipSpan, typeInput, "red", typetips.air);
			type = false;
		} else {
			change(tipSpan, typeInput, "green", typetips.ok);
			type = true;
		}
	}
}


function submitTest() {
	var submitBtn = document.getElementById("submit");
	submitBtn.onclick = function() {
		if (name && phone && address && type) {
			alert("全部合格~！");
			return true;
		} else {
			alert("检查一下，还有错误哦~");
			return false;
		}
	}

}

/*必须包含一个并且只有一个符号@ 
第一个字符不能是'@'或者'.' 
不允许出现'@.'或者'.@'或者'-@'或者'@-' 
结尾不得是字符'@'或者'.' 
字符@后面只能是'a-za-z0-9'*/

function isEmail(str) {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}

function change(tipSpan, Input, color, tip) {
	Input.style.borderColor = color;
	tipSpan.style.color = color;
	tipSpan.innerHTML = tip;
}