import { useNavigate } from 'react-router-dom'
import './style.css'
import logo from '../../assets/images/logo.png' // ajuste o caminho conforme seu projeto

function PaginaHome() {
    const navigate = useNavigate()
    
    return (
        <div className='home'>
            <div className='container'>
                <img src={logo} alt="Logo do Clube" className="logo" />
                <h2>Seja Bem Vindo ao Tabajara</h2>
                
                <button onClick={() => navigate('/cadastro')} className='link-voltar'>
                    Entrar
                </button>
            </div>
        </div>
    )
}

export default PaginaHome
