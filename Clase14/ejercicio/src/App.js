import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Main from './components/Main';

function App() {
    return (
        <div className="App">
            <Header titulo="Ejercicio 01" subtitulo="Jugando con React" />
            <Main />
            <Footer />
        </div>
    );
}

export default App;
