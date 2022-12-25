import mapslocation from "./images/maps-location.PNG";
import bank from "./images/bank.PNG";
import atm from "./images/atm.PNG";
import {Link} from "react-router-dom";


const Home = () => {
    return(
        <div className="App">
            <div>
                <img id="log" src={mapslocation} alt="logo" width={250} />
            </div>
            <div id="heading">Bank/ATM Near Me</div>
            <div id="icons">
                <Link to={"/bank"}
                     style={{ display: "flex", "flex-direction": "column", "padding-inline": "50px" }}>
                    <img src={bank} width={250}/>
                    <h2>Bank</h2>
                </Link>
                <Link to={"/atm"}
                      style={{ display: "flex", "flex-direction": "column", "padding-inline": "50px" }}>
                    <img src={atm} width={250}/>
                    <h2>ATM</h2>
                </Link>
            </div>
        </div>
    )
}
export default Home;