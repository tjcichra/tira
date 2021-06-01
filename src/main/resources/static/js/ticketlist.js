class TicketListApp extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			tickets: []
		};
	}

	componentDidMount() {
		fetch('/api/tickets').then(response => response.json()).then(data => this.setState({
			tickets: data._embedded.tickets
		}));
	}

	render() {
		return (
			<TicketList tickets={this.state.tickets}/>
		)
	}
}

class TicketList extends React.Component {
	render() {
		const tickets = this.props.tickets.map(ticket =>
			<Ticket key={ticket._links.self.href} ticket={ticket}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Subject</th>
						<th>Description</th>
						<th>Reporter</th>
					</tr>
					{tickets}
				</tbody>
			</table>
		)
	}
}

class Ticket extends React.Component{

	constructor(props) {
		super(props);
		this.state = {
			username: "",
			redirect: ""
		};
	}

	componentDidMount() {
		fetch(this.props.ticket._links.reporter.href).then(response => response.json()).then(data => this.setState({
			username: data.username
		}));

		var urlParts = this.props.ticket._links.self.href.split("/");
		this.setState({
			redirect: "/ticket/" + urlParts[urlParts.length - 1]
		});
	}
	
	render() {
		return (
			<tr>
				<td>{this.props.ticket.subject}</td>
				<td><a href={this.state.redirect}>{this.props.ticket.description}</a></td>
				<td>{this.state.username}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<TicketListApp />,
	document.getElementById('react')
)