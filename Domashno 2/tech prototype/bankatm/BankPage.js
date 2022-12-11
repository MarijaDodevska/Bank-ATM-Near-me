import arrow from "./images/back-arrow.png"
import {Link} from "react-router-dom";
import React from "react";
import Map from "./Map";

const InitialBank1 = {
    id:1,
    bankName: "NLB",
    x: "10",
    y: "20"
}

const InitialBank2 = {
    id:2,
    bankName: "Sparkasse",
    x: "20",
    y: "30"
}

const BankPage = () => {
    const [searchInput, setSearchInput] = React.useState("");
    const [banks, setBanks] = React.useState([InitialBank1,InitialBank2])

    const handleChange = (e) => {
        setSearchInput(e.target.value)
    }

    const handleClick = () => {

    }

    return(
        <div className="App" style={{ "justify-content": "left" }}>
        <Link to={"/home"}>
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
                <div style={{ "display": "flex", "flex-direction": "row"}}>
                <div style={{}}>
                        {banks.map((bank) => {
                            return (
                                <ul>
                                    <li>{bank.bankName}  {bank.x + "" + bank.y}</li>
                                </ul>
                            )
                        })}
                </div>
                <div>
                    <Map banks={banks}/>
                </div>
                </div>
            </div>
        </div>
    )
}
export default BankPage;