// src\components\FormularioCadastro\index.js

import { useState } from "react";
import './styles.css'
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem'
import MensagemFeedback from '../MensagemFeedback'
import logo from '../../assets/images/logo.png'
import axios from 'axios'

function FormularioCadastro() {
    const [nome, setNome] = useState('');
    const [sexo, setSexo] = useState('');
    const [idade, setIdade] = useState('');
    const [posicao, setPosicao] = useState('');
    const [altura, setAltura] = useState('');
    const [peso, setPeso] = useState('');
    const [numero, setNumero] = useState('');
    const navigate = useNavigate()
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem()

    const cadastrarUsuario = async () => {
        try {
            const response = await axios.post('http://localhost:8080/Elenco', {nome, sexo,idade,posicao,altura,peso,numero})
            exibirMensagem(response.data.mensagem || 'Jogador cadastrado com sucesso!', 'sucesso')
            setNome('');
            setSexo('');
            setIdade('');
            setPosicao('');
            setAltura('');
            setPeso('');
            setNumero('');
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.'
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ')
                }
            }
            exibirMensagem(erroMsg, 'erro')
        }
    }

    return (
        <div className="container">
            <img src={logo} alt="Logo da empresa" />
            <h2>Cadastro de Jogadores</h2>
            <form onSubmit={(e) => {e.preventDefault(); cadastrarUsuario()}}>
            <input 
                  type="text"
                  id="nome"
                  placeholder="Nome"
                  value={nome}
                  onChange={(e) => setNome(e.target.value)}
                  required
                />

                <select
                  id="sexo"
                  value={sexo}
                  onChange={(e) => setSexo(e.target.value)}
                  required
                >
                  <option value="">Selecione o sexo</option>
                  <option value="Masculino">Masculino</option>
                  <option value="Feminino">Feminino</option>
                </select>

            <input 
              type="text"
              id="idade"
              placeholder="Idade"
              value={idade}
              onChange={(e) => setIdade(e.target.value)}
              required
            />        

            <input 
              type="text"
              id="posicao"
              placeholder="Posição"
              value={posicao}
              onChange={(e) => setPosicao(e.target.value)}
              required
            />       


            <input 
              type="number"
              id="altura"
              placeholder="Altura"
              value={altura}
              onChange={(e) => setAltura(e.target.value)}
              step="0.01"
              required
            />

            <input 
              type="number"
              id="peso"
              placeholder="Peso"
              value={peso}
              onChange={(e) => setPeso(e.target.value)}
              step="0.01"
              required
            />

            <input 
              type="text"
              id="numero"
              placeholder="Número da Camisa"
              value={numero}
              onChange={(e) => setNumero(e.target.value)}
              required
            />

                <button type="submit">Cadastrar</button>
            </form>

            <button onClick={() => navigate('/usuarios')} className="link-usuarios">
                Ver Jogadores cadastrados
            </button>

            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    )
}

export default FormularioCadastro