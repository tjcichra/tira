class Navbar extends React.Component {

	render() {
		return (
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/">Tira</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/">Tickets</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        )
	}
}