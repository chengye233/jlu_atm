var currentCoinValue = 0;
var itemPrice = 2;//TODO:设置为商品价格

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
	if(currentCoinValue>itemPrice)enablePurchaseBtn();
}

function enablePurchaseBtn(){
	var btn=document.getElementById('purchaseBtn');
	btn.className="itemdetail_sumbitpurchasebutton bordered color_ok font30";
	btn.value="确认购买";
	btn.disabled=false;
	//TODO：在此处插入令按钮可按下
	//btn.onclick=function () {}
}

document.getElementById('priceText').innerHTML=String(itemPrice.toFixed(2));
document.getElementById('coinText').innerHTML=String(currentCoinValue.toFixed(2));
//document.onkeypress=insertCoin;