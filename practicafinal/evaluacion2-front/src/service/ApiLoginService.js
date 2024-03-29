import axios from 'axios';
import { URLS } from '../constants/Constants';

export const ApiLoginService = {

    login : (credentials) => {
        return axios.post(
            URLS.LOGIN(),
            {
                username:credentials.username,
                password:credentials.password
            },{
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        )
    }

}