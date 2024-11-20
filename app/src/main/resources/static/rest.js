// Função para listar todas as campanhas, agora incluindo os doadores
async function asyncLerCampanhas(proxsucesso, proxerro) {
    const URL = '/api/campanhas';
    fetch(URL)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse)) // Sucesso ao obter as campanhas e doadores
        .catch(proxerro);
}

// Função para enviar uma nova campanha
async function enviarCampanha(campanha) {
    try {
        const response = await fetch('/api/campanhas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campanha)
        });

        if (response.ok) {
            alert('Campanha salva com sucesso!');
        } else {
            console.error('Erro:', response.status, response.statusText);
            alert('Erro ao salvar a campanha.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
}

// Função para apagar uma campanha
async function apagarCampanha(idCampanha) {
    try {
        const response = await fetch(`/api/campanhas/${idCampanha}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            alert('Campanha apagada com sucesso!');
        } else {
            console.error('Erro:', response.status, response.statusText);
            alert('Erro ao apagar a campanha.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
}

// Função para atualizar uma campanha
async function atualizarCampanha(campanha) {
    try {
        const response = await fetch(`/api/campanhas/${campanha.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campanha)
        });

        if (response.ok) {
            alert('Campanha atualizada com sucesso!');
        } else {
            console.error('Erro:', response.status, response.statusText);
            alert('Erro ao atualizar a campanha.');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
}
