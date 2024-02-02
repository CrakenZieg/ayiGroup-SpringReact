import { axios } from 'axios';
import { URLS } from '../constants/Constants';

export default ApiService = {

    login : (credentials) => {
        axios.post(
            URLS.LOGIN(),
            {
                username:credentials.username,
                password:credentials.password
            },{
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        ).then(
            response => {
                localStorage.setItem("token", response.data.token);
                localStorage.setItem("user", credentials.username);
                return;
            }
        )
    }

}