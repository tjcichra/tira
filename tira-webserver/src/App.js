import logo from './logo.svg';
import './App.css';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';
import TiraNavbar from './TiraNavbar.js'
import HomePage from './pages/HomePage';
import TicketCreatePage from './pages/TicketCreatePage';
import CategoryCreatePage from './pages/CategoryCreatePage';
import { Switch, Route } from 'react-router-dom';
import TicketsPage from './pages/TicketsPage';

function App() {
  return (
    <div>
      <TiraNavbar/>
      <Container>
        <Switch>
          <Route path="/home">
            <HomePage/>
          </Route>
          <Route path="/createticket">
            <TicketCreatePage/>
          </Route>
          <Route path="/createcategory">
            <CategoryCreatePage/>
          </Route>
          <Route path="/tickets">
            <TicketsPage/>
          </Route>
          <Route path="*">
            <h1>ERRNOR</h1>
          </Route>
        </Switch>
      </Container>
    </div>
  );
}

export default App;
