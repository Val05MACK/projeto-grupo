async function asyncLerDoacoes(proxsucesso,proxerro) {
    const URL='/doacoes';
    fetch(URL)
    .then(resposta=>{if(!resposta.ok) throw Error(resposta.status); return resposta;})
    .then(resposta=>resposta.json())
    .then(jsonresponse=> proxsucesso(jsonresponse))
    .catch(proxerro);
  }
  