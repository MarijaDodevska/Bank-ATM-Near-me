import arrow from "./images/back-arrow.png"
import {Link} from "react-router-dom";
import React from "react";
import Map from "./Map";
import {getAtms1} from "./service/AtmServices";

const InitialAtm1 = {
    id:1,
    atmName: "NLB",
    x: "10",
    y: "20"
}

const InitialAtm2 = {
    id:2,
    atmName: "Sparkasse",
    x: "20",
    y: "30"
}

const AtmPage = () => {
    const [searchInput, setSearchInput] = React.useState("");
    const [atms, setAtms] = React.useState([])

    const handleChange = (e) => {
        setSearchInput(e.target.value)
    }

    const handleClick = () => {
        getAtms1(searchInput,  41.99646, 21.43141)
            .then(r => setAtms(r));
    }

    return(
        <div className="App" style={{ "justify-content": "left" }}>
            <Link className="arr" to={"/home"}>
                <img src={arrow} alt={"nzm"}/>
            </Link>
            <div>
                <input
                    type="text"
                    placeholder="Search here"
                    onChange={handleChange}
                    value={searchInput} />
                <button
                    type={"button"}
                    onClick={handleClick}>
                    Search
                </button>
                <div className="results">
                    <ul>

                    </ul>
                </div>
                <div style={{}}>
                    {atms.map((atm) => {
                        return (
                            <ul>
                                <li>{atm.atmName}  {atm.x + "" + atm.y}</li>
                            </ul>
                        )
                    })}
                </div>


                    <div>
                        <Map atms={atms}/>
                    </div>
            </div>
        </div>
    )
}
export default AtmPage;