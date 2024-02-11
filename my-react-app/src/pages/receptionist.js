import {
  Container,
  Button,
  Navbar,
  Nav,
} 
from "react-bootstrap";

import "./receptionist.css";
import { useEffect, useState } from "react";
import AddNewPatientModal from "../components/patient/AddNewPatient";

import Patient from "../components/patient/patient";

;

const ReceptionistHome = () => {
  // ============================all constants=======================
  const [addNewPatientModalFlag, setAddNewPatientModalFlag] = useState(false);

  const [patients, setPatients] = useState([]);


  const [dataChangedFlag, setDataChangedFlag] = useState(false);
  const [search,setSearch]=useState("")
   
  //************************=======fuctions=========--------------- */

  const ToggleAddNewPatientModal = () => {
    setAddNewPatientModalFlag(true);
  
    console.log(
      "value of ToggleAddNewPatientModal in function : " +
        addNewPatientModalFlag
    );
  };



  useEffect(() => {
  
    console.log("inside useEffect of adminDetails");
  }, [dataChangedFlag]);
  
  //******************=-------------=======----------=======------------- */
  return (
    <div className="receptionContainer">
      <Navbar bg="" expand="lg" sticky="top">
        <Container>
          <Navbar.Toggle
            aria-controls="basic-navbar-nav"
            style={{ color: "brown", fontWeight: "bold",background:"aqua" }}
          >
            Click For Options
          </Navbar.Toggle>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {/* ==============================add new patient==================== */}
              <Nav.Link>
                <Button onClick={ToggleAddNewPatientModal} variant="danger">
                  Add new Patient
                </Button>
              </Nav.Link>
              <Nav.Link>
              <Button size="sm" variant="warning">
                    {" "}
                    Search Patient
                  </Button>
                  <input
                    style={{
                      borderStyle: "solid",
                      borderRadius: "20px",
                      marginLeft: "10px",
                     

                    }}
                    placeholder="enter name"
                    onChange={e=>{
                      setSearch(e.target.value)
                    }}
                    type="text"
                  />
              </Nav.Link>
              
              <Nav.Link>
             
                <Button
                 
                >
                  Logout
                </Button>
                
               
                
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <div>
        {addNewPatientModalFlag && (
          <AddNewPatientModal/>
        )}
      </div>

      <hr />
      {/* =======================================table container of patients====================================== */}
      <div className="cointainer-fluid receptionTableContainer">
        <table class="table table-dark table-hover">
          <thead>
            <tr>
              <th scope="col">Patient Id</th>
              <th scope="col">Name</th>
              <th scope="col">Payment Status</th>
              <th scope="col">Details</th>
            </tr>
          </thead>
          <tbody>
            {patients.filter((e)=>{
               if(search=="")
               return e;
               else
               if(`${e.firstName}+" "+${e.lastName}`.includes(search.toLocaleLowerCase()) )
               return e;

            }).map((e) => {
              return (
                <Patient patient={e} setDataChangedFlag={setDataChangedFlag} />
              );
            })}
          </tbody>
        </table>
      </div>
      {/* ================================================table container over========================== */}
    </div>
  );
};

export default ReceptionistHome;
