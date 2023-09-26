function getJson(url) {
    const promise = new Promise((resolve, reject) => {
      const xhr = new XMLHttpRequest();
      xhr.open('GET', url, true);
      xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 400) {
          // SUCESSO
          resolve(JSON.parse(xhr.responseText));
        } else {
          // ERROS
          const objErro = {
            codigo: xhr.status,
            mensagem: 'Erro'
          };
          reject(objErro);
        }
      }
      xhr.send();
    });
    return promise;
  }