let url = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

class Service {

    async getTrago(){
        const response = await fetch(url);
        return response.json();
    }

}

export default new Service();