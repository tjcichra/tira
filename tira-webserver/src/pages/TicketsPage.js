import { useState, useEffect } from 'react';
import Ticket from '../components/Ticket';

function TicketsPage() {
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/tickets').then(response => response.json()).then(data => {
            setTickets(data._embedded.tickets);
        });
    }, []);

    return (
        <div>
            {tickets.map((ticket, index) => <Ticket key={index} ticket={ticket}/>)}
        </div>
    );
}

export default TicketsPage;