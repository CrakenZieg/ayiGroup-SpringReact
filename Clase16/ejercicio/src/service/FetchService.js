let url = "https://www.themealdb.com/api/json/v1/1/random.php";

class Service {
    async getOne(){
        let response = await fetch(url);
        return response.json();
    }
}

export default new Service();
