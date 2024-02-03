export function eanLastNumber(array){
    let suma = 0;
    for(let i = array.length-2; i >= 0  ; i--){
        if(i%2===0){
            suma += Number.parseInt(array[i])*3;
        } else {
            suma += Number.parseInt(array[i]);
        }       
    }
    let result = Math.floor((suma/10)+1)*10 - suma;
    return result%10;
}

export function productoWithEanArray(producto){
    
    console.log(producto)
    let prodWithArray = {
        ean: [],
        nombre:"",
        descripcion:"",
        tipo:"",
        marca:"",
        precio:0,
        stock:0
    }
    if(producto.id!==""){
        prodWithArray.id = producto.id
    }
    prodWithArray.ean = producto.ean.split("").map((e)=>{return Number.parseInt(e)}); 
    prodWithArray.nombre = producto.nombre;
    prodWithArray.descripcion = producto.descripcion;
    prodWithArray.tipo = producto.tipo;
    prodWithArray.marca = producto.marca;
    prodWithArray.precio = producto.precio;
    prodWithArray.stock = producto.stock;
    console.log(prodWithArray)
    return prodWithArray;
}

export function productoWithEanString(producto){
    console.log(producto)
    const prodWithString = {}
    if(producto.id!==""){
        prodWithString.id = producto.id
    }
    prodWithString.ean = producto.ean.map((e)=>(e).toString()).join("");
    prodWithString.nombre = producto.nombre;
    prodWithString.descripcion = producto.descripcion;
    prodWithString.tipo = producto.tipo;
    prodWithString.marca = producto.marca;
    prodWithString.precio = producto.precio;
    prodWithString.stock = producto.stock;
    return prodWithString;
}