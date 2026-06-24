import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Login from './autenticacion/Login';
import Register from './autenticacion/Register';
import './App.css';

// Componente simple para el Dashboard (Vista Protegida)
const Dashboard = () => {
  const { user, logoutUser } = useAuth();

  return (
    <div className="section">
      <div className="container">
        <div className="box has-text-centered" style={{ maxWidth: '600px', margin: '40px auto' }}>
          <h1 className="title is-2 has-text-info">Dashboard de Pets Place</h1>
          <h2 className="subtitle is-4">¡Bienvenido de vuelta, {user?.nombre}!</h2>
          <hr />
          <div className="content">
            <p><strong>Email:</strong> {user?.email}</p>
            <p><strong>Rol en el sistema:</strong> <span className="tag is-primary is-medium">{user?.rol}</span></p>
          </div>
          <button className="button is-danger is-medium mt-4" onClick={logoutUser}>
            Cerrar Sesión
          </button>
        </div>
      </div>
    </div>
  );
};

function App() {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          {/* Rutas Públicas */}
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />

          {/* Rutas Privadas / Protegidas */}
          <Route element={<ProtectedRoute />}>
            <Route path="/" element={<Dashboard />} />
          </Route>

          {/* Redirección por defecto */}
          <Route path="*" element={<Navigate to="/login" replace />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
