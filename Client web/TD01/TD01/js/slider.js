$(document).ready(function () {
    var listeBoutons = document.querySelectorAll(".slider-control");
	//var listeBoutons = $("div.slider-controls");
	
    listeBoutons.forEach(function (elt) {
        var pos = [].indexOf.call(listeBoutons, elt);
		elt.addEventListener("click",function(){afficher(pos);});
    });
	i = 0;
	setInterval(function(){afficher(i); i++;}, 5000);

});

function afficher(numero) {
    var liste = document.querySelectorAll(".slider-panel");
	//var liste = $(".slider").find(".slider-panel");
    var liste2 = document.querySelectorAll(".slider-control");
	cacher(liste);
	cacher(liste2);
	montrer(liste, numero);
	montrer(liste2, numero);
}



function cacher(liste)
{
    liste.forEach(function (elt) {
        elt.classList.remove("active");
    });
}

function montrer(liste, numero)
{
	liste.item(numero).classList.add("active");
}