
import { Route,Routes } from 'react-router-dom';

import "../node_modules/bootstrap/dist/css/bootstrap.min.css"

import Admin from './component/Admin/admin';

import './App.css';


import SignIn from './pages/signIn';
import AddDoctor from './component/Admin/addDoctor';


function App() {
  return <div className='container-fluid'>
  



  <Routes>

  <Route path='/' element={<SignIn/>}/>

  <Route path='/admin' element={<Admin/>}/>

  <Route path='/admin/addDoctor' element={<AddDoctor/>}/>
  


  </Routes>










  </div>
}

export default App;
