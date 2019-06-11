var Url = 'http://localhost:8080/api/vehicles?';

class Vehicle extends React.Component {
	constructor(props) {
		super(props);
	}
	render() {
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
};

class VehicleTable extends React.Component {
	constructor(props) {
		super(props);
	}
	render() {
		var rows = [];
		this.props.vehicles.forEach(function(vehicle) {
			rows.push(
				<Vehicle vehicle={vehicle} />);
		});
		return (
			<table className="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Make</th>
						<th>Year</th>
						<th>Color</th>
						<th>Price</th>
						<th>Sunroof</th>
						<th>4 Wheel Drive</th>
						<th>Low Miles</th>
						<th>Power Windows</th>
						<th>Navigation</th>
						<th>Heated Seats</th>
					</tr>
				</thead>
				<tbody>{rows}</tbody>
			</table>
		);
	}
};

class Search extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			vehicles: [],
			and: true,
			make: 'Any',
			year: 2015,
			color: 'Any',
			price: 15000,
			hasSunroof: true,
			isFourWheelDrive: true,
			hasLowMiles: true,
			hasPowerWindows: true,
			hasNavigation: true,
			hasHeatedSeats: true
		};
		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}
	loadVehiclesFromServer() {
		var self = this;
		$.ajax({
			url: Url,
			success: function(response) {
				self.setState({ vehicles: response.content });
			}
		});
	}
	componentDidMount() {
		this.loadVehiclesFromServer();
	}
	handleInputChange(event) {
		const target = event.target;
		const value = target.type === 'checkbox' ? target.checked : target.value;
		const name = target.name;
		this.setState({
			[name]: value
		});
	}
	handleSubmit(event) {
		Url = 'http://localhost:8080/api/vehicles?';
		if (typeof(this.state.and) != "undefined")
			Url += '&operatorAnd=' + this.state.and;
		if (typeof(this.state.make) != "undefined" && this.state.make != 'Any')
			Url += '&make=' + this.state.make;
		if (typeof(this.state.year) != "undefined" && this.state.yearEnabled)
			Url += '&year=' + this.state.year;
		if (typeof(this.state.color) != "undefined" && this.state.color != 'Any')
			Url += '&color=' + this.state.color;
		if (typeof(this.state.price) != "undefined" && this.state.priceEnabled)
			Url += '&price=' + this.state.price;
		if (typeof(this.state.hasSunroof) != "undefined" && this.state.hasSunroofEnabled)
			Url += '&hasSunroof=' + this.state.hasSunroof;
		if (typeof(this.state.isFourWheelDrive) != "undefined" && this.state.isFourWheelDriveEnabled)
			Url += '&isFourWheelDrive=' + this.state.isFourWheelDrive;
		if (typeof(this.state.hasLowMiles) != "undefined" && this.state.hasLowMilesEnabled)
			Url += '&hasLowMiles=' + this.state.hasLowMiles;
		if (typeof(this.state.hasPowerWindows) != "undefined" && this.state.hasPowerWindowsEnabled)
			Url += '&hasPowerWindows=' + this.state.hasPowerWindows;
		if (typeof(this.state.hasNavigation) != "undefined" && this.state.hasNavigationEnabled)
			Url += '&hasNavigation=' + this.state.hasNavigation;
		if (typeof(this.state.hasHeatedSeats) != "undefined" && this.state.hasHeatedSeatsEnabled)
			Url += '&hasHeatedSeats=' + this.state.hasHeatedSeats;
		alert(Url);
		this.loadVehiclesFromServer();
		event.preventDefault();
	}
	render() {
		return (
			<div className="container">
				<form onSubmit={this.handleSubmit}>
					<div className="checkbox">
						<label><input name="and" type="checkbox" checked={this.state.and} onChange={this.handleInputChange} /> AND operator (uncheck for OR)</label>
					</div>
					<div className="form-group">
						<label>Make</label>
						<select className="form-control" value={this.state.make} onChange={this.handleInputChange}>
							<option value="Any">Any</option>
							<option value="Chevy">Chevy</option>
							<option value="Ford">Ford</option>
							<option value="Mercedes">Mercedes</option>
							<option value="Toyota">Toyota</option>
						</select>
					</div>
					<div className="form-group">
						<label><input name="yearEnabled" type="checkbox" checked={this.state.yearEnabled} onChange={this.handleInputChange} /> Year (&gt;=)</label>
						<input name="year" className="form-control" type="number" disabled={!this.state.yearEnabled} value={this.state.year} onChange={this.handleInputChange} />
					</div>
					<div className="form-group">
						<label>Color</label>
						<select className="form-control" value={this.state.color} onChange={this.handleInputChange}>
							<option value="Any">Any</option>
							<option value="Black">Black</option>
							<option value="Gray">Gray</option>
							<option value="Red">Red</option>
							<option value="Silver">Silver</option>
							<option value="White">White</option>
						</select>
					</div>
					<div className="form-group">
						<label><input name="priceEnabled" type="checkbox" checked={this.state.priceEnabled} onChange={this.handleInputChange} /> Price (&lt;=)</label>
						<input name="price" className="form-control" type="number" disabled={!this.state.priceEnabled} value={this.state.price} onChange={this.handleInputChange} />
					</div>
					<div className="checkbox">
						<label>
							<input name="hasSunroofEnabled" type="checkbox" checked={this.state.hasSunroofEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="hasSunroof" type="checkbox" disabled={!this.state.hasSunroofEnabled} checked={this.state.hasSunroof} onChange={this.handleInputChange} /> hasSunroof</label>
					</div>
					<div className="checkbox">
						<label>
							<input name="isFourWheelDriveEnabled" type="checkbox" checked={this.state.isFourWheelDriveEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="isFourWheelDrive" type="checkbox" disabled={!this.state.isFourWheelDriveEnabled} checked={this.state.isFourWheelDrive} onChange={this.handleInputChange} /> isFourWheelDrive</label>
					</div>
					<div className="checkbox">
						<label>
							<input name="hasLowMilesEnabled" type="checkbox" checked={this.state.hasLowMilesEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="hasLowMiles" type="checkbox" disabled={!this.state.hasLowMilesEnabled} checked={this.state.hasLowMiles} onChange={this.handleInputChange} /> hasLowMiles</label>
					</div>
					<div className="checkbox">
						<label>
							<input name="hasPowerWindowsEnabled" type="checkbox" checked={this.state.hasPowerWindowsEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="hasPowerWindows" type="checkbox" disabled={!this.state.hasPowerWindowsEnabled} checked={this.state.hasPowerWindows} onChange={this.handleInputChange} /> hasPowerWindows</label>
					</div>
					<div className="checkbox">
						<label>
							<input name="hasNavigationEnabled" type="checkbox" checked={this.state.hasNavigationEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="hasNavigation" type="checkbox" disabled={!this.state.hasNavigationEnabled} checked={this.state.hasNavigation} onChange={this.handleInputChange} /> hasNavigation</label>
					</div>
					<div className="checkbox">
						<label>
							<input name="hasHeatedSeatsEnabled" type="checkbox" checked={this.state.hasHeatedSeatsEnabled} onChange={this.handleInputChange} />&nbsp;
							<input name="hasHeatedSeats" type="checkbox" disabled={!this.state.hasHeatedSeatsEnabled} checked={this.state.hasHeatedSeats} onChange={this.handleInputChange} /> hasHeatedSeats</label>
					</div>
					<button type="submit" className="btn btn-default">Submit</button>
				</form>
				<VehicleTable vehicles={this.state.vehicles} />
			</div>
		);
	}
};

ReactDOM.render(<Search />, document.getElementById('root'));
