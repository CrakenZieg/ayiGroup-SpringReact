import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { AuthProvider } from './contexts/AuthContext';
import Header from './components/header/Header';
import Router from './components/router/Router';
import Footer from './components/footer/Footer';

function App() {
  return (
    <>
      <AuthProvider>
        <Header/>
        <Router/>
        <Footer/>
      </AuthProvider>
    </>
  );
}

export default App;
