import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { AuthProvider } from './contexts/AuthContext';
import Router from './router/Router';

function App() {
  return (
    <>
      <AuthProvider>
        <Router/>
      </AuthProvider>
    </>
  );
}

export default App;
