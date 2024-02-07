import { useState } from "react";
import Header from "../Header";

import doctorclipart from "./kisspng-physician-medicine-health-care-general-practitione-5ce67ea99bc7f7.1567409215586095776381.jpg"
import patientclipart from "./1430453.png"
import bedclipart from "./il_570xN.2458323844_iqhw.avif"

function Admin ()
{

    const[doctor,setDoctor] =useState("");


    return <>


    
    <Header/> 
    <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">Welcome Admin</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarText">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
      <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="#">Dashboard</a>
        </li>
        <li className="nav-item">
          <a className="nav-link"  element={<AddDoctor/>}>Add Doctor</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Edit Doctor</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Receptionist</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Edit Receptionist</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Appointment</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Manage Appointment</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Patient</a>
        </li>  <li className="nav-item">
          <a className="nav-link" href="#">Manage Patient</a>
        </li>
      </ul>
     
    </div>
  </div>
</nav>

<br></br>
<br></br>


<center> 
    <table style={{width:"60%"}}>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
         

        </tr>
        </thead>
        <tbody>
            <tr>
                <td>
<img src={doctorclipart} style={{height:"200px", width:"150px"}}/>

<figcaption><h5>Doctor Count: </h5></figcaption>
                </td>
                <td>  
                <img src={patientclipart} style={{height:"200px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5>Patient Count: </h5> </figcaption>
                </td>
                <td>  
                <img src={bedclipart} style={{height:"200px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Bed Count: </h5> </figcaption>
                </td>
            </tr>
            <tr>
            <td>  
                <img src={bedclipart} style={{height:"200px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Bed Count: </h5> </figcaption>
                </td>
                <td>  
                <img src={bedclipart} style={{height:"200px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Bed Count: </h5> </figcaption>
                </td>
                <td>  
                <img src={bedclipart} style={{height:"200px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Bed Count: </h5> </figcaption>
                </td>

            </tr>
        </tbody>
       
    </table>
</center>


    </>
}

export default Admin;