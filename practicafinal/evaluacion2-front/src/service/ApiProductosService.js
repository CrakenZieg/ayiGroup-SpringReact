import axios from 'axios';
import { URLS } from '../constants/Constants';

export const ApiProductosService = {

    all: (token) => {
        return axios.get(
            URLS.PRODUCTO(),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    one: (id, token) => {
        return axios.get(
            URLS.PRODUCTO_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    },

    create: (empleado, token) => {
        return axios.post(
            URLS.PRODUCTO(),
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
            URLS.PRODUCTO(),
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
            URLS.PRODUCTO_ID(id),
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }
        )
    }
}