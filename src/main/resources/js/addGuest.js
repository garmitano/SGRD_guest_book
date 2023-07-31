console.log("hjola");
// Aquí irá el código JavaScript con Fetch API
document.getElementById("addGuest").addEventListener("click", function () {
    var id = document.getElementById("idGuest").value;
    console.log("hjola");
    // Realiza la petición AJAX con Fetch API
    fetch(
        "http://localhost:8086/registries/addGuest?id=" +
            encodeURIComponent(id),
        {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        }
    )
        .then((response) => {
            if (!response.ok) {
                throw new Error("Error al comunicarse con el servidor.");
            }
            return response.json();
        })
        .then((data) => {
            if (data.exist) {
                // El ID existe en la base de datos, se reciben los datos
                alert("Existe");
            } else {
                // El ID no existe en la base de datos
                alert("El ID no existe en la base de datos.");
            }
        })
        .catch((error) => {
            alert(error.message);
        });
});
