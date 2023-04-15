import React, { useEffect, useState } from "react";
import axios from "axios";

const ShowProducts = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [productos, setProductos] = useState([]);

  const [name, setName] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [addres, setAddres] = useState("");
  const [identification, setIdentification] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [nameProduct, setNameProduct] = useState("");
  const [quantityProduct, setQuantityProduct] = useState("");
  const [supplier, setSupplier] = useState("");
  const [unitProduct,  setUnitProduct] = useState("");
  const [valueProduct, setValueProduct] = useState("");
  const [weightProduct, setWeightProduct] = useState("");

  const handleSubmitp = (events) => {
    events.preventDefault();
    const datap = {
      nameProduct,
      quantityProduct,
      supplier,
      unitProduct,
      valueProduct,
      weightProduct
      
    };
    axios
      .post("http://localhost:8080/api/products/save", datap)
      .then((res) => {
        console.log(res);
        console.log(datap);
        alert("Usuario Guardado Exitosamente");
      })
      .catch((err) => {
        console.log(err);
        console.log(datap);
        alert("Error, llene todos los campos");
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = {
      name,
      lastname,
      email,
      phone,
      addres,
      identification,
      username,
      password,
    };
    axios
      .post("http://localhost:8080/api/users/save", data)
      .then((res) => {
        console.log(res);
        console.log(data);
        alert("Usuario Guardado Exitosamente");
      })
      .catch((err) => {
        console.log(err);
        console.log(data);
        alert("Error, llene todos los campos");
      });
  };
  

  const peticionGet = async () => {
    await axios
      .get("http://localhost:8080/api/users/list")
      .then((response) => {
        setUsuarios(response.data.listObjectGeneric[0]);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const peticionList = async () => {
    try {
      await axios
      .get("http://localhost:8080/api/products/list" )
      .then((response) => {
        setProductos(response.data.listObjectGeneric[0]);
      console.log(response.data);
      })
      
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    peticionGet();
    peticionList();
  }, []);
 

  return (
    <div className="App">
      <div className="container-fluid">
        <div className="row mt-3">
          <div className="col-md-4 offset-4">
            <div className="d-grid mx-auto">
              <form
                id="datos"
                onSubmit={handleSubmit}
                style={{
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                }}
              >
                <h2>Registar usuario</h2>
                <label htmlFor="nombre">NOMBRE: </label>
                <input
                  type="text"
                  id="nombre"
                  onChange={(event) => setName(event.target.value)}
                />
                <br />
                <label htmlFor="apellido">APELLIDO: </label>
                <input
                  type="text"
                  id="apellido"
                  onChange={(event) => setLastname(event.target.value)}
                />
                <br />
                <label htmlFor="email">EMAIL: </label>
                <input
                  type="text"
                  id="email"
                  onChange={(event) => setEmail(event.target.value)}
                />
                <br />
                <label htmlFor="telefono">TELEFONO: </label>
                <input
                  type="number"
                  id="telefono"
                  onChange={(event) => setPhone(event.target.value)}
                />
                <br />
                <label htmlFor="direccion">DIRECCION: </label>
                <input
                  type="text"
                  id="direcion"
                  onChange={(event) => setAddres(event.target.value)}
                />
                <br />
                <label htmlFor="identificacion">IDENTIFICACION: </label>
                <input
                  type="text"
                  id="identificacion"
                  onChange={(event) => setIdentification(event.target.value)}
                />
                <br />
                <label htmlFor="username">NOMBRE DE USUARIO: </label>
                <input
                  type="text"
                  id="username"
                  onChange={(event) => setUsername(event.target.value)}
                />
                <br />
                <label htmlFor="password">CONTRASEÑA : </label>
                <input
                  type="text"
                  id="password"
                  onChange={(event) => setPassword(event.target.value)}
                />
                <br />
                <button>
                  <i className="fa-solid fa-circleplus"></i>Añadir
                </button>
              </form>
              <br />
            </div>
          </div>
        </div>
      </div>
      <div className="row mt-3">
        <div className="col-12 col-lg-8 offset-0 offset-lg-2">
          <div className="table-responsive">
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>NOMBRE</th>
                  <th>APELLIDO</th>
                  <th>EMAIL</th>
                  <th>TELEFON</th>
                  <th>DIRECCION</th>
                  <th>IDENTIFICACION</th>
                  <th>NOMBRE DE USUARIO</th>
                </tr>
              </thead>
              <tbody className="table-group-divider">
                {usuarios.map((user) => (
                  <tr key={user.id}>
                    <td>{user.id}</td>
                    <td>{user.nameUser}</td>
                    <td>{user.lastname}</td>
                    <td>{user.email}</td>
                    <td>{user.phone}</td>
                    <td>{user.addres}</td>
                    <td>{user.identification}</td>
                    <td>{user.username}</td>
                  </tr>
                ))}
              </tbody>
            </table>
            <br />
            <div>
              <h1
                style={{
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                }}
              >
                PRODUCTOS
              </h1>
              <form
                id="datos"
                onSubmit={handleSubmitp}
                style={{
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                }}
              >
                <h2>Registar productos</h2>
                <label htmlFor="nombre">NOMBRE: </label>
                <input
                  type="text"
                  id="nombre"
                  onChange={(event) => setNameProduct(event.target.value)}
                />
                <br />
                <label htmlFor="apellido">CANTIDAD: </label>
                <input
                  type="number"
                  id="apellido"
                  onChange={(event) => setQuantityProduct(event.target.value)}
                />
                <br />
                <label htmlFor="email">PROVEEDOR: </label>
                <input
                  type="text"
                  id="email"
                  onChange={(event) => setSupplier(event.target.value)}
                />
                <br />
                <label htmlFor="telefono">UNIDADES: </label>
                <input
                  type="text"
                  id="telefono"
                  onChange={(event) => setUnitProduct(event.target.value)}
                />
                <br />
                <label htmlFor="direccion">VALOR: </label>
                <input
                  type="number"
                  id="direcion"
                  onChange={(event) => setValueProduct(event.target.value)}
                />
                <br />
                <label htmlFor="identificacion">PESO: </label>
                <input
                  type="text"
                  id="identificacion"
                  onChange={(event) => setWeightProduct(event.target.value)}
                />
                <br />
                <button>
                  <i className="fa-solid fa-circleplus"></i>Añadir
                </button>
              </form>
              <br />
              <div>
                <table className="table table-bordered">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>NOMBRE PRODUCTO</th>
                      <th>CANTIDAD</th>
                      <th>PROVEEDOR</th>
                      <th>UNIDADES</th>
                      <th>VALOR</th>
                      <th>PESO</th>
                    </tr>
                  </thead>
                  <tbody className="table-group-divider">
                {productos.map((users) => (
                  <tr key={users.id}>
                    <td>{users.id}</td>
                    <td>{users.nameProduct}</td>
                    <td>{users.quantityProduct}</td>
                    <td>{users.supplier}</td>
                    <td>{users.unitProduct}</td>
                    <td>{users.valueProduct}</td>
                    <td>{users.weightProduct}</td>
                  </tr>
                ))}
              </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="modal fade"></div>
    </div>
  );
};

export default ShowProducts;
