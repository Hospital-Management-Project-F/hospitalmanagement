
import { Route,Routes } from 'react-router-dom';

import "../node_modules/bootstrap/dist/css/bootstrap.min.css"


import './App.css';


import SignIn from './pages/signIn';


function App() {
  return <div className='container-fluid'>
  



  <Routes>

  <Route path='/' element={<SignIn/>}/>
  


  </Routes>










  </div>
}

export default App;
