import axios from 'axios';
import { URLS } from '../constants/Constants';

export const ApiService = {

    login: (credentials) => {
        return axios.post(
            URLS.LOGIN(),
            {
                username: credentials.username,
                password: credentials.password
            }, {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        )
    },

    all: (token) => {
        return axios.get(
            URLS.EMPLEADOS(),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    one: (id, token) => {
        return axios.get(
            URLS.EMPLEADOS_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    create: (empleado, token) => {
        return axios.post(
            URLS.EMPLEADOS(),
            empleado,
            {
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            }
        )
    },

    update: (empleado, token) => {
        return axios.put(
            URLS.EMPLEADOS(),
            empleado,
            {
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            }
        )
    },

    delete: (id, token) => {
        return axios.delete(
            URLS.EMPLEADOS_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    }
}