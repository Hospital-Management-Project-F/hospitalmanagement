import {  Button,
Col,
Row,
} from "react-bootstrap";
import { useState } from "react";

import { Link } from "react-router-dom";



const ResetPassword = () => {
  
  

  const [uniqueEmail, setUniqueEmail] = useState("");
  const [email, setEmail] = useState("");
 
  const [password, setPassword] = useState("");


  const changePassword = (args)=>
  {
  
  }

  


  return (
    <div>
      <Row>
        <Col></Col>
        <Col>
        
          <hr />
          <div style={{ border: "solid", borderRadius: "10px" }}>
            <div className="form-group needs-validation">
              <label className="form-label">
                <h4>Email</h4>
              </label>
              <input
                style={{ margin: "auto" }}
            
                onChange={(e) => {
                  setUniqueEmail("");
                  console.log(email);

                  setEmail(e.target.value);
      
                }}
                type="email"
                className="form-control"
              />
              {email.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) &&
              email.endsWith(".com") &&
              uniqueEmail == "DUPLICATE_EMAIL" ? (
                <div className=""> </div>
              ) : (
                <h6 className="emptyFieldWarning">*enter valid email</h6>
              )}              
            </div>
            <div>
              <Button
                style={{ marginTop: "10px" }}
                onClick={() => {
                  changePassword();
                }}
                variant="success"
                size="sm"
              >
                Submit
              </Button>
              <div style={{ marginTop: "10px" }}>
                <Link to="/">SignIn </Link>
              </div>
            </div>
          </div>
        </Col>
        <Col></Col>
      </Row>

     
    </div>
  );
};
export default ResetPassword;
