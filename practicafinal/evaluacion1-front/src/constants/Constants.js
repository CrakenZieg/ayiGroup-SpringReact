export const URLS = {

    BASE: "http://localhost:8080",

    LOGIN: function () {
        return `${this.BASE}/auth/login`;
    },

    EMPLEADOS: function () {
        return `${this.BASE}/api/v1`;
    },

    EMPLEADOS_ID: function (id) {
        return `${this.EMPLEADOS()}/${id}`;
    }

}