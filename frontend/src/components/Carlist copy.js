import { useEffect, useState } from "react";
import { SERVER_URL } from "../Constants";

function Carlist() {
    const [cars, setCars] = useState([]);

    useEffect(() => {
        fetch(SERVER_URL + 'api/cars')
            .then(response => response.json())
            .then(data => setCars(data._embedded.cars))
            .catch(err => console.error(err));
    }, []);

    const columns = [
        {field: 'brand', headerName: 'Brand', width: 200},
        {field: 'model', headerName: 'Model', width: 200},
        {field: 'color', headerName: 'Color', width: 200},
        {field: 'carYear', headerName: 'Year', width: 150},
        {field: 'price', headerName: 'Price', width: 150}
    ];

    return (
        <div>
            <table>
                <tbody>
                    {
                        cars.map((car, index) =>
                            <tr key={index}>
                                <td>{car.brand}</td>
                                <td>{car.model}</td>
                                <td>{car.color}</td>
                                <td>{car.carYear}</td>
                                <td>{car.price}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}

export default Carlist;