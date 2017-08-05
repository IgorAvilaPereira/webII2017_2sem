// apaga 
// somente debug
localStorage.clear();

var vet = [];

function fatorialN(x){
	var resultado = 1;
	while (x > 1){
		resultado = resultado * x;
		x--;
	}
	return resultado;

}

function fatorial(x){
	if (x == 0 || x == 1){
		return 1;
	}
	return x * fatorial(x-1);
}

function inicializa(){
	if (localStorage.getItem("vet") != undefined){
		vet = JSON.parse(localStorage.getItem("vet"));
	}	
}

function pegaValor(){
	//var vetDiv = document.getElementsByTagName("div");
	//vetDiv[0].innerHTML = "oi";
	var vetCheckboxes = document.querySelectorAll("input[type=\"checkbox\"]");
	//divMeninas.innerHTML += ", olá...";
	//alert(nome.value)
	for (var i = 0; i < vetCheckboxes.length; i++) {
		alert("oi");
		vetCheckboxes[i].checked = true;
	}
}


function validaNome(nome){
	if (nome.length < 3){
		alert("Tem que ser maior...");
	} 
	var totalVogais = 0;
	for (var i = 0; i < nome.length; i++) {
		if (nome[i] == 'a' || nome[i] == 'e' || nome[i] == 'i' || nome[i] == 'o' || nome[i] == 'u') {
			totalVogais++;
		}
	}
	alert(totalVogais);
}

// opcao 1
function Pessoa(id, nome, sobrenome){
	this.id = id;
	this.nome = nome;
	this.sobrenome = sobrenome;

}

// opcao 2
//var Pessoa = {nome: "", sobrenome: ""};

function excluir(id){
	// JSON.parse transforma uma string em objeto ou vetor
	var vet = JSON.parse(localStorage.getItem("vet"));
	var vetNovo = [];
	for (var i = 0; i < vet.length; i++){
		var g = vet[i];
		if (g.id != id){
			vetNovo.push(g);
		}
	}
	vet = vetNovo;	
	localStorage.setItem("vet", JSON.stringify(vet));
	listar();
}

function listar(){
	document.getElementById("divResultado").innerHTML = "";

	var vet = JSON.parse(localStorage.getItem("vet"));
	for (var i = 0; i < vet.length; i++){
		var g = vet[i];
		document.getElementById("divResultado").innerHTML+= "<button onclick=excluir("+g.id+")> " + g.nome + "</button> <br>";
	}
	alert("Listou com sucesso");
	
}

function adiciona(){
	// obter valores dos inputs
	var nome = document.getElementById("nome").value;
	var sobrenome = document.getElementById("sobrenome").value;
	// crio um novo objeto de Pessoa
	var id = vet.length + 1;
	var pessoa = new Pessoa(id, nome, sobrenome);
	// adiciono no vetor que armazena todas as Pessoas
	vet.push(pessoa);
	// atualizo o vetor no localStorage
	localStorage.setItem("vet", JSON.stringify(vet));
	alert("Adicionou...");
}

function soma(nro1, nro2){
 	var soma = nro1 + nro2;
 	alert(soma);	
 }

function somaDiferente(){
	var nro1 = parseInt(prompt("Digite:"));
	var nro2 = parseInt(prompt("Digite:"));
	alert(nro1+nro2);
}

function curtiu(){
	alert("curtiu?");
}

function bemvindo(){
	alert("Bemvindo");
}

function somaVetor(){
	var vet = [1,2];
	var resultado = 0;
	for (var i = 0; i < vet.length; i++){
		resultado += vet[i];
	}
	var divao = document.getElementById("divResultado");
	// muda de estilo
	divao.style = "width: 10px; background-color: yellow;";
	// coloca no div
	divao.innerHTML = resultado;	
	if (resultado == 3){
		alert("oi");
	}
}

