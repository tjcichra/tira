//import React, { Component } from 'react';
//import { CKEditor } from '@ckeditor/ckeditor5-react';
//import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

class CreateTicketForm extends React.Component {

	constructor(props) {
		super(props);

		this.state = {
			subject: "",
			description: "",
			reporter: "",
			assignees: [],
			users: []
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleAssigneesChange = this.handleAssigneesChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleInputChange(event) {
		const target = event.target;
		console.log("Target value: " + target.value);

		this.setState({
			[target.name]: target.value
		});
	}

	handleAssigneesChange(e) {
		var assigneesVal = Array.from(e.target.selectedOptions, option => option.value);

		console.log(assigneesVal);
		this.setState({
			assignees: assigneesVal
		});
	}

	handleSubmit(event) {
		event.preventDefault();

		var url = "/api/tickets";
		var data = {
			subject: this.state.subject,
			description: this.state.description,
			reporter: this.state.reporter,
			assignees: this.state.assignees,
			comments: []
		};

		fetch(url, {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(data)
		}).then(response => response.json()).then(data => {
			console.log('Success:', data);
		});
	}

	componentDidMount() {
		fetch('/api/users').then(response => response.json()).then(data => this.setState({
			users: data._embedded.users,
			reporter: data._embedded.users[0]._links.self.href
		}));
	}

	render() {
		const users = this.state.users.map(user =>
			<User key={user._links.self.href} user={user}/>
		);
		return (
			<form onSubmit={this.handleSubmit}>
				<label>
					Subject:
					<input type="text" name="subject" value={this.state.subject} onChange={this.handleInputChange}/>
				</label>
				<br/>
				<label>
					Description:
					<textarea name="description" value={this.state.description} onChange={this.handleInputChange}/>
				</label>                
				<br/>
				<select value={this.state.reporter} name="reporter" onChange={this.handleInputChange}>
					{users}
				</select>
				<br/>
				<select value={this.state.assignees} name="assignees" multiple={true} onChange={this.handleAssigneesChange}>
					{users}
				</select>
				<br/>
				<select value={this.state.status} name="status" onChange={this.handleInputChange}>
					<option value="inprogress">In Progress</option>
					<option value="testing">Testing</option>
					<option value="done">Done</option>
				</select>
				<br/>
				<input type="submit"/>
			</form>
		)
	}
}

class User extends React.Component {

	render() {
		return (
			<option value={this.props.user._links.self.href}>{this.props.user.name}</option>
		)
	}
}

ReactDOM.render(
	<CreateTicketForm />,
	document.getElementById('react')
)