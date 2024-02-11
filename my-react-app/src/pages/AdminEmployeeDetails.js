import {

  Button,
  Table,

  Navbar,
  Container,
  Nav,

  Dropdown,
  DropdownButton,
} from "react-bootstrap";
import Employee from "../components/admin/employee";
import "./adminDetails.css";

import { useEffect, useState } from "react";

const Admin = () => {
  


 

  const [employees, setEmployees] = useState([]);


  const [search, setSearch] = useState("");

  
  useEffect(() => {
  
  }, []);
 


 

  return (
    <div>
      <Navbar bg="" expand="lg" sticky="top">
        <Container>
          <Navbar.Toggle
            aria-controls="basic-navbar-nav"
            style={{
              color: "brown",
              fontWeight: "bold",
              background: "chartreuse",
            }}
          >
            Click For Options
          </Navbar.Toggle>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {/* ==============================add new employee==================== */}
              <DropdownButton
                size="sm"
                title="Employee"
                variant="warning"
                style={{ margin: "6px" }}
              >
                <Dropdown.Item>
                  <Button
                    size="sm"
                    variant="success"
                   
                  >
                    Add New Employee
                  </Button>
                </Dropdown.Item>
                <Dropdown.Item>
                  <Button
                    size="sm"
                    variant="danger"
                
               
                  >
                    Remove Employee
                  </Button>
                </Dropdown.Item>
              </DropdownButton>

              {/* ==========================add ward========================= */}
              <DropdownButton
                size="sm"
                title="Ward"
                variant="warning"
                style={{ margin: "6px" }}
              >
                <Dropdown.Item>
                  <Button
                    variant="success"
                    size="sm"
              
                  >
                    {" "}
                    Add ward
                  </Button>
                </Dropdown.Item>
                <Dropdown.Item>
                  <Button
                    variant="danger"
                    size="sm"
                 
                  >
                    {" "}
                    remove ward
                  </Button>
                </Dropdown.Item>
              </DropdownButton>

              {/* =========================add medicine=========================== */}
              <DropdownButton
                size="sm"
                title="Medicine"
                variant="warning"
                style={{ margin: "6px" }}
              >
                <Dropdown.Item>
                  <Button
                    variant="success"
                    size="sm"
                    onClick={() => {
               
                    }}
                  >
                    {" "}
                    Add Medicine
                  </Button>
                </Dropdown.Item>
                <Dropdown.Item>
                  <Button
                    variant="danger"
                    size="sm"
                    onClick={() => {
                
                    }}
                  >
                    {" "}
                    remove Medicine
                  </Button>
                </Dropdown.Item>
              </DropdownButton>

              {/* ================================search employee===================== */}
              <Nav.Link>
                {/* third button */}
                <div style={{ float: "right" }}>
                  <Button size="sm" variant="secondary">
                    {" "}
                    Search employee
                  </Button>
                  <input
                    style={{
                      borderStyle: "solid",
                      borderRadius: "20px",
                      marginLeft: "10px",
                    }}
                    placeholder="enter name"
                    onChange={(e) => {
                      setSearch(e.target.value);
                    }}
                    type="text"
                  />
                </div>
              </Nav.Link>
              <Nav.Link>
                {/* fourth menu operration */}
                <Button
                  size="sm"
              
                  variant="primary"
                >
                  LogOut
                </Button>
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <div>

     
      
      </div>
      <div>
        <Table variant="dark" striped bordered hover>
          <thead>
            <tr>
              <th>EmpId</th>
              <th>Name</th>
              <th>cell no</th>
              <th>Role</th>
              <th>DOB</th>
              <th>Join Date</th>
              <th>Salary</th>
              <th>Update Detail</th>
            </tr>
          </thead>
       
          <tbody>
            {employees
              .filter((e) => {
                if (search == "") return e;
                else if (
                  `${e.firstName}+" "+${e.lastName}`.includes(
                    search.toLocaleLowerCase()
                  )
                )
                  return e;
              })
              .map((e) => {
                return (
                  <Employee
                
                  />
                );
              })}
          </tbody>
        </Table>
      </div>
    </div>
  );
};
export default Admin;
