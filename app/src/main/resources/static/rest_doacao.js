/**
 * Função para salvar uma nova doação.
 * @param {Object} doacao - Objeto contendo os dados da doação.
 * @param {Function} onSuccess - Callback executado em caso de sucesso.
 * @param {Function} onError - Callback executado em caso de erro.
 */
async function enviarDoacao(doacao, onSuccess, onError) {
  const URL = '/doacoes'; // Endpoint do seu servidor para salvar a doação.

  try {
      const resposta = await fetch(URL, {
          method: 'POST', // Método HTTP para criar um novo recurso.
          headers: {
              'Content-Type': 'application/json' // Especifica que os dados são JSON.
          },
          body: JSON.stringify(doacao) // Converte o objeto em JSON para envio.
      });

      if (!resposta.ok) {
          throw new Error(`Erro ao salvar a doação: ${resposta.status}`);
      }

      const jsonResponse = await resposta.json();
      if (onSuccess) {
          onSuccess(jsonResponse); // Chama o callback de sucesso, passando a resposta.
      }
  } catch (error) {
      if (onError) {
          onError(error); // Chama o callback de erro, passando o erro.
      } else {
          console.error("Erro não tratado:", error);
      }
  }
}
