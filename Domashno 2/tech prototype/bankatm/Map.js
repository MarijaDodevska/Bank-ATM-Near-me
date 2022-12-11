import React from 'react'
import {GoogleMap, LoadScript, Marker} from '@react-google-maps/api';

const containerStyle = {
    width: '400px',
    height: '400px'
};

const center = {
    lat: -3.745,
    lng: -38.523
};

const Map = (banks) => {
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
                {/*{for (let i = 0; i < banks.lenght; i++){*/}
                {/*    console.log(bank);*/}
                {/*    const x = bank.x;*/}
                {/*    const y = bank.y;*/}
                {/*    const currentMarker = { lat: x, lng: y };*/}
                {/*    return(<Marker position={currentMarker}/>)*/}
                {/*})}*/}
                <></>
            </GoogleMap>
        </LoadScript>
    )
}

export default React.memo(Map);