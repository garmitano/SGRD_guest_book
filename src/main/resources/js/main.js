const option = {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify(jsonData),
};

document.getElementById("submit").onclick = function () {
    var value = document.getElementById("name").value;
    console.log("hola " + value);
};
