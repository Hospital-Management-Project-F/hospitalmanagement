
import { Route,Routes } from 'react-router-dom';

import "../node_modules/bootstrap/dist/css/bootstrap.min.css"

import Admin from './component/Admin/admin';

import './App.css';


import SignIn from './pages/signIn';
import AddDoctor from './component/Admin/addDoctor';
import ShowDoctors from './component/Admin/showDoctors';


function App() {
  return <div className='container-fluid'>
  



  <Routes>

  <Route path='/' element={<SignIn/>}/>

  <Route path='/admin' element={<Admin/>}/>

  <Route path='/admin/addDoctor' element={<AddDoctor/>}/>

  <Route path='/admin/showDoctors' element={<ShowDoctors/>}/>
  


  </Routes>










  </div>
}

export default App;
