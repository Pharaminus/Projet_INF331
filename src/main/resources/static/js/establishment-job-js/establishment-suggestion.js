
document.getElementById("suggest").addEventListener("click", () => {
    let xhr = new XMLHttpRequest();

    xhr.open("Get", "/establishment/test", true)
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            try{
                // window.location.href = "/home"
                let response = JSON.parse(xhr.responseText)
                console.log(response)
            }
            catch(error){
                window.location.href = "/login/form"
                console.log(error)
            }
        }
    }

    xhr.send()
})