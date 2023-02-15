import React from 'react'
import {GoogleMap, LoadScript, Marker} from '@react-google-maps/api';

const containerStyle = {
    width: '400px',
    height: '400px'
};

const center = {
    lat: 41.99646,
    lng: 21.43141
};

const Map = (banks_rec) => {
    const [banks, setBanks] = React.useState(banks_rec)
    return (
        <LoadScript
            googleMapsApiKey=""
        >
            <GoogleMap
                mapContainerStyle={containerStyle}
                center={center}
                zoom={10}
            >
                <Marker position={center}/>
                {banks.map((bank)=>{
                    console.log(bank);
                    const x = bank.x;
                    const y = bank.y;
                    const currentMarker = { lat: x, lng: y };
                    return(<Marker position={currentMarker}/>)
                })}
                <></>
            </GoogleMap>
        </LoadScript>
    )
}

export default React.memo(Map);