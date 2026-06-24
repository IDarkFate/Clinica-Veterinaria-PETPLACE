import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

/**
 * Componente que protege las rutas privadas redireccionando a /login si no hay sesión activa.
 */
const ProtectedRoute = () => {
  const { token, loading } = useAuth();

  if (loading) {
    return (
      <div className="hero is-fullheight is-light">
        <div className="hero-body is-justify-content-center is-align-items-center">
          <div className="has-text-centered">
            <button className="button is-loading is-large is-ghost" style={{ border: 'none' }}></button>
            <p className="mt-4 has-text-grey">Verificando sesión...</p>
          </div>
        </div>
      </div>
    );
  }

  if (!token) {
    return <Navigate to="/login" replace />;
  }

  return <Outlet />;
};

export default ProtectedRoute;
