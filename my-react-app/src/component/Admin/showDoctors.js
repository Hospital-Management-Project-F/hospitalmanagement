import { useEffect, useState } from "react";
import Header from "../Header";
import axios from "axios";

function ShowDoctors ()
{
const [firstName, setFirstName] = useState("");
const [lastName, setLastName]= useState("");
const [gender,setGender]= useState("");
const [address,setAddress]= useState("");
const [email,setEmail]= useState("");
const [charges, setCharges]= useState(0);

const [specialization, setSpecialization]= useState("");



    const [doctors, setDoctors] = useState([]);
  
    useEffect(() => {
    //   axios.get("").then((response) => {
    //     setDoctors(response.data);
    //   });
    }, []);
  
    const deleteDoctor = (id) => {
      axios.delete(``).then((response) => {
        setDoctors(doctors.filter((doctor) => doctor._id !== id));
      });
    };
    

    const editDoctor = (doctor)=>
    {
        
    }

    return<>
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
          <a className="nav-link " aria-current="page" href="/admin">Dashboard</a>
        </li>
        <li className="nav-item">
          <a className="nav-link"  href="/admin/addDoctor">Add Doctor</a>
        </li>
        <li className="nav-item">
          <a className="nav-link active" href="/admin/showDoctors">Show All Doctors</a>
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
        <li className="nav-item">
          <a className="nav-link" href="#">Manage Bed</a>
        </li>
      </ul>
     
    </div>
  </div>
</nav>

<center>
<br></br>

    



<div>

<table className="table table-bordered" style={{ width: "35%", backgroundColor: "White" }}>
          <thead>
            <tr>
              <th>Employee Id</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Mobile No</th>
              <th>Address</th>
              <th>Specialization</th>
              <th>Charges</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {doctors.map((doctor) => (
              <tr key={doctor._id}>
                <td>{doctor.employeeId}</td>
                <td>{doctor.firstName}</td>
                <td>{doctor.lastName}</td>
                <td>{doctor.email}</td>
                <td>{doctor.mobileNo}</td>
                <td>{doctor.address}</td>
                <td>{doctor.specialization}</td>
                <td>{doctor.charges}</td>
                <td>
                  <button className="btn btn-primary" onClick={()=>editDoctor(doctor)}>Edit</button>
                </td>
                <td>
                  <button className="btn btn-danger" onClick={() => deleteDoctor(doctor._id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
</div>

    

</center>

    </>
}

export default ShowDoctors;