import axios from 'axios';
import { URLS } from '../constants/Constants';

export const ApiClientesService = {

    all: (token) => {
        return axios.get(
            URLS.CLIENTE(),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    one: (id, token) => {
        return axios.get(
            URLS.CLIENTE_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    create: (empleado, token) => {
        return axios.post(
            URLS.CLIENTE(),
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
            URLS.CLIENTE(),
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
            URLS.CLIENTE_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    }
}