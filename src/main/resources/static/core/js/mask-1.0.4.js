/**
 * Máscaras ER 
 * @autor Diego Lirio
 * version 1.0.1 -> add mascara _decimal
 * version 1.0.2 -> add mascara _peso
 * version 1.0.3 -> ...
 */
function Mask() {

//	var _mascara = function (o,f) {
//	    v_obj=o
//	    v_fun=f
//	    setTimeout("execmascara()",1)
//	};
//	
//	var _execmascara = function(){
//	    v_obj.value=v_fun(v_obj.value)
//	};
	
	var _cep = function(v) {
	    v=v.replace(/\D/g,"")                    //Remove tudo o que não é numero
	    v=v.replace(/^(\d{5})(\d)/,"$1-$2")         //Esse é tão fácil que não merece explicações
	    return v
	};
	
	var _tel = function(v) {
	    v=v.replace(/\D/g,"");             //Remove tudo o que não é numero
	    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
	    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
	    return v;
	};
	
	var _cnpj = function(v) {
	    v=v.replace(/\D/g,"")                           //Remove tudo o que não é numero
	    v=v.replace(/^(\d{2})(\d)/,"$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
	    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
	    v=v.replace(/\.(\d{3})(\d)/,".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
	    v=v.replace(/(\d{4})(\d)/,"$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
	    return v
	};
	
	var _cpf = function(v) {
	    v=v.replace(/\D/g,"")                    //Remove tudo o que não é numero
	    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
	    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
	                                             //de novo (para o segundo bloco de números)
	    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
	    return v
	};
	
	var _data = function(v) {
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é numero
	    v=v.replace(/(\d{2})(\d)/,"$1/$2");
	    v=v.replace(/(\d{2})(\d)/,"$1/$2");
	    v=v.replace(/(\d{2})(\d{2})$/,"$1$2");
	    return v;
	};
	
	var _tempo = function(v) {
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é numero
	    v=v.replace(/(\d{1})(\d{2})(\d{2})/,"$1:$2.$3");
	    return v;
	};

	var _hora = function(v) {
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é numero
	    v=v.replace(/(\d{2})(\d)/,"$1:$2"); 
		var hora = v.substr(0,2);
	    var min  = v.substr(3,2);
	    if(Number(hora) > 23 ){
	    	hora = '00';
	    }
	    if(Number(min) > 59){
	    	min = '00';
	    }
	    v = String(hora + min);
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é numero
	    v=v.replace(/(\d{2})(\d)/,"$1:$2"); 
	    return v;
	};
	
	var _rg = function(v) {
		v=v.replace(/\D/g,"");                                      //Remove tudo o que não é numero
        v=v.replace(/(\d)(\d{7})$/,"$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
        v=v.replace(/(\d)(\d{4})$/,"$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
        v=v.replace(/(\d)(\d)$/,"$1-$2");               //Coloca o - antes do último dígito
        return v;
	};
	
	var _num = function(v){
	    v=v.replace(/\D/g,""); //Remove tudo o que não é numero(numero)
	    return v;
	};
	
	var _moeda = function(v) {
		v=String(v);
		v=v.replace(/\D/g,"");//Remove tudo o que não é numero
		v=String(Number(v));
//		v=v.replace(/(\d)(\d{8})$/,"$1.$2");//coloca o ponto dos milhões
//	    v=v.replace(/(\d)(\d{5})$/,"$1.$2");//coloca o ponto dos milhares
	    v=v.replace(/(\d)(\d{2})$/,"$1.$2");//coloca a virgula antes dos 2 últimos dígitos
	    return v;
	};
	
	var _comprimento = function(v) {
		v=String(v);
		v=v.replace(/\D/g,"");//Remove tudo o que não é numero
		//v=String(Number(v));
		v=v.replace(/(\d)(\d{8})$/,"$1.$2");//coloca o ponto dos milhões
	    v=v.replace(/(\d)(\d{5})$/,"$1.$2");//coloca o ponto dos milhares
	    v=v.replace(/(\d)(\d{2})$/,"$1,$2");//coloca a virgula antes dos 2 últimos dígitos
	    return v;
	};	
	
	var _peso = function(v){
		v=_num(v);
		v=String(Number(v));
		while(v.length < 4){
			v = "0" + v; 
		}
		v=v.replace(/(\d)(\d{3})$/,"$1.$2");//coloca a virgula antes dos 2 últimos dígitos
      	return v;
		//v=String(v);
		//if(v.length == 1) v += "000";
		//v=v.replace(/\D/g,"");//Remove tudo o que não é numero
	    //v=String(Number(v)); 
//	    v=v.replace(/(\d)(\d{6})$/,"$1.$2");//coloca o ponto dos milhões 
//	    v=v.replace(/(\d)(\d{3})$/,"$1,$2");//coloca o ponto dos milhares	 
	    //v=v.replace(/(\d)(\d{3})$/,"$1,$2");//coloca a virgula antes dos 2 últimos dígitos  
	    //return v;
	};	
	
	var _pesoDecimal = function(v){
		v=String(v);
		v=v.replace(/\D/g,"");//Remove tudo o que não é numero
	    v=String(Number(v)); 
	    v=v.replace(/(\d)(\d{9})$/,"$1.$2");//coloca o ponto dos milhões 
	    v=v.replace(/(\d)(\d{6})$/,"$1.$2");//coloca o ponto dos milhares	 
	    v=v.replace(/(\d)(\d{3})$/,"$1,$2");//coloca a virgula antes dos 2 últimos dígitos  
	    return v;
	};
	
	var _decimal = function(v) {
		v=_num(v);
		v=String(Number(v));
		while(v.length < 3){
			v = "0" + v; 
		}
		v=v.replace(/(\d)(\d{2})$/,"$1.$2");//coloca a virgula antes dos 2 últimos dígitos
      	return v;
    };	
	
	var _decimalConvercao = function(v) {
		v=_num(v);
		v=String(Number(v));
		v=v.replace(/(\d)(\d{2})$/,"$1.$2");//coloca a virgula antes dos 2 últimos dígitos
      	return v;
    };	
	
	
	/*
	var _celularComDDD = function(v) {
	    v = v.replace(/\D/g, "");//remove tudo o que não é numero		
		if(v.length === 1){
			v = "(" + v;//coloca o primeiro parênteses
		}
		else {
			v = v.replace(/^(\d\d)/g, "($1) ");//coloca parênteses em volta dos dois primeiros numeros			
			if(v.length > 13){
				v = v.replace(/(\d{5})(\d)/, "$1-$2");//coloca hífen entre o quinto e o sexto numeros
			}
			else {
				v = v.replace(/(\d{4})(\d)/, "$1-$2");//coloca hífen entre o quarto e o quinto numeros
			}
		}		
	    return v;
	};
	*/
	
	
	return {

		cep : _cep,
		
		tel : _tel,
		
		cnpj : _cnpj,
		
		cpf : _cpf,
		
		data : _data,
		
		tempo : _tempo,
		
		hora : _hora,
		
		rg : _rg,
		
		num : _num,
		
		moeda : _moeda,
		
		comprimento : _comprimento,
		
		peso : _peso,
		
		pesoDecimal : _pesoDecimal,
		
		decimal : _decimal,
		
		decimalConvercao: _decimalConvercao
		
		//celularComDDD : _celularComDDD
	};

}