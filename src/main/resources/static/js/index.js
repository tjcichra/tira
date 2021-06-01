class IndexDisplay extends React.Component {

	render() {
		return (
			<div>
				<Navbar/>
				<div class="container" style="margin-top:50px">
					<div class="row">
						<div class="col-sm-4">
							<a href="/ticketlist">View all Tickets</a>
						</div>
						<div class="col-sm-4">
							<a href="/createticket">Create Ticket</a>
						</div>
					</div>					
				</div>
			</div>
		)
	}
}

ReactDOM.render(
	<IndexDisplay/>,
	document.getElementById('react')
);