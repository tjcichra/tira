class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

	componentDidMount() {
		fetch('/api/users').then(response => response.json()).then(data => this.setState({
			users: data._embedded.users
		}));
    }

    render() {
        return (
            <UserList users={this.state.users}/>
        )
    }
}

class UserList extends React.Component{
	render() {
		const users = this.props.users.map(user =>
			<User key={user._links.self.href} user={user}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Username</th>
						<th>Password</th>
						<th>Name</th>
					</tr>
					{users}
				</tbody>
			</table>
		)
	}
}

class User extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.user.username}</td>
				<td>{this.props.user.password}</td>
				<td>{this.props.user.name}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)