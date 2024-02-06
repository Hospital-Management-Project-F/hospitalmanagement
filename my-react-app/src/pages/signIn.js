import { useEffect, useState } from "react";
import "../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { useNavigate } from "react-router-dom";
import { Button } from "bootstrap";

import corosoleImage from './17036796453702.jpeg';
import secondImage from './360_F_124928348_gmLHtItkKNtTTHiNVN2Fz2WjinAZF1jl.jpg';
import thirdImage from './1aacccd507c773c0c880df7562bcc6df.jpg';

// import "./signIn.css";


const SignIn = () => {
  const [role, setRole] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("")
  const [passwordError, setPasswordError] = useState("")

  const navigate = useNavigate();


  useEffect(() => {
    
  }, []);

  const changeEmail= (event)=>{

    console.log(event.target.value);
    setEmail(event.target.value);

  }
  const changePassword= (event)=>{

    console.log(event.target.value);
    setPassword(event.target.value);

  }
  return (
    

<center>

<div >
        <h1 style={{ color: "brown" }} className="messageText">
          YOUR HEALTH IS OUR PRIORITY.
        </h1>

        <h2 style={{ color: "black" }} className="messageText">
          We Provide Medical Services That You Can Trust!
        </h2>
</div>


<div>
<table >
        <thead>
          <tr>
            <th></th>
            <th></th>
            <th></th>               
          </tr>

        </thead>
        <tbody>
          <tr>
            <td></td>
            <td>
<div className="dropdown open">
  <button
    className="btn btn-secondary dropdown-toggle"
    type="button"
    id="role"
    data-bs-toggle="dropdown"
    aria-haspopup="true"
    aria-expanded="false"
  >
    Select Role
  </button>
  <div className="dropdown-menu" aria-labelledby="triggerId">
    <button className="dropdown-item" onClick={(e) => {
                          setRole(e.target.innerText);
                          console.log(e.target.innerText);
                        }} >Admin</button>
  <button className="dropdown-item" onClick={(e) => {
                          setRole(e.target.innerText);
                          console.log(e.target.innerText);
                        }} >Doctor</button>
  <button className="dropdown-item" onClick={(e) => {
                          setRole(e.target.innerText);
                          console.log(e.target.innerText);
                        }}>Recptionist</button>
  <button className="dropdown-item" onClick={(e) => {
                          setRole(e.target.innerText);
                          console.log(e.target.innerText);
                        }} >Patient</button>
  
  </div>
</div></td>
<td></td>
          </tr>
          <tr>
            <td>
            <label>Email &nbsp;</label>
            </td>
            <td><input type="email" onChange={changeEmail} placeholder="abc@gmail.com"/></td>
            <td></td>
          </tr>
          <tr>
            <td>
            <label>Password &nbsp;</label>
            </td>
            <td><input type="password" onChange={changePassword} placeholder="Enter password Here"/></td>
            <td></td>
          </tr>
          <tr>
          
          <td>

          </td>
          <td>
          <input type="button" className="btn btn-success" value={"Login"}/>

          &nbsp;<a href="./forgotPassword">Forgot Password</a>
          </td>

          </tr>

        </tbody>

</table>

<br></br>
<br></br>
</div>
<div id="carouselExampleRide" className="carousel slide" data-bs-ride="true">
  <div className="carousel-inner">
    <div className="carousel-item active">
      <img src={secondImage} className="d-block -50" alt="..."/>
    </div>
    <div className="carousel-item active">
      <img src={corosoleImage} className="d-block w-50" alt="..."/>
    </div>
    
    <div className="carousel-item">
      <img src={thirdImage} className="d-block w-50" alt="..."/>
    </div>
  
  </div>
  <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
    <span className="visually-hidden">Previous</span>
  </button>
  <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
    <span className="carousel-control-next-icon" aria-hidden="true"></span>
    <span className="visually-hidden">Next</span>
  </button>
</div>

</center>
  

  );
}

export default SignIn;
