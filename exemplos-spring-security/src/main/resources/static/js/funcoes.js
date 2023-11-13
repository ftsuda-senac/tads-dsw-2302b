function buscarDadosJson(urlJson, params, jwt, accept = 'application/json') {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        let urlAjustada = urlJson;
        if (params) {
            urlAjustada = urlAjustada + '?' + params
        }
        xhr.open('GET', urlJson, true);
        xhr.setRequestHeader('content-type', 'application/json');
        xhr.setRequestHeader('accept', accept);
        if (jwt != null) {
            xhr.setRequestHeader('authorization', 'Bearer ' + jwt);
        }

        xhr.onload = function () {
            if (xhr.status === 200) {
                const dados = JSON.parse(xhr.responseText);
                resolve(dados);
            } else {
                reject({
                    status: xhr.status,
                    mensagem: 'Erro na requisição'
                });
            }
        };
        xhr.send();
    });
}

function enviarDados(urlJson, dados, contentType = 'application/json', accept = 'application/json') {
    return new Promise((resolve, reject) => {
      let xhr = new XMLHttpRequest();
      xhr.open('POST', urlJson, true);
      xhr.setRequestHeader('content-type', contentType);
      xhr.setRequestHeader('accept', accept);

      xhr.onload = function() {
        if (xhr.status === 200) {
            if (accept === 'application/json') {
                resolve(JSON.parse(xhr.responseText));
            } else if (accept === 'text/plain') {
                resolve(xhr.responseText);
            } else {
                resolve(xhr.responseText);
            }
        } else {
          reject({
            codigo:  xhr.status,
            mensagem: 'Erro ao buscar dados',
            erros: JSON.parse(xhr.responseText)?.errors.map(
              (erro) => ({ campoErro: erro.field, mensagem: erro.defaultMessage })
             )
          });
        }
      };
      let dadosParaEnviar;
      if (contentType === 'application/json') {
        dadosParaEnviar = JSON.stringify(dados);
      } else if (contentType === 'application/x-www-form-urlencoded') {
        dadosParaEnviar = dados.toString();
      }
      xhr.send(dadosParaEnviar);
    });
}
