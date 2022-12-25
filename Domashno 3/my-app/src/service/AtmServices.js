const getAtms = async ( search, lat, lng) => {
    try {
        const {data:response} = await axios.get(`/api/atm/all?search=${search}&lat=${lat}&lng=${lng}`)
        return response;
    }

    catch (error) {
        console.log(error);
    }
};