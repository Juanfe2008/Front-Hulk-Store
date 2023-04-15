import {Routes, Route, BrowserRouter} from 'react-router-dom';
import ShowProducts from './components/ShowProducts';
import layout from './page/layout';
import productos from './page/productos';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<ShowProducts />}></Route>
        <Route path='/' element={<layout />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
