<<<<<<< HEAD
﻿var currentCoinValue = 0;
var itemPrice = document.getElementById('priceText').innerHTML;

function insertCoin(event){
	console.log(event.keyCode||event.which);
	switch(event.keyCode||event.which)
	{
		case 65: case 97: currentCoinValue+=1; break; //A键
		case 83: case 115: currentCoinValue+=0.5; break; //S键
		case 68: case 100: currentCoinValue+=0.1; break; //D键
		default: return;
	}
	document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
	if(currentCoinValue>itemPrice) {
		enablePurchaseBtn();
	}
	var cancelBtn = document.getElementById('cancelBtn');
	cancelBtn.onclick=function (){
		var purchaseBtn = document.getElementById('purchaseBtn');
		purchaseBtn.className="itemdetail_sumbitpurchasebutton bordered color_notavailable font30";
		purchaseBtn.value="您的投币不足";
		purchaseBtn.disabled=true;
		currentCoinValue=0;
		document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
	}
}

// 购买商品
function enablePurchaseBtn(){
	var btn=document.getElementById('purchaseBtn');
	btn.className="itemdetail_sumbitpurchasebutton bordered color_ok font30";
	btn.value="确认购买";
	btn.disabled=false;
	// 购买
	btn.onclick=function () {
		// 取表单
		var form = document.getElementById('form');
		// 赋值
		var moneyInput = document.getElementById('money');
		moneyInput.value = currentCoinValue;
		// 表单提交
		form.submit();
	};
}

document.getElementById('priceText').innerHTML=String(itemPrice.toFixed(2));
document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
=======
﻿var currentCoinValue = 0;
var itemPrice = document.getElementById('priceText').innerHTML;

function insertCoin(event){
	console.log(event.keyCode||event.which);
	switch(event.keyCode||event.which)
	{
		case 65: case 97: currentCoinValue+=1; break; //A键
		case 83: case 115: currentCoinValue+=0.5; break; //S键
		case 68: case 100: currentCoinValue+=0.1; break; //D键
		default: return;
	}
	document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
	if(currentCoinValue>itemPrice) {
		enablePurchaseBtn();
	}
	var cancelBtn = document.getElementById('cancelBtn');
	cancelBtn.onclick=function (){
		var purchaseBtn = document.getElementById('purchaseBtn');
		purchaseBtn.className="itemdetail_sumbitpurchasebutton bordered color_notavailable font30";
		purchaseBtn.value="您的投币不足";
		purchaseBtn.disabled=true;
		currentCoinValue=0;
		document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
	}
}

// 购买商品
function enablePurchaseBtn(){
	var btn=document.getElementById('purchaseBtn');
	btn.className="itemdetail_sumbitpurchasebutton bordered color_ok font30";
	btn.value="确认购买";
	btn.disabled=false;
	// 购买
	btn.onclick=function () {
		// 取表单
		var form = document.getElementById('form');
		// 赋值
		var moneyInput = document.getElementById('money');
		moneyInput.value = currentCoinValue;
		// 表单提交
		form.submit();
	};
}

document.getElementById('priceText').innerHTML=String(itemPrice.toFixed(2));
document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
>>>>>>> dev
//document.onkeypress=insertCoin;