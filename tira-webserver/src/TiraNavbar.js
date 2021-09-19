import { useState, useEffect } from 'react'
import { Container, Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { Link } from 'react-router-dom';

function TiraNavbar() {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/categories').then(response => response.json()).then(data => {
            setCategories(data._embedded.categories);
        });
    }, []);

    const dropdown = categories.map((c, index) => <NavDropdown.Item key={c.name} as={Link} to="/tickets">{c.name}</NavDropdown.Item>);

    return (
        <Navbar bg="light" sticky="top">
        {console.log(categories)}
            <Container>
                <Navbar.Brand as={Link} to="/home">Tira</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <NavDropdown title="Tickets" id="collasible-nav-dropdown">
                            {dropdown}
                        </NavDropdown>
                        <Nav.Link as={Link} to="/createticket">Create Ticket</Nav.Link>
                        <Nav.Link as={Link} to="/createcategory">Create Category</Nav.Link>
                        <Nav.Link as={Link} to="/tickets">Tickets</Nav.Link>
                    </Nav>
                    <Nav>
                        <Nav.Link>User</Nav.Link>
                        <Nav.Link>Log Out</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default TiraNavbar;