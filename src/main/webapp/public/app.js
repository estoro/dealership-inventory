var Vehicle = React.createClass({
	render: function() {
		return (
			<tr>
				<td>{this.props.vehicle._id}</td>
				<td>{this.props.vehicle.make}</td>
				<td>{this.props.vehicle.year}</td>
				<td>{this.props.vehicle.color}</td>
				<td>{this.props.vehicle.price}</td>
				<td>{String(this.props.vehicle.hasSunroof)}</td>
				<td>{String(this.props.vehicle.isFourWheelDrive)}</td>
				<td>{String(this.props.vehicle.hasLowMiles)}</td>
				<td>{String(this.props.vehicle.hasPowerWindows)}</td>
				<td>{String(this.props.vehicle.hasNavigation)}</td>
				<td>{String(this.props.vehicle.hasHeatedSeats)}</td>
			</tr>
		);
	}
});

var VehicleTable = React.createClass({
	render: function() {
		var rows = [];
		this.props.vehicles.forEach(function(vehicle) {
			rows.push(<Vehicle vehicle={vehicle} />);
		});
		return (
			<div className="container">
			<table className="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Make</th>
						<th>Year</th>
						<th>Color</th>
						<th>Price</th>
						<th>Sunroof</th>
						<th>Four Wheel Drive</th>
						<th>Low Miles</th>
						<th>Power Windows</th>
						<th>Navigation</th>
						<th>Heated Seats</th>
					</tr>
				</thead>
				<tbody>{rows}</tbody>
			</table>
			</div>
		);
	}
});

var App = React.createClass({
	loadVehiclesFromServer: function () {
		var self = this;
		$.ajax({
            url: 'http://localhost:8080/api/vehicles',
            success: function(response) {
                self.setState({vehicles: response.content});
			}
		});
	},
	getInitialState: function () {
		return {vehicles: []};
	},
	componentDidMount: function () {
		this.loadVehiclesFromServer();
	},
	render() {
		return (
			<VehicleTable vehicles={this.state.vehicles}/>
		);
	}
});

ReactDOM.render(<App />, document.getElementById('root'));
