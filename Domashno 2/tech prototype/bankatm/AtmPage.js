import arrow from "./images/back-arrow.png"
import {Link} from "react-router-dom";
import React from "react";
import Map from "./Map";

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
    const [atms, setAtms] = React.useState([InitialAtm1,InitialAtm2])

    const handleChange = (e) => {
        setSearchInput(e.target.value)
    }

    const handleClick = () => {

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
                            {/*{atms.map((atm) => {*/}
                            {/*    return (*/}
                            {/*        <tr>*/}
                            {/*            <td>*/}
                            {/*                {atm.bankName}*/}
                            {/*            </td>*/}
                            {/*            <td>*/}
                            {/*                {atm.x + "" + atm.y}*/}
                            {/*            </td>*/}
                            {/*        </tr>*/}
                            {/*    )*/}
                            {/*})}*/}


                    <div>
                        <Map atms={atms}/>
                    </div>
            </div>
        </div>
    )
}
export default AtmPage;