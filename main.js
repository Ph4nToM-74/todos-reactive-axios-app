
let instance = axios.create({

    baseURL: "http://localhost:8080/reactive",

    headers: {

        "Content-Type": "application/json",
    },
});

function htmlizeResponse(response) {

    return `<div class="alert alert-secondary mt-3" role="alert"><pre>` +
            JSON.stringify(response, null, 4) + "</pre></div>";
}

function linkReactiveApi() {

    let resultElement = document.getElementById("linkResult");

    resultElement.innerHTML = "";

    const host = document.getElementById("get-host").value;
    const port = document.getElementById("get-port").value;

    if (host && port) {

        instance = axios.create({

            baseURL: "http://" + host + ":" + port + "/reactive",

            headers: {

                "Content-Type": "application/json",
            },
        });
    }

    resultElement.innerHTML = htmlizeResponse(instance.getUri());
}

async function getAllData() {

    let resultElement = document.getElementById("getResult");

    resultElement.innerHTML = "";

    try {

        const response = await instance.get("/todos");

        const result = {

            status: response.status + "-" + response.statusText,
            headers: response.headers, data: response.data,
        };

        resultElement.innerHTML = htmlizeResponse(result);

    } catch (error) {

        resultElement.innerHTML = htmlizeResponse(error);
    }
}

async function getDataById() {

    let resultElement = document.getElementById("getResult");

    resultElement.innerHTML = "";

    const id = document.getElementById("get-id").value;

    if (id) {

        try {

            const response = await instance.get(`/todos/${id}`);

            const result = {

                status: response.status + "-" + response.statusText,
                headers: response.headers, data: response.data,
            };

            resultElement.innerHTML = htmlizeResponse(result);

        } catch (error) {

            resultElement.innerHTML = htmlizeResponse(error);
        }
    }
}

async function getDataByTitle() {

    let resultElement = document.getElementById("getResult");

    resultElement.innerHTML = "";

    const title = document.getElementById("get-title").value;

    if (title) {

        try {

            // const response = await instance.get(`/todos?title=${title}`);

            const reponse = await instance.get("/todos", {

                params: { title: title }
            });

            const result = {

                status: reponse.status + "-" + reponse.statusText,
                headers: reponse.headers, data: reponse.data,
            };

            resultElement.innerHTML = htmlizeResponse(result);

        } catch (error) {

            resultElement.innerHTML = htmlizeResponse(error);
        }
    }
}

async function postData() {

    let resultElement = document.getElementById("postResult");

    resultElement.innerHTML = "";

    const title = document.getElementById("post-title").value;
    const description = document.getElementById("post-description").value;

    try {

        const response = await instance.post("/todos", {

            title: title, description: description,
        });

        const result = {

            status: response.status + "-" + response.statusText,
            headers: response.headers, data: response.data,
        };

        resultElement.innerHTML = htmlizeResponse(result);

    } catch (error) {

        resultElement.innerHTML = htmlizeResponse(error);
    }
}

async function putData() {

    let resultElement = document.getElementById("putResult");

    resultElement.innerHTML = "";

    const id = document.getElementById("put-id").value;
    const title = document.getElementById("put-title").value;
    const description = document.getElementById("put-description").value;
    const done = document.getElementById("put-done").checked;

    try {

        const response = await instance.put(`/todos/${id}`, {

            title: title, description: description, done: done
        });

        const result = {

            status: response.status + "-" + response.statusText,
            headers: response.headers, data: response.data,
        };

        resultElement.innerHTML = htmlizeResponse(result);

    } catch (error) {

        resultElement.innerHTML = htmlizeResponse(error);
    }
}

async function deleteAllData() {

    let resultElement = document.getElementById("deleteResult");

    resultElement.innerHTML = "";

    try {

        const response = await instance.delete("/todos");

        const result = {

            status: response.status + "-" + response.statusText,
            headers: response.headers, data: response.data,
        };

        resultElement.innerHTML = htmlizeResponse(result);

    } catch (error) {

        resultElement.innerHTML = htmlizeResponse(error);
    }
}

async function deleteDataById() {

    let resultElement = document.getElementById("deleteResult");

    resultElement.innerHTML = "";

    const id = document.getElementById("delete-id").value;

    try {

        const response = await instance.delete(`/todos/${id}`);

        const result = {

            status: response.status + "-" + response.statusText,
            headers: response.headers, data: response.data,
        };

        resultElement.innerHTML = htmlizeResponse(result);

    } catch (error) {

        resultElement.innerHTML = htmlizeResponse(error);
    }
}

function clearLinkOutput() {

    document.getElementById("linkResult").innerHTML = "";
}

function clearGetOutput() {

    document.getElementById("getResult").innerHTML = "";
}

function clearPostOutput() {

    document.getElementById("postResult").innerHTML = "";
}

function clearPutOutput() {

    document.getElementById("putResult").innerHTML = "";
}

function clearDeleteOutput() {

    document.getElementById("deleteResult").innerHTML = "";
}
