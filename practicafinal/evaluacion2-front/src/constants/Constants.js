export const URLS = {

    BASE : "http://localhost:8080",

    LOGIN: function (){
        return `${this.BASE}/auth/login`;
    },

    PRODUCTO: function (){
        return `${this.BASE}/api/v1/producto`;
    },

    PRODUCTO_ID: function (id){
        return `${this.PRODUCTO()}/${id}`;
    },

    CLIENTE: function (){
        return `${this.BASE}/api/v1/cliente`;
    },

    CLIENTE_ID: function (id){
        return `${this.CLIENTE()}/${id}`;
    }

}