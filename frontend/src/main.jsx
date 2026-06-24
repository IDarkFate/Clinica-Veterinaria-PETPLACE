import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import 'bulma/css/bulma.min.css'
import './autenticacion/Auth.css'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
