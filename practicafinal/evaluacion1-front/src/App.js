import './App.css';
import { AuthProvider } from './contexts/AuthContext';

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
