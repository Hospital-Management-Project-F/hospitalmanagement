import { useState } from "react";
import Header from "../Header";
import axios from "axios";

function AddDoctor ()
{
const [firstName, setFirstName] = useState("");
const [lastName, setLastName]= useState("");
const [gender,setGender]= useState("");
const [address,setAddress]= useState("");
const [email,setEmail]= useState("");
const [charges, setCharges]= useState(0);

const [specialization, setSpecialization]= useState("");


    
    const handleChange = (e) => {
        const { name, value } = e.target;
        switch (name) {
          case "firstName":
            setFirstName(value);
            break;
          case "lastName":
            setLastName(value);
            break;
          case "gender":
            setGender(value);
            break;
          case "address":
            setAddress(value);
            break;
          case "email":
            setEmail(value);
            break;
          case "charges":
            setCharges(value);
            break;
          case "specialization":
            setSpecialization(value);
            break;
          default:
            break;
        }
      };


      const handleSubmit = (e) => {
        e.preventDefault();
        const formData = {
          firstName,
          lastName,
          gender,
          address,
          email,
          charges,
          specialization,
        };
        axios
          .post(" ", formData)
          .then((response) => {
            console.log("Form submitted successfully:", response.data);
            
          })
          .catch((error) => {
            console.error("Error submitting form:", error);
         
          });
      };

      const resetFields = (e) => {
        setCharges(0);
        setAddress("");
        setEmail("")
        setFirstName("")
        setLastName("");
        setSpecialization("");
        setGender("");
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
          <a className="nav-link active"  href="/admin/addDoctor">Add Doctor</a>
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

<center>
<br></br>

    

<form onSubmit={handleSubmit}>
   

<div style={{margin:"50px 50px 20px 50px"}}>

<table className="table" style={{width:"35%"}}>
        <thead>
            <tr>
                <th colSpan={2}><h1 style={{textAlign:"center"}}>Add Doctor</h1></th>
              
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
             <label htmlFor="firstName">First Name:</label>
                </td>
                <td>
                <input
      type="text"
      name="firstName"
      id="firstName"
      value={firstName}
      onChange={handleChange}
    />
                </td>
            </tr>
            <tr>
                <td>
                <label htmlFor="lastName">Last Name:</label>
                </td>
                <td>
                <input
      type="text"
      name="lastName"
      id="lastName"
      value={lastName}
      onChange={handleChange}
    />
                </td>
            </tr>
            <tr>
                <td> <label htmlFor="gender">Gender:</label></td>
                <td>  <select name="gender" id="gender" value={gender} onChange={handleChange}>
      <option value=""></option>
      <option value="male">Male</option>
      <option value="female">Female</option>
    </select></td>

            </tr>

            <tr>
                <td>
                <label htmlFor="address">Address:</label>
                </td>
                <td>
                <textarea
      name="address"
      id="address"
      value={address}
      onChange={handleChange}
    ></textarea>
                </td>
            </tr>

            <tr>
                <td>    <label htmlFor="email">Email:</label></td>
                <td>    <input
      type="email"
      name="email"
      id="email"
      value={email}
      onChange={handleChange}
    /></td>
            </tr>

            <tr>
                <td>
                <label htmlFor="charges">Charges:</label>
                </td>
                <td>
                <input
      type="number"
      name="charges"
      id="charges"
      min={0}
      value={charges}
      onChange={handleChange}
    />
                </td>
            </tr>
            <tr>
                <td><label htmlFor="specialization">Specialization:</label></td>
                <td>  <input
      type="text"
      name="specialization"
      id="specialization"
      value={specialization}
      onChange={handleChange}
    /></td>
            </tr>
            <tr>
                <td></td>
                <td><button className="btn btn-success" type="submit" >Submit</button>
                &nbsp;&nbsp;  <button type="reset" onClick={resetFields} className="btn btn-warning">
        Reset
      </button>
                </td>
            </tr>
        </tbody>
    </table>
</div>

    
  </form>
</center>

    </>
}
export default AddDoctor;