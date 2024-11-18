async function asyncLerCampanhas(proxsucesso,proxerro) {
    const URL='/api/campanhas';
    fetch(URL)
    .then(resposta=>{if(!resposta.ok) throw Error(resposta.status); return resposta;})
    .then(resposta=>resposta.json())
    .then(jsonresponse=> proxsucesso(jsonresponse))
    .catch(proxerro);
  }
  
  async function enviarCampanha(campanha) {
    try {
      const response = await fetch('/api/campanhas', {
          method: 'POST',
          body: JSON.stringify(campanha)
      });

        if (response.ok) {
            alert('Doação salva com sucesso!');
        } else {
            console.error('Erro:', response.status, response.statusText);
            alert('Erro ao salvar a doação.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
}
