class TicketDisplay extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			ticket: null
		};
	}

	componentDidMount() {
		var urlParts = window.location.href.split("/");
		var ticketId = urlParts[urlParts.length - 1];

		fetch('/api/tickets/' + ticketId).then(response => response.json()).then(data => this.setState({
			ticket: data
		}));
	}

	render() {
		if(this.state.ticket == null) {
			return (
				<div></div>
			)
		} else {
			return (
				<div>
					<Navbar/>
					<p>{this.state.ticket.subject}</p>
					<p>{this.state.ticket.description}</p>
				</div>
			)
		}
	}
}

ReactDOM.render(
	<TicketDisplay />,
	document.getElementById('react')
)