import { useState } from "react";
import Header from "../Header";

import doctorclipart from "./doctor.png"
import patientclipart from "./examination.png"
import bedclipart from "./hospital-bed.png"
import receiptClipart from "./receipt.png"
import appointClipart from "./medical-appointment.png"
import paymentClipart from "./payment-method.png"


function Admin ()
{

   


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
          <a className="nav-link"   href="/admin/addDoctor">Add Doctor</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="/admin/showDoctors">Show All Doctor</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Receptionist</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Show Receptionist</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Appointment</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Manage Appointments</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Add Patient</a>
        </li>  <li className="nav-item">
          <a className="nav-link" href="#">Manage Patients</a>
        </li>
         <li className="nav-item">
          <a className="nav-link" href="#">Manage Bed</a>
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
<img src={doctorclipart} style={{height:"160px", width:"150px", marginBottom:"20px"}}/>

<figcaption><h5>Doctor Count: </h5></figcaption>
                </td>
                <td>  
                <img src={patientclipart} style={{height:"160px", width:"150px", }}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5>Patient Count: </h5> </figcaption>
                </td>
                <td>  
                <img src={bedclipart} style={{height:"170px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Bed Count: </h5> </figcaption>
                </td>
            </tr>
            <tr>
            <td>  
                <img src={appointClipart} style={{height:"170px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;<h5 >Todays Appointment</h5> </figcaption>
                </td>
                <td>  
                <img src={receiptClipart} style={{height:"175px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Receptionist Count: </h5> </figcaption>
                </td>
                <td>  
                <img src={paymentClipart} style={{height:"160px", width:"150px"}}/>
<figcaption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h5 >Todays Transcation </h5> </figcaption>
                </td>

            </tr>
        </tbody>
       
    </table>
</center>


    </>
}

export default Admin;